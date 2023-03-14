package p20.insitu.model.entities

import p20.insitu.model.components.spatial.SpatialRepresentation

/**
 * Interface for spatial semantic objects. A spatial semantic object is a [DocNumberObject] that
 * has one or more spatial representations, e.g., a geographic coordinate or shape in a floor plan.
 */
interface SpatialSemanticObject : DocNumberObject {

    /**
     * Set of spatial representations.
     */
    var spatialRepresentation: SpatialRepresentation?

}