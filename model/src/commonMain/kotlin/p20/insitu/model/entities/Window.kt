package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.Material
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Window(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var typeOfObject: CatalogCodeNotComplete<KatalogCode119_NichtAbgeschlossen>?,
    override var specialFeatures: String?,
    override var comment: String?,
    override var material: List<Material>?,
    override var color: List<ColorDescription>?,
    override var length: Size?,
    override var width: Size?,
    override var height: Size?,
    override var volume: Volume?,
    override var weight: Weight?,
    override var numberOfPieces: Int?
) : BaseEntity(), ISomeObject {

    override val entityType: String = EntityType.WINDOW.toString()

    override fun getSonstigeSache(): SonstigeSache {
        return SonstigeSache().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = typeOfObject?.getKatalogCodeNichtAbgeschlossen()
            it.bezeichnung = designation
            it.bemerkung = comment
            it.besondereMerkmale = specialFeatures
            it.material = material?.map { it.getMaterial() }
            it.farbangabe = color?.map { it.getFarbangabe() }
            it.laenge = length?.getAusmass()
            it.breite = width?.getAusmass()
            it.hoehe = height?.getAusmass()
            it.volumen = volume?.getVolumen()
            it.gewicht = weight?.getGewicht()
            it.stueckzahl = numberOfPieces
            it.asservat = getAsservat()
        }
    }
}
