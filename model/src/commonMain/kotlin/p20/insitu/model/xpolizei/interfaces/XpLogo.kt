package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode241_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Logo
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpLogo {

    var methodOfApplicaion: CatalogCodeNotComplete<KatalogCode241_NichtAbgeschlossen>?
    var designation: String?

    fun getLogo(): Logo
}