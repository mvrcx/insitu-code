package p20.insitu.db.documentation

import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import p20.insitu.model.entities.*
import p20.insitu.model.entities.Annotation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.entities.enums.EntityTypeIdentifier

actual class DocuDataApi : KoinComponent {

    //region Observe data
    actual fun <T : IBaseEntity> observeEntity(entityId: String): Flow<T?> {
        TODO("Not yet implemented")
    }
    //endregion

    //region Live queries
    actual fun liveQueryAddress(entityId: String): Flow<Address?> {
        TODO("Not yet implemented")
    }

    actual fun <T : Annotation> liveQueryAnnotations(
        entityId: String,
        annotationType: EntityType?
    ): Flow<List<T>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryAudioAnnotations(entityId: String): Flow<List<Audio>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryCriminalOffenses(entityId: String): Flow<List<CriminalOffense>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryHierarchicalChildIds(
        parentId: String,
        typeIdentifier: EntityTypeIdentifier?
    ): Flow<List<String>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryHierarchicalChildren(
        parentId: String,
        typeIdentifier: EntityTypeIdentifier?
    ): Flow<List<HierarchicalObject>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryHierarchicalParent(childId: String): Flow<HierarchicalObject?> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryImageAnnotations(entityId: String): Flow<List<Image>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryInvestigations(userId: String): Flow<List<Investigation>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryLastActiveDocuObject(userId: String): Flow<Investigation?> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryLastActiveInvestigation(userId: String): Flow<Investigation?> {
        TODO("Not yet implemented")
    }

    actual fun <T : Annotation> liveQueryNestedAnnotations(
        entityId: String,
        annotationType: EntityType?
    ): Flow<List<T>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryNestedAudioAnnotations(entityId: String): Flow<List<Audio>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryNestedImageAnnotations(entityId: String): Flow<List<Image>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryNestedNoteAnnotations(entityId: String): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryNestedVideoAnnotations(entityId: String): Flow<List<Video>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryNoteAnnotations(entityId: String): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    actual fun liveQueryVideoAnnotations(entityId: String): Flow<List<Video>> {
        TODO("Not yet implemented")
    }
    //endregion

    actual fun update(entity: BaseEntity, userId: String, updateChildDocNumbers: Boolean) {
        TODO("Not yet implemented")
    }

    //region Save
    actual fun saveAddress(
        address: Address,
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

    actual fun saveCrimeScene(
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

    actual fun saveCriminalOffense(
        criminalOffense: CriminalOffense,
        investigation: Investigation,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

    actual fun saveEvidence(
        evidence: Evidence,
        topologicalParent: DocNumberObject,
        investigation: Investigation,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

    actual fun saveImage(
        image: Image,
        docuObject: DocumentationObject,
        investigation: Investigation,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

    actual fun saveInvestigation(investigation: Investigation, userId: String) {
        TODO("Not yet implemented")
    }

    actual fun saveUserSettings(
        userId: String,
        lastActiveInvestigationId: String?,
        lastActiveCrimeSceneId: String?,
        lastActiveDocuObjectId: String?
    ) {
        TODO("Not yet implemented")
    }

    actual fun saveSite(
        site: Site,
        crimeScene: CrimeScene,
        investigation: Investigation,
        userId: String
    ) {
        TODO("Not yet implemented")
    }

    actual fun saveSubSite(
        site: Site,
        parentSite: Site,
        investigation: Investigation,
        userId: String
    ) {
        TODO("Not yet implemented")
    }
    //endregion

    //region Delete
    actual fun deleteBaseEntity(entity: IBaseEntity, userId: String) {
        TODO("Not yet implemented")
    }

    actual fun deleteAll() {
        TODO("Not yet implemented")
    }
    //endregion

    //region Fetch
    actual suspend fun <T : IBaseEntity> getEntityById(id: String): T? {
        TODO("Not yet implemented")
    }
    //endregion
}