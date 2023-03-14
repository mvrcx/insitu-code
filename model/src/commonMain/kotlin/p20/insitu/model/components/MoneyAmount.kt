package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpMoneyAmount
import p20.insitu.model.xpolizei.schema.Geldbetrag
import p20.insitu.model.xpolizei.schema.KatalogCode230_NichtAbgeschlossen

@Serializable
data class MoneyAmount(
    override var currency: CatalogCodeNotComplete<KatalogCode230_NichtAbgeschlossen>,
    override var amount: Double
): Component(), XpMoneyAmount {

    override fun getGeldbetrag(): Geldbetrag {
        return Geldbetrag(
            waehrung = currency.getKatalogCodeNichtAbgeschlossen(),
            betrag = amount
        )
    }
}
