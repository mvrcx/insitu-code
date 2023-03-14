package p20.insitu.model.components.spatial.geometry2d.prefabs

import kotlinx.serialization.Serializable
import p20.insitu.model.components.spatial.geometry2d.shapes.Polygon
import p20.insitu.model.components.spatial.util.*

@Serializable
data class PathModel(
    var pathData: String,
    var name: String? = null,
    var fillAlpha: Float = PATH_FILL_ALPHA,
    var fillColor: String = PATH_DEFAULT_COLOR,
    var strokeAlpha: Float = PATH_STROKE_ALPHA,
    var strokeColor: String = PATH_DEFAULT_COLOR,
    var strokeWidth: Float = PATH_STROKE_WIDTH
){
    fun getBoundingBox(): Polygon {
        TODO("Not yet implemented")
    }
}