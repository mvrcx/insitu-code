package p20.insitu.model.entities

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geometry2d.shapes.ComposedShape2D
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.KatalogCode102
import p20.insitu.model.xpolizei.schema.KatalogCode203_NichtAbgeschlossen
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime

@Serializable
data class Sketch(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var filename: String?,
    override var deviceId: String?,
    override var annotationType: CatalogCodeFixed<KatalogCode102>?,
    override var keywords: List<String>?,
    override var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>?,
    override var creationDate: ZonedDateTime?,
    var sketch: ComposedShape2D?
) : BaseEntity(), Annotation {

    override val entityType: String = EntityType.SKETCH.toString()

}
