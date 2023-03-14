package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class DrugRawMaterial(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var comment: String?,
    override var manufacturingInformation: ManufacturingInformation?,
    override var volume: Volume?,
    override var width: Size?,
    override var height: Size?,
    override var length: Size?,
    override var weight: Weight?,
    override var streetValue: MoneyAmount?,
    override var diameter: Size?,
    override var pertinentNote: List<String>?,
    override var type: CatalogCodeFixed<KatalogCode313>?
    ) : BaseEntity(), Evidence, XpDrugRawMaterial {

    override val entityType: String = EntityType.DRUG_RAW_MATERIAL.toString()

    override fun getGrundstoff(): Grundstoff {
        return Grundstoff().also {
            // Base class attributes
            it.id = id
            // MedicineDrugRawMaterial
            it.bezeichnung = designation
            it.bemerkung = comment
            it.herstellungsinformation = manufacturingInformation?.getHerstellungsinformation()
            it.volumen = volume?.getVolumen()
            it.breite = width?.getAusmass()
            it.hoehe = height?.getAusmass()
            it.laenge = length?.getAusmass()
            it.strassenhandelswert = streetValue?.getGeldbetrag()
            it.durchmesser = diameter?.getAusmass()
            it.sachgebundenerHinweis = pertinentNote
            it.asservat = getAsservat()
            // Class attributes
            it.art = type?.getKatalogCode()
        }
    }
}
