package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import p20.insitu.android.ui.components.LoadingAnimations
import p20.insitu.viewmodels.entities.AudioViewModel

@Composable
fun AudioPlayer(viewModel: AudioViewModel) {
    val context = LocalContext.current
    val uri = viewModel.uri.collectAsState()
    val exoPlayer = remember(context) { ExoPlayer.Builder(context).build() }

    // Content
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