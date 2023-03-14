package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode245
import p20.insitu.model.xpolizei.schema.KatalogCode316
import p20.insitu.model.xpolizei.schema.ModusOperandi
import p20.insitu.model.components.CatalogCodeFixed

interface XpModusOperandi {

    var type: CatalogCodeFixed<KatalogCode245>?
    var designation: String?
    var crimePhase: CatalogCodeFixed<KatalogCode316>?

    fun getModusOperandi(): ModusOperandi

}