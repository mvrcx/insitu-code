package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode277
import p20.insitu.model.xpolizei.schema.Verletzung
import p20.insitu.model.components.BodyPartDescription
import p20.insitu.model.components.CatalogCodeFixed

interface XpInjury {

    var designation: String?
    var location: BodyPartDescription?
    var severity: CatalogCodeFixed<KatalogCode277>?
    var comment: String?

    fun getVerletzung(): Verletzung

}