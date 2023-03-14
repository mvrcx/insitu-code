package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode274_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Taetowierung
import p20.insitu.model.components.BodyPartDescription
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpTatoo {

    var motive: CatalogCodeNotComplete<KatalogCode274_NichtAbgeschlossen>?
    var location: BodyPartDescription?
    var comment: String?

    fun getTaetowierung(): Taetowierung

}