package p20.insitu.model.components.spatial.representations

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.components.spatial.geometry3d.Pose

@Serializable
data class ARRepresentation(
    var pose: Pose?
) : Component()