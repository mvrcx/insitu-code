package p20.insitu.model.components.spatial.geodetic.shapes

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.components.spatial.Appearance
import p20.insitu.model.util.randomUUID
import p20.insitu.model.components.spatial.geodetic.GeoPoint

@Serializable
abstract class GeoShape: Component(), IGeoShape, GeoTransformable {
    override val id: String = randomUUID()

    override fun getBoundingBox(): GeoPolygon? {
        TODO("Not yet implemented")
    }

    override fun translateBy(delta: GeoPoint) {
        TODO("Not yet implemented")
    }

    override fun translateTo(dest: GeoPoint) {
        TODO("Not yet implemented")
    }

    override fun rotateBy(angle: Float) {
        TODO("Not yet implemented")
    }

    override fun rotateTo(angle: Float) {
        TODO("Not yet implemented")
    }

    override fun scaleBy(fLat: Float, fLong: Float) {
        TODO("Not yet implemented")
    }

    override fun scaleTo(fLat: Float, fLong: Float) {
        TODO("Not yet implemented")
    }
}