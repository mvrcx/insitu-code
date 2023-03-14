package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Firearm(
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
    override var category: CatalogCodeFixed<KatalogCode305>?,
    override var type: CatalogCodeFixed<KatalogCode291>?,
    override var illegalModificationOrManufacturing: List<CatalogCodeFixed<KatalogCode296>>?,
    override var barrelLength: Size?,
    override var manufacturingInformation: FirearmManufacturingInformation?,
    override var dealerIdentification: String?,
    override var caliber: List<CatalogCodeFixed<KatalogCode329>>?,
    override var condition: FirearmCondition?,
    override var registered: CatalogCodeFixed<KatalogCode214>?,
    override var permitRequired: CatalogCodeFixed<KatalogCode217>?
) : BaseEntity(), Evidence, XpFirearm {

    override val entityType: String = EntityType.FIREARM.toString()

    override fun getSchusswaffe(): Schusswaffe {
        return Schusswaffe().also {
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
            it.haendlerzeichen = dealerIdentification
            it.kategorie = category?.getKatalogCode()
            it.art = type?.getKatalogCode()
            it.ungesetzlicheBearbeitung_Herstellung = illegalModificationOrManufacturing?.map {
                it.getKatalogCode()
            }?.filterNotNull()
            it.lauflaenge = barrelLength?.getAusmass()
            it.schusswaffenherstellungsinformation =
                manufacturingInformation?.getSchusswaffenherstellungsinformation()
            it.kaliber = caliber?.map { it.getKatalogCode() }?.filterNotNull()
            it.schusswaffenzustandsinformation = condition?.getSchusswaffenzustandsinformation()
            it.amtlichRegistriert = registered?.getKatalogCode()
            it.erlaubnispflicht = permitRequired?.getKatalogCode()
        }
    }
}
