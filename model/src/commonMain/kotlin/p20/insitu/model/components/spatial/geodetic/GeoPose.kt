package p20.insitu.model.components.spatial.geodetic

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geodetic.util.GeodeticReferenceSystem
import p20.insitu.model.components.spatial.geometry3d.Pose

/**
 *
 *
 */
@Serializable
data class GeoPose(
    var referenceSystem: GeodeticReferenceSystem,
    var position: GeoPoint,
    var pose: Pose
)
