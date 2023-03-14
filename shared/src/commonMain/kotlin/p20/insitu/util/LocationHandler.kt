package p20.insitu.util

import org.koin.core.component.KoinComponent
import p20.insitu.model.components.spatial.geodetic.GeoPoint

expect class LocationHandler() : KoinComponent {

    fun getCurrentLocation(): GeoPoint?

}