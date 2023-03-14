package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpNumber
import p20.insitu.model.xpolizei.schema.Nummer

@Serializable
data class Number(
    override var designation: String? = null,
    override var value: String? = null,
    override var authority: Authority? = null
) : Component(), XpNumber{

    override fun getNummer(): Nummer {
        return Nummer(
            bezeichnung = designation,
            nummernwert = value,
            behoerde = authority?.getBeteiligteStelle()
        )
    }
}
