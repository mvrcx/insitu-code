package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class CounterfeitMoney(
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
    override var forgeryType: List<CatalogCodeNotComplete<KatalogCode226_NichtAbgeschlossen>>?,
    override var specialFeatures: String?,
    override var plateNumber: String?,
    override var coinMark: String?,
    override var detectedBy: CatalogCodeFixed<KatalogCode227>?,
    override var numberOfPiecesWithSameFeatures: Int?,
    override var seriesDesignation: String?,
    ) : BaseEntity(), Evidence, XpCounterfeitMoney {
    
    override var entityType: String = EntityType.COUNTERFEIT_MONEY.toString()

    override fun getFalschgeld(): Falschgeld {
        return Falschgeld().also {
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
            it.faelschungsart = forgeryType?.map { it.getKatalogCodeNichtAbgeschlossen() }?.filterNotNull()
            it.besondereMerkmale = specialFeatures
            it.plattennummer = plateNumber
            it.muenzzeichen = coinMark
            it.festgestelltBei = detectedBy?.getKatalogCode()
            it.anzahlMitGleichenHerstellungsmerkmalen = numberOfPiecesWithSameFeatures
            it.serienbezeichnung = seriesDesignation
        }
    }

}
