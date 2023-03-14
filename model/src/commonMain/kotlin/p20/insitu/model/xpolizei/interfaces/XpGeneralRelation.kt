package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Beziehung_allgemein
import p20.insitu.model.xpolizei.schema.KatalogCode001
import p20.insitu.model.components.CatalogCodeFixed

interface XpGeneralRelation {

     var role: CatalogCodeFixed<KatalogCode001>?
     var designation: String?
     var comment: String?

    fun getBeziehungAllgemein(): Beziehung_allgemein

}