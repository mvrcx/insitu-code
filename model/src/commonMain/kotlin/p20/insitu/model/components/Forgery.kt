package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpForgery
import p20.insitu.model.xpolizei.schema.Faelschung
import p20.insitu.model.xpolizei.schema.KatalogCode222

@Serializable
data class Forgery(
    override var type: CatalogCodeFixed<KatalogCode222>?,
    override var features: String?
) : Component(), XpForgery{

    override fun getFaelschung(): Faelschung {
        return Faelschung(
            art = type?.getKatalogCode(),
            merkmale = features
        )
    }
}
