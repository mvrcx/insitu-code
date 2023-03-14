@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.media.*
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.entities.DNATrace
import p20.insitu.nav.NavAction
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.DNATraceViewModel

@Composable
fun DNATraceTabs(
    navigationState: MutableState<NavAction?>,
    uiStateHandler: UiStateHandler,
    sessionHandler: SessionHandler,
    catalogRepo: CatalogRepo,
    viewModel: DNATraceViewModel,
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
        (docuObject.value as? DNATrace)?.let {
            // Init view model
            LaunchedEffect(key1 = Unit, block = {
                viewModel.init(
                    it.id,
                    navigationState,
                    null
                )
            })
        }
    }

    // Entity
    val dnaTrace = viewModel.entity.collectAsState()

    // UI
    val tabTitles = if (editMode.value) {
        TabTitles.getEditEvidenceTabTitles(language.value)
    } else {
        TabTitles.getViewEvidenceTabTitles(language.value)
    }
    val selectedTab = viewModel.selectedTab.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        if (entityCreation) {
            // Always start with the first tab
            viewModel.setSelectedTab(tabTitles[0].first)
        }
    })

    if (dnaTrace.value == null) {
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
                    DNATraceDetails(
                        uiStateHandler = uiStateHandler,
                        catalogRepo = catalogRepo,
                        viewModel = viewModel
                    )
                }
                TabType.EVIDENCE_DATA -> {
                    EvidenceData(
                        sessionHandler = sessionHandler,
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