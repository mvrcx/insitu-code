package p20.insitu.android.ui.entities.screens

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.rememberNavController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.LoadingAnimations
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.viewmodels.entities.VideoViewModel
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.android.ui.components.TopAppBars

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Video(
    uiStateHandler: UiStateHandler = get(),
    viewModel: VideoViewModel = get(),
    entityId: String? = null,
    creationFinishedDestination: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    val context = LocalContext.current

    val language = uiStateHandler.language.collectAsState()
    val uri = viewModel.uri.collectAsState(null)
    val exoPlayer = remember(context) { ExoPlayer.Builder(context).build() }

    // Init view model
    LaunchedEffect(key1 = Unit, block = {
        viewModel.init(
            entityId,
            navigationState
        )
    })

    Scaffold(
        topBar = {
            TopAppBars.BaseEntityDetails(
                navigationState = navigationState,
                title = EntityTypeStrings.video(language.value),
                sessionHandler = get(),
                uiStateHandler = get(),
                showEditButton = true,
                viewModel = viewModel
            )
        },
        content = {
            uri.value?.let {
                exoPlayer.setMediaItem(MediaItem.fromUri(it))
                exoPlayer.prepare()
                DisposableEffect(
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AndroidView(
                            factory = { context ->
                                StyledPlayerView(context).apply {
                                    player = exoPlayer
                                }
                            },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                ) {
                    onDispose {
                        exoPlayer.release()
                    }
                }
            } ?: LoadingAnimations.StandardLoadingAnimation()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun VideoPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Video()
        }
    }
}