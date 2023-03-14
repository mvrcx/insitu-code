package p20.insitu.model.components.spatial.geometry2d.prefabs

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D
import p20.insitu.model.components.spatial.geometry2d.util.ShapeViewType

@Serializable
data class ChairType1Prefab(
    override val shapeType: String,
    override var viewType: ShapeViewType? = null,
    override var worldPosition: Point2D? = null,
    override var rotationDegrees: Float = 0.0f,
    override var scaleX: Float = 1.0f,
    override var scaleY: Float = 1.0f,
    override var modelInfo: ModelInfo,
    override val parts: MutableList<Prefab2D> = mutableListOf(),
    override val pathModels: MutableList<PathModel> = mutableListOf()
) : Shape2D(), ChairPrefab {

    enum class Components(
        override val shapeType: String,
        override val modelId: String
    ) : ComponentInfo {
        BACKREST("prefab_someobject_chair_backrest_type1", "backrest"),
        SEAT("prefab_someobject_chair_seat_type1", "seat"),
        ARMREST_LEFT("prefab_someobject_chair_armrest_type1", "armrest_left"),
        ARMREST_RIGHT("prefab_someobject_chair_armrest_type1", "armrest_right"),
        CHAIR_LEG_FRONT_LEFT("prefab_someobject_chair_leg_type1", "chair_leg_front_left"),
        CHAIR_LEG_FRONT_RIGHT("prefab_someobject_chair_leg_type1", "chair_leg_front_right"),
        CHAIR_LEG_BACK_LEFT("prefab_someobject_chair_leg_type1", "chair_leg_back_left"),
        CHAIR_LEG_BACK_RIGHT("prefab_someobject_chair_leg_type1", "chair_leg_back_right")
    }

    override fun getSeat(): Prefab2D? {
        return getPart(Components.SEAT)
    }

    override fun getBackrest(): Prefab2D? {
        return getPart(Components.BACKREST)
    }

    override fun getArmrests(): List<Prefab2D> {
        return parts.getByShapeType(
            Components.ARMREST_LEFT.shapeType,
            Prefab2D.ComparisonType.EQUALS
        )
    }

    fun getArmrestLeft(): Prefab2D? {
        return getPart(Components.ARMREST_LEFT)
    }

    fun getArmrestRight(): Prefab2D? {
        return getPart(Components.ARMREST_RIGHT)
    }

    override fun getChairLegs(): List<Prefab2D> {
        return parts.getByShapeType(
            Components.CHAIR_LEG_FRONT_LEFT.shapeType,
            Prefab2D.ComparisonType.EQUALS
        )
    }

    fun getChairLegFrontLeft(): Prefab2D? {
        return getPart(Components.CHAIR_LEG_FRONT_LEFT)
    }

    fun getChairLegFrontRight(): Prefab2D? {
        return getPart(Components.CHAIR_LEG_FRONT_RIGHT)
    }

    fun getChairLegBackLeft(): Prefab2D? {
        return getPart(Components.CHAIR_LEG_BACK_LEFT)
    }

    fun getChairLegBackRight(): Prefab2D? {
        return getPart(Components.CHAIR_LEG_BACK_RIGHT)
    }

}