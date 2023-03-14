package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.xpolizei.schema.KatalogCode367
import p20.insitu.model.xpolizei.schema.Schusswaffenzustandsinformation
import p20.insitu.model.components.CatalogCodeFixed

interface XpFirearmCondition {

    var safetyOn: CatalogCodeFixed<KatalogCode217>?
    var safetyExisting: CatalogCodeFixed<KatalogCode217>?
    var fireMode: CatalogCodeFixed<KatalogCode367>?
    var loaded: CatalogCodeFixed<KatalogCode217>?
    var cocked: CatalogCodeFixed<KatalogCode217>?
    var barrelCondition: String?
    var breechCondition: String?

    fun getSchusswaffenzustandsinformation(): Schusswaffenzustandsinformation

}