package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.Material
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Door(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation? = null,
    override var evidenceData: EvidenceData? = null,
    override var typeOfObject: CatalogCodeNotComplete<KatalogCode119_NichtAbgeschlossen>? = null,
    override var specialFeatures: String? = null,
    override var comment: String? = null,
    override var material: List<Material>? = null,
    override var color: List<ColorDescription>? = null,
    override var length: Size? = null,
    override var width: Size? = null,
    override var height: Size? = null,
    override var volume: Volume? = null,
    override var weight: Weight? = null,
    override var numberOfPieces: Int? = null
) : BaseEntity(), ISomeObject {

    override val entityType: String = EntityType.DOOR.toString()

}
