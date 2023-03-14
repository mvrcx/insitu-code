package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpPackaging
import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.xpolizei.schema.Verpackung

@Serializable
data class Packaging(
    override var primaryPackaging: String?,
    override var secondaryPackaging: String?,
    override var leaflet: CatalogCodeFixed<KatalogCode217>?
) : Component(), XpPackaging{

    override fun getVerpackung(): Verpackung {
        return Verpackung(
            primaerverpackung =  primaryPackaging,
            sekundaerverpackung = secondaryPackaging,
            beipackzettel = leaflet?.getKatalogCode()
        )
    }
}
