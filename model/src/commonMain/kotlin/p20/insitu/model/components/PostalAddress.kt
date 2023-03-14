package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpPostalAddress
import p20.insitu.model.xpolizei.schema.Anschrift
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.PLZOrt

@Serializable
data class PostalAddress(
    override var street: String? = null,
    override var houseNumber: String? = null,
    override var district: String? = null,
    override var streetCode: String? = null,
    override var alternativeAddress: String? = null,
    override var city: String? = null,
    override var postalCode: String? = null,
    override var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>? = null
) : Component(), XpPostalAddress {

    override fun toString(): String {
        val addressString =
            "${street.orEmpty()} ${houseNumber.orEmpty()}, ${postalCode.orEmpty()} ${city.orEmpty()}"
        return addressString.trimEnd(',', ' ')
    }

    override fun getAnschrift(): Anschrift {
        return Anschrift(
            strasse = street,
            hausnummer = houseNumber,
            ortsteil = district,
            strassenschluessel = streetCode,
            alternativeAdressangabe = alternativeAddress,
            pLZOrt = PLZOrt(
                ortsname = city,
                pLZ = postalCode,
                staat = country?.getKatalogCodeNichtAbgeschlossen()
            )
        )
    }
}
