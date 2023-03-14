package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpInjury
import p20.insitu.model.xpolizei.schema.KatalogCode277
import p20.insitu.model.xpolizei.schema.Verletzung

@Serializable
data class Injury(
    override var designation: String?,
    override var location: BodyPartDescription?,
    override var severity: CatalogCodeFixed<KatalogCode277>?,
    override var comment: String?
) : Component(), XpInjury {

    override fun getVerletzung(): Verletzung {
        return Verletzung(
            bezeichnung = designation,
            lage = location?.getKoerperteilangabe(),
            grad = severity?.getKatalogCode(),
            bemerkung = comment
        )
    }
}
