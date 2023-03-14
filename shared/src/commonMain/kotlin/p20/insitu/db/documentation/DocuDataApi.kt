package p20.insitu.db.documentation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import p20.insitu.model.entities.*
import p20.insitu.model.entities.Annotation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.entities.enums.EntityTypeIdentifier

@OptIn(ExperimentalCoroutinesApi::class)
expect class DocuDataApi() : KoinComponent {

    //region Observe data
    fun <T : IBaseEntity> observeEntity(entityId: String): Flow<T?>
    //endregion

    //region Live queries
    fun liveQueryAddress(crimeSceneId: String): Flow<Address?>

    fun <T : Annotation> liveQueryAnnotations(
        entityId: String,
        annotationType: EntityType? = null
    ): Flow<List<T>>

    fun liveQueryAudioAnnotations(entityId: String): Flow<List<Audio>>

    fun liveQueryCriminalOffenses(entityId: String): Flow<List<CriminalOffense>>

    fun liveQueryHierarchicalChildIds(
        parentId: String,
        typeIdentifier: EntityTypeIdentifier?
    ): Flow<List<String>>

    fun liveQueryHierarchicalChildren(
        parentId: String,
        typeIdentifier: EntityTypeIdentifier?
    ): Flow<List<HierarchicalObject>>

    fun liveQueryHierarchicalParent(childId: String): Flow<HierarchicalObject?>

    fun liveQueryImageAnnotations(entityId: String): Flow<List<Image>>

    fun liveQueryInvestigations(userId: String): Flow<List<Investigation>>

    fun liveQueryLastActiveCrimeScene(userId: String): Flow<CrimeScene?>

    fun liveQueryLastActiveDocuObject(userId: String): Flow<Investigation?>

    fun liveQueryLastActiveInvestigation(userId: String): Flow<Investigation?>

    fun <T : Annotation> liveQueryNestedAnnotations(
        entityId: String,
        annotationType: EntityType?
    ): Flow<List<T>>

    fun liveQueryNestedAudioAnnotations(entityId: String): Flow<List<Audio>>

    fun liveQueryNestedImageAnnotations(entityId: String): Flow<List<Image>>

    fun liveQueryNestedNoteAnnotations(entityId: String): Flow<List<Note>>

    fun liveQueryNestedVideoAnnotations(entityId: String): Flow<List<Video>>

    fun liveQueryNoteAnnotations(entityId: String): Flow<List<Note>>

    fun liveQueryPersons(entityId: String): Flow<List<Person>>

    fun liveQueryUserAnnotationIds(
        investigationId: String,
        userId: String,
        type: EntityType
    ): Flow<List<String>>

    fun liveQueryVideoAnnotations(entityId: String): Flow<List<Video>>
    //endregion

    //region Update
    fun update(entity: BaseEntity, userId: String, updateChildDocNumbers: Boolean = false)
    //endregion

    //region Save
    fun saveAddress(
        address: Address,
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    )

    fun saveAnnotation(
        annotation: Annotation,
        docuObject: DocumentationObject,
        investigation: Investigation,
        userId: String
    )

    fun saveCrimeScene(
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    )

    fun saveCriminalOffense(
        criminalOffense: CriminalOffense,
        investigation: Investigation,
        userId: String
    )

    fun saveEvidence(
        evidence: Evidence,
        topologicalParent: DocNumberObject,
        investigation: Investigation,
        userId: String
    )

    fun saveInvestigation(investigation: Investigation, userId: String)

    fun savePerson(
        person: Person,
        investigation: Investigation,
        userId: String
    )

    fun saveSite(site: Site, crimeScene: CrimeScene, investigation: Investigation, userId: String)

    fun saveSubSite(site: Site, parentSite: Site, investigation: Investigation, userId: String)

    fun saveUserSettings(
        userId: String,
        lastActiveInvestigationId: String?,
        lastActiveCrimeSceneId: String?,
        lastActiveDocuObjectId: String?
    )
    //endregion

    //region Delete
    fun deleteBaseEntity(entity: IBaseEntity, userId: String)

    fun deleteAll()
    //endregion

    //region Fetch
    suspend fun <T : IBaseEntity> getEntityById(id: String): T?

    suspend fun getRelatedAddress(entityId: String): Address?
    //endregion

}