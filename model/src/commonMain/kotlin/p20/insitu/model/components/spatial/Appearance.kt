package p20.insitu.model.components.spatial

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component
import p20.insitu.model.components.spatial.util.PATH_DEFAULT_COLOR
import p20.insitu.model.components.spatial.util.PATH_FILL_ALPHA
import p20.insitu.model.components.spatial.util.PATH_STROKE_ALPHA
import p20.insitu.model.components.spatial.util.PATH_STROKE_WIDTH

@Serializable
data class Appearance(
    var fillAlpha: Float = PATH_FILL_ALPHA,
    var fillColor: String = PATH_DEFAULT_COLOR,
    var strokeAlpha: Float = PATH_STROKE_ALPHA,
    var strokeColor: String = PATH_DEFAULT_COLOR,
    var strokeWidth: Float = PATH_STROKE_WIDTH,
): Component()
