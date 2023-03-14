package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode311
import p20.insitu.model.xpolizei.schema.Zahn
import p20.insitu.model.components.CatalogCodeFixed

interface XpTooth {

    var number: CatalogCodeFixed<KatalogCode311>?
    var color: String?
    var status: String?
    var condition: String?
    var material: String?
    var comment: String?
    var specialFeatures: String?

    fun getZahn(): Zahn
}