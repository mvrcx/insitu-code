package p20.insitu.model.components

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpDocument
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Document(
    override var type: CatalogCodeNotComplete<KatalogCode388_NichtAbgeschlossen>?,
    override var version: String?,
    override var subject: String?,
    override var processingStatus: CatalogCodeFixed<KatalogCode221>?,
    override var comment: String?,
    override var creationDate: LocalDate?,
    override var digitalData: List<DigitalData>?,
    override var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>?
) : Component(), XpDocument {

    override fun getDokument(): Dokument {
        return Dokument().also {
            it.art = type?.getKatalogCodeNichtAbgeschlossen()
            it.bearbeitungsstand = processingStatus?.getKatalogCode()
            it.version = version
            it.betreff = subject
            it.bemerkung = comment
            it.erstelldatum = creationDate?.toString()
            it.digitaleDaten = digitalData?.map { it.getDigitaleDaten() }
            it.sprache =
                language?.map { it.getKatalogCodeNichtAbgeschlossen() }?.filterNotNull()
        }
    }
}