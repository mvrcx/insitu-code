package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.xpolizei.schema.Verpackung
import p20.insitu.model.components.CatalogCodeFixed

interface XpPackaging {

    var primaryPackaging: String?
    var secondaryPackaging: String?
    var leaflet: CatalogCodeFixed<KatalogCode217>?

    fun getVerpackung(): Verpackung
}