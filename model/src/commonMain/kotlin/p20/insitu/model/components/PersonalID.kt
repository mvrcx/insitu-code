package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpPersonalID
import p20.insitu.model.xpolizei.schema.KatalogCode322_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Personenidentifikationsnummer

@Serializable
data class PersonalID(
    override var number: Number? = null,
    override var type: CatalogCodeNotComplete<KatalogCode322_NichtAbgeschlossen>? = null
) : Component(), XpPersonalID{

    override fun getPersonenidentifikationsnummer(): Personenidentifikationsnummer {
        return Personenidentifikationsnummer(
            nummer = number?.getNummer(),
            art = type?.getKatalogCodeNichtAbgeschlossen()
        )
    }
}
