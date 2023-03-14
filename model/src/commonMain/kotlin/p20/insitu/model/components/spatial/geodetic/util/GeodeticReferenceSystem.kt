package p20.insitu.model.components.spatial.geodetic.util

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.schema.KatalogCode231

@Serializable
enum class GeodeticReferenceSystem {

    /**
     * World Geodetic System 1984
     */
    WGS84,

    /**
     * Europäische Terrestrische Referenzsystem 1989
     */
    ETRS89;

    fun toKatalogCode231(): KatalogCode231 {
        return KatalogCode231().also {
            it.code = when (this) {
                WGS84 -> {
                    "231_1"
                }
                ETRS89 -> {
                    "231_2"
                }
            }
            it.name = when (this) {
                WGS84 -> {
                    "WGS84"
                }
                ETRS89 -> {
                    "ETRS89"
                }
            }
        }
    }

}