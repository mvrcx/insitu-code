package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geodetic.shapes.GeoPositionMarker
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.XpAddress
import p20.insitu.model.components.AdministrativeEncoding
import p20.insitu.model.components.PostalAddress
import p20.insitu.model.xpolizei.schema.Adresse

/**
 * This class describes an address.
 *
 * ## XPolizei
 * [Address] implements the [XpAddress] interface which exposes an [Adresse] object.
 *
 * @property deleted Indicates if the address should be regarded as deleted. Default: `false`
 * @property designation The name or short description of the address.
 * @property thumbnailId A reference to a thumbnail [Image] for the address.
 * @property postalAddress Encapsulates the postal information of the address.
 * Maps to [Adresse.adresstyp].
 * @property comment A supplementary comment. Maps to [Adresse.bemerkung].
 * @property administrativeEncoding Administrative encoding information of the address region.
 * Maps to [Adresse.verwaltungspolitischeKodierung].
 * @property [geolocation] The geographic location, i.e. global coordinate, of the address.
 * Maps to [Adresse.geokodierung].
 * @property region The region of the address. Maps to [Adresse.region].
 * @constructor Create a new [Address] object.
 */
@Serializable
data class Address(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var postalAddress: PostalAddress? = null,
    override var comment: String? = null,
    override var administrativeEncoding: AdministrativeEncoding? = null,
    override var geolocation: GeoPositionMarker? = null,
    override var region: String? = null
) : BaseEntity(), DocumentationObject, XpAddress {

    override val entityType: String = EntityType.ADDRESS.toString()

    fun getStreetAndHouseNbr(): String {
        return "${postalAddress?.street} ${postalAddress?.houseNumber}"
    }

    fun getPostalCodeAndCity(): String {
        return "${postalAddress?.postalCode} ${postalAddress?.city}"
    }

    override fun toString(): String {
        return "${postalAddress?.street} ${postalAddress?.houseNumber}, ${postalAddress?.postalCode} ${postalAddress?.city}"
    }

}

