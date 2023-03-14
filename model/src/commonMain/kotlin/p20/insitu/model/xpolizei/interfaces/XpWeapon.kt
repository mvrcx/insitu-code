package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Waffe
import p20.insitu.model.components.ColorDescription
import p20.insitu.model.components.ItemNumber
import p20.insitu.model.components.Size
import p20.insitu.model.components.Weight

/**
 * Interface for the abstract XPolizei object [Waffe].
 * Declares a (sub-)set of relevant properties and maps them to its XPolizei counterparts.
 */
interface XpWeapon: XpCommonBaseClass {

    /**
     * The name or short description of the weapon. Maps to [Waffe.bezeichnung].
     */
    var designation: String?

    /**
     * The weapon model. Maps to [Waffe.modell].
     */
    var model: String?

    /**
     * A list of relevant numbers / codes related to the specific weapon. Maps to [Waffe.nummernangabe].
     */
    var weaponNumber: List<ItemNumber>?

    /**
     * The number of pieces, in case this is a collection of identical weapons.
     * Maps to [Waffe.stueckzahl].
     */
    var numberOfPieces: Int?

    /**
     * Special features of the weapon. Maps to [Waffe.besondereMerkmale].
     */
    var specialFeatures: String?

    /**
     * An object-related comment. Maps to [Waffe.bemerkung].
     */
    var comment: String?

    /**
     * The weight of the weapon. Maps to [Waffe.gewicht].
     */
    var weight: Weight?

    /**
     * The width of the weapon. Maps to [Waffe.breite].
     */
    var width: Size?

    /**
     * The height of the weapon. Maps to [Waffe.hoehe].
     */
    var height: Size?

    /**
     * The length of the weapon. Maps to [Waffe.laenge].
     */
    var length: Size?

    /**
     * The color(s) of the weapon. Maps to [Waffe.farbangabe].
     */
    var color: List<ColorDescription>?

}