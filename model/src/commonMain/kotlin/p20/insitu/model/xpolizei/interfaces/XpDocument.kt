package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDate
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.DigitalData

interface XpDocument {

    var type: CatalogCodeNotComplete<KatalogCode388_NichtAbgeschlossen>?
    var version: String?
    var subject: String?
    var processingStatus: CatalogCodeFixed<KatalogCode221>?
    var comment: String?
    var creationDate: LocalDate?
    var digitalData: List<DigitalData>?
    var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>?

    fun getDokument(): Dokument

}