package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.DocNumber
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.model.components.CatalogCodeNotComplete

@Serializable
data class Floor(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation? = null,
    override var locationType: CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>? = null,
    var shortDescription: String? = null,
    var height: Float? = null
) : BaseEntity(), BuildingSite {

    override val entityType: String = EntityType.FLOOR.toString()

}
