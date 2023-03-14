package p20.insitu.model.components.spatial.geometry2d.util

import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D

expect fun translateBy(shape: Shape2D, dXdY: Point2D)
expect fun translateTo(shape: Shape2D, dest: Point2D)

expect fun rotateBy(shape: Shape2D, angle: Float)
expect fun rotateTo(shape: Shape2D, angle: Float)

expect fun scaleBy(shape: Shape2D, fX: Float, fY: Float)
expect fun scaleTo(shape: Shape2D, fX: Float, fY: Float)
