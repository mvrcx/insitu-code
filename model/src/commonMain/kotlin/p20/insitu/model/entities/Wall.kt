package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.DocNumber
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType

@Serializable
data class Wall(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    var startHeight: Float,
    var endHeight: Float,
    var thickness: Float = 0.20f
    ) : BaseEntity(), SpatialSemanticObject {

    override val entityType: String = EntityType.WALL.toString()

}
