package p20.insitu.model.entities

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Medicine(
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
    override var type: CatalogCodeFixed<KatalogCode323>?,
    override var numberOfPieces: Int?,
    override var dosageForm: CatalogCodeFixed<KatalogCode324>?,
    override var pharmaceuticalNumber: String?,
    override var intendedUse: CatalogCodeFixed<KatalogCode325>?,
    override var dopingSubstance: CatalogCodeFixed<KatalogCode217>?,
    override var batchNumber: String?,
    override var expiryDate: LocalDate?,
    override var subsituteDrug: CatalogCodeFixed<KatalogCode217>?,
    override var packaging: Packaging?,
    override var illegalSubstance: List<IllegalSubstance>?,
    override var forgery: Forgery?,
    override var activeSubstance: List<ActiveSubstance>?
) : BaseEntity(), Evidence, XpMedicine {

    override val entityType: String = EntityType.MEDICINE.toString()

    override fun getArzneimittel(): Arzneimittel {
        return Arzneimittel().also {
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
            it.stueckzahl = numberOfPieces
            it.darreichungsform = dosageForm?.getKatalogCode()
            it.pZN = pharmaceuticalNumber
            it.verwendungszweck = intendedUse?.getKatalogCode()
            it.dopingmittel = dopingSubstance?.getKatalogCode()
            it.chargennummer = batchNumber
            it.verfallsdatum = expiryDate?.toString()
            it.ausweichmittelBtM = subsituteDrug?.getKatalogCode()
            it.verpackung = packaging?.getVerpackung()
            it.verboteneSubstanz = illegalSubstance?.map { it.getVerboteneSubstanz() }
            it.faelschung = forgery?.getFaelschung()
            it.wirkstoff = activeSubstance?.map { it.getWirkstoff() }
        }
    }
}
