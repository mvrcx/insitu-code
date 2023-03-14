package p20.insitu.model.components.spatial.geometry3d.shapes

import p20.insitu.model.components.spatial.geometry3d.Pose

interface Transformable3D {
    fun transform(newPose: Pose)
}