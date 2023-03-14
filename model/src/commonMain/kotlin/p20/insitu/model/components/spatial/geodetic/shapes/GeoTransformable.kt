package p20.insitu.model.components.spatial.geodetic.shapes

import p20.insitu.model.components.spatial.geodetic.GeoPoint

interface GeoTransformable {
    fun translateBy(delta: GeoPoint)
    fun translateTo(dest: GeoPoint)
    fun rotateBy(angle: Float)
    fun rotateTo(angle: Float)
    fun scaleBy(fLat: Float, fLong: Float)
    fun scaleTo(fLat: Float, fLong: Float)
}