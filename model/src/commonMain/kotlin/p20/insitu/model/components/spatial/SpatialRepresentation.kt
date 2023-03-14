package p20.insitu.model.components.spatial

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.components.spatial.representations.*

@Serializable
data class SpatialRepresentation(
    var scaledDrawing: ScaledDrawing?,
    var planRepresentation: PlanRepresentation?,
    var arRepresentation: ARRepresentation?,
    var mapRepresentation: MapRepresentation?,
    var photoRepresentation: PhotoRepresentation?,
    var schemaRepresentation: SchemaRepresentation?,
    var sketchRepresentation: SketchRepresentation?
): Component()
