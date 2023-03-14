package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode326
import p20.insitu.model.xpolizei.schema.VerboteneSubstanz
import p20.insitu.model.components.CatalogCodeFixed

interface XpIllegalSubstance {

    var type: CatalogCodeFixed<KatalogCode326>?
    var designation: String?

    fun getVerboteneSubstanz(): VerboteneSubstanz
}