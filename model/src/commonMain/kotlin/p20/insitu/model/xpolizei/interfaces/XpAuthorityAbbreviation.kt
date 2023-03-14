package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Behoerdenkennzeichnung
import p20.insitu.model.xpolizei.schema.KatalogCode389
import p20.insitu.model.components.CatalogCodeFixed

interface XpAuthorityAbbreviation {

    var designation: String?
    var code: CatalogCodeFixed<KatalogCode389>?

    fun getBehoerdenkennzeichnung(): Behoerdenkennzeichnung
}