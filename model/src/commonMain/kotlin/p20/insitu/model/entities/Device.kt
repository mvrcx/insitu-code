package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.entities.enums.EntityType

@Serializable
data class Device(
    override var deleted: Boolean = false,
    var designation: String?,
    var serialNumber: String?
) : BaseEntity() {

    override val entityType: String = EntityType.DEVICE.toString()

}
