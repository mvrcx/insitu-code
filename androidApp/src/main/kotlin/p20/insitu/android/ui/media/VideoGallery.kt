package p20.insitu.android.ui.media

import androidx.compose.runtime.*
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.ui.components.Galleries
import p20.insitu.viewmodels.MediaViewModel

@Composable
fun VideoGallery(
    navigationState: MutableState<NavAction?>,
    uiStateHandler: UiStateHandler,
    viewModel: MediaViewModel
) {
    val language = uiStateHandler.language.collectAsState()
    val showNestedAnnotations = uiStateHandler.showNestedAnnotations.collectAsState()
    val showUserAnnotationsOnly = uiStateHandler.showUserAnnotationsOnly.collectAsState()

    val videos = viewModel.videos.collectAsState(listOf())
    val videosNested = viewModel.videosNested.collectAsState(listOf())

    Galleries.VideoGallery(
        items = if (showNestedAnnotations.value) videos.value + videosNested.value else videos.value,
        language = language.value,
        onClickAction = { item ->
            navigationState.value =
                NavDestination.getEntityDetailView(item).navigate()
        }
    )
}