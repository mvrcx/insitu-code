package p20.insitu.model.components.spatial.geometry2d.util

import kotlinx.serialization.Serializable

/**
 *             top
 *       |-------------|
 *       |             |
 * right |    front    | left
 *       |             |
 *       |-------------|
 *            bottom
 */
@Serializable
enum class ShapeViewType {
    /**
     * The top view of an object.
     */
    TOP,
    /**
     * The bottom view of an object.
     */
    BOTTOM,
    /**
     * The left view of an object.
     */
    LEFT,
    /**
     * The right view of an object.
     */
    RIGHT,
    /**
     * The front view of an object.
     */
    FRONT,
    /**
     * The back view of an object.
     */
    BACK
}