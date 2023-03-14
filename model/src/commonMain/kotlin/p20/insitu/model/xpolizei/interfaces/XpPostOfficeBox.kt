package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Postfach
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpPostOfficeBox {

    var number: String?
    var city: String?
    var postalCode: String?
    var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?

    fun getPostfach(): Postfach
}