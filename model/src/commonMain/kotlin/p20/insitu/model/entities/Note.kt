package p20.insitu.model.entities

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime

@Serializable
data class Note(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var filename: String? = null,
    override var deviceId: String? = null,
    override var annotationType: CatalogCodeFixed<KatalogCode102>? = null,
    override var keywords: List<String>? = null,
    override var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>? = null,
    override var creationDate: ZonedDateTime? = null,
    var text: String? = null
) : BaseEntity(), Annotation {

    override val entityType: String = EntityType.NOTE.toString()

}
