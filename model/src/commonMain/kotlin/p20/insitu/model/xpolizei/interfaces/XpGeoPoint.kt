package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.GeoPoint
import p20.insitu.model.xpolizei.schema.GeoPointWithIndex

interface XpGeoPoint {

    var latitude: Float
    var longitude: Float

    fun getXpGeoPoint(): GeoPoint {
        return GeoPoint(
            geografischeLaenge = this.longitude.toDouble(),
            geografischeBreite = this.latitude.toDouble()
        )
    }

    fun getGeoPointWithIndex(index: Int): GeoPointWithIndex {
        return GeoPointWithIndex(index).also {
            it.geografischeLaenge = this.longitude.toDouble()
            it.geografischeBreite = this.latitude.toDouble()
        }
    }

}