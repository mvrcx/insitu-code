package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.DocNumber
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime

@Serializable
data class CrimeScene(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var docNumber: DocNumber? = null,
    override var locationType: CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>? = null,
    var shortDescription: String? = null,
    var timeOfArrival: ZonedDateTime? = null
) : BaseEntity(), DocNumberObject, Location {

    override val entityType: String = EntityType.CRIME_SCENE.toString()

}