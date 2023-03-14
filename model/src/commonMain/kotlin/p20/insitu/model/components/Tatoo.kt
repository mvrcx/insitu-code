package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpTatoo
import p20.insitu.model.xpolizei.schema.KatalogCode274_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Taetowierung

@Serializable
data class Tatoo(
    override var motive: CatalogCodeNotComplete<KatalogCode274_NichtAbgeschlossen>?,
    override var location: BodyPartDescription?,
    override var comment: String?
) : Component(), XpTatoo {

    override fun getTaetowierung(): Taetowierung {
        return Taetowierung(
            motiv = motive?.getKatalogCodeNichtAbgeschlossen(),
            lage = location?.getKoerperteilangabe(),
            bemerkung = comment
        )
    }
}
