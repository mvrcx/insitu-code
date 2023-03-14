package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.Logo
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Drug(
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
    override var type: CatalogCodeFixed<KatalogCode105>?,
    override var form: CatalogCodeFixed<KatalogCode211>?,
    override var packaging: String?,
    override var numberOfPieces: Int?,
    override var color: List<ColorDescription>?,
    override var composition: List<Ingredient>?,
    override var logo: Logo?
    ) : BaseEntity(), Evidence, XpDrug {

    override val entityType: String = EntityType.DRUG.toString()

    override fun getBetaeubungsmittel(): Betaeubungsmittel {
        return Betaeubungsmittel().also {
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
            it.beschaffenheit = form?.getKatalogCode()
            it.verpackungsart = packaging
            it.stueckzahl = numberOfPieces
            it.farbangabe = color?.map { it.getFarbangabe() }
            it.zusammensetzung = composition?.map { it.getInhaltsstoff() }
            it.logo = logo?.getLogo()
        }
    }
}
