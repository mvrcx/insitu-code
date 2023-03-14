package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ManufacturingInformation

/**
 * Interface for the XPolizei object [Munition].
 * Declares a (sub-)set of relevant properties and maps them to its XPolizei counterparts.
 * Provides a Getter function to create an instance of [Munition].
 */
interface XpAmmunition: XpWeapon {

    /**
     * The type of ammunition. Maps to [Munition.art].
     */
    var type: CatalogCodeFixed<KatalogCode292>?

    /**
     * The ammunition stamp at the bottom. Maps to [Munition.bodenstempel].
     */
    var stamp: String?

    /**
     * Manufacturing information. Maps to [Munition.herstellungsinformation].
     */
    var manufacturingInformation: ManufacturingInformation?

    /**
     * The caliber of the ammunition. Maps to [Munition.kaliber].
     */
    var caliber: CatalogCodeFixed<KatalogCode329>?

    /**
     * Indicates if a permit is required for possessing this ammunition. Maps to [Munition.erlaubnispflicht].
     */
    var permitRequired: CatalogCodeFixed<KatalogCode214>?

    /**
     * Get an instance of [Munition] by mapping the interface properties.
     *
     * @return An instance of [Munition].
     */
    fun getMunition(): Munition

}