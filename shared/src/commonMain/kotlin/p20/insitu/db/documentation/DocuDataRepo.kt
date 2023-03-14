package p20.insitu.db.documentation

import co.touchlab.kermit.Logger
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import p20.insitu.model.entities.*
import p20.insitu.model.entities.Annotation
import org.koin.core.component.KoinComponent
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.entities.enums.EntityTypeIdentifier

@OptIn(ExperimentalCoroutinesApi::class)
class DocuDataRepo(
    private val log: Logger,
    private val docuDataApi: DocuDataApi
) : KoinComponent {

    //region Save
    fun saveAddress(
        address: Address,
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        docuDataApi.saveAddress(
            address = address,
            crimeScene = crimeScene,
            investigation = investigation,
            userId = userId
        )
    }

    fun saveAnnotation(
        annotation: Annotation,
        docuObject: DocumentationObject,
        investigation: Investigation,
        userId: String
    ) {
        docuDataApi.saveAnnotation(
            annotation = annotation,
            docuObject = docuObject,
            investigation = investigation,
            userId = userId
        )
    }

    fun saveCrimeScene(
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        docuDataApi.saveCrimeScene(
            crimeScene = crimeScene,
            investigation = investigation,
            userId = userId
        )
    }

    fun saveCriminalOffense(
        criminalOffense: CriminalOffense,
        investigation: Investigation,
        userId: String
    ) {
        docuDataApi.saveCriminalOffense(
            criminalOffense = criminalOffense,
            investigation = investigation,
            userId = userId
        )
    }

    fun saveEvidence(
        evidence: Evidence,
        topologicalParent: DocNumberObject,
        investigation: Investigation,
        userId: String
    ) {
        docuDataApi.saveEvidence(
            evidence = evidence,
            topologicalParent = topologicalParent,
            investigation = investigation,
            userId = userId
        )
    }

    fun saveInvestigation(investigation: Investigation, userId: String) {
        docuDataApi.saveInvestigation(
            investigation = investigation,
            userId = userId
        )
    }

    fun savePerson(
        person: Person,
        investigation: Investigation,
        userId: String
    ) {
        docuDataApi.savePerson(
            person = person,
            investigation = investigation,
            userId = userId
        )
    }

    fun saveSite(
        site: Site,
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        docuDataApi.saveSite(
            site = site,
            crimeScene = crimeScene,
            investigation = investigation,
            userId = userId
        )
    }

    fun saveSubSite(
        site: Site,
        parentSite: Site,
        investigation: Investigation,
        userId: String
    ) {
        docuDataApi.saveSubSite(
            site = site,
            parentSite = parentSite,
            investigation = investigation,
            userId = userId
        )
    }

    fun saveUserSettings(
        userId: String,
        lastActiveInvestigationId: String?,
        lastActiveCrimeSceneId: String?,
        lastActiveDocuObjectId: String?
    ) {
        docuDataApi.saveUserSettings(
            userId = userId,
            lastActiveInvestigationId = lastActiveInvestigationId,
            lastActiveCrimeSceneId = lastActiveCrimeSceneId,
            lastActiveDocuObjectId = lastActiveDocuObjectId
        )
    }

    //endregion

    //region Update
    fun update(entity: BaseEntity, userId: String, updateChildDocNumbers: Boolean = false) {
        docuDataApi.update(
            entity = entity,
            userId = userId,
            updateChildDocNumbers = updateChildDocNumbers
        )
    }
    //endregion

    //region Delete
    fun deleteBaseEntity(entity: IBaseEntity, userId: String) {
        docuDataApi.deleteBaseEntity(
            entity = entity,
            userId = userId
        )
    }

    fun deleteAll() {
        docuDataApi.deleteAll()
    }
    //endregion

    //region Fetch
    suspend fun <T : IBaseEntity> getEntityById(id: String): T? {
        return docuDataApi.getEntityById(id)
    }

    suspend fun getRelatedAddress(entityId: String): Address? {
        return docuDataApi.getRelatedAddress(entityId)
    }
    //endregion

    //region Observe data
    fun observeDocNumberParent(childId: String): Flow<DocNumberObject?> {
        return liveQueryHierarchicalParent(childId).flatMapLatest { parent ->
            (parent as? DocNumberObject)?.let {
                observeEntity<DocNumberObject>(it.id).onStart { emit(it) }
            } ?: flow { emit(null) }
        }
    }

    fun observeDocNumberChildren(parentId: String): Flow<List<DocNumberObject>> {
        return liveQueryHierarchicalChildren(parentId).flatMapLatest { children ->
            if (children.isEmpty()) {
                flow { emit(listOf()) }
            } else {
                combine(
                    children.map { child ->
                        observeEntity<DocumentationObject>(child.id)
                            .onStart { emit(child) }
                    }
                ) {
                    it.asList().filterIsInstance<DocNumberObject>()
                }
            }
        }
    }

    fun <T : IBaseEntity> observeEntity(entityId: String): Flow<T?> {
        return docuDataApi.observeEntity(entityId)
    }

    fun observeInvestigations(userId: String): Flow<List<Investigation>> {
        return liveQueryInvestigations(userId).flatMapLatest { investigations ->
            combine(
                investigations.map { investigation ->
                    observeEntity<Investigation>(investigation.id)
                        .onStart { emit(investigation) }
                }
            ) {
                it.asList().filterNotNull()
            }
        }
    }

    fun observeLastActiveCrimeScene(userId: String): Flow<CrimeScene?> {
        return liveQueryLastActiveCrimeScene(userId).flatMapLatest { crimeScene ->
            crimeScene?.let {
                observeEntity<CrimeScene>(it.id).onStart { emit(it) }
            } ?: flow { emit(null) }
        }
    }

    fun observeLastActiveDocuObject(userId: String): Flow<DocumentationObject?> {
        return liveQueryLastActiveDocuObject(userId).flatMapLatest { docuObject ->
            docuObject?.let {
                observeEntity<DocumentationObject>(it.id).onStart { emit(it) }
            } ?: flow { emit(null) }
        }
    }

    fun observeLastActiveInvestigation(userId: String): Flow<Investigation?> {
        return liveQueryLastActiveInvestigation(userId).flatMapLatest { investigation ->
            investigation?.let {
                observeEntity<Investigation>(it.id).onStart { emit(it) }
            } ?: flow { emit(null) }
        }
    }

    fun observeRelatedAddress(crimeSceneId: String): Flow<Address?> {
        return liveQueryAddress(crimeSceneId).flatMapLatest { address ->
            address?.let {
                observeEntity<Address>(it.id).onStart { emit(it) }
            } ?: flow { emit(null) }
        }
    }

    fun observeRelatedCrimeScenes(investigationId: String): Flow<List<CrimeScene>> {
        return liveQueryCrimeScenes(investigationId).flatMapLatest { crimeScenes ->
            if (crimeScenes.isEmpty()) {
                flow { emit(listOf()) }
            } else {
                combine(
                    crimeScenes.map { crimeScene ->
                        observeEntity<CrimeScene>(crimeScene.id)
                            .onStart { emit(crimeScene) }
                    }
                ) {
                    it.asList().filterIsInstance<CrimeScene>()
                }
            }
        }
    }

    fun observeRelatedCriminalOffenses(entityId: String): Flow<List<CriminalOffense>> {
        return liveQueryCriminalOffenses(entityId).flatMapLatest { criminalOffenses ->
            if (criminalOffenses.isEmpty()) {
                flow { emit(listOf()) }
            } else {
                combine(
                    criminalOffenses.map { criminalOffense ->
                        observeEntity<CriminalOffense>(criminalOffense.id)
                            .onStart { emit(criminalOffense) }
                    }
                ) {
                    it.asList().filterIsInstance<CriminalOffense>()
                }
            }
        }
    }

    fun observeRelatedPersons(entityId: String): Flow<List<Person>> {
        return liveQueryPersons(entityId).flatMapLatest { persons ->
            if (persons.isEmpty()) {
                flow { emit(listOf()) }
            } else {
                combine(
                    persons.map { person ->
                        observeEntity<Person>(person.id)
                            .onStart { emit(person) }
                    }
                ) {
                    it.asList().filterIsInstance<Person>()
                }
            }
        }
    }
    //endregion

    //region Live queries

    private fun liveQueryAddress(crimeSceneId: String): Flow<Address?> {
        return docuDataApi.liveQueryAddress(crimeSceneId)
    }

    fun liveQueryAudioAnnotations(entityId: String): Flow<List<Audio>> {
        return docuDataApi.liveQueryAudioAnnotations(entityId)
    }

    private fun liveQueryCrimeScenes(investigationId: String): Flow<List<CrimeScene>> {
        return docuDataApi.liveQueryHierarchicalChildren(
            parentId = investigationId,
            typeIdentifier = EntityType.CRIME_SCENE
        ).map { it.filterIsInstance<CrimeScene>() }
    }

    private fun liveQueryCriminalOffenses(investigationId: String): Flow<List<CriminalOffense>> {
        return docuDataApi.liveQueryCriminalOffenses(investigationId)
    }

    private fun liveQueryHierarchicalChildren(
        investigationId: String,
        typeIdentifier: EntityTypeIdentifier? = null
    ): Flow<List<HierarchicalObject>> {
        return docuDataApi.liveQueryHierarchicalChildren(
            parentId = investigationId,
            typeIdentifier = typeIdentifier
        )
    }

    private fun liveQueryHierarchicalParent(childId: String): Flow<DocumentationObject?> {
        return docuDataApi.liveQueryHierarchicalParent(childId)
    }

    private fun liveQueryInvestigations(userId: String): Flow<List<Investigation>> {
        return docuDataApi.liveQueryInvestigations(userId)
    }

    fun liveQueryImageAnnotations(entityId: String): Flow<List<Image>> {
        return docuDataApi.liveQueryImageAnnotations(entityId)
    }

    private fun liveQueryLastActiveCrimeScene(userId: String): Flow<CrimeScene?> {
        return docuDataApi.liveQueryLastActiveCrimeScene(userId)
    }

    private fun liveQueryLastActiveDocuObject(userId: String): Flow<DocumentationObject?> {
        return docuDataApi.liveQueryLastActiveDocuObject(userId)
    }

    private fun liveQueryLastActiveInvestigation(userId: String): Flow<Investigation?> {
        return docuDataApi.liveQueryLastActiveInvestigation(userId)
    }

    fun liveQueryNestedAudioAnnotations(entityId: String): Flow<List<Audio>> {
        return docuDataApi.liveQueryNestedAudioAnnotations(entityId)
    }

    fun liveQueryNestedImageAnnotations(entityId: String): Flow<List<Image>> {
        return docuDataApi.liveQueryNestedImageAnnotations(entityId)
    }

    fun liveQueryNestedNoteAnnotations(entityId: String): Flow<List<Note>> {
        return docuDataApi.liveQueryNestedNoteAnnotations(entityId)
    }

    fun liveQueryNestedVideoAnnotations(entityId: String): Flow<List<Video>> {
        return docuDataApi.liveQueryNestedVideoAnnotations(entityId)
    }

    fun liveQueryNoteAnnotations(entityId: String): Flow<List<Note>> {
        return docuDataApi.liveQueryNoteAnnotations(entityId)
    }

    private fun liveQueryPersons(entityId: String): Flow<List<Person>> {
        return docuDataApi.liveQueryPersons(entityId)
    }

    fun liveQueryUserAnnotationIds(
        investigationId: String,
        userId: String,
        type: EntityType
    ): Flow<List<String>> {
        return docuDataApi.liveQueryUserAnnotationIds(investigationId, userId, type)
    }

    fun liveQueryVideoAnnotations(entityId: String): Flow<List<Video>> {
        return docuDataApi.liveQueryVideoAnnotations(entityId)
    }
    //endregion

}