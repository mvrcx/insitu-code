package p20.insitu.model.components.spatial.representations

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.components.spatial.geometry2d.shapes.Shape2D

@Serializable
data class SketchRepresentation(
    override var shape: Shape2D? = null
): Component(), SpatialRepresentation2D