package p20.insitu.model.components.spatial.geometry2d.shapes

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.Appearance
import p20.insitu.model.components.spatial.ShapeType
import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.util.*
import p20.insitu.model.components.spatial.util.*

@Serializable
data class Oval(
    override val shapeType: String = ShapeType.OVAL.toString(),
    override var viewType: ShapeViewType? = null,
    override var worldPosition: Point2D? = null,
    override var rotationDegrees: Float = 0.0f,
    override var scaleX: Float = 1.0f,
    override var scaleY: Float = 1.0f,
    override val appearance: Appearance = Appearance(),
    var center: Point2D? = null,
    var radiusX: Float = DEFAULT_RADIUS_X,
    var radiusY: Float = DEFAULT_RADIUS_Y
) : Shape2D(), CustomShape {

}