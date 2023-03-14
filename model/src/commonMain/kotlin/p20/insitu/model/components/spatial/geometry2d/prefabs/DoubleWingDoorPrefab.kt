package p20.insitu.model.components.spatial.geometry2d.prefabs

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geometry2d.Point2D
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D
import p20.insitu.model.components.spatial.geometry2d.util.ShapeViewType

@Serializable
data class DoubleWingDoorPrefab(
    override val shapeType: String,
    override var viewType: ShapeViewType? = null,
    override var worldPosition: Point2D? = null,
    override var rotationDegrees: Float = 0.0f,
    override var scaleX: Float = 1.0f,
    override var scaleY: Float = 1.0f,
    override var modelInfo: ModelInfo,
    override val parts: MutableList<Prefab2D> = mutableListOf(),
    override val pathModels: MutableList<PathModel> = mutableListOf()
) : Shape2D(), DoorPrefab {

    enum class Components(
        override val shapeType: String,
        override val modelId: String
    ) : ComponentInfo {
        OPENING("prefab_someobject_door_2wing_opening", "opening"),
        DOOR_LEAF_LEFT("prefab_someobject_door_2wing_door_leaf_left", "door_leaf_left"),
        DOOR_LEAF_RIGHT("prefab_someobject_door_2wing_door_leaf_right", "door_leaf_right"),
        DOORKNOB_LEFT("prefab_someobject_doorknob_type1", "doorknob_left"),
        DOORKNOB_RIGHT("prefab_someobject_doorknob_type1", "doorknob_right")
    }

    override fun getOpening(): Prefab2D? {
        return getPart(Components.OPENING)
    }

    fun getDoorLeafLeft(): Prefab2D? {
        return getPart(Components.DOOR_LEAF_LEFT)
    }

    fun getDoorLeafRight(): Prefab2D? {
        return getPart(Components.DOOR_LEAF_RIGHT)
    }

    fun getDoorknobLeft(): Prefab2D? {
        return getPart(Components.DOORKNOB_LEFT)
    }

    fun getDoorknobRight(): Prefab2D? {
        return getPart(Components.DOORKNOB_RIGHT)
    }

}