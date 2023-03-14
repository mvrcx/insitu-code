package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode242_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Material
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpMaterial {

    var type: CatalogCodeNotComplete<KatalogCode242_NichtAbgeschlossen>?
    var designation: String?
    var percentage: Double?
    var comment: String?

    fun getMaterial(): Material

}