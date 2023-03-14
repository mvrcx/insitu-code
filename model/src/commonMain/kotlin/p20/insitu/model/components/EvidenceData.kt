package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpEvidence
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class EvidenceData(
    var securedByUserId: String?= null,
    var documentedByUserId: String?= null,
    var securingTimestamp: ZonedDateTime?= null,
    var barcodes: List<Barcode>? = null,
    var externalSystemId: ExternalSystemId? = null,
    var suspectedTraceCarrier: Boolean?= null,
    override var securingMethod: CatalogCodeNotComplete<KatalogCode405_NichtAbgeschlossen>? = null,
    override var purposeOfSecuring: List<CatalogCodeFixed<KatalogCode369>>? = null,
    override var damagePermission: CatalogCodeFixed<KatalogCode217>? = null,
    override var forensicAnalysis: CatalogCodeFixed<KatalogCode217>? = null,
    override var hazardWarning: String? = null,
    override var transportAndStorageAdvice: String? = null,
    override var storageStatus: CatalogCodeFixed<KatalogCode331>? = null,
    override var unDangerousGoodsNumber: CatalogCodeFixed<KatalogCode349>? = null,
    override var dangerousGoodsNumber: CatalogCodeFixed<KatalogCode395>? = null
) : Component(), XpEvidence {

    override fun getAsservat(baseEntityId: String, docNumber: DocNumber?): Asservat {
        return Asservat().also {
            it.fachlicheAsservatennummer =
                docNumber?.toString() ?: externalSystemId?.id ?: baseEntityId
            it.asservatenID = externalSystemId?.id ?: baseEntityId
            it.sicherungsart = securingMethod?.getKatalogCodeNichtAbgeschlossen()
            it.zweckDerAsservierung = purposeOfSecuring?.map { it.getKatalogCode() }?.filterNotNull()
            it.beschaedigungserlaubnis = damagePermission?.getKatalogCode()
            it.kTUntersuchung = forensicAnalysis?.getKatalogCode()
            it.gefahrenhinweis = hazardWarning
            it.transportUndLagerhinweis = transportAndStorageAdvice
            it.lagerstatus = storageStatus?.getKatalogCode()
            it.uNNummer = unDangerousGoodsNumber?.getKatalogCode()
            it.gefahrgutnummer = dangerousGoodsNumber?.getKatalogCode()
        }
    }

}
