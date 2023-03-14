package p20.insitu.model.components

import kotlinx.serialization.Serializable

@Serializable
data class ObjectDetectionTag(
    var objectClass: Int,
    val score: Float?,
    val boundingBox: FloatArray?,
    val automated: Boolean?,
    val model: String
): Component()
