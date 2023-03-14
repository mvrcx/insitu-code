package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Anschrift
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpPostalAddress {

    var street: String?
    var houseNumber: String?
    var district: String?
    var streetCode: String?
    var alternativeAddress: String?
    var city: String?
    var postalCode: String?
    var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?

    fun getAnschrift(): Anschrift
}