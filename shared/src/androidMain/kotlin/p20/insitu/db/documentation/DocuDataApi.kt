package p20.insitu.db.documentation

import co.touchlab.kermit.Logger
import com.couchbase.lite.*
import com.couchbase.lite.Document
import com.couchbase.lite.MutableDocument
import com.couchbase.lite.UnitOfWork
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import p20.insitu.model.components.DocNumber
import p20.insitu.model.entities.*
import p20.insitu.model.entities.Annotation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.entities.enums.EntityTypeIdentifier
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.util.toZonedDateTime
import p20.insitu.util.GlobalSettings
import kotlin.Exception

enum class DbOp {
    INSERT,
    UPDATE
}

@Suppress("UNCHECKED_CAST")
@OptIn(ExperimentalCoroutinesApi::class)
actual class DocuDataApi : KoinComponent {

    private val log: Logger =
        get(parameters = { parametersOf(DocuDataApi::class.simpleName) })
    private val clock: Clock by inject()

    @OptIn(DelicateCoroutinesApi::class)
    private val globalCoroutineScope: CoroutineScope = GlobalScope
    private val database: Database by inject()

    //region Executing the actual database operations
    /**
     * Inserts or updates multiple documents in a single batch operation.
     *
     * @param documents List of [Document]s that will be written to the database. Each document is
     * associated with an enum value that indicates the kind of database operation (insert or update).
     */
    private suspend fun writeInBatch(
        documents: List<Pair<MutableDocument, DbOp>>
    ) = withContext(Dispatchers.IO) {
        try {
            database.inBatch(
                UnitOfWork {
                    documents.forEach { pair ->
                        database.save(pair.first, ConcurrencyControl.LAST_WRITE_WINS)
                        log.i(
                            "${pair.second} Document[${pair.first.getString("id") ?: "value not found"}] - ${
                                pair.first.getString(
                                    entityType
                                ) ?: "value not found"
                            }"
                        )
                    }
                })
        } catch (ex: Exception) {
            log.e("Error during database transaction! ${ex.message}")
        }
    }
    //endregion

    //region Prepare database documents
    /**
     * Creates the [MutableDocument]s for the given [BaseEntity] and an associated [AuditEntry] to
     * be inserted into the database.
     *
     * @param baseEntity The [BaseEntity] entity to be inserted
     * @param userId The ID of the user responsible for the insert operation
     * @return [MutableDocument]s for the given [BaseEntity] and the associated [AuditEntry] paired
     * with the targeted database operation
     */
    private fun insertBaseEntity(
        baseEntity: BaseEntity,
        userId: String
    ): List<Pair<MutableDocument, DbOp>> {
        return listOf(
            Pair(Serializer.toMutableDocument(baseEntity), DbOp.INSERT),
            Pair(
                Serializer.toMutableDocument(
                    ObjectFactory.createAuditEntryForInsert(
                        timestamp = clock.now().toZonedDateTime(TimeZone.currentSystemDefault()),
                        entity = baseEntity,
                        properties = Serializer.toMap(baseEntity),
                        userId = userId
                    )
                ), DbOp.INSERT
            )
        )
    }

    /**
     * Creates the [MutableDocument]s for the given [BaseEntity] and an associated [AuditEntry] to
     * be updated / inserted in the database.
     *
     * @param newVersion The [BaseEntity] entity to be updated
     * @param oldVersion The old version of the [BaseEntity]
     * @param userId The ID of the user responsible for the update operation
     * @return [MutableDocument]s for the given [BaseEntity] and the associated [AuditEntry] paired
     * with the targeted database operation
     */
    private fun updateBaseEntity(
        newVersion: BaseEntity,
        oldVersion: BaseEntity,
        userId: String
    ): List<Pair<MutableDocument, DbOp>> {
        return listOf(
            Pair(
                Serializer.toMutableDocument(
                    ObjectFactory.createAuditEntryForUpdate(
                        timestamp = clock.now()
                            .toZonedDateTime(TimeZone.currentSystemDefault()),
                        entity = newVersion,
                        oldProperties = Serializer.toMap(oldVersion),
                        newProperties = Serializer.toMap(newVersion),
                        userId = userId
                    )
                ), DbOp.INSERT
            ),
            Pair(Serializer.toMutableDocument(newVersion), DbOp.UPDATE)
        )
    }

    private suspend fun getDocumentsForDeleteOp(
        entity: IBaseEntity,
        userId: String
    ): List<Pair<MutableDocument, DbOp>> {
        val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()

        // Set the deleted property of the entity to 'true' and add it to update documents list
        entity.deleted = true
        documents.add(Pair(Serializer.toMutableDocument(entity as BaseEntity), DbOp.UPDATE))

        // Create an AuditEntry for the delete update and add it to the insert documents list
        getEntityById<BaseEntity>(entity.id)?.let { oldVersion ->
            documents.add(
                Pair(
                    Serializer.toMutableDocument(
                        ObjectFactory.createAuditEntryForDelete(
                            timestamp = clock.now()
                                .toZonedDateTime(TimeZone.currentSystemDefault()),
                            entity = entity,
                            oldProperties = Serializer.toMap(oldVersion),
                            newProperties = Serializer.toMap(entity),
                            userId = userId
                        )
                    ), DbOp.INSERT
                )
            )
        }

        // If the entity is a relation object, we are done at this point
        // If not, we look for related objects that need to be deleted
        if (entity !is Relation) {

            // HierarchicalObjects may have children that need to be deleted
            if (entity is HierarchicalObject) {
                // Recursively get the documents for deleting all hierarchical children of the entity
                getHierarchicalChildren(entity.id).forEach { childEntity ->
                    getDocumentsForDeleteOp(
                        childEntity,
                        userId
                    ).let {
                        documents.addAll(it)
                    }
                }
            }

            // DocumentationObjects that are not annotations themselves, may have annotations that need to be deleted
            if (entity is DocumentationObject && entity !is Annotation) {
                // Recursively get the documents for deleting all related annotations
                // Note: We only delete annotations that aren't connected to other entities
                getDeletableAnnotations(entity.id).forEach { annotation ->
                    getDocumentsForDeleteOp(
                        annotation,
                        userId
                    ).let {
                        documents.addAll(it)
                    }
                }
            }

            // Images may have image tags that need to be deleted
            if (entity is Image) {
                // Recursively get the documents for deleting all related image tags
                getImageTags(entity.id).forEach { imageTag ->
                    getDocumentsForDeleteOp(
                        imageTag,
                        userId
                    ).let {
                        documents.addAll(it)
                    }
                }
            }

            // Recursively get the documents for deleting all relations where entity.id occurs
            // Note: This has to be done last, so it doesn't interfere with deleting children or annotations
            getRelationsBySourceOrTarget(entity.id, null).forEach { relation ->
                getDocumentsForDeleteOp(
                    relation,
                    userId
                ).let {
                    documents.addAll(it)
                }
            }
        }

        return documents
    }
    //endregion

    //region Private helper functions for live queries
    private fun <T : IBaseEntity> liveQueryEntity(query: Query): Flow<T?> {
        return query.queryChangeFlow().map { queryChange ->
            queryChange.results?.allResults()
                ?.firstOrNull()?.getString(id)?.let {
                    getEntityById(it)
                }
        }
    }

    private fun <T : IBaseEntity> liveQueryEntityList(query: Query): Flow<List<T>> {
        return query.queryChangeFlow().map { queryChange ->
            queryChange.results?.allResults()?.map { result ->
                result.getString(id)?.let { id ->
                    getEntityById<T>(id)
                }
            }?.filterNotNull() ?: listOf()
        }
    }

    private fun liveQueryIdList(query: Query): Flow<List<String>> {
        return query.queryChangeFlow().map { queryChange ->
            queryChange.results?.allResults()?.mapNotNull { result ->
                result.getString(id)
            } ?: listOf()
        }
    }
    //endregion

    //region Observe entity or query changes
    actual fun liveQueryAddress(crimeSceneId: String): Flow<Address?> {
        return liveQueryEntity(
            getRelatedAddressId(
                database,
                crimeSceneId,
            )
        )
    }

    actual fun <T : Annotation> liveQueryAnnotations(
        entityId: String,
        annotationType: EntityType?
    ): Flow<List<T>> {
        return getAnnotationIds(
            database,
            entityId,
            annotationType
        ).queryChangeFlow().map { queryChange ->
            queryChange.results?.allResults()?.map { result ->
                result.getString(id)?.let { id ->
                    getEntityById<T>(id)
                }
            }?.filterNotNull() ?: listOf()
        }
    }

    actual fun liveQueryAudioAnnotations(entityId: String): Flow<List<Audio>> {
        return liveQueryAnnotations(
            entityId = entityId,
            annotationType = EntityType.AUDIO
        )
    }

    actual fun liveQueryCriminalOffenses(entityId: String): Flow<List<CriminalOffense>> {
        return liveQueryEntityList(
            getCriminalOffenseIds(
                database,
                entityId
            )
        )
    }

    actual fun liveQueryHierarchicalChildIds(
        parentId: String,
        typeIdentifier: EntityTypeIdentifier?
    ): Flow<List<String>> {
        return liveQueryIdList(
            getHierarchicalChildIds(
                database,
                parentId,
                typeIdentifier
            )
        )
    }

    actual fun liveQueryHierarchicalChildren(
        parentId: String,
        typeIdentifier: EntityTypeIdentifier?
    ): Flow<List<HierarchicalObject>> {
        return liveQueryEntityList(
            getHierarchicalChildIds(
                database,
                parentId,
                typeIdentifier
            )
        )
    }

    actual fun liveQueryHierarchicalParent(
        childId: String
    ): Flow<HierarchicalObject?> {
        return liveQueryEntity(
            getHierarchicalParentId(
                database,
                childId
            )
        )
    }

    actual fun liveQueryImageAnnotations(entityId: String): Flow<List<Image>> {
        return liveQueryAnnotations(
            entityId = entityId,
            annotationType = EntityType.IMAGE
        )
    }

    actual fun liveQueryInvestigations(userId: String): Flow<List<Investigation>> {
        return liveQueryEntityList(
            // TODO: change query to only return investigations for which this user ID is authorized
            getEntityIds(
                database,
                EntityType.INVESTIGATION
            )
        )
    }

    actual fun liveQueryLastActiveCrimeScene(userId: String): Flow<CrimeScene?> {
        return liveQueryEntity(
            getLastActiveCrimeSceneId(database, userId)
        )
    }

    actual fun liveQueryLastActiveDocuObject(userId: String): Flow<Investigation?> {
        return liveQueryEntity(
            getLastActiveDocuObjectId(database, userId)
        )
    }

    actual fun liveQueryLastActiveInvestigation(userId: String): Flow<Investigation?> {
        return liveQueryEntity(
            getLastActiveInvestigationId(database, userId)
        )
    }

    actual fun <T : Annotation> liveQueryNestedAnnotations(
        entityId: String,
        annotationType: EntityType?
    ): Flow<List<T>> {
        // TODO This implementation only observes the DIRECT children, if the annotations of deeper
        //  nested children change or more grand children are added, the QueryChangeFlow will not be
        //  triggered. N1QL doesn't allow for recursive queries (I think). So how to go about this?
        //  There might be a way to combine nested flows...but I haven't worked it out yet.
        /*
        return getHierarchicalChildIds(
            database,
            entityId
        ).queryChangeFlow().map { queryChange ->
            queryChange.results?.allResults()?.map { result ->
                result.getString(id)?.let { childId ->
                    getAnnotations(
                        childId,
                        annotationType,
                        true
                    )
                } ?: listOf()
            }?.flatten()
        }.filterIsInstance()
        */

        // Alternatively we currently wrap the flow in a while-true loop to update the query every
        // couple of seconds - like we did in the beginning.
        return flow {
            while (true) {
                getHierarchicalChildIds(
                    database,
                    entityId
                ).execute()
                    .allResults().map { result ->
                        result.getString(id)?.let { childId ->
                            getAnnotations(
                                childId,
                                annotationType,
                                true
                            )
                        } ?: listOf()
                    }.flatten().let {
                        emit(it as List<T>)
                    }
                delay(GlobalSettings.Delay.UPDATE_LONG)
            }
        }
    }

    actual fun liveQueryNestedAudioAnnotations(entityId: String): Flow<List<Audio>> {
        return liveQueryNestedAnnotations(
            entityId = entityId,
            annotationType = EntityType.AUDIO
        )
    }

    actual fun liveQueryNestedImageAnnotations(entityId: String): Flow<List<Image>> {
        return liveQueryNestedAnnotations(
            entityId = entityId,
            annotationType = EntityType.IMAGE
        )
    }

    actual fun liveQueryNestedNoteAnnotations(entityId: String): Flow<List<Note>> {
        return liveQueryNestedAnnotations(
            entityId = entityId,
            annotationType = EntityType.NOTE
        )
    }

    actual fun liveQueryNestedVideoAnnotations(entityId: String): Flow<List<Video>> {
        return liveQueryNestedAnnotations(
            entityId = entityId,
            annotationType = EntityType.VIDEO
        )
    }

    actual fun liveQueryNoteAnnotations(entityId: String): Flow<List<Note>> {
        return liveQueryAnnotations(
            entityId = entityId,
            annotationType = EntityType.NOTE
        )
    }

    actual fun liveQueryPersons(entityId: String): Flow<List<Person>> {
        return getPersonIds(
            database,
            entityId
        ).queryChangeFlow().map { queryChange ->
            queryChange.results?.allResults()?.map { result ->
                val sourceId = result.getString(sourceId)
                val targetId = result.getString(targetId)
                val id = when {
                    sourceId != entityId -> sourceId
                    targetId != entityId -> targetId
                    else -> null
                }
                id?.let { getEntityById<Person>(it) }
            }?.filterNotNull() ?: listOf()
        }
    }

    actual fun liveQueryUserAnnotationIds(
        investigationId: String,
        userId: String,
        type: EntityType
    ): Flow<List<String>> {
        // TODO
        return emptyFlow()
    }

    actual fun liveQueryVideoAnnotations(entityId: String): Flow<List<Video>> {
        return liveQueryAnnotations(
            entityId = entityId,
            annotationType = EntityType.VIDEO
        )
    }

    actual fun <T : IBaseEntity> observeEntity(entityId: String): Flow<T?> {
        return database.documentChangeFlow(entityId, null).map { documentChange ->
            getEntityById(documentChange.documentID)
        }
    }
    //endregion

    //region Update
    actual fun update(entity: BaseEntity, userId: String, updateChildDocNumbers: Boolean) {
        globalCoroutineScope.launch {
            getEntityById<BaseEntity>(entity.id)?.let { oldVersion ->
                writeInBatch(updateBaseEntity(entity, oldVersion, userId))
                if (updateChildDocNumbers) {
                    updateChildDocNumbers(entity.id, userId)
                }
            }
        }
    }
    //endregion

    //region Save
    /**
     * Saves an [Address] entity. This includes the creation of the necessary [Relation]s and
     * [AuditEntry] objects.
     *
     * @param address The [Address] entity to be saved
     * @param crimeScene The associated [CrimeScene]
     * @param investigation The associated [Investigation]
     * @param userId The ID of the user responsible for the save operation
     */
    actual fun saveAddress(
        address: Address,
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        globalCoroutineScope.launch {
            val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()

            getEntityById<Address>(address.id)?.let { oldVersion ->
                // Update an existing Address
                documents.addAll(updateBaseEntity(address, oldVersion, userId))
            } ?: run {
                // Insert a new Address
                documents.addAll(insertBaseEntity(address, userId))
                // Create an AddressRelation to the associated crime scene
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createAddressRelation(
                            crimeScene = crimeScene,
                            address = address
                        ), userId
                    )
                )
                // Create an InvestigationRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createInvestigationRelation(
                            relatedObject = address,
                            investigation = investigation
                        ), userId
                    )
                )
            }
            // Write documents to database
            writeInBatch(documents)
        }
    }

    actual fun saveAnnotation(
        annotation: Annotation,
        docuObject: DocumentationObject,
        investigation: Investigation,
        userId: String
    ) {
        globalCoroutineScope.launch {
            val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()

            getEntityById<Annotation>(annotation.id)?.let { oldVersion ->
                // Update an existing Image
                documents.addAll(
                    updateBaseEntity(
                        annotation as BaseEntity,
                        oldVersion as BaseEntity,
                        userId
                    )
                )
            } ?: run {
                // Set creation timestamp
                annotation.creationDate =
                    clock.now().toZonedDateTime(TimeZone.currentSystemDefault())
                // Insert a new Image
                documents.addAll(insertBaseEntity(annotation as BaseEntity, userId))
                // Create an AnnotationRelation to the associated documentation object
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createAnnotationRelation(
                            docuObject = docuObject,
                            annotation = annotation
                        ), userId
                    )
                )
                // Create an InvestigationRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createInvestigationRelation(
                            relatedObject = annotation,
                            investigation = investigation
                        ), userId
                    )
                )
            }
            // Write documents to database
            writeInBatch(documents)
        }
    }

    /**
     * Saves an [CrimeScene] entity. This includes the creation of the necessary [Relation]s and
     * [AuditEntry] objects.
     *
     * @param crimeScene The [CrimeScene] entity to be saved
     * @param investigation The associated [Investigation]
     * @param userId The ID of the user responsible for the save operation
     */
    actual fun saveCrimeScene(
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        globalCoroutineScope.launch {
            val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()
            var assignDocNumber = false

            getEntityById<CrimeScene>(crimeScene.id)?.let { oldVersion ->
                // Update an existing CrimeScene
                documents.addAll(updateBaseEntity(crimeScene, oldVersion, userId))
            } ?: run {
                assignDocNumber = true
                // Insert a new CrimeScene
                documents.addAll(insertBaseEntity(crimeScene, userId))
                // Create a CrimeSceneRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createCrimeSceneRelation(
                            investigation = investigation,
                            crimeScene = crimeScene
                        ), userId
                    )
                )
                // Create an InvestigationRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createInvestigationRelation(
                            relatedObject = crimeScene,
                            investigation = investigation
                        ), userId
                    )
                )
            }
            // Write documents to database
            writeInBatch(documents)

            if (assignDocNumber) {
                // Assign DocNumber
                assignDocNumber(crimeScene.id, userId)
                // TODO: random delay and then clear up any double assignments
            }
        }
    }

    /**
     * Saves an [CriminalOffense] entity. This includes the creation of the necessary [Relation]s and
     * [AuditEntry] objects.
     *
     * @param criminalOffense The [CriminalOffense] entity to be saved
     * @param investigation The associated [Investigation]
     * @param userId The ID of the user responsible for the save operation
     */
    actual fun saveCriminalOffense(
        criminalOffense: CriminalOffense,
        investigation: Investigation,
        userId: String
    ) {
        globalCoroutineScope.launch {
            val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()

            getEntityById<CriminalOffense>(criminalOffense.id)?.let { oldVersion ->
                // Update an existing CriminalOffense
                documents.addAll(updateBaseEntity(criminalOffense, oldVersion, userId))
            } ?: run {
                // Insert a new CriminalOffense
                documents.addAll(insertBaseEntity(criminalOffense, userId))
                // Create a CriminalOffenseRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createCriminalOffenseRelation(
                            relatedObject = investigation,
                            criminalOffense = criminalOffense
                        ), userId
                    )
                )
                // Create an InvestigationRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createInvestigationRelation(
                            relatedObject = criminalOffense,
                            investigation = investigation
                        ), userId
                    )
                )
            }
            // Write documents to database
            writeInBatch(documents)
        }
    }

    /**
     * Saves a [Evidence] entity. This includes the creation of the necessary [Relation]s and
     * [AuditEntry] objects.
     *
     * @param evidence The [Evidence] entity to be saved
     * @param topologicalParent The associated [DocNumberObject] that is the hierarchical
     * parent of the evidence object
     * @param investigation The associated [Investigation]
     * @param userId The ID of the user responsible for the save operation
     */
    actual fun saveEvidence(
        evidence: Evidence,
        topologicalParent: DocNumberObject,
        investigation: Investigation,
        userId: String
    ) {
        globalCoroutineScope.launch {
            val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()
            var assignDocNumber = false

            getEntityById<Evidence>(evidence.id)?.let { oldVersion ->
                // Update an existing evidence object
                documents.addAll(
                    updateBaseEntity(
                        evidence as BaseEntity,
                        oldVersion as BaseEntity,
                        userId
                    )
                )
            } ?: run {
                assignDocNumber = true
                // Insert a new evidence object
                documents.addAll(insertBaseEntity(evidence as BaseEntity, userId))
                // Create a TopologicalRelation to the associated parent object
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createTopologicalRelation(
                            child = evidence,
                            parent = topologicalParent
                        ), userId
                    )
                )
                // Create an InvestigationRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createInvestigationRelation(
                            relatedObject = evidence,
                            investigation = investigation
                        ), userId
                    )
                )
            }
            // Write documents to database
            writeInBatch(documents)

            // We currently always assign a doc number, regardless of existing evidenceData
            // TODO ask users if it is useful / necessary to be able have un-numbered objects in the documentation list, and if so, change this routine
            if (assignDocNumber) {
                // Assign DocNumber
                assignDocNumber(evidence.id, userId)
                // TODO: random delay and then clear up any double assignments
            }
        }
    }

    /**
     * Saves an [Investigation] entity. This includes the creation of an [AuditEntry].
     *
     * @param investigation The [Investigation] entity to be saved
     * @param userId The ID of the user responsible for the save operation
     */
    actual fun saveInvestigation(investigation: Investigation, userId: String) {
        globalCoroutineScope.launch {
            getEntityById<Investigation>(investigation.id)?.let { oldVersion ->
                writeInBatch(updateBaseEntity(investigation, oldVersion, userId))
            } ?: run {
                writeInBatch(insertBaseEntity(investigation, userId))
            }
        }
    }

    actual fun savePerson(
        person: Person,
        investigation: Investigation,
        userId: String
    ) {
        globalCoroutineScope.launch {
            val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()
            getEntityById<Person>(person.id)?.let { oldVersion ->
                // Update an existing Person
                documents.addAll(updateBaseEntity(person, oldVersion, userId))
            } ?: run {
                // Insert a new Person
                documents.addAll(insertBaseEntity(person, userId))
                // Create an InvestigationRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createInvestigationRelation(
                            relatedObject = person,
                            investigation = investigation
                        ), userId
                    )
                )
            }
            // Write documents to database
            writeInBatch(documents)
        }
    }

    /**
     * Saves a [Site] entity. This includes the creation of the necessary [Relation] and
     * [AuditEntry] objects.
     *
     * @param site The [Site] entity to be saved
     * @param crimeScene The associated [CrimeScene] that is the hierarchical parent of the site
     * @param investigation The associated [Investigation]
     * @param userId The ID of the user responsible for the save operation
     */
    actual fun saveSite(
        site: Site,
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        globalCoroutineScope.launch {
            val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()
            var assignDocNumber = false

            getEntityById<Site>(site.id)?.let { oldVersion ->
                // Update an existing site
                documents.addAll(
                    updateBaseEntity(
                        site as BaseEntity,
                        oldVersion as BaseEntity,
                        userId
                    )
                )
            } ?: run {
                assignDocNumber = true
                // Insert a new Site
                documents.addAll(insertBaseEntity(site as BaseEntity, userId))
                // Create a SiteRelation to the associated crime scene
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createSiteRelation(
                            crimeScene = crimeScene,
                            site = site
                        ), userId
                    )
                )
                // Create an InvestigationRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createInvestigationRelation(
                            relatedObject = site,
                            investigation = investigation
                        ), userId
                    )
                )
            }
            // Write documents to database
            writeInBatch(documents)

            // Assign DocNumber
            if (assignDocNumber) {
                assignDocNumber(site.id, userId)
                // TODO: random delay and then clear up any double assignments
            }
        }
    }

    /**
     * Saves a [Site] entity. This includes the creation of the necessary [Relation] and
     * [AuditEntry] objects.
     *
     * @param site The [Site] entity to be saved
     * @param parentSite The associated [Site] that is the hierarchical parent of the site
     * @param investigation The associated [Investigation]
     * @param userId The ID of the user responsible for the save operation
     */
    actual fun saveSubSite(
        site: Site,
        parentSite: Site,
        investigation: Investigation,
        userId: String
    ) {
        globalCoroutineScope.launch {
            val documents: MutableList<Pair<MutableDocument, DbOp>> = mutableListOf()
            var assignDocNumber = false

            getEntityById<Site>(site.id)?.let { oldVersion ->
                // Update an existing site
                documents.addAll(
                    updateBaseEntity(
                        site as BaseEntity,
                        oldVersion as BaseEntity,
                        userId
                    )
                )
            } ?: run {
                assignDocNumber = true
                // Insert a new Site
                documents.addAll(insertBaseEntity(site as BaseEntity, userId))
                // Create a TopologicalRelation to the associated parent site
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createTopologicalRelation(
                            child = site,
                            parent = parentSite
                        ), userId
                    )
                )
                // Create an InvestigationRelation to the associated investigation
                documents.addAll(
                    insertBaseEntity(
                        ObjectFactory.createInvestigationRelation(
                            relatedObject = site,
                            investigation = investigation
                        ), userId
                    )
                )
            }
            // Write documents to database
            writeInBatch(documents)

            // Assign DocNumber
            if (assignDocNumber) {
                assignDocNumber(site.id, userId)
                // TODO: random delay and then clear up any double assignments
            }
        }
    }

    actual fun saveUserSettings(
        userId: String,
        lastActiveInvestigationId: String?,
        lastActiveCrimeSceneId: String?,
        lastActiveDocuObjectId: String?
    ) {
        globalCoroutineScope.launch {
            getUserSettings(userId)?.let { userSettings ->
                userSettings.lastActiveInvestigationId = lastActiveInvestigationId
                userSettings.lastActiveCrimeSceneId = lastActiveCrimeSceneId
                userSettings.lastActiveDocuObjectId = lastActiveDocuObjectId
                update(userSettings, userId)
            } ?: run {
                ObjectFactory.createUserSettings(
                    userId,
                    lastActiveInvestigationId,
                    lastActiveCrimeSceneId,
                    lastActiveDocuObjectId
                ).let { userSettings ->
                    writeInBatch(insertBaseEntity(userSettings, userId))
                }
            }
        }
    }
    //endregion

    //region Delete
    actual fun deleteBaseEntity(entity: IBaseEntity, userId: String) {
        globalCoroutineScope.launch {
            writeInBatch(getDocumentsForDeleteOp(entity, userId))
        }
    }

    actual fun deleteAll() {
        database.delete()
    }
    //endregion

    //region Fetch
    @Suppress("UNCHECKED_CAST")
    actual suspend fun <T : IBaseEntity> getEntityById(id: String): T? {
        return database.getDocument(id)?.let { document ->
            try {
                Serializer.toBaseEntity(document) as T
            } catch (e: ClassCastException) {
                log.e(e.localizedMessage ?: e.message ?: e.toString(), e)
                null
            }
        }
    }

    actual suspend fun getRelatedAddress(entityId: String): Address? {
        return getRelatedAddressId(
            database,
            entityId,
        ).execute()
            .allResults().firstOrNull()?.getString(id)?.let {
                getEntityById(it)
            }
    }

    private suspend fun getHierarchicalParent(childId: String): HierarchicalObject? {
        return getHierarchicalParentId(
            database,
            childId
        ).execute()
            .allResults().firstOrNull()?.getString(id)?.let {
                getEntityById(it)
            }
    }

    private suspend fun getHierarchicalChildren(
        parentId: String,
        typeRestriction: EntityTypeIdentifier? = null
    ): List<HierarchicalObject> {
        val children: MutableList<HierarchicalObject> = mutableListOf()
        getHierarchicalChildIds(
            database,
            parentId,
            typeRestriction
        ).execute()
            .allResults().forEach { result ->
                result.getString(id)?.let { childId ->
                    getEntityById<HierarchicalObject>(childId)?.let {
                        children.add(it)
                    }
                }
            }
        return children
    }

    private suspend fun getUserSettings(userId: String): UserSettings? {
        return getUserSettingsId(database, userId)
            .execute()
            .allResults()
            .firstOrNull()?.getString(id)?.let {
                getEntityById(it)
            }
    }

    private suspend fun getAnnotations(
        entityId: String,
        annotationType: EntityType? = null,
        includeChildAnnotations: Boolean = false
    ): List<Annotation> {
        val annotations: MutableList<Annotation> = mutableListOf()
        getAnnotationIds(
            database,
            entityId,
            annotationType
        ).execute()
            .allResults().forEach { result ->
                result.getString(id)?.let { annotationId ->
                    getEntityById<Annotation>(annotationId)?.let {
                        annotations.add(it)
                    }
                }
            }
        if (includeChildAnnotations) {
            getHierarchicalChildren(entityId).forEach { child ->
                annotations.addAll(
                    getAnnotations(child.id, annotationType, includeChildAnnotations)
                )
            }
        }
        return annotations
    }
    //endregion

    //region DocNumber handling
    private suspend fun assignDocNumber(entityId: String, userId: String) {
        getEntityById<DocNumberObject>(entityId)?.let { childObject ->
            getHierarchicalParent(entityId)?.let { parentObject ->
                getHierarchicalChildren(parentObject.id)
                    .filterIsInstance<DocNumberObject>()
                    .filter { it.id != entityId }
                    .let { siblings ->
                        // Get max doc number of siblings
                        siblings.map { it.docNumber?.docNumberEntries }.filterNotNull()
                            .maxByOrNull { it.last() }
                            ?.let { docNumberEntries ->
                                // Create a new DocNumber for entity and update
                                val newEntries = mutableListOf<Int>()
                                newEntries.addAll(docNumberEntries)
                                // Increase last number
                                newEntries[newEntries.lastIndex]++
                                // Set DocNumber
                                childObject.docNumber = DocNumber(newEntries)
                                // Update object
                                update(childObject as BaseEntity, userId)
                                log.d("Assigned DocNumber to ${childObject.entityType}: ${childObject.docNumber?.docNumberString}")
                            } ?: run {
                            // There are no siblings (with DocNumbers)
                            // So this is the first object on its level, therefore we assign a new DocNumber
                            // First, we the DocNumber of the parent
                            (parentObject as? DocNumberObject)?.let {
                                it.docNumber?.docNumberEntries?.let { parentEntries ->
                                    // Create a new DocNumber for entity and update
                                    val newEntries = mutableListOf<Int>()
                                    newEntries.addAll(parentEntries)
                                    // Add new number entry
                                    newEntries.add(1)
                                    // Set DocNumber
                                    childObject.docNumber = DocNumber(newEntries)
                                    // Update object
                                    update(childObject as BaseEntity, userId)
                                    log.d("Assigned DocNumber to ${childObject.entityType}: ${childObject.docNumber?.docNumberString}")
                                } ?: run {
                                    // Recursively assign DocNumber to parent
                                    assignDocNumber(parentObject.id, userId)
                                    // Now call function again for the original object
                                    assignDocNumber(entityId, userId)
                                }
                            } ?: run {
                                // The parent is not a DocNumberObject, which means its an Investigation
                                // Because there are no siblings, we assign the very first number
                                // Just to be sure, check our assumptions
                                if (parentObject is Investigation && childObject is CrimeScene) {
                                    // Set DocNumber
                                    childObject.docNumber = DocNumber(listOf(1))
                                    // Update object
                                    update(childObject as BaseEntity, userId)
                                    log.d("Assigned DocNumber to ${childObject.entityType}: ${childObject.docNumber?.docNumberString}")
                                }
                            }
                        }
                    }
            }
        }
    }

    private suspend fun updateChildDocNumbers(entityId: String, userId: String) {
        getEntityById<DocNumberObject>(entityId)?.let { parentObject ->
            getHierarchicalChildren(parentObject.id)
                .filterIsInstance<DocNumberObject>()
                .let { children ->
                    parentObject.docNumber?.let { parentDocNumber ->
                        children.forEach { childObject ->
                            childObject.docNumber?.let { childDocNumber ->
                                val oldDocNumberString = childDocNumber.docNumberString
                                // Update old parent entries with current ones
                                val newEntries = mutableListOf<Int>()
                                newEntries.addAll(parentDocNumber.docNumberEntries)
                                for (i in parentDocNumber.docNumberEntries.size until childDocNumber.docNumberEntries.size) {
                                    newEntries.add(childDocNumber.docNumberEntries[i])
                                }
                                childObject.docNumber = DocNumber(newEntries)
                                // Update child
                                update(childObject as BaseEntity, userId)
                                // Recursively update DocNumbers of grand children
                                updateChildDocNumbers(childObject.id, userId)
                                log.d("Changed DocNumber from $oldDocNumberString to ${childObject.docNumber!!.docNumberString}")
                            }
                        }
                    }
                }
        }
    }
    //endregion

    //region Util
    private suspend fun getDeletableAnnotations(
        entityId: String
    ): List<BaseEntity> {
        val annotations: MutableList<BaseEntity> = mutableListOf()
        // Fetch the IDs of all annotations that are connected to the entity with the given ID
        var annotationIds = getAnnotationIds(database, entityId)
            .execute()
            .allResults()
            .map { it.getString(id) }
            .filterNotNull()
        // Fetch th IDs of all annotations that are connected to at least one other entity
        val excludedAnnotationIds =
            getAnnotationIdsNotRelatedToEntity(database, entityId)
                .execute()
                .allResults()
                .map { it.getString(id) }
                .filterNotNull()
        // Filter these IDs from the annotationIds list
        // What remains are the IDs of annotations that are solely connected to the given entity
        annotationIds = annotationIds.filter { excludedAnnotationIds.contains(it) }
        // Collect annotation entities
        annotationIds.forEach { annotationId ->
            getEntityById<BaseEntity>(annotationId)?.let {
                annotations.add(it)
            }
        }
        return annotations
    }

    private suspend fun getImageTags(entityId: String): List<ImageTag> {
        val imageTags: MutableList<ImageTag> = mutableListOf()
        getImageTagIds(database, entityId).execute()
            .allResults()
            .forEach { result ->
                result.getString(id)?.let { imageTagId ->
                    getEntityById<ImageTag>(imageTagId)?.let {
                        imageTags.add(it)
                    }
                }
            }
        return imageTags
    }

    private suspend fun getRelationsBySourceOrTarget(
        sourceOrTargetId: String,
        relationType: EntityType?
    ): List<BaseEntity> {
        val relations: MutableList<BaseEntity> = mutableListOf()
        getRelationIdsBySourceOrTarget(database, sourceOrTargetId, relationType).execute()
            .allResults()
            .forEach { result ->
                result.getString(id)?.let { relationId ->
                    getEntityById<BaseEntity>(relationId)?.let {
                        relations.add(it)
                    }
                }
            }
        return relations
    }
    //endregion


}
