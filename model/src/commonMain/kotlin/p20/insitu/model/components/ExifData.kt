package p20.insitu.model.components

import kotlinx.serialization.Serializable

@Serializable
data class ExifData(
    var cameraModel: String?,
    var orientation: Int?,
    var imageWidth: Long?,
    var imageLength: Long?
) : Component()
