@file:OptIn(ExperimentalSerializationApi::class)

package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.inject
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.entities.*
import p20.insitu.model.entities.Person
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.util.getDummyInvestigationNumber
import p20.insitu.model.util.toZonedDateTime
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.resources.FileHandler
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.getCurrentZonedDateTime

@OptIn(ExperimentalCoroutinesApi::class)
class InvestigationViewModel(
    log: Logger,
    fileHandler: FileHandler,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Investigation>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {
    // Just for demo investigation numbers...
    private val clock: Clock by inject()

    //region Entity fields
    // Type of process
    private val _typeOfProcess = MutableStateFlow<CatalogCodeFixed<KatalogCode123>?>(null)
    val typeOfProcess: StateFlow<CatalogCodeFixed<KatalogCode123>?> = _typeOfProcess
    fun setTypeOfProcess(typeOfProcess: CatalogCodeFixed<KatalogCode123>?) {
        _typeOfProcess.value = typeOfProcess
        checkForPendingChanges()
    }

    // Investigation number
    private val _number = MutableStateFlow<String?>(null)
    val number: StateFlow<String?> = _number
    fun setNumber(number: String?) {
        _number.value = number
        checkForPendingChanges()
    }

    // Keywords
    private val _keywords = MutableStateFlow<List<String>>(listOf())
    val keywords: StateFlow<List<String>> = _keywords
    fun setKeywords(keywords: List<String>) {
        _keywords.value = keywords
        checkForPendingChanges()
    }

    // Priority
    private val _priority = MutableStateFlow<CatalogCodeFixed<KatalogCode235>?>(null)
    val priority: StateFlow<CatalogCodeFixed<KatalogCode235>?> = _priority
    fun setPriority(priority: CatalogCodeFixed<KatalogCode235>?) {
        _priority.value = priority
        checkForPendingChanges()
    }

    // Category
    private val _category = MutableStateFlow<CatalogCodeFixed<KatalogCode330>?>(null)
    val category: StateFlow<CatalogCodeFixed<KatalogCode330>?> = _category
    fun setCategory(category: CatalogCodeFixed<KatalogCode330>?) {
        _category.value = category
        checkForPendingChanges()
    }

    // Processing status
    private val _processingStatus = MutableStateFlow<CatalogCodeFixed<KatalogCode221>?>(null)
    val processingStatus: StateFlow<CatalogCodeFixed<KatalogCode221>?> = _processingStatus
    fun setProcessingStatus(processingStatus: CatalogCodeFixed<KatalogCode221>?) {
        _processingStatus.value = processingStatus
    }

    // Comment
    private val _comment = MutableStateFlow<String?>(null)
    val comment: StateFlow<String?> = _comment
    fun setComment(comment: String?) {
        _comment.value = comment
        checkForPendingChanges()
    }

    // Start date (time) of the investigation
    private val _startDate = MutableStateFlow<ZonedDateTime?>(null)
    val startDate: StateFlow<ZonedDateTime?> = _startDate
    fun setStartDate(startDate: ZonedDateTime?) {
        _startDate.value = startDate
        checkForPendingChanges()
    }

    // End date (time) of the investigation
    private val _endDate = MutableStateFlow<ZonedDateTime?>(null)
    val endDate: StateFlow<ZonedDateTime?> = _endDate
    fun setEndDate(endDate: ZonedDateTime?) {
        _endDate.value = endDate
        checkForPendingChanges()
    }
    //endregion


    /**
     * StateFlow that provides the most recent data for the criminal offenses associated with the
     * current investigation.
     */
    val criminalOffenses: StateFlow<List<CriminalOffense>> =
        sessionHandler.docuHandler.investigation.flatMapLatest { inv ->
            inv?.id?.let { invId ->
                docuDataRepo.observeRelatedCriminalOffenses(invId)
            } ?: flow { emit(listOf()) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    /**
     * StateFlow that provides the most recent data for the crime scenes associated with the
     * current investigation.
     */
    val crimeScenes: StateFlow<List<CrimeScene>> =
        sessionHandler.docuHandler.investigation.flatMapLatest { inv ->
            inv?.id?.let { invId ->
                docuDataRepo.observeRelatedCrimeScenes(invId)
            } ?: flow { emit(listOf()) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    /**
     * StateFlow that provides the most recent data for the addresses related to the crime scenes
     * associated with the current investigation.
     */
    val crimeSceneAddresses: StateFlow<Map<String, Address?>> =
        crimeScenes.flatMapLatest { crimeScenes ->
            flow {
                emit(crimeScenes.associate { it.id to docuDataRepo.getRelatedAddress(it.id) })
            }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = mapOf()
        )

    /**
     * StateFlow that provides the most recent data for the persons associated with the
     * current investigation.
     */
    val persons: StateFlow<List<Person>> =
        sessionHandler.docuHandler.investigation.flatMapLatest { inv ->
            inv?.id?.let { invId ->
                docuDataRepo.observeRelatedPersons(invId)
            } ?: flow { emit(listOf()) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    override fun createNewEntity(): Investigation {
        return ObjectFactory.createInvestigation(
            designation = "",
            number = getDummyInvestigationNumber(
                clock.now().toZonedDateTime(TimeZone.currentSystemDefault())
            ),
            startDate = getCurrentZonedDateTime()
        )
    }

    override fun updateUiStates(entity: Investigation) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _typeOfProcess.value = entity.typeOfProcess
        _number.value = entity.number
        _keywords.value = entity.keywords ?: listOf()
        _priority.value = entity.priority
        _category.value = entity.category
        _processingStatus.value = entity.processingStatus
        _comment.value = entity.comment
        _startDate.value = entity.startDate
        _endDate.value = entity.endDate
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.typeOfProcess = _typeOfProcess.value
            it.number = _number.value
            it.keywords = _keywords.value
            it.priority = _priority.value
            it.category = _category.value
            it.processingStatus = _processingStatus.value
            it.comment = _comment.value
            it.startDate = _startDate.value
            it.endDate = _endDate.value
            if (it.designation.isNullOrEmpty()) {
                it.designation = typeOfProcess.value?.name ?: EntityTypeStrings.typeString(
                    EntityType.INVESTIGATION,
                    uiStateHandler.language.value
                )
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): Investigation {
        return Investigation().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.typeOfProcess = typeOfProcess.value
            it.number = number.value
            it.keywords = keywords.value
            it.priority = priority.value
            it.category = category.value
            it.processingStatus = processingStatus.value
            it.comment = comment.value
            it.startDate = startDate.value
            it.endDate = endDate.value
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