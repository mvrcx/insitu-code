package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.Authority
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class LicensePlate(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var specialFeatures: String?,
    override var comment: String?,
    override var frameColor: ColorDescription?,
    override var backgroundColor: ColorDescription?,
    override var fontColor: ColorDescription?,
    override var licensePlateData: LicensePlateData?,
    override var width: Size?,
    override var length: Size?,
    override var issuedBy: Authority?,
    override var numberOfPieces: Int?
): BaseEntity(), Evidence, XpLicensePlate {

    override val entityType: String = EntityType.LICENSE_PLATE.toString()

    override fun getKfzKennzeichenschild(): KfzKennzeichenschild {
        return KfzKennzeichenschild().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.besondereMerkmale = specialFeatures
            it.bemerkung = comment
            it.umrandungsfarbe = frameColor?.getFarbangabe()
            it.hintergrundfarbe = backgroundColor?.getFarbangabe()
            it.schriftfarbe = fontColor?.getFarbangabe()
            it.kfzKennzeicheninformation = licensePlateData?.getKfzKennzeicheninformation()
            it.breite = width?.getAusmass()
            it.laenge = length?.getAusmass()
            it.ausgestelltVon = issuedBy?.getBeteiligteStelle()
            it.stueckzahl = numberOfPieces
            it.asservat = getAsservat()
        }
    }

}
