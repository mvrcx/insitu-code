package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpTooth
import p20.insitu.model.xpolizei.schema.KatalogCode311
import p20.insitu.model.xpolizei.schema.Zahn

@Serializable
data class Tooth(
    override var number: CatalogCodeFixed<KatalogCode311>?,
    override var color: String?,
    override var status: String?,
    override var condition: String?,
    override var material: String?,
    override var comment: String?,
    override var specialFeatures: String?
) : Component(), XpTooth {

    override fun getZahn(): Zahn {
        return Zahn(
            zahnnummer = number?.getKatalogCode(),
            zahnfarbe = color,
            zahnstatus = status,
            zahnzustand = condition,
            zahnmaterial = material,
            zahnBemerkung = comment,
            zahnBesonderheiten = specialFeatures
        )
    }
}
