package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class RailVehicle(
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
    override var type: CatalogCodeFixed<KatalogCode118>?
) : BaseEntity(), Site, Evidence, XpRailVehicle {

    override val entityType: String = EntityType.RAIL_VEHICLE.toString()

    override fun getSchienenfahrzeug(): Schienenfahrzeug {
        return Schienenfahrzeug().also {
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
            it.art = type?.getKatalogCode()
        }
    }
}
