package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Farbangabe
import p20.insitu.model.xpolizei.schema.KatalogCode228_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode229
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpColorDescription {

    var color: CatalogCodeNotComplete<KatalogCode228_NichtAbgeschlossen>?
    var colorEffect: CatalogCodeFixed<KatalogCode229>?
    var designation: String?
    var comment: String?

    fun getFarbangabe(): Farbangabe
}