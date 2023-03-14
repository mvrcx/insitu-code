package p20.insitu.model.components.spatial.representations

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.components.spatial.geodetic.shapes.GeoShape

@Serializable
data class MapRepresentation(
    var shape: GeoShape?
) : Component()