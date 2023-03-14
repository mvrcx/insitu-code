package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Herstellungsinformation
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpManufacturingInformation {

    var manufacturer: String?
    var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?
    var manufacuringDate: String?

    fun getHerstellungsinformation(): Herstellungsinformation

}