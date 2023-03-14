package p20.insitu.model.components.spatial.geodetic.util

import p20.insitu.model.components.spatial.geodetic.GeoPoint
import p20.insitu.model.components.spatial.geodetic.shapes.GeoShape

expect fun translateBy(geoShape: GeoShape, delta: GeoPoint)
expect fun translateTo(geoShape: GeoShape, dest: GeoPoint)
expect fun rotateBy(geoShape: GeoShape, angle: Float)
expect fun rotateTo(geoShape: GeoShape, angle: Float)
expect fun scaleBy(geoShape: GeoShape, fLat: Float, fLong: Float)
expect fun scaleTo(geoShape: GeoShape, fLat: Float, fLong: Float)
