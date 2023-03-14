package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import p20.insitu.android.ui.components.*
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.AudioViewModel

@Composable
fun AudioTabs(
    uiStateHandler: UiStateHandler,
    viewModel: AudioViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Entity
    val audio = viewModel.entity.collectAsState()

    // UI
    val tabTitles = TabTitles.getTabTitles(
            setOf(
                TabType.ENTITY_DETAILS,
                TabType.AUDIO_PLAYER
            ), language.value
        )
    val selectedTab = viewModel.selectedTab.collectAsState()

    // Content
    if (audio.value == null) {
        LoadingAnimations.StandardLoadingAnimation()
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            if (editMode.value) {
                AudioDetails(
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
                        AudioDetails(
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    TabType.AUDIO_PLAYER -> {
                        AudioPlayer(
                            viewModel = viewModel
                        )
                    }
                    else -> {
                        // Set the start tab for this screen
                        viewModel.setSelectedTab(tabTitles[1].first)
                    }
                }
            }
        }
    }
}