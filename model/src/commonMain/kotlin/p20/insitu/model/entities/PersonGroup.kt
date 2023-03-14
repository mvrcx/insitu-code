package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.DocNumber
import p20.insitu.model.entities.enums.EntityType

@Serializable
data class PersonGroup(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var docNumber: DocNumber? = null
) : BaseEntity(), DocNumberObject {

    override val entityType: String = EntityType.PERSON_GROUP.toString()

}