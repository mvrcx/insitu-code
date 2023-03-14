package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.Weight

/**
 * Interface for the XPolizei object [Luftfahrzeug].
 * Declares a (sub-)set of relevant properties and maps them to its XPolizei counterparts.
 * Provides a Getter function to create an instance of [Luftfahrzeug].
 */
interface XpAircraft : XpVehicle {

    /**
     * The type of aircraft. Maps to [Luftfahrzeug.art].
     */
    var type: CatalogCodeFixed<KatalogCode114>?

    /**
     * The license / registration number of the aircraft. Maps to [Luftfahrzeug.kennzeichen].
     */
    var registrationNumber: String?

    /**
     * The country in which the aircraft is registered. Maps to [Luftfahrzeug.nationalitaet].
     */
    var nationality: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?

    /**
     * The weight of the aircraft. Maps to [Luftfahrzeug.gewicht].
     */
    var weight: Weight?

    /**
     * Get an instance of [Luftfahrzeug] by mapping the interface properties.
     *
     * @return An instance of [Luftfahrzeug].
     */
    fun getLuftfahrzeug(): Luftfahrzeug

}