package p20.insitu.android.ui.media

import androidx.compose.runtime.*
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.ui.components.Lists
import p20.insitu.viewmodels.MediaViewModel

@Composable
fun AudioGallery(
    navigationState: MutableState<NavAction?>,
    uiStateHandler: UiStateHandler,
    viewModel: MediaViewModel
) {
    val language = uiStateHandler.language.collectAsState()
    val showNestedAnnotations = uiStateHandler.showNestedAnnotations.collectAsState()
    val showUserAnnotationsOnly = uiStateHandler.showUserAnnotationsOnly.collectAsState()

    val audioRecordings = viewModel.audioRecordings.collectAsState(listOf())
    val audioRecordingsNested = viewModel.audioRecordingsNested.collectAsState(listOf())

    Lists.Audio(
        items = if (showNestedAnnotations.value) audioRecordingsNested.value + audioRecordings.value else audioRecordings.value,
        language = language.value,
        onClickAction = { item ->
            navigationState.value =
                NavDestination.getEntityDetailView(item).navigate()
        }
    )
}