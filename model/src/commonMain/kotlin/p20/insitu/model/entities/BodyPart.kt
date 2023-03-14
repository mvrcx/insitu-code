package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class BodyPart(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var type: BodyPartDescription?,
    override var recoveryNumber: String?,
    override var identificationNumber: String?,
    override var child: CatalogCodeFixed<KatalogCode217>?,
    override var comment: String?,
    override var injury: List<Injury>?,
    override var characteristics: List<PhysicalFeature>?,
    override var tatoo: List<Tatoo>?,
    override var dentures: Dentures?
): BaseEntity(), Evidence, XpBodyPart {

    override val entityType: String = EntityType.BODY_PART.toString()

    override fun getKoerperteil(): Koerperteil {
        return Koerperteil().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = type?.getKoerperteilangabe()
            it.bergungsnummer = recoveryNumber
            it.identifizierungsnummer = identificationNumber
            it.kind = child?.getKatalogCode()
            it.bemerkung = comment
            it.verletzung = injury?.map { it.getVerletzung() }
            it.merkmal = characteristics?.map { it.getMerkmal() }
            it.taetowierung = tatoo?.map { it.getTaetowierung() }
            it.gebiss = dentures?.getGebiss()
            it.asservat = getAsservat()
        }
    }

}
