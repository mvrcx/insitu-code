package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpFirearmManufacturingInformation {

    var manufacturer: CatalogCodeNotComplete<KatalogCode290_NichtAbgeschlossen>?
    var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?
    var manufacturingDate: String?

    fun getSchusswaffenherstellungsinformation(): Schusswaffenherstellungsinformation
}