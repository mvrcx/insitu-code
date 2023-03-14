package p20.insitu.model.components.spatial.geometry2d.util

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.Geometry
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.util.AffineTransformation
import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.shapes.Polygon
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D


@Suppress("UNCHECKED_CAST")
fun <T : Geometry> translate(geom: T, dx: Double, dy: Double): T {
    val at = AffineTransformation.translationInstance(dx, dy)
    return at.transform(geom) as T
}

fun toJTS(polygon: Polygon): org.locationtech.jts.geom.Polygon {
    polygon.points.map { Coordinate(it.x.toDouble(), it.y.toDouble()) }.toTypedArray().let { coordinates ->
        return GeometryFactory().createPolygon(coordinates)
    }
}

actual fun translateBy(shape: Shape2D, dXdY: Point2D) {
    when (shape) {
        is Polygon -> {
            shape.points = translate(
                toJTS(shape),
                dXdY.x.toDouble(),
                dXdY.y.toDouble()
            ).coordinates.map { c -> Point2D(c.x.toFloat(), c.y.toFloat()) }
                .toMutableList()
        }
        else -> {
            TODO("Not yet implemented")
        }
    }
}

actual fun translateTo(shape: Shape2D, dest: Point2D) {
    TODO("Not yet implemented")
}

actual fun rotateBy(shape: Shape2D, angle: Float) {
    TODO("Not yet implemented")
}

actual fun rotateTo(shape: Shape2D, angle: Float) {
    TODO("Not yet implemented")
}

actual fun scaleBy(shape: Shape2D, fX: Float, fY: Float) {
    TODO("Not yet implemented")
}

actual fun scaleTo(shape: Shape2D, fX: Float, fY: Float) {
    TODO("Not yet implemented")
}
