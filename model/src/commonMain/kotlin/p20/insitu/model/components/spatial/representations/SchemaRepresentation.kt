package p20.insitu.model.components.spatial.representations

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D
import p20.insitu.model.components.spatial.geometry2d.util.ShapeViewType

@Serializable
data class SchemaRepresentation (
    override var shape: Shape2D? = null,
    var parentViewType: ShapeViewType? = null
) : Component(), SpatialRepresentation2D