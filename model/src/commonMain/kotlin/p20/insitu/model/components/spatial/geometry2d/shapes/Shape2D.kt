package p20.insitu.model.components.spatial.geometry2d.shapes

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.util.randomUUID
import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.util.*

@Serializable
abstract class Shape2D : Component(), IShape2D, Transformable2D {
    override val id: String = randomUUID()

    override fun getBoundingBox(): Polygon? {
        TODO("Not yet implemented")
    }

    override fun hitTest(hitLocation: Point2D): Boolean {
        TODO("Not yet implemented")
    }

    override fun hitTestZoomSensitive(hitLocation: Point2D, zoomRatio: Float): Boolean {
        TODO("Not yet implemented")
    }

    override fun translateBy(dXdY: Point2D) {
        translateBy(this, dXdY)
    }

    override fun translateTo(dest: Point2D) {
        translateTo(this, dest)
    }

    override fun rotateBy(angle: Float) {
        rotateBy(this, angle)
    }

    override fun rotateTo(angle: Float) {
        rotateTo(this, angle)
    }

    override fun scaleBy(fX: Float, fY: Float) {
        scaleBy(this, fX, fY)
    }

    override fun scaleTo(fX: Float, fY: Float) {
        scaleTo(this, fX, fY)
    }
}