@file:Suppress("OPT_IN_USAGE")

package p20.insitu.android.ui.media.recordings

import android.annotation.SuppressLint
import android.graphics.Color.*
import androidx.camera.core.CameraSelector
import androidx.camera.video.*
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import p20.insitu.android.rememberNavigationState
import p20.insitu.model.util.ObjectFactory
import p20.insitu.nav.NavDestination
import p20.insitu.resources.FileHandler
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Video
import p20.insitu.resources.FileType
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import java.util.*

@SuppressLint("MissingPermission")
@Composable
fun VideoRecorder(
    fileHandler: FileHandler = get(),
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    docuDataRepo: DocuDataRepo = get()
) {
    val navigationState = rememberNavigationState()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    var recording: Recording? = remember { null }
    val previewView: PreviewView = remember { PreviewView(context) }
    val videoCapture: MutableState<VideoCapture<Recorder>?> = remember { mutableStateOf(null) }
    val isRecording: MutableState<Boolean> = remember { mutableStateOf(false) }
    val isAudioEnabled: MutableState<Boolean> = remember { mutableStateOf(true) }
    val cameraSelector: MutableState<CameraSelector> = remember {
        mutableStateOf(CameraSelector.DEFAULT_BACK_CAMERA)
    }
    val videoAnnotation = remember { mutableStateOf<Video?>(null) }

    var elapsedTime by remember { mutableStateOf(0L) }

    LaunchedEffect(isRecording.value) {
        if (isRecording.value) {
            val startTime = System.currentTimeMillis()
            while (isRecording.value) {
                elapsedTime = System.currentTimeMillis() - startTime
                delay(1000)
            }
        } else {
            elapsedTime = 0L
        }
    }
    LaunchedEffect(previewView) {
        videoCapture.value = context.createVideoCaptureUseCase(
            lifecycleOwner = lifecycleOwner,
            cameraSelector = cameraSelector.value,
            previewView = previewView
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView({ previewView }, modifier = Modifier.fillMaxSize()) {}
        if (isRecording.value) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .background(Color.Red),

            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = formatElapsedTime(elapsedTime),
                color = Color.White,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.background(Color.Red, RectangleShape).padding(5.dp)
            )
            }
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom
        ) {
            VideoCameraControls(
                uiStateHandler,
                isVideoRecording = isRecording.value,
                isAudioRecording = isAudioEnabled.value
            ) { videoCameraUIAction ->
                when (videoCameraUIAction) {
                    is VideoRecorderUIAction.OnStartRecordVideoClick -> {
                        videoCapture.value?.let { vc ->
                            videoAnnotation.value =
                                ObjectFactory.createVideoAnnotation(FileType.VIDEO.extension)
                            videoAnnotation.value?.let { video ->
                                fileHandler.getVideoFile(video.filename!!)?.let { videoFile ->
                                    val outputOptions =
                                        FileOutputOptions.Builder(videoFile).build()
                                        isRecording.value = true
                                        recording = vc.output
                                            .prepareRecording(context, outputOptions)
                                            .apply { if (isAudioEnabled.value) withAudioEnabled() }
                                            .start(context.mainExecutor) {}
                                }
                            }
                        }
                    }
                    is VideoRecorderUIAction.OnStopRecordVideoClick -> {
                        isRecording.value = false
                        recording?.stop()
                        videoAnnotation.value?.let { video ->
                            sessionHandler.userInfo.value?.let { userInfo ->
                                sessionHandler.docuHandler.investigation.value?.let { investigation ->
                                    sessionHandler.docuHandler.docuObject.value?.let { docuObject ->
                                        docuDataRepo.saveAnnotation(
                                            video,
                                            docuObject,
                                            investigation,
                                            userInfo.id
                                        )
                                        navigationState.value =
                                            NavDestination.getEntityDetailView(video)
                                                .popUpTo(
                                                    NavDestination.VideoRecorder, inclusive = true
                                                )
                                    }
                                }
                            }
                        }
                        // navigationState.value = NavDestination.BACK.navigate()
                    }
                    is VideoRecorderUIAction.OnToogleAudioRecordingClick -> {
                        isAudioEnabled.value = !isAudioEnabled.value
                    }
                    is VideoRecorderUIAction.OnSwitchRecorderClick -> {
                        cameraSelector.value =
                            if (cameraSelector.value == CameraSelector.DEFAULT_BACK_CAMERA) CameraSelector.DEFAULT_FRONT_CAMERA
                            else CameraSelector.DEFAULT_BACK_CAMERA
                        lifecycleOwner.lifecycleScope.launch {
                            videoCapture.value = context.createVideoCaptureUseCase(
                                lifecycleOwner = lifecycleOwner,
                                cameraSelector = cameraSelector.value,
                                previewView = previewView
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun formatElapsedTime(timeMs: Long): String {
    val seconds = (timeMs / 1000) % 60
    val minutes = (timeMs / (1000 * 60)) % 60
    val hours = timeMs / (1000 * 60 * 60)
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}