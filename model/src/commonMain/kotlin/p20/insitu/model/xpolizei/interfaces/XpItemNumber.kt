package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.xpolizei.schema.Nummernangabe
import p20.insitu.model.components.CatalogCodeFixed

interface XpItemNumber {

    var number: String?
    var designation: String?
    var unique: CatalogCodeFixed<KatalogCode217>?

    fun getNummernangabe(): Nummernangabe

}