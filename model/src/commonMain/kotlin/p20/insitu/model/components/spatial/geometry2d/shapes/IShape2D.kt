package p20.insitu.model.components.spatial.geometry2d.shapes

import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.util.ShapeViewType

interface IShape2D {
    val id: String
    val shapeType: String
    var viewType: ShapeViewType?
    var worldPosition: Point2D?
    var rotationDegrees: Float
    var scaleX: Float
    var scaleY: Float

    fun getBoundingBox(): Polygon?
    fun hitTest(hitLocation: Point2D): Boolean
    fun hitTestZoomSensitive(hitLocation: Point2D, zoomRatio: Float): Boolean
}
