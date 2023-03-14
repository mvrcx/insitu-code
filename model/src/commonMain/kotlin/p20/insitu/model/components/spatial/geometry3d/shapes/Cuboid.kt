package p20.insitu.model.components.spatial.geometry3d.shapes

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geometry3d.Point3D
import p20.insitu.model.components.spatial.geometry3d.Pose

@Serializable
data class Cuboid(
    override val shapeType: String = Cuboid::class.simpleName.orEmpty(),
    override var worldPosition: Pose? = null,
    var width: Float,
    var length: Float,
    var height: Float,
    val points: MutableList<Point3D> = mutableListOf()
) : Shape3D(){

    init{
        updatePoints()
    }

    /**
     * Calculates corner points of cuboid based on current pose and dimensions.
     * @see points
     */
    private fun updatePoints(){
        TODO("Not yet implemented")
    }

    override fun getBoundingBox(): Cuboid {
        return this
    }

}