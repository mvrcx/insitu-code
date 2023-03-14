package p20.insitu.model.entities

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.Document
import p20.insitu.model.components.ZonedDateTime

@Serializable
data class Document(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var filename: String?,
    override var deviceId: String?,
    override var annotationType: CatalogCodeFixed<KatalogCode102>?,
    override var keywords: List<String>?,
    override var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>?,
    override var creationDate: ZonedDateTime?,
    var documents: List<Document>?
) : BaseEntity(), Annotation {

    override val entityType: String = EntityType.DOCUMENT.toString()

    fun getDokumente(): List<Dokument>? {
        return documents?.map { it.getDokument() }
    }

    override fun getAufzeichnung(): Aufzeichnung {
        return super.getAufzeichnung().also {
            it.dokument = getDokumente()
        }
    }

}
