package p20.insitu.android.ui.documode

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.android.BottomNavigationBar
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.MiscComponents
import p20.insitu.model.entities.*
import p20.insitu.nav.NavDestination
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.*
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.entities.tabs.*
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.util.TabType

@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun DocuModeDetails(
    scaffoldState: ScaffoldState,
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    initialTab: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    // Documentation object
    val docuObject = sessionHandler.docuHandler.docuObject.collectAsState(null)
    val selectedDetailsObject =
        sessionHandler.docuHandler.selectedDetailsObject.collectAsState(null)

    // Get a ViewModel for the documentation object
    val docuObjectViewModel = remember{ mutableStateOf<EntityViewModel<*>?>(null)}
    selectedDetailsObject.value?.let {
        when (it) {
            is Apartment -> {
                val entityViewModel: ApartmentViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is Building -> {
                val entityViewModel: BuildingViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is CrimeScene -> {
                val entityViewModel: CrimeSceneViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is CriminalOffense -> {
                val entityViewModel: CriminalOffenseViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is Door -> {
                val entityViewModel: DoorViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is Floor -> {
                val entityViewModel: FloorViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is Investigation -> {
                val entityViewModel: InvestigationViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is Person -> {
                val entityViewModel: PersonViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is PhysicalTrace -> {
                val entityViewModel: PhysicalTraceViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is Room -> {
                val entityViewModel: RoomViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is SomeObject -> {
                val entityViewModel: SomeObjectViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
            is SomeSite -> {
                val entityViewModel: SomeSiteViewModel = get()
                docuObjectViewModel.value = entityViewModel
            }
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        // In case it is not set yet, activate the documentation mode
        if (!uiStateHandler.docuMode.value) {
            uiStateHandler.activateDocuMode()
        }
        // Reset to the last selected object (if there is one)
        selectedDetailsObject.value?.let { lastSelectedObject ->
            if (lastSelectedObject.id != docuObject.value?.id) {
                sessionHandler.userInfo.value?.id?.let { userId ->
                    sessionHandler.docuHandler.setSelectedDetailsObject(
                        selectedDetailsObject = lastSelectedObject,
                        userId = userId
                    )
                }
            }
        }
    })

    // UI
    val selectedTab = docuObjectViewModel.value?.selectedTab?.collectAsState()
    val showEditButton = selectedDetailsObject.value?.let { selectedObject ->
        when {
            selectedObject is CriminalOffense -> true
            selectedObject is CrimeScene && (selectedTab?.value == TabType.ENTITY_DETAILS
                    || selectedTab?.value == TabType.ADDRESS_DETAILS)-> true
            selectedObject is Evidence && (selectedTab?.value == TabType.ENTITY_DETAILS
                    || selectedTab?.value == TabType.EVIDENCE_DATA) -> true
            else -> selectedTab?.value == TabType.ENTITY_DETAILS
        }
    } ?: false
    val showFilterButton = selectedTab?.value?.isMediaTab() ?: false

    val initialTabSet = remember{ mutableStateOf(false)}
    docuObjectViewModel.value?.let { viewModel ->
        if(initialTab != null && !initialTabSet.value){
            viewModel.setSelectedTab(TabType.valueOf(initialTab))
            initialTabSet.value = true
        }
    }

    // Content
    Scaffold(
        topBar = {
            TopAppBars.DocuMode(
                navigationState = navigationState,
                sessionHandler = get(),
                uiStateHandler = get(),
                showEditButton = showEditButton,
                showFilterButton = showFilterButton,
                filterOn = selectedTab?.value?.let { tabType ->
                    uiStateHandler.annotationFiltersSet(tabType)
                } ?: false,
                onFilterBtnClick = {
                    when (selectedTab?.value) {
                        TabType.NOTE_ANNOTATIONS -> {
                            navigationState.value = NavDestination.NoteFilterSettings.navigate()
                        }
                        TabType.IMAGE_ANNOTATIONS -> {
                            navigationState.value = NavDestination.ImageFilterSettings.navigate()
                        }
                        TabType.AUDIO_ANNOTATIONS -> {
                            navigationState.value = NavDestination.AudioFilterSettings.navigate()
                        }
                        TabType.VIDEO_ANNOTATIONS -> {
                            navigationState.value = NavDestination.VideoFilterSettings.navigate()
                        }
                        else -> {}
                    }
                },
                docuObjectViewModel = docuObjectViewModel.value
            )
        },
        floatingActionButton = {
            when (selectedTab?.value) {
                TabType.NOTE_ANNOTATIONS,
                TabType.IMAGE_ANNOTATIONS,
                TabType.AUDIO_ANNOTATIONS,
                TabType.VIDEO_ANNOTATIONS -> {
                    Buttons.AddAnnotation(selectedTab.value, language.value)
                }
                else -> {}
            }
        },
        snackbarHost = { SnackbarHost(hostState = scaffoldState.snackbarHostState) },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                selectedDetailsObject.value?.let {
                    MiscComponents.DocuObjectBar(
                        docuObject = it,
                        language = language.value
                    )
                    when (it) {
                        is Apartment -> {
                            ApartmentTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                viewModel = docuObjectViewModel.value as ApartmentViewModel,
                                entityCreation = false
                            )
                        }
                        is Building -> {
                            BuildingTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                viewModel = docuObjectViewModel.value as BuildingViewModel,
                                entityCreation = false
                            )
                        }
                        is CrimeScene -> {
                            CrimeSceneTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as CrimeSceneViewModel,
                                entityCreation = false
                            )
                        }
                        is CriminalOffense -> {
                            CriminalOffenseTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as CriminalOffenseViewModel,
                                entityCreation = false
                            )
                        }
                        is DNATrace -> {
                            DNATraceTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as DNATraceViewModel,
                                entityCreation = false
                            )
                        }
                        is Door -> {
                            DoorTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as DoorViewModel,
                                entityCreation = false
                            )
                        }
                        is Floor -> {
                            FloorTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                viewModel = docuObjectViewModel.value as FloorViewModel,
                                entityCreation = false
                            )
                        }
                        is Investigation -> {
                            InvestigationTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as InvestigationViewModel,
                                entityCreation = false
                            )
                        }
                        is Person -> {
                            PersonTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as PersonViewModel,
                                entityCreation = false
                            )
                        }
                        is PhysicalTrace -> {
                            PhysicalTraceTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as PhysicalTraceViewModel,
                                entityCreation = false
                            )
                        }
                        is Room -> {
                            RoomTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                viewModel = docuObjectViewModel.value as RoomViewModel,
                                entityCreation = false
                            )
                        }
                        is SomeObject -> {
                            SomeObjectTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as SomeObjectViewModel,
                                entityCreation = false
                            )
                        }
                        is SomeSite -> {
                            SomeSiteTabs(
                                navigationState = navigationState,
                                sessionHandler = get(),
                                uiStateHandler = get(),
                                catalogRepo = get(),
                                viewModel = docuObjectViewModel.value as SomeSiteViewModel,
                                entityCreation = false
                            )
                        }
                    }
                } ?: run {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(Padding.screen),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = MessageStrings.selectDetailsObject(language.value),
                            style = MaterialTheme.typography.h5
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navigationState = navigationState,
                hostScreen = NavDestination.DocuMode.Details,
                uiStateHandler = uiStateHandler
            )
        }
    )
}
