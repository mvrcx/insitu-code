package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode243_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Merkmal
import p20.insitu.model.components.BodyPartDescription
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpPhysicalFeature {

    var designation: CatalogCodeNotComplete<KatalogCode243_NichtAbgeschlossen>?
    var location: BodyPartDescription?
    var comment: String?

    fun getMerkmal(): Merkmal
}