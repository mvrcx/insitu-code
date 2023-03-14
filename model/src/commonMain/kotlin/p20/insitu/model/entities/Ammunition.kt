package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

/**
 * This class describes ammunition. Ammunition is a subclass of [Weapon].
 * Ammunition is a [SpatialSemanticObject] and can hold spatial descriptions for various
 * reference contexts (see [SpatialRepresentation]).
 * Ammunition may be regarded as [Evidence] and can therefore hold [EvidenceData].
 *
 * ## XPolizei
 * [Ammunition] implements the [XpAmmunition] interface which exposes a [Munition] object.
 * [Ammunition] is a [Weapon] and therefore implements the [Evidence] interface which exposes an
 * [Asservat] object. When calling [getMunition], the [Asservat] data will automatically be assigned
 * to [Munition.asservat].
 *
 * @property deleted Indicates if the object should be regarded as deleted. Default: `false`
 * @property designation The name or short description of the ammunition.
 * @property thumbnailId Reference to an [Image] object that represents the thumbnail / icon of the
 * ammunition.
 * @property docNumber The documentation number.
 * @property spatialRepresentation Set of spatial representations.
 * @property evidenceData Set of evidence related information.
 * @property model The weapon model. Maps to [Waffe.modell].
 * @property weaponNumber A list of relevant numbers / codes related to the specific weapon.
 * Maps to [Waffe.nummernangabe].
 * @property numberOfPieces  The number of pieces, in case this is a collection of identical weapons.
 * Maps to [Waffe.stueckzahl].
 * @property specialFeatures Special features of the weapon. Maps to [Waffe.besondereMerkmale].
 * @property comment An object-related comment. Maps to [Waffe.bemerkung].
 * @property weight The weight of the weapon. Maps to [Waffe.gewicht].
 * @property width The width of the weapon. Maps to [Waffe.breite].
 * @property height The height of the weapon. Maps to [Waffe.hoehe].
 * @property length The length of the weapon. Maps to [Waffe.laenge].
 * @property color The color(s) of the weapon. Maps to [Waffe.farbangabe].
 * @property type The type of ammunition. Maps to [Munition.art].
 * @property stamp The ammunition stamp at the bottom. Maps to [Munition.bodenstempel].
 * @property manufacturingInformation Manufacturing information. Maps to [Munition.herstellungsinformation].
 * @property caliber The caliber of the ammunition. Maps to [Munition.kaliber].
 * @property permitRequired Indicates if a permit is required for possessing this ammunition.
 * Maps to [Munition.erlaubnispflicht].
 * @constructor Create a new Ammunition object.
 */
@Serializable
data class Ammunition(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation? = null,
    override var evidenceData: EvidenceData? = null,
    override var model: String? = null,
    override var weaponNumber: List<ItemNumber>? = null,
    override var numberOfPieces: Int? = null,
    override var specialFeatures: String? = null,
    override var comment: String? = null,
    override var weight: Weight? = null,
    override var width: Size? = null,
    override var height: Size? = null,
    override var length: Size? = null,
    override var color: List<ColorDescription>? = null,
    override var type: CatalogCodeFixed<KatalogCode292>? = null,
    override var stamp: String? = null,
    override var manufacturingInformation: ManufacturingInformation? = null,
    override var caliber: CatalogCodeFixed<KatalogCode329>? = null,
    override var permitRequired: CatalogCodeFixed<KatalogCode214>? = null
) : BaseEntity(), Evidence, XpAmmunition {

    /**
     * The unique type descriptor for this entity class.
     *
     * @see p20.insitu.model.entities.enums.EntityType
     */
    override val entityType: String = EntityType.AMMUNITION.toString()

    override fun getMunition(): Munition {
        return Munition().also {
            // Base class attributes
            it.id = id
            // XpWeapon
            it.bezeichnung = designation
            it.modell = model
            it.nummernangabe = weaponNumber?.map { it.getNummernangabe() }
            it.stueckzahl = numberOfPieces
            it.besondereMerkmale = specialFeatures
            it.bemerkung = comment
            it.gewicht = weight?.getGewicht()
            it.breite = width?.getAusmass()
            it.hoehe = height?.getAusmass()
            it.laenge = length?.getAusmass()
            it.farbangabe = color?.map { it.getFarbangabe() }
            it.asservat = getAsservat()
            // Class attributes
            it.art = type?.getKatalogCode()
            it.bodenstempel = stamp
            it.herstellungsinformation = manufacturingInformation?.getHerstellungsinformation()
            it.kaliber = caliber?.getKatalogCode()
            it.erlaubnispflicht = permitRequired?.getKatalogCode()
        }
    }
}
