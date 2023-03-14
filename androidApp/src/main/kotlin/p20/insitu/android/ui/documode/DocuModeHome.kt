package p20.insitu.android.ui.documode

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.android.BottomNavigationBar
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.components.dialogs.AlertDialogs
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.entities.tabs.InvestigationTabs
import p20.insitu.nav.NavDestination
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.nav.NavRoute
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.util.TabType
import p20.insitu.util.userMessages.PredefinedErrorMessages
import p20.insitu.viewmodels.entities.InvestigationViewModel

@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DocuModeHome(
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    viewModel: InvestigationViewModel = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    // Entity
    val investigation = viewModel.entity.collectAsState()

    // UI
    val selectedTab = viewModel.selectedTab.collectAsState()
    val showEditButton = selectedTab.value == TabType.ENTITY_DETAILS
    val showFilterButton = selectedTab.value?.isMediaTab() ?: false

    // Init
    LaunchedEffect(key1 = Unit, block = {
        // In case it is not set yet, activate the documentation mode
        if (!uiStateHandler.docuMode.value) {
            uiStateHandler.activateDocuMode()
        }
        // Init view model
        sessionHandler.docuHandler.investigation.value?.let {
            viewModel.init(
                it.id,
                navigationState
            )
        }
        // Set the docu object to the investigation
        sessionHandler.userInfo.value?.id?.let { userId ->
            sessionHandler.docuHandler.investigation.value?.let { investigation ->
                sessionHandler.docuHandler.setDocuObject(
                    docuObject = investigation,
                    userId = userId
                )
            }
        }
    })

    Scaffold(
        topBar = {
            TopAppBars.DocuMode(
                navigationState = navigationState,
                sessionHandler = get(),
                uiStateHandler = get(),
                showEditButton = showEditButton,
                showFilterButton = showFilterButton,
                docuObjectViewModel = viewModel,
                onFilterBtnClick = {
                    when (selectedTab.value) {
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
                }
            )
        },
        floatingActionButton = {
            when (selectedTab.value) {
                TabType.CRIMINAL_OFFENSES -> {
                    Buttons.AddBaseEntity(
                        title = EntityTypeStrings.typeString(
                            EntityType.CRIMINAL_OFFENSE,
                            language.value
                        )
                    ) {
                        navigationState.value =
                            NavDestination.getEntityCreationView(EntityType.CRIMINAL_OFFENSE)
                                .navigate()
                    }
                }
                TabType.CRIME_SCENES -> {
                    Buttons.AddBaseEntity(
                        title = EntityTypeStrings.typeString(
                            EntityType.CRIME_SCENE,
                            language.value
                        )
                    ) {
                        navigationState.value =
                            NavDestination.getEntityCreationView(EntityType.CRIME_SCENE)
                                .navigate()
                    }
                }
                TabType.PERSONS -> {
                    Buttons.AddBaseEntity(
                        title = EntityTypeStrings.typeString(
                            EntityType.PERSON,
                            language.value
                        )
                    ) {
                        navigationState.value =
                            NavDestination.getEntityCreationView(EntityType.PERSON).navigate()
                    }
                }
                TabType.NOTE_ANNOTATIONS,
                TabType.IMAGE_ANNOTATIONS,
                TabType.AUDIO_ANNOTATIONS,
                TabType.VIDEO_ANNOTATIONS -> {
                    Buttons.AddAnnotation(
                        selectedTab = selectedTab.value,
                        language = language.value
                    )
                }
                else -> {}
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                investigation.value?.let {
                    MiscComponents.DocuObjectBar(
                        docuObject = it,
                        language = language.value
                    )
                }
                InvestigationTabs(
                    navigationState = navigationState,
                    sessionHandler = get(),
                    uiStateHandler = get(),
                    catalogRepo = get(),
                    viewModel = viewModel,
                    entityCreation = false
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navigationState = navigationState,
                hostScreen = NavDestination.DocuMode.Home,
                uiStateHandler = uiStateHandler
            )
        }
    )
}