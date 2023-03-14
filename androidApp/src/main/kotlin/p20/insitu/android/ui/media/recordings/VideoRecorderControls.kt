package p20.insitu.android.ui.media.recordings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.get
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.ui.components.buttons.IconButtons

@Composable
fun VideoCameraControls(
    uiStateHandler: UiStateHandler = get(),
    isVideoRecording: Boolean,
    isAudioRecording: Boolean,
    cameraUIAction: (VideoRecorderUIAction) -> Unit
) {
    val language = uiStateHandler.language.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButtons.VideoCameraControls.FlipCameraAndroid(
            language = language.value,
            modifier = Modifier.size(64.dp)
        ) {
            cameraUIAction(VideoRecorderUIAction.OnSwitchRecorderClick)
        }

        IconButtons.VideoCameraControls.RecordVideo(
            isRecording = isVideoRecording,
            language = language.value,
            modifier = Modifier
                .size(64.dp)
                .padding(1.dp)
                .border(1.dp, Color.White, CircleShape)
        ) {
            cameraUIAction(
                if (isVideoRecording) VideoRecorderUIAction.OnStopRecordVideoClick
                else VideoRecorderUIAction.OnStartRecordVideoClick
            )
        }

        IconButtons.VideoCameraControls.RecordAudio(
            isRecording = isAudioRecording,
            language = language.value,
            modifier = Modifier.size(64.dp)
        ) {
            cameraUIAction(VideoRecorderUIAction.OnToogleAudioRecordingClick)
        }

    }
}