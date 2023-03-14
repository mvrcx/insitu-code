package p20.insitu.model.components.spatial.geometry3d

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component

@Serializable
data class Pose(
    var point3D: Point3D,
    var rotationX: Float,
    var rotationY: Float,
    var rotationZ: Float,
    var quaternionW: Float,
    var quaternionX: Float,
    var quaternionY: Float,
    var quaternionZ: Float,
    var scaleX: Float,
    var scaleY: Float,
    var scaleZ: Float
    ) :Component()