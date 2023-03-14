package p20.insitu.model.entities

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Record(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var annotationType: CatalogCodeFixed<KatalogCode102>?,
    override var keywords: List<String>?,
    override var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>?,
    override var creationDate: ZonedDateTime?
) : BaseEntity(), Evidence, XpRecording {

    override val entityType: String = EntityType.RECORD.toString()

    override fun getAufzeichnung(): Aufzeichnung {
        return Aufzeichnung().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = annotationType?.getKatalogCode()
            it.bezeichnung = designation
            it.schlagworte = keywords?.joinToString(";")
            it.sprache =
                language?.map { it.getKatalogCodeNichtAbgeschlossen() }?.filterNotNull()
            it.erstellungsDatum = creationDate?.dateTime
            it.asservat = getAsservat()
        }
    }
}
