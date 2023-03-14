package p20.insitu.android.ui.media

import androidx.compose.runtime.*
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.ui.components.Galleries
import p20.insitu.viewmodels.MediaViewModel

@Composable
fun ImageGallery(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    viewModel: MediaViewModel
) {
    val language = uiStateHandler.language.collectAsState()
    val showNestedAnnotations = uiStateHandler.showNestedAnnotations.collectAsState()
    val showUserAnnotationsOnly = uiStateHandler.showUserAnnotationsOnly.collectAsState()

    val images = viewModel.images.collectAsState(listOf())
    val imageBitmaps = viewModel.imageBitmaps.collectAsState(mapOf())
    val imagesNested = viewModel.imagesNested.collectAsState(listOf())
    val imageBitmapsNested = viewModel.imageBitmapsNested.collectAsState(mapOf())

    Galleries.ImageGallery(
        items = if(showNestedAnnotations.value) images.value + imagesNested.value else images.value,
        imageBitmaps = if(showNestedAnnotations.value) imageBitmaps.value + imageBitmapsNested.value else imageBitmaps.value,
        language = language.value,
        onClickAction = { selectedIndex ->
            sessionHandler.docuHandler.docuObject.value?.id?.let { entityId ->
                navigationState.value =
                    NavDestination.ImagePager.withImagePagerArgs(
                        entityId,
                        selectedIndex,
                        showNestedAnnotations.value
                    ).navigate()
            }
        }
    )
}