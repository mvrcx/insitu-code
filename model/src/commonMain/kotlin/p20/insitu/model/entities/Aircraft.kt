package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

/**
 * This class describes an aircraft. An aircraft is a [Vehicle].
 * An aircraft is a [SpatialSemanticObject] and can hold spatial descriptions for various
 * reference contexts (see [SpatialRepresentation]).
 * An aircraft may be regarded as [Evidence] and can therefore hold [EvidenceData].
 * An aircraft can function as a [Site] within the INSITU data model.
 *
 * ## XPolizei
 * [Aircraft] implements the [XpAircraft] interface which exposes a [Luftfahrzeug] object.
 * [Aircraft] is a [Vehicle] and therefore implements the [Evidence] interface which exposes an
 * [Asservat] object. When calling [getLuftfahrzeug], the [Asservat] data will automatically be
 * assigned to [Luftfahrzeug.asservat].
 *
 * @property deleted Indicates if the aircraft should be regarded as deleted. Default: `false`
 * @property designation The name or short description of the aircraft.
 * @property thumbnailId A reference to a thumbnail [Image] for the aircraft.
 * @property docNumber The documentation number.
 * @property spatialRepresentation Set of spatial representations.
 * @property evidenceData Set of evidence related information.
 * @property pertinentNote An important object-related notice.
 * Maps to [Fahrzeug.sachgebundenerHinweis].
 * @property specialFeatures Special features of the vehicle. Maps to [Fahrzeug.besondereMerkmale].
 * @property comment An object-related comment. Maps to [Fahrzeug.bemerkung].
 * @property usage The usage type of the vehicle. Maps to [Fahrzeug.verwendungsart].
 * @property currentValue The current value of the vehicle. Maps to [Fahrzeug.zeitwert].
 * @property newValue The original / new price of the vehicle. Maps to [Fahrzeug.neuwert].
 * @property vehicleNumber A list of relevant numbers / codes related to the specific vehicle.
 * Maps to [Fahrzeug.nummernangabeBeiFahrzeugen].
 * @property width The width of the vehicle. Maps to [Fahrzeug.breite].
 * @property height The height of the vehicle. Maps to [Fahrzeug.hoehe].
 * @property length The length of the vehicle. Maps to [Fahrzeug.laenge].
 * @property color The color(s) of the vehicle. Maps to [Fahrzeug.fahrzeugfarbe].
 * @property forgery Indicates if the vehicle is a forgery. Maps to [Fahrzeug.faelschung].
 * @property manufacturingInformation Manufacturing information.
 * Maps to [Fahrzeug.herstellungsinformation].
 * @property type The type of aircraft. Maps to [Luftfahrzeug.art].
 * @property registrationNumber The license / registration number of the aircraft.
 * Maps to [Luftfahrzeug.kennzeichen].
 * @property nationality The country in which the aircraft is registered.
 * Maps to [Luftfahrzeug.nationalitaet].
 * @property weight The weight of the aircraft. Maps to [Luftfahrzeug.gewicht].
 * @constructor Create a new [Aircraft] object.
 */
@Serializable
data class Aircraft(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation? = null,
    override var evidenceData: EvidenceData? = null,
    override var pertinentNote: List<CatalogCodeNotComplete<KatalogCode223_NichtAbgeschlossen>>? = null,
    override var specialFeatures: String? = null,
    override var comment: String? = null,
    override var usage: CatalogCodeNotComplete<KatalogCode224_NichtAbgeschlossen>? = null,
    override var currentValue: MoneyAmount? = null,
    override var newValue: MoneyAmount? = null,
    override var vehicleNumber: List<VehicleNumber>? = null,
    override var width: Size? = null,
    override var height: Size? = null,
    override var length: Size? = null,
    override var color: List<VehicleColor>? = null,
    override var forgery: Forgery? = null,
    override var manufacturingInformation: ManufacturingInformation? = null,
    override var type: CatalogCodeFixed<KatalogCode114>? = null,
    override var registrationNumber: String? = null,
    override var nationality: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>? = null,
    override var weight: Weight? = null
) : BaseEntity(), Site, Evidence, XpAircraft {

    /**
     * The unique type descriptor for this entity class.
     *
     * @see p20.insitu.model.entities.enums.EntityType
     */
    override val entityType: String = EntityType.AIRCRAFT.toString()

    override fun getLuftfahrzeug(): Luftfahrzeug {
        return Luftfahrzeug().also {
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
            it.kennzeichen = registrationNumber
            it.nationalitaet = nationality?.getKatalogCodeNichtAbgeschlossen()
            it.gewicht = weight?.getGewicht()
        }
    }
}
