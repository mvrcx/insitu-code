package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpLegalBasis {

    var proceduralLaw: CatalogCodeFixed<KatalogCode237>?
    var policeLaw: CatalogCodeFixed<KatalogCode356>?
    var law: CatalogCodeNotComplete<KatalogCode387_NichtAbgeschlossen>?

    fun getRechtsgrundlage(): Rechtsgrundlage

}