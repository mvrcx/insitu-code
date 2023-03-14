package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Oertlichkeit
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpLocation : XpCommonBaseClass {

    var designation:String?
    var locationType: CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>?

    fun getOertlichkeit(): Oertlichkeit
}