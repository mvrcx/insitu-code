package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.ExifData
import p20.insitu.model.components.spatial.geodetic.GeoPose
import p20.insitu.model.components.spatial.geometry2d.shapes.ComposedShape2D
import p20.insitu.model.components.spatial.geometry3d.Pose
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime

@Serializable
data class Image(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var filename: String? = null,
    override var deviceId: String? = null,
    override var annotationType: CatalogCodeFixed<KatalogCode102>? = null,
    override var keywords: List<String>? = null,
    override var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>? = null,
    override var creationDate: ZonedDateTime? = null,
    var planPose: Pose? = null,
    var geoPose: GeoPose? = null,
    var exifData: ExifData? = null,
    var sketch: ComposedShape2D? = null
) : BaseEntity(), Annotation {

    override val entityType: String = EntityType.IMAGE.toString()

}
