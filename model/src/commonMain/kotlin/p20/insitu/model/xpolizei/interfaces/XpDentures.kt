package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Gebiss
import p20.insitu.model.xpolizei.schema.KatalogCode374
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.Tooth

interface XpDentures {

    var specialFeatures: List<CatalogCodeFixed<KatalogCode374>>?
    var teeth: List<Tooth>?

    fun getGebiss(): Gebiss
}