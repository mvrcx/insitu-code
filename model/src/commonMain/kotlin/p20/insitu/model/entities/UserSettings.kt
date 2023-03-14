package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.entities.enums.EntityType

@Serializable
data class UserSettings(
    override var deleted: Boolean = false,
    var userId: String?,
    var lastActiveInvestigationId: String?,
    var lastActiveCrimeSceneId: String?,
    var lastActiveDocuObjectId: String?
) : BaseEntity() {

    override val entityType: String = EntityType.USER_SETTINGS.toString()

}
