package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpItemNumber
import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.xpolizei.schema.Nummernangabe

@Serializable
data class ItemNumber(
    override var number: String?,
    override var designation: String?,
    override var unique: CatalogCodeFixed<KatalogCode217>?
) : Component(), XpItemNumber{

    override fun getNummernangabe(): Nummernangabe {
        return Nummernangabe(
            nummer = number,
            bezeichnung = designation,
            individualnummer = unique?.getKatalogCode()
        )
    }
}
