@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.entities.CrimeScene
import p20.insitu.nav.NavAction
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.CrimeSceneViewModel
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.media.*

@Composable
fun CrimeSceneTabs(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: CrimeSceneViewModel,
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
        (docuObject.value as? CrimeScene)?.let { docuObject ->
            // Init view model
            LaunchedEffect(key1 = Unit, block = {
                viewModel.init(
                    docuObject.id,
                    navigationState,
                    null
                )
            })
        }
    }

    // View model states
    val crimeScene = viewModel.entity.collectAsState()

    // UI
    val tabTitles = if (editMode.value) {
        TabTitles.getTabTitles(
            setOf(
                TabType.ENTITY_DETAILS,
                TabType.ADDRESS_DETAILS
            ), language.value
        )
    } else {
        TabTitles.getTabTitles(
            setOf(
                TabType.ENTITY_DETAILS,
                TabType.ADDRESS_DETAILS,
                TabType.NOTE_ANNOTATIONS,
                TabType.AUDIO_ANNOTATIONS,
                TabType.IMAGE_ANNOTATIONS,
                TabType.VIDEO_ANNOTATIONS
            ), language.value
        )
    }
    val selectedTab = viewModel.selectedTab.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        if (entityCreation) {
            // Always start with the first tab
            viewModel.setSelectedTab(tabTitles[0].first)
        }
    })

    // Content
    if (crimeScene.value == null) {
        LoadingAnimations.StandardLoadingAnimation()
    } else {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Tabs(
                selectedTab = selectedTab.value,
                titles = tabTitles
            ) {
                viewModel.setSelectedTab(it)
            }
            when (selectedTab.value) {
                TabType.ENTITY_DETAILS -> {
                    CrimeSceneDetails(
                        uiStateHandler = uiStateHandler,
                        catalogRepo = catalogRepo,
                        viewModel = viewModel
                    )
                }
                TabType.ADDRESS_DETAILS -> {
                    CrimeSceneAddressDetails(
                        uiStateHandler = uiStateHandler,
                        catalogRepo = catalogRepo,
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
