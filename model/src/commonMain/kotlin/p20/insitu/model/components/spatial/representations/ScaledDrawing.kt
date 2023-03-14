package p20.insitu.model.components.spatial.representations

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D
import p20.insitu.model.components.spatial.geometry2d.prefabs.Prefab2D

@Serializable
data class ScaledDrawing(
    val shapeType: String? = null,
    val top: Shape2D? = null,
    val bottom: Shape2D? = null,
    val left: Shape2D? = null,
    val right: Shape2D? = null,
    val front: Shape2D? = null,
    val back: Shape2D? = null
    ): Component() {

    val views:List<Shape2D> = listOfNotNull(top, bottom, left, right, front, back)

    fun hasParts(): Boolean {
        return views.any { ((it as? Prefab2D)?.parts?.size ?: 0) > 0 }
    }

}