package p20.insitu.util

import org.koin.core.component.KoinComponent
import p20.insitu.model.components.spatial.geodetic.GeoPoint

actual class LocationHandler actual constructor() : KoinComponent {

    actual fun getCurrentLocation(): GeoPoint?{
        // TODO
        return null
    }

}