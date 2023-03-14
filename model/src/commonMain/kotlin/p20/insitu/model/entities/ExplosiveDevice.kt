package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class ExplosiveDevice(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var model: String?,
    override var weaponNumber: List<ItemNumber>?,
    override var numberOfPieces: Int?,
    override var specialFeatures: String?,
    override var comment: String?,
    override var weight: Weight?,
    override var width: Size?,
    override var height: Size?,
    override var length: Size?,
    override var color: List<ColorDescription>?,
    override var category: CatalogCodeFixed<KatalogCode302>?,
    override var type: CatalogCodeFixed<KatalogCode300>?,
    override var dummy: CatalogCodeFixed<KatalogCode217>?,
    override var assembly: CatalogCodeFixed<KatalogCode301>?,
    override var manufacturingInformation: ManufacturingInformation?,
    override var permitRequired: CatalogCodeFixed<KatalogCode214>?
) : BaseEntity(), Evidence, XpExplosiveDevice {

    override val entityType: String = EntityType.EXPLOSIVE_DEVICE.toString()

    override fun getSprengvorrichtungBrandvorrichtung(): Sprengvorrichtung_Brandvorrichtung {
        return Sprengvorrichtung_Brandvorrichtung().also {
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
            it.kategorie = category?.getKatalogCode()
            it.art = type?.getKatalogCode()
            it.attrappe = dummy?.getKatalogCode()
            it.laborierung = assembly?.getKatalogCode()
            it.herstellungsinformation = manufacturingInformation?.getHerstellungsinformation()
            it.erlaubnispflicht = permitRequired?.getKatalogCode()
        }
    }
}
