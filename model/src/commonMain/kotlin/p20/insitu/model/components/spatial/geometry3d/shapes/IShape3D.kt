package p20.insitu.model.components.spatial.geometry3d.shapes

import p20.insitu.model.components.spatial.geometry3d.Pose

interface IShape3D {
    val id: String
    val shapeType: String
    val worldPosition: Pose?
    fun getBoundingBox(): Cuboid?
}