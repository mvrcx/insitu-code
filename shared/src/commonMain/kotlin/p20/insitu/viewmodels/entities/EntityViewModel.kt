@file:OptIn(ExperimentalSerializationApi::class)

package p20.insitu.viewmodels.entities

import androidx.compose.runtime.MutableState
import co.touchlab.kermit.Logger
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.db.util.toMap
import p20.insitu.model.entities.*
import p20.insitu.model.entities.Annotation
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.model.util.mapDifference
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.nav.NavRoute
import p20.insitu.resources.FileHandler
import p20.insitu.util.TabType

@OptIn(ExperimentalCoroutinesApi::class)
abstract class EntityViewModel<T : DocumentationObject>(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    coroutineScope: CoroutineScope,
    protected val catalogRepo: CatalogRepo
) : KoinComponent, EntityMediaViewModel<T>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    coroutineScope = coroutineScope
) {

    init {
        log.i("initializing ViewModel: ${this::class.simpleName}")
    }

    protected lateinit var navigationState: MutableState<NavAction?>

    private val _catalogCode = MutableStateFlow<String?>(null)
    val catalogCode: StateFlow<String?> = _catalogCode

    protected var initialAttributeMap: Map<String, Any?> = mapOf()

    val entity: StateFlow<T?> =
        _entity.flatMapLatest { entity ->
            entity?.id?.let { entityId ->
                docuDataRepo.observeEntity<T>(entityId)
                    .onStart {
                        emit(entity)
                    }
            } ?: flow { emit(null) }
        }.onEach {
            // TODO: Maybe ignore updates when in edit mode?
            it?.let { updateUiStates(it) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    open fun setEntity(entity: T) {
        _entity.value = entity
        updateUiStates(entity)
    }

    protected val _designation = MutableStateFlow<String?>(null)
    val designation: StateFlow<String?> = _designation
    fun setDesignation(designation: String?) {
        _designation.value = designation
        checkForPendingChanges()
    }

    protected val _thumbnailId = MutableStateFlow<String?>(null)
    val thumbnailId: StateFlow<String?> = _thumbnailId
    fun setThumbnailId(thumbnailId: String?) {
        _thumbnailId.value = thumbnailId
        checkForPendingChanges()
    }

    private val _selectedTab = MutableStateFlow<TabType?>(
        uiStateHandler.getSelectedTab(this::class.simpleName!!)
    )
    val selectedTab: StateFlow<TabType?> = _selectedTab
    fun setSelectedTab(selectedTab: TabType?) {
        _selectedTab.value = selectedTab
        // Update selected tab state in global ui state handler to keep selected screen on back navigation
        uiStateHandler.setSelectedTab(this::class.simpleName!!, selectedTab)
    }

    protected abstract fun createNewEntity(): T

    protected abstract fun updateUiStates(entity: T)

    protected abstract fun updateEntityFromUiStates()

    protected abstract fun getEditedEntityState(): T

    open suspend fun init(
        entityId: String? = null,
        navigationState: MutableState<NavAction?>,
        onCreationFinishedDestination: NavRoute? = null,
        catalogCode: String? = null
    ) {
        log.d("init (entityId = $entityId)")
        _catalogCode.value = catalogCode
        this.navigationState = navigationState

        // If entityId is null -> create new entity
        if (entityId == null) {
            onCreationFinishedDestination?.getNavDestination()?.let { destination ->
                destination.popUpTo(destination, inclusive = true).let {
                    uiStateHandler.specificBackNavDestination = it
                }
            }
            createNewEntity().also {
                setEntity(it)
                uiStateHandler.activateEditModeForNewEntity()
            }
        } else {
            docuDataRepo.getEntityById<T>(entityId)?.let {
                setEntity(it)
                // Remember pre edit mode attributes
                initialAttributeMap = toMap(it as BaseEntity)
                // Set the current documentation object to be this entity
                when (it) {
                    is Investigation -> {
                        when (sessionHandler.docuHandler.docuObject.value) {
                            null -> {
                                sessionHandler.docuHandler.setDocuObject(
                                    docuObject = it,
                                    userId = sessionHandler.userInfo.value?.id
                                )
                            }
                            else -> {}
                        }
                    }
                    !is Annotation -> {
                        sessionHandler.docuHandler.setDocuObject(
                            docuObject = it,
                            userId = sessionHandler.userInfo.value?.id
                        )
                    }
                    else -> {}
                }
            }
        }
    }

    fun discardChangesAndResetEntity() {
        coroutineScope.launch {
            _entity.value?.id?.let { entityId ->
                docuDataRepo.getEntityById<T>(entityId)?.let {
                    setEntity(it)
                    initialAttributeMap = toMap(it as BaseEntity)
                }
            }
        }
    }

    open fun checkForPendingChanges(ignoreAttributes: List<String> = listOf("id")): Boolean {
        var pendingChanges = false
        if (uiStateHandler.editMode.value && !uiStateHandler.newEntity.value) {
            getEditedEntityState().let { currentState ->
                val currentAttributeMap = toMap(currentState as BaseEntity)
                val mapDifference = mapDifference(
                    oldMap = initialAttributeMap,
                    newMap = currentAttributeMap,
                    ignoreKeys = ignoreAttributes
                )
                pendingChanges = !mapDifference.entriesDiffering.isNullOrEmpty() ||
                        !mapDifference.entriesAdded.isNullOrEmpty() ||
                        !mapDifference.entriesRemoved.isNullOrEmpty()
                uiStateHandler.setPendingChanges(pendingChanges)
            }
        }

        return pendingChanges
    }

    protected fun saveEntity(entity: T){
        updateEntityFromUiStates()
        sessionHandler.userInfo.value?.let { userInfo ->
            when (entity) {
                is CrimeScene -> {
                    sessionHandler.docuHandler.investigation.value?.let { investigation ->
                        docuDataRepo.saveCrimeScene(
                            crimeScene = entity,
                            investigation = investigation,
                            userId = userInfo.id
                        )
                    }
                }
                is CriminalOffense -> {
                    sessionHandler.docuHandler.investigation.value?.let { investigation ->
                        docuDataRepo.saveCriminalOffense(
                            criminalOffense = entity,
                            investigation = investigation,
                            userId = userInfo.id
                        )
                    }
                }
                is Investigation -> {
                    docuDataRepo.saveInvestigation(
                        investigation = entity,
                        userId = userInfo.id
                    )
                }
                is Person -> {
                    sessionHandler.docuHandler.investigation.value?.let { investigation ->
                        docuDataRepo.savePerson(
                            person = entity,
                            investigation = investigation,
                            userId = userInfo.id
                        )
                    }
                }
                is Annotation -> {
                    sessionHandler.docuHandler.investigation.value?.let { investigation ->
                        sessionHandler.docuHandler.docuObject.value?.let { docuObject ->
                            docuDataRepo.saveAnnotation(
                                annotation = entity,
                                docuObject = docuObject,
                                investigation = investigation,
                                userId = userInfo.id
                            )
                        }
                    }
                }
                is Evidence -> {
                    sessionHandler.docuHandler.investigation.value?.let { investigation ->
                        (sessionHandler.docuHandler.docuObject.value as? DocNumberObject)?.let { docuObject ->
                            docuDataRepo.saveEvidence(
                                evidence = entity,
                                topologicalParent = docuObject,
                                investigation = investigation,
                                userId = userInfo.id
                            )
                        }
                    }
                }
                // ATTENTION! This has to be last in the when clause!
                is Site -> {
                    sessionHandler.docuHandler.investigation.value?.let { investigation ->
                        sessionHandler.docuHandler.docuObject.value?.let { docuObject ->
                            when (docuObject) {
                                is CrimeScene -> {
                                    docuDataRepo.saveSite(
                                        site = entity,
                                        crimeScene = docuObject,
                                        investigation = investigation,
                                        userId = userInfo.id
                                    )
                                }
                                is Site -> {
                                    docuDataRepo.saveSubSite(
                                        site = entity,
                                        parentSite = docuObject,
                                        investigation = investigation,
                                        userId = userInfo.id
                                    )
                                }
                            }
                        }
                    }
                }
                else -> {
                    log.w("no save method")
                }
            }
        }
    }

    protected fun postSaving(entity: T){
        if (uiStateHandler.newEntity.value) {
            when (entity) {
                is Investigation -> {
                    sessionHandler.docuHandler.setInvestigation(
                        investigation = entity,
                        userId = sessionHandler.userInfo.value?.id
                    )
                    uiStateHandler.activateDocuMode()
                    navigationState.value = NavDestination.DocuMode.Home.navigate()
                }
                else -> {
                    sessionHandler.docuHandler.setDocuObject(
                        docuObject = entity,
                        userId = sessionHandler.userInfo.value?.id
                    )
                    navigationState.value = NavDestination.BACK.navigate()
                }
            }
        }
        uiStateHandler.deactivateEditMode()
    }

    @OptIn(ExperimentalSerializationApi::class)
    open fun save() {
        entity.value?.let {
            saveEntity(it)
            postSaving(it)
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    fun delete() {
        entity.value?.let { baseEntity ->
            sessionHandler.userInfo.value?.let { userInfo ->
                docuDataRepo.deleteBaseEntity(
                    entity = baseEntity,
                    userId = userInfo.id
                )
            }
            if (uiStateHandler.docuMode.value) {
                // If we are in docu mode, we now have to reset the documentation object
                when (baseEntity) {
                    is Investigation -> {
                        sessionHandler.docuHandler.clear()
                        uiStateHandler.deactivateDocuMode()
                        uiStateHandler.deactivateEditMode()
                        navigationState.value = NavDestination.Start.popUpTo(inclusive = false)
                    }
                    is CrimeScene -> {
                        sessionHandler.docuHandler.investigation.value?.let { investigation ->
                            sessionHandler.docuHandler.setDocuHandler(
                                docuObject = investigation,
                                crimeScene = null,
                                investigation = investigation,
                                selectedDetailsObject = null,
                                selectedListObject = null,
                                userId = sessionHandler.userInfo.value?.id
                            )
                            uiStateHandler.deactivateEditMode()
                            navigationState.value =
                                NavDestination.DocuMode.Home.popUpTo(inclusive = false)
                        }
                    }
                    is DocNumberObject -> {
                        sessionHandler.docuHandler.setDocuHandler(
                            docuObject = sessionHandler.docuHandler.docNumberParent.value
                                ?: sessionHandler.docuHandler.investigation.value,
                            crimeScene = sessionHandler.docuHandler.crimeScene.value,
                            investigation = sessionHandler.docuHandler.investigation.value,
                            selectedDetailsObject = sessionHandler.docuHandler.docNumberParent.value,
                            selectedListObject = sessionHandler.docuHandler.docNumberParent.value,
                            userId = sessionHandler.userInfo.value?.id
                        )
                        uiStateHandler.deactivateEditMode()
                        navigationState.value = NavDestination.DocuMode.List.navigate()
                    }
                    else -> {
                        uiStateHandler.deactivateEditMode()
                        navigationState.value = NavDestination.BACK.navigate()
                    }
                }
            } else {
                uiStateHandler.deactivateEditMode()
                navigationState.value = NavDestination.BACK.navigate()
            }
        }
    }
}