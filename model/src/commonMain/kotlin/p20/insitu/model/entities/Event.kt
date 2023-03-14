package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Event(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var type: CatalogCodeNotComplete<KatalogCode101_NichtAbgeschlossen>? = null,
    override var shortDescription: String? = null,
    override var start: ZonedDateTime? = null,
    override var end: ZonedDateTime? = null,
    override var timeOfDetermination: ZonedDateTime? = null,
    override var attempt: CatalogCodeFixed<KatalogCode217>? = null
    ) : BaseEntity(), DocumentationObject, XpGeneralEvent {

    /**
     * The unique type descriptor for this entity class.
     *
     * @see p20.insitu.model.entities.enums.EntityType
     */
    override val entityType: String = EntityType.EVENT.toString()

    override fun getAllgemeinesEreignis(): AllgemeinesEreignis {
        return AllgemeinesEreignis().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = type?.getKatalogCodeNichtAbgeschlossen()
            it.bezeichnung = designation
            it.kurzdarstellung = shortDescription
            it.beginn = start?.getDatumZeit()
            it.ende = end?.getDatumZeit()
            it.feststellungszeit = timeOfDetermination?.getDatumZeit()
            it.versuch = attempt?.getKatalogCode()
        }
    }
}
