package p20.insitu.model.components.spatial.geodetic

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpGeoPoint

/**
 * Geo point
 *
 * @property latitude
 * @property longitude
 * @property altitude
 * @constructor Create empty Geo point
 */
@Serializable
data class GeoPoint(
    override var latitude: Float,
    override var longitude: Float,
    var altitude: Float? = null
): XpGeoPoint {
    override fun toString(): String {
        return "Lat. $latitude | Long. $longitude"
    }
}
