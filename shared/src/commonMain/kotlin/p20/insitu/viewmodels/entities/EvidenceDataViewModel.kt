package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.ExperimentalSerializationApi
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.components.*
import p20.insitu.model.entities.Evidence
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.resources.FileHandler
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.getCurrentZonedDateTime

@OptIn(ExperimentalSerializationApi::class)
abstract class EvidenceDataViewModel<E : Evidence>(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<E>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {

    override fun updateUiStates(entity: E) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        // TODO remove fixed assignment of userInfo
        _securedByUserId.value =
            entity.evidenceData?.securedByUserId ?: sessionHandler.userInfo.value?.id
        // TODO remove fixed assignment of userInfo
        _documentedByUserId.value =
            entity.evidenceData?.documentedByUserId ?: sessionHandler.userInfo.value?.id
        _securingTimestamp.value = entity.evidenceData?.securingTimestamp
        _barcodes.value = entity.evidenceData?.barcodes
        _externalSystemId.value = entity.evidenceData?.externalSystemId
        _suspectedTraceCarrier.value = entity.evidenceData?.suspectedTraceCarrier
        _securingMethod.value = entity.evidenceData?.securingMethod
        _purposeOfSecuring.value = entity.evidenceData?.purposeOfSecuring ?: listOf()
        _damagePermission.value = entity.evidenceData?.damagePermission
        _forensicAnalysis.value = entity.evidenceData?.forensicAnalysis
        _hazardWarning.value = entity.evidenceData?.hazardWarning
        _transportAndStorageAdvice.value = entity.evidenceData?.transportAndStorageAdvice
        _storageStatus.value = entity.evidenceData?.storageStatus
        _unDangerousGoodsNumber.value = entity.evidenceData?.unDangerousGoodsNumber
        _dangerousGoodsNumber.value = entity.evidenceData?.dangerousGoodsNumber
    }

    protected fun getEvidenceDataFromCurrentState(): EvidenceData? {
        return if (entity.value?.evidenceData == null && !_secureAsEvidence.value) {
            null
        } else {
            EvidenceData(
                securedByUserId = securedByUserId.value,
                documentedByUserId = documentedByUserId.value,
                securingTimestamp = getCurrentZonedDateTime(),
                barcodes = barcodes.value,
                externalSystemId = externalSystemId.value,
                suspectedTraceCarrier = suspectedTraceCarrier.value,
                securingMethod = securingMethod.value,
                purposeOfSecuring = purposeOfSecuring.value,
                damagePermission = damagePermission.value,
                forensicAnalysis = forensicAnalysis.value,
                hazardWarning = hazardWarning.value,
                transportAndStorageAdvice = transportAndStorageAdvice.value,
                storageStatus = storageStatus.value,
                unDangerousGoodsNumber = unDangerousGoodsNumber.value,
                dangerousGoodsNumber = dangerousGoodsNumber.value
            )
        }
    }

    // When creating a new object -> should it be secured as evidence?
    private val _secureAsEvidence = MutableStateFlow(false)
    fun setSecureAsEvidence(secureAsEvidence: Boolean) {
        _secureAsEvidence.value = secureAsEvidence
    }

    // Secured by which user?
    private val _securedByUserId = MutableStateFlow<String?>(null)
    val securedByUserId: StateFlow<String?> = _securedByUserId
    fun setSecuredByUserId(securedByUserId: String?) {
        _securedByUserId.value = securedByUserId
        checkForPendingChanges()
    }

    // Documented by which user?
    private val _documentedByUserId = MutableStateFlow<String?>(null)
    val documentedByUserId: StateFlow<String?> = _documentedByUserId
    fun setDocumentedByUserId(documentedByUserId: String?) {
        _documentedByUserId.value = documentedByUserId
        checkForPendingChanges()
    }

    // Time of securing the evidence
    private val _securingTimestamp = MutableStateFlow<ZonedDateTime?>(null)
    val securingTimestamp: StateFlow<ZonedDateTime?> = _securingTimestamp
    fun setSecuringTimestamp(securingTimestamp: ZonedDateTime?) {
        _securingTimestamp.value = securingTimestamp
        checkForPendingChanges()
    }

    // Associated Barcodes / QR codes
    private val _barcodes = MutableStateFlow<List<Barcode>?>(null)
    val barcodes: StateFlow<List<Barcode>?> = _barcodes
    fun setBarcodes(barcodes: List<Barcode>?) {
        _barcodes.value = barcodes
        checkForPendingChanges()
    }

    // Evidence ID of an external system
    private val _externalSystemId = MutableStateFlow<ExternalSystemId?>(null)
    val externalSystemId: StateFlow<ExternalSystemId?> = _externalSystemId
    fun setExternalSystemId(externalSystemId: ExternalSystemId?) {
        _externalSystemId.value = externalSystemId
        checkForPendingChanges()
    }

    // Is the evidence a potential trace carrier?
    private val _suspectedTraceCarrier = MutableStateFlow<Boolean?>(null)
    val suspectedTraceCarrier: StateFlow<Boolean?> = _suspectedTraceCarrier
    fun setSuspectedTraceCarrier(suspectedTraceCarrier: Boolean?) {
        _suspectedTraceCarrier.value = suspectedTraceCarrier
        checkForPendingChanges()
    }

    // The method of securing the evidence
    private val _securingMethod =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode405_NichtAbgeschlossen>?>(null)
    val securingMethod: StateFlow<CatalogCodeNotComplete<KatalogCode405_NichtAbgeschlossen>?> =
        _securingMethod

    fun setSecuringMethod(securingMethod: CatalogCodeNotComplete<KatalogCode405_NichtAbgeschlossen>?) {
        _securingMethod.value = securingMethod
        checkForPendingChanges()
    }

    // The purpose of securing the evidence
    private val _purposeOfSecuring =
        MutableStateFlow<List<CatalogCodeFixed<KatalogCode369>>>(listOf())
    val purposeOfSecuring: StateFlow<List<CatalogCodeFixed<KatalogCode369>>> = _purposeOfSecuring
    fun setPurposeOfSecuring(purposeOfSecuring: List<CatalogCodeFixed<KatalogCode369>>) {
        _purposeOfSecuring.value = purposeOfSecuring
        checkForPendingChanges()
    }

    // Is it allowed to damage the evidence (e.g. during examination)
    private val _damagePermission = MutableStateFlow<CatalogCodeFixed<KatalogCode217>?>(null)
    val damagePermission: StateFlow<CatalogCodeFixed<KatalogCode217>?> = _damagePermission
    fun setDamagePermission(damagePermission: CatalogCodeFixed<KatalogCode217>?) {
        _damagePermission.value = damagePermission
        checkForPendingChanges()
    }

    // Should a forensic analysis be conducted
    private val _forensicAnalysis = MutableStateFlow<CatalogCodeFixed<KatalogCode217>?>(null)
    val forensicAnalysis: StateFlow<CatalogCodeFixed<KatalogCode217>?> = _forensicAnalysis
    fun setForensicAnalysis(forensicAnalysis: CatalogCodeFixed<KatalogCode217>?) {
        _forensicAnalysis.value = forensicAnalysis
        checkForPendingChanges()
    }

    // Hazard warning
    private val _hazardWarning = MutableStateFlow<String?>(null)
    val hazardWarning: StateFlow<String?> = _hazardWarning
    fun setHazardWarning(hazardWarning: String?) {
        _hazardWarning.value = hazardWarning
        checkForPendingChanges()
    }

    // Advice for transport and storage
    private val _transportAndStorageAdvice = MutableStateFlow<String?>(null)
    val transportAndStorageAdvice: StateFlow<String?> = _transportAndStorageAdvice
    fun setTransportAndStorageAdvice(transportAndStorageAdvice: String?) {
        _transportAndStorageAdvice.value = transportAndStorageAdvice
        checkForPendingChanges()
    }

    // Storage status
    private val _storageStatus = MutableStateFlow<CatalogCodeFixed<KatalogCode331>?>(null)
    val storageStatus: StateFlow<CatalogCodeFixed<KatalogCode331>?> = _storageStatus
    fun setStorageStatus(storageStatus: CatalogCodeFixed<KatalogCode331>?) {
        _storageStatus.value = storageStatus
        checkForPendingChanges()
    }

    // UN dangerous goods number
    private val _unDangerousGoodsNumber = MutableStateFlow<CatalogCodeFixed<KatalogCode349>?>(null)
    val unDangerousGoodsNumber: StateFlow<CatalogCodeFixed<KatalogCode349>?> =
        _unDangerousGoodsNumber

    fun setUnDangerousGoodsNumber(unDangerousGoodsNumber: CatalogCodeFixed<KatalogCode349>?) {
        _unDangerousGoodsNumber.value = unDangerousGoodsNumber
        checkForPendingChanges()
    }

    // Federal dangerous goods number
    private val _dangerousGoodsNumber = MutableStateFlow<CatalogCodeFixed<KatalogCode395>?>(null)
    val dangerousGoodsNumber: StateFlow<CatalogCodeFixed<KatalogCode395>?> = _dangerousGoodsNumber
    fun setDangerousGoodsNumber(dangerousGoodsNumber: CatalogCodeFixed<KatalogCode395>?) {
        _dangerousGoodsNumber.value = dangerousGoodsNumber
        checkForPendingChanges()
    }

}