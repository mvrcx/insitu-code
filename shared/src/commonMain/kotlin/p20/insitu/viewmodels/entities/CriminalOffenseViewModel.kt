package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataApi
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.components.*
import p20.insitu.model.components.ModusOperandi
import p20.insitu.model.entities.CriminalOffense
import p20.insitu.model.entities.Investigation
import p20.insitu.model.util.CatalogInfo
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.resources.FileHandler
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

class CriminalOffenseViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<CriminalOffense>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {
    // The type of criminal act
    private val _typeOfCrime = MutableStateFlow<CatalogCodeFixed<KatalogCode121>?>(null)
    val typeOfCrime: StateFlow<CatalogCodeFixed<KatalogCode121>?> = _typeOfCrime
    fun setTypeOfCrime(typeOfCrime: CatalogCodeFixed<KatalogCode121>?) {
        _typeOfCrime.value = typeOfCrime
        checkForPendingChanges()
    }

    // If it was an attempt or 'successfully' executed
    private val _attempt = MutableStateFlow<CatalogCodeFixed<KatalogCode217>?>(null)
    val attempt: StateFlow<CatalogCodeFixed<KatalogCode217>?> = _attempt
    fun setAttempt(attempt: CatalogCodeFixed<KatalogCode217>?) {
        _attempt.value = attempt
        checkForPendingChanges()
    }

    // The affected legal assets
    private val _legalAssets = MutableStateFlow<List<CatalogCodeFixed<KatalogCode370>>>(listOf())
    val legalAssets: StateFlow<List<CatalogCodeFixed<KatalogCode370>>> = _legalAssets
    fun setLegalAssets(legalAssets: List<CatalogCodeFixed<KatalogCode370>>) {
        _legalAssets.value = legalAssets
        checkForPendingChanges()
    }

    // European crime categories
    private val _europeanCrimeCategories =
        MutableStateFlow<List<CatalogCodeNotComplete<KatalogCode272_NichtAbgeschlossen>>>(listOf())
    val europeanCrimeCategories: StateFlow<List<CatalogCodeNotComplete<KatalogCode272_NichtAbgeschlossen>>> =
        _europeanCrimeCategories

    fun setEuropeanCrimeCategories(europeanCrimeCategories: List<CatalogCodeNotComplete<KatalogCode272_NichtAbgeschlossen>>) {
        _europeanCrimeCategories.value = europeanCrimeCategories
        checkForPendingChanges()
    }

    // Characteristics of the crime
    private val _characteristics =
        MutableStateFlow<List<CatalogCodeNotComplete<KatalogCode304_NichtAbgeschlossen>>>(listOf())
    val characteristics: StateFlow<List<CatalogCodeNotComplete<KatalogCode304_NichtAbgeschlossen>>> =
        _characteristics

    fun setCharacteristics(characteristics: List<CatalogCodeNotComplete<KatalogCode304_NichtAbgeschlossen>>) {
        _characteristics.value = characteristics
        checkForPendingChanges()
    }

    // Type of victim
    private val _victimType =
        MutableStateFlow<List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>>(listOf())
    val victimType: StateFlow<List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>> = _victimType
    fun setVictimType(victimType: List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>) {
        _victimType.value = victimType
        checkForPendingChanges()
    }

    // Type of offender
    private val _offenderType =
        MutableStateFlow<List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>>(listOf())
    val offenderType: StateFlow<List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>> =
        _offenderType

    fun setOffenderType(victimType: List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>) {
        _offenderType.value = victimType
        checkForPendingChanges()
    }

    // Short description
    private val _shortDescription = MutableStateFlow<String?>(null)
    val shortDescription: StateFlow<String?> = _shortDescription
    fun setShortDescription(shortDescription: String?) {
        _shortDescription.value = shortDescription
        checkForPendingChanges()
    }

    // Modus Operandi planning phase
    private val _modusOperandiPlanning =
        MutableStateFlow<ModusOperandi>(ObjectFactory.createModusOperandiPlanningPhase())
    val modusOperandiPlanning: StateFlow<ModusOperandi> = _modusOperandiPlanning
    fun setModusOperandiPlanning(modusOperandiPlanning: ModusOperandi) {
        _modusOperandiPlanning.value = modusOperandiPlanning
        checkForPendingChanges()
    }

    // Modus Operandi execution phase
    private val _modusOperandiExecution =
        MutableStateFlow<ModusOperandi>(ObjectFactory.createModusOperandiExecutionPhase())
    val modusOperandiExecution: StateFlow<ModusOperandi> = _modusOperandiExecution
    fun setModusOperandiExecution(modusOperandiExecution: ModusOperandi) {
        _modusOperandiExecution.value = modusOperandiExecution
        checkForPendingChanges()
    }

    // Modus Operandi post execution phase
    private val _modusOperandiPostExecution =
        MutableStateFlow<ModusOperandi>(ObjectFactory.createModusOperandiPostExecutionPhase())
    val modusOperandiPostExecution: StateFlow<ModusOperandi> = _modusOperandiPostExecution
    fun setModusOperandiPostExecution(modusOperandiPostExecution: ModusOperandi) {
        _modusOperandiPostExecution.value = modusOperandiPostExecution
        checkForPendingChanges()
    }

    // Start date (time) of the criminal act
    private val _start = MutableStateFlow<ZonedDateTime?>(null)
    val start: StateFlow<ZonedDateTime?> = _start
    fun setStart(start: ZonedDateTime?) {
        _start.value = start
        checkForPendingChanges()
    }

    // End date (time) of the criminal act
    private val _end = MutableStateFlow<ZonedDateTime?>(null)
    val end: StateFlow<ZonedDateTime?> = _end
    fun setEnd(end: ZonedDateTime?) {
        _end.value = end
        checkForPendingChanges()
    }

    // The time the crime was reported
    private val _timeOfReporting = MutableStateFlow<ZonedDateTime?>(null)
    val timeOfReporting: StateFlow<ZonedDateTime?> = _timeOfReporting
    fun setTimeOfReporting(timeOfReporting: ZonedDateTime?) {
        _timeOfReporting.value = timeOfReporting
        checkForPendingChanges()
    }

    override fun createNewEntity(): CriminalOffense {
        return ObjectFactory.createCriminalOffense()
    }

    override fun updateUiStates(entity: CriminalOffense) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _typeOfCrime.value = entity.typeOfCrime
        _attempt.value = entity.attempt
        _europeanCrimeCategories.value = entity.europeanCrimeCategory ?: listOf()
        _shortDescription.value = entity.shortDescription
        _characteristics.value = entity.characteristics ?: listOf()
        _start.value = entity.start
        _end.value = entity.end
        _timeOfReporting.value = entity.timeOfReporting
        _modusOperandiPlanning.value =
            entity.modusOperandi?.get(0) ?: ObjectFactory.createModusOperandiPlanningPhase()
        _modusOperandiExecution.value =
            entity.modusOperandi?.get(1) ?: ObjectFactory.createModusOperandiExecutionPhase()
        _modusOperandiPostExecution.value =
            entity.modusOperandi?.get(2)
                ?: ObjectFactory.createModusOperandiPostExecutionPhase()
        _victimType.value = entity.victimType ?: listOf()
        _offenderType.value = entity.offenderType ?: listOf()
        _legalAssets.value = entity.legalAsset ?: listOf()
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { it ->
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.typeOfCrime = _typeOfCrime.value
            it.attempt = _attempt.value
            it.europeanCrimeCategory = _europeanCrimeCategories.value
            it.shortDescription = _shortDescription.value
            it.characteristics = _characteristics.value
            it.start = _start.value
            it.end = _end.value
            it.timeOfReporting = _timeOfReporting.value
            it.modusOperandi = listOf(
                _modusOperandiPlanning.value,
                _modusOperandiExecution.value,
                _modusOperandiPostExecution.value
            )
            it.victimType = _victimType.value
            it.offenderType = _offenderType.value
            it.legalAsset = _legalAssets.value
            if (it.designation.isNullOrEmpty() && it.typeOfCrime != null) {
                it.designation = it.typeOfCrime!!.toString()
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): CriminalOffense {
        return CriminalOffense().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.typeOfCrime = typeOfCrime.value
            it.attempt = attempt.value
            it.europeanCrimeCategory = europeanCrimeCategories.value
            it.shortDescription = shortDescription.value
            it.characteristics = characteristics.value
            it.start = start.value
            it.end = end.value
            it.timeOfReporting = timeOfReporting.value
            it.modusOperandi = listOf(
                modusOperandiPlanning.value,
                modusOperandiExecution.value,
                modusOperandiPostExecution.value
            )
            it.victimType = victimType.value
            it.offenderType = offenderType.value
            it.legalAsset = legalAssets.value
        }
    }

    override fun checkForPendingChanges(ignoreAttributes: List<String>): Boolean {
        return super.checkForPendingChanges(
            listOf(
                "id",
                "deleted"
            )
        )
    }
}