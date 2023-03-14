package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.media.*
import p20.insitu.model.entities.Building
import p20.insitu.nav.NavAction
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.BuildingViewModel

@Composable
fun BuildingTabs(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    viewModel: BuildingViewModel,
    entityCreation: Boolean
) {
    // UiStateHandler states
    val docuMode = uiStateHandler.docuMode.collectAsState()
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // DocuHandler states
    val docuObject = sessionHandler.docuHandler.docuObject.collectAsState()

    // Init view model when in docu mode
    if (docuMode.value && !entityCreation) {
        (docuObject.value as? Building)?.let { docuObject ->
            LaunchedEffect(key1 = Unit, block = {
                viewModel.init(
                    docuObject.id,
                    navigationState,
                    null
                )
            })
        }
    }

    // Entity
    val building = viewModel.entity.collectAsState()

    // UI
    val tabTitles = TabTitles.getDefaultDocuObjectTabTitles(language.value)
    val selectedTab = viewModel.selectedTab.collectAsState()

    // Content
    if (building.value == null) {
        LoadingAnimations.StandardLoadingAnimation()
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            if (editMode.value) {
                BuildingDetails(
                    uiStateHandler = uiStateHandler,
                    viewModel = viewModel
                )
            } else {
                Tabs(
                    selectedTab = selectedTab.value,
                    titles = tabTitles
                ) {
                    viewModel.setSelectedTab(it)
                }
                when (selectedTab.value) {
                    TabType.ENTITY_DETAILS -> {
                        BuildingDetails(
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    TabType.NOTE_ANNOTATIONS -> {
                        NoteGallery(
                            navigationState = navigationState,
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    TabType.IMAGE_ANNOTATIONS -> {
                        ImageGallery(
                            navigationState = navigationState,
                            sessionHandler = sessionHandler,
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    TabType.AUDIO_ANNOTATIONS -> {
                        AudioGallery(
                            navigationState = navigationState,
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    TabType.VIDEO_ANNOTATIONS -> {
                        VideoGallery(
                            navigationState = navigationState,
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    else -> {
                        // Set the start tab for this screen
                        viewModel.setSelectedTab(tabTitles[0].first)
                    }
                }
            }
        }
    }
}