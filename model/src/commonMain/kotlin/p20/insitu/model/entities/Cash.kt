package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Cash(
    override var deleted: Boolean = false,
    override var designation: String?,
    override var thumbnailId: String?,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation?,
    override var evidenceData: EvidenceData?,
    override var type: CatalogCodeFixed<KatalogCode104>?,
    override var serialNumber: String?,
    override var yearIssued: Int?,
    override var comment: String?,
    override var amount: MoneyAmount?,
    override var serialNumberSeries: BankNoteSeries?,
    override var numberOfPieces: Int?,
    override var specialFeatures: String?,
    override var pertinentNote: List<CatalogCodeFixed<KatalogCode386>>?,
    override var issuingCountry: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?,
    override var issuer: CatalogCodeNotComplete<KatalogCode209_NichtAbgeschlossen>?
) : BaseEntity(), Evidence, XpCash {

    override var entityType: String = EntityType.CASH.toString()

    override fun getBargeld(): Bargeld {
        return Bargeld().also {
            // Base class attributes
            it.id = id
            // Money
            it.art = type?.getKatalogCode()
            it.seriennummer = serialNumber
            it.ausgabejahr = yearIssued
            it.bemerkung = comment
            it.nennwert = amount?.getGeldbetrag()
            it.seriennummernserie = serialNumberSeries?.getSerie()
            it.asservat = getAsservat()
            // Class attributes
            it.bezeichnung = designation
            it.stueckzahl = numberOfPieces
            it.besondereMerkmale = specialFeatures
            it.sachgebundenerHinweis = pertinentNote?.map { it.getKatalogCode() }?.filterNotNull()
            it.ausgabestaat = issuingCountry?.getKatalogCodeNichtAbgeschlossen()
            it.emittent = issuer?.getKatalogCodeNichtAbgeschlossen()
        }
    }

}
