package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpPostOfficeBox
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.PLZOrt
import p20.insitu.model.xpolizei.schema.Postfach

@Serializable
data class PostOfficeBox(
    override var number: String?,
    override var city: String?,
    override var postalCode: String?,
    override var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?
) : Component(),  XpPostOfficeBox {

    override fun getPostfach(): Postfach {
        return Postfach(
            nummer = number,
            pLZOrt = PLZOrt(
                ortsname = city,
                pLZ = postalCode,
                staat = country?.getKatalogCodeNichtAbgeschlossen()
            )
        )
    }
}
