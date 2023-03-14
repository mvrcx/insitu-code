package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Bicycle(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var pertinentNote: List<CatalogCodeNotComplete<KatalogCode223_NichtAbgeschlossen>>?,
    override var specialFeatures: String?,
    override var comment: String?,
    override var usage: CatalogCodeNotComplete<KatalogCode224_NichtAbgeschlossen>?,
    override var currentValue: MoneyAmount?,
    override var newValue: MoneyAmount?,
    override var vehicleNumber: List<VehicleNumber>?,
    override var width: Size?,
    override var height: Size?,
    override var length: Size?,
    override var color: List<VehicleColor>?,
    override var forgery: Forgery?,
    override var manufacturingInformation: ManufacturingInformation?,
    override var frameNumber: String?,
    override var codeNumber: String?,
    override var wheelDiameterInch: Double?,
    override var model: String?,
    override var type: CatalogCodeNotComplete<KatalogCode328_NichtAbgeschlossen>?,
    override var pedelec: CatalogCodeFixed<KatalogCode217>?
) : BaseEntity(), Site, Evidence, XpBicycle {

    override val entityType: String = EntityType.BICYCLE.toString()

    override fun getFahrrad(): Fahrrad {
        return Fahrrad().also {
            // Base class attributes
            it.id = id
            // Vehicle
            it.bezeichnung = designation
            it.sachgebundenerHinweis =
                pertinentNote?.map { it.getKatalogCodeNichtAbgeschlossen() }?.filterNotNull()
            it.besondereMerkmale = specialFeatures
            it.bemerkung = comment
            it.verwendungsart = usage?.getKatalogCodeNichtAbgeschlossen()
            it.zeitwert = currentValue?.getGeldbetrag()
            it.neuwert = newValue?.getGeldbetrag()
            it.nummernangabeBeiFahrzeugen =
                vehicleNumber?.map { it.getNummernangabeBeiFahrzeugen() }
            it.breite = width?.getAusmass()
            it.hoehe = height?.getAusmass()
            it.laenge = length?.getAusmass()
            it.fahrzeugfarbe = color?.map { it.getFahrzeugfarbe() }
            it.faelschung = forgery?.getFaelschung()
            it.herstellungsinformation = manufacturingInformation?.getHerstellungsinformation()
            it.asservat = getAsservat()
            // Class attributes
            it.rahmennummer = frameNumber
            it.codenummer = codeNumber
            it.radgroesseInZoll = wheelDiameterInch
            it.modell = model
            it.art = type?.getKatalogCodeNichtAbgeschlossen()
            it.pedelec = pedelec?.getKatalogCode()
        }
    }
}
