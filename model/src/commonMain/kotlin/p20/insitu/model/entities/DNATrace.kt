package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.Material
import p20.insitu.model.components.dna.DNAClassification
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class DNATrace(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation? = null,
    override var evidenceData: EvidenceData? = null,
    override var typeOfPhysicalTrace: CatalogCodeFixed<KatalogCode120>? = null,
    override var numberOfPieces: Int? = null,
    override var position: String? = null,
    override var comment: String? = null,
    override var weight: Weight? = null,
    override var color: List<ColorDescription>? = null,
    override var volume: Volume? = null,
    override var material: List<Material>? = null,
    override var length: Size? = null,
    override var width: Size? = null,
    override var height: Size? = null,
    override var diameter: Size? = null,
    override var quality: CatalogCodeFixed<KatalogCode327>? = null,
    var classification: DNAClassification? = null
) : BaseEntity(), Evidence, XpPhysicalTrace {

    override val entityType: String = EntityType.DNA_TRACE.toString()

    override fun getSpurMateriell(): SpurMateriell {
        return SpurMateriell().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = typeOfPhysicalTrace?.getKatalogCode()
            it.stueckzahl = numberOfPieces
            it.lage = position
            it.bemerkung = comment
            it.gewicht = weight?.getGewicht()
            it.farbangabe = color?.map { it.getFarbangabe() }
            it.volumen = volume?.getVolumen()
            it.material = material?.map { it.getMaterial() }
            it.laenge = length?.getAusmass()
            it.breite = width?.getAusmass()
            it.hoehe = height?.getAusmass()
            it.durchmesser = diameter?.getAusmass()
            it.verwertbarkeit = quality?.getKatalogCode()
            it.asservat = getAsservat()
        }
    }
}
