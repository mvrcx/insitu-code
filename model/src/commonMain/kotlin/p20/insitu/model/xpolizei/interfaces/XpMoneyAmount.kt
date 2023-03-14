package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Geldbetrag
import p20.insitu.model.xpolizei.schema.KatalogCode230_NichtAbgeschlossen
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpMoneyAmount {

    var currency: CatalogCodeNotComplete<KatalogCode230_NichtAbgeschlossen>
    var amount: Double

    fun getGeldbetrag(): Geldbetrag

}