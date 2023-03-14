package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode322_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Personenidentifikationsnummer
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.Number

interface XpPersonalID {

    var number: Number?
    var type: CatalogCodeNotComplete<KatalogCode322_NichtAbgeschlossen>?

    fun getPersonenidentifikationsnummer(): Personenidentifikationsnummer
}