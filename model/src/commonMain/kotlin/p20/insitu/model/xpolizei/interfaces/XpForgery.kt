package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Faelschung
import p20.insitu.model.xpolizei.schema.KatalogCode222
import p20.insitu.model.components.CatalogCodeFixed

interface XpForgery {

    var type: CatalogCodeFixed<KatalogCode222>?
    var features: String?

    fun getFaelschung(): Faelschung
}