package p20.insitu.model.components.spatial.geometry3d.shapes

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.util.randomUUID
import p20.insitu.model.components.spatial.geometry3d.Pose

@Serializable
abstract class Shape3D : Component(), IShape3D, Transformable3D {
    override val id: String = randomUUID()

    override fun getBoundingBox(): Cuboid? {
        TODO("Not yet implemented")
    }

    override fun transform(newPose: Pose) {
        TODO("Not yet implemented")
    }
}