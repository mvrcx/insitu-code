package p20.insitu.model.components.spatial.geometry2d.shapes

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.Appearance
import p20.insitu.model.components.spatial.ShapeType
import p20.insitu.model.components.spatial.util.PATH_DEFAULT_COLOR
import p20.insitu.model.components.spatial.util.PATH_FILL_ALPHA
import p20.insitu.model.components.spatial.util.PATH_STROKE_ALPHA
import p20.insitu.model.components.spatial.util.PATH_STROKE_WIDTH
import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.util.*

@Serializable
data class ComposedShape2D(
    override val shapeType: String = ShapeType.COMPOSED_SHAPE_2D.toString(),
    override var viewType: ShapeViewType? = null,
    override var worldPosition: Point2D? = null,
    override var rotationDegrees: Float = 0.0f,
    override var scaleX: Float = 1.0f,
    override var scaleY: Float = 1.0f,
    override val appearance: Appearance = Appearance(),
    var parts: List<CustomShape>? = null
) : Shape2D(), CustomShape {

}
