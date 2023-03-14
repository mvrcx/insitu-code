package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*
import p20.insitu.model.xpolizei.schema.*

/**
 * Interface for the abstract XPolizei object [Fahrzeug].
 * Declares a (sub-)set of relevant properties and maps them to its XPolizei counterparts.
 */
interface XpVehicle: XpCommonBaseClass {

    /**
     * The name or short description of the vehicle. Maps to [Fahrzeug.bezeichnung].
     */
    var designation: String?

    /**
     * An important object-related notice. Maps to [Fahrzeug.sachgebundenerHinweis].
     */
    var pertinentNote: List<CatalogCodeNotComplete<KatalogCode223_NichtAbgeschlossen>>?

    /**
     * Special features of the vehicle. Maps to [Fahrzeug.besondereMerkmale].
     */
    var specialFeatures: String?

    /**
     * An object-related comment. Maps to [Fahrzeug.bemerkung].
     */
    var comment: String?

    /**
     * The usage type of the vehicle. Maps to [Fahrzeug.verwendungsart].
     */
    var usage: CatalogCodeNotComplete<KatalogCode224_NichtAbgeschlossen>?

    /**
     * The current value of the vehicle. Maps to [Fahrzeug.zeitwert].
     */
    var currentValue: MoneyAmount?

    /**
     * The original / new price of the vehicle. Maps to [Fahrzeug.neuwert].
     */
    var newValue: MoneyAmount?

    /**
     * A list of relevant numbers / codes related to the specific vehicle.
     * Maps to [Fahrzeug.nummernangabeBeiFahrzeugen].
     */
    var vehicleNumber: List<VehicleNumber>?

    /**
     * The width of the vehicle. Maps to [Fahrzeug.breite].
     */
    var width: Size?

    /**
     * The height of the vehicle. Maps to [Fahrzeug.hoehe].
     */
    var height: Size?

    /**
     * The length of the vehicle. Maps to [Fahrzeug.laenge].
     */
    var length: Size?

    /**
     * The color(s) of the vehicle. Maps to [Fahrzeug.fahrzeugfarbe].
     */
    var color: List<VehicleColor>?

    /**
     * Indicates if the vehicle is a forgery. Maps to [Fahrzeug.faelschung].
     */
    var forgery: Forgery?

    /**
     * Manufacturing information. Maps to [Fahrzeug.herstellungsinformation].
     */
    var manufacturingInformation: ManufacturingInformation?

}