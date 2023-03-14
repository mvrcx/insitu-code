package p20.insitu.model.components.spatial.geometry2d.prefabs

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D
import p20.insitu.model.components.spatial.geometry2d.util.ShapeViewType

@Serializable
data class RectangularTablePrefab(
    override val shapeType: String,
    override var viewType: ShapeViewType? = null,
    override var worldPosition: Point2D? = null,
    override var rotationDegrees: Float = 0.0f,
    override var scaleX: Float = 1.0f,
    override var scaleY: Float = 1.0f,
    override var modelInfo: ModelInfo,
    override val parts: MutableList<Prefab2D> = mutableListOf(),
    override val pathModels: MutableList<PathModel> = mutableListOf()
) : Shape2D(), TablePrefab {

    enum class Components(
        override val shapeType: String,
        override val modelId: String
    ) : ComponentInfo {
        TABLE_TOP("prefab_someobject_tabletop_rectangular", "tabletop"),
        TABLE_LEG_FRONT_LEFT("prefab_someobject_tableleg_type1", "tableleg_front_left"),
        TABLE_LEG_FRONT_RIGHT("prefab_someobject_tableleg_type1", "tableleg_front_right"),
        TABLE_LEG_BACK_LEFT("prefab_someobject_tableleg_type1", "tableleg_back_left"),
        TABLE_LEG_BACK_RIGHT("prefab_someobject_tableleg_type1", "tableleg_back_right")
    }

    override fun getTableTop(): Prefab2D? {
        return getPart(Components.TABLE_TOP)
    }

    override fun getTableLegs(): List<Prefab2D> {
        return parts.getByShapeType(
            Components.TABLE_LEG_FRONT_LEFT.shapeType,
            Prefab2D.ComparisonType.EQUALS
        )
    }

    fun getTableLegFrontLeft(): Prefab2D? {
        return getPart(Components.TABLE_LEG_FRONT_LEFT)
    }

    fun getTableLegFrontRight(): Prefab2D? {
        return getPart(Components.TABLE_LEG_FRONT_RIGHT)
    }

    fun getTableLegBackLeft(): Prefab2D? {
        return getPart(Components.TABLE_LEG_BACK_LEFT)
    }

    fun getTableLegBackRight(): Prefab2D? {
        return getPart(Components.TABLE_LEG_BACK_RIGHT)
    }
}