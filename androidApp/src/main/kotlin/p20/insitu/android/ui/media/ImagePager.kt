package p20.insitu.android.ui.media

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import org.koin.androidx.compose.get
import p20.insitu.android.rememberNavigationState
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.ImagePagerViewModel
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.nav.NavDestination
import p20.insitu.resources.strings.EntityTypeStrings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagePager(
    uiStateHandler: UiStateHandler = get(),
    viewModel: ImagePagerViewModel = get(),
    entityId: String? = null,
    imageIndex: Int = 0,
    showNested: Boolean = false
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // Init view model
    LaunchedEffect(key1 = Unit, block = {
        viewModel.init(entityId)
    })

    val language = uiStateHandler.language.collectAsState()
    val pagerState = rememberPagerState(imageIndex)

    val images = viewModel.images.collectAsState(listOf())
    val imageBitmaps = viewModel.imageBitmaps.collectAsState(mapOf())
    val imagesNested = viewModel.imagesNested.collectAsState(listOf())
    val imageBitmapsNested = viewModel.imageBitmapsNested.collectAsState(mapOf())

    val showImages = if (showNested) {
        images.value + imagesNested.value
    } else {
        images.value
    }

    val showImagesBitmaps = if (showNested) {
        imageBitmaps.value + imageBitmapsNested.value
    } else {
        imageBitmaps.value
    }

    Scaffold(
        topBar = {
            TopAppBars.ImagePager(
                navigationState = navigationState,
                sessionHandler = get(),
                uiStateHandler = get()
            ) {
                if (showImages.isNotEmpty()) {
                    uiStateHandler.activateEditMode()
                    navigationState.value =
                        NavDestination.getEntityDetailView(showImages[pagerState.currentPage]).navigate()
                }
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                val imageCount = showImages.size
                HorizontalPager(
                    count = imageCount,
                    state = pagerState,
                    modifier = Modifier.align(Alignment.Center)
                ) { page ->
                    showImagesBitmaps[showImages[page].id]?.let {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            bitmap = it,
                            contentDescription = EntityTypeStrings.image(language.value)
                        )
                    }
                }
            }
        }
    )


}