package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpBankNoteSeries
import p20.insitu.model.xpolizei.schema.Serie

@Serializable
data class BankNoteSeries(
    override var quantity: Int,
    override var increment: Int
) : Component(), XpBankNoteSeries{

    override fun getSerie(): Serie {
        return Serie(
            anzahl = quantity,
            inkrement = increment
        )
    }
}
