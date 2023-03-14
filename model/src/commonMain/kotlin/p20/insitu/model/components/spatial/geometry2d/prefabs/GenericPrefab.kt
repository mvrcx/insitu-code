package p20.insitu.model.components.spatial.geometry2d.prefabs

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D
import p20.insitu.model.components.spatial.geometry2d.util.ShapeViewType

@Serializable
data class GenericPrefab (
    override val shapeType: String,
    override var viewType: ShapeViewType? = null,
    override var worldPosition: Point2D? = null,
    override var rotationDegrees: Float = 0.0f,
    override var scaleX: Float = 1.0f,
    override var scaleY: Float = 1.0f,
    override var modelInfo: ModelInfo,
    override val parts: MutableList<Prefab2D> = mutableListOf(),
    override val pathModels: MutableList<PathModel> = mutableListOf()
) : Shape2D(), Prefab2D {

}