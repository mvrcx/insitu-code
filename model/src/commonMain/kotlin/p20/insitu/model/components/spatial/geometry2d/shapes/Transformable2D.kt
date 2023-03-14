package p20.insitu.model.components.spatial.geometry2d.shapes

import p20.insitu.model.components.spatial.geometry2d.Point2D

interface Transformable2D {
    fun translateBy(dXdY: Point2D)
    fun translateTo(dest: Point2D)
    fun rotateBy(angle: Float)
    fun rotateTo(angle: Float)
    fun scaleBy(fX: Float, fY: Float)
    fun scaleTo(fX: Float, fY: Float)
}