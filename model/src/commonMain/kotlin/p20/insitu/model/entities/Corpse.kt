package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.DocNumber
import p20.insitu.model.components.EvidenceData
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.BodyPartDescription
import p20.insitu.model.components.CatalogCodeFixed

@Serializable
data class Corpse(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber?,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var completeness: CatalogCodeFixed<KatalogCode217>?,
    override var missingBodyParts: List<BodyPartDescription>?,
    override var recoveryNumber: String?,
    override var identificationNumber: String?,
    override var child: CatalogCodeFixed<KatalogCode217>?,
    override var comment: String?
) : BaseEntity(), Site, Evidence, XpCorpse {

    override val entityType: String = EntityType.CORPSE.toString()

    override fun getLeiche(): Leiche {
        return Leiche().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.vollstaendigkeit = completeness?.getKatalogCode()
            it.fehlendesKoerperteil = missingBodyParts?.map { it.getKoerperteilangabe() }
            it.bergungsnummer = recoveryNumber
            it.identifizierungsnummer = identificationNumber
            it.kind = child?.getKatalogCode()
            it.bemerkung = comment
            it.asservat = getAsservat()
        }
    }

}
