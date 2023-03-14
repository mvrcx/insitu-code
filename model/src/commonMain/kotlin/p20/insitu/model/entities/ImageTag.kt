package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.ObjectDetectionTag
import p20.insitu.model.entities.enums.EntityType

@Serializable
data class ImageTag(
    override var deleted: Boolean = false,
    var imageId: String,
    var tags: List<ObjectDetectionTag>
) : BaseEntity() {

    override val entityType: String = EntityType.IMAGE_TAG.toString()

}
