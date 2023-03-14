package p20.insitu.model.components.spatial

import kotlinx.serialization.Serializable

@Serializable
enum class ShapeType {
    // Geodetic
    COMPOSED_GEO_SHAPE,
    GEO_FREE_DRAWING,
    GEO_LINE_STRING,
    GEO_OVAL,
    GEO_POLYGON,
    GEO_POSITION_MARKER,

    // 2D
    COMPOSED_SHAPE_2D,
    FREE_DRAWING,
    LINE_STRING,
    OVAL,
    POLYGON,
    POSITION_MARKER,
    WALL_FOOTPRINT,


    // 3D
}