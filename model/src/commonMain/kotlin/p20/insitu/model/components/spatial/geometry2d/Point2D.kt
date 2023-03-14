package p20.insitu.model.components.spatial.geometry2d

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component

/**
 *
 */
@Serializable
data class Point2D(
    var x: Float = 0.0f,
    var y: Float = 0.0f
): Component()