package p20.insitu.android.ui.media.recordings

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.media.MediaRecorder
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Audio
import p20.insitu.model.util.ObjectFactory
import p20.insitu.nav.NavDestination
import p20.insitu.resources.FileHandler
import p20.insitu.resources.FileType
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

@RequiresApi(Build.VERSION_CODES.S)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalSerializationApi::class)
@Composable
fun AudioRecorder(
    fileHandler: FileHandler = get(),
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    docuDataRepo: DocuDataRepo = get(),
    clock: Clock = get(),
    coroutineScope: CoroutineScope = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    val context = LocalContext.current

    val language = uiStateHandler.language.collectAsState()

    val circleColor = MaterialTheme.colors.primary
    val iconColorDefault = MaterialTheme.colors.onPrimary
    val iconColorIsRecording = MaterialTheme.colors.secondary


    val audioAnnotation: MutableState<Audio?> = remember { mutableStateOf(null) }
    val mediaRecorder: MutableState<MediaRecorder?> = remember { mutableStateOf(null) }
    val isRecording = remember { mutableStateOf(false) }
    val timer = remember { mutableStateOf<TimestampMillisecondsFormatter?>(null) }
    val timestamp = remember { mutableStateOf(TimestampMillisecondsFormatter.DEFAULT_TIME) }

    Scaffold(
        topBar = {
            TopAppBars.Main(
                title = TitleStrings.audioRecorder(language.value),
                navigationState = navigationState,
                sessionHandler = get(),
                uiStateHandler = get(),
                showBackNavigation = true
            )
        },
        content = {
            // Audio recording on / off
            DisposableEffect(
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = timestamp.value,
                        maxLines = 1,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(horizontal = Padding.screen)
                    )
                    if (!isRecording.value) {
                        IconButton(
                            onClick = {
                                mediaRecorder.value = MediaRecorder(context)
                                audioAnnotation.value =
                                    ObjectFactory.createAudioAnnotation(FileType.AUDIO.extension)
                                mediaRecorder.value?.let { recorder ->
                                    audioAnnotation.value?.filename?.let { filename ->
                                        fileHandler.getAudioFile(filename)?.let { audioFile ->
                                            recorder.setAudioSource(MediaRecorder.AudioSource.MIC)
                                            recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                                            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT)
                                            recorder.setOutputFile(audioFile)
                                            recorder.prepare()
                                            recorder.start()
                                            isRecording.value = true
                                            timer.value = TimestampMillisecondsFormatter(
                                                clock.now().toEpochMilliseconds()
                                            )
                                            coroutineScope.launch {
                                                while (isRecording.value) {
                                                    timestamp.value =
                                                        timer.value?.getStringTimeRepresentation(
                                                            clock.now().toEpochMilliseconds()
                                                        )
                                                            ?: TimestampMillisecondsFormatter.DEFAULT_TIME
                                                    delay(20)
                                                }
                                            }
                                        }
                                    }
                                }
                            },
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 32.dp)
                                .drawBehind {
                                    drawCircle(
                                        color = circleColor,
                                        radius = 96f
                                    )
                                },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Mic,
                                contentDescription = IconContentDescriptions.audioRecordingStart(
                                    language.value
                                ),
                                tint = if(isRecording.value) iconColorIsRecording else iconColorDefault,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    } else {
                        IconButton(
                            onClick = {
                                mediaRecorder.value?.let { recorder ->
                                    recorder.stop()
                                    audioAnnotation.value?.let { audio ->
                                        sessionHandler.userInfo.value?.let { userInfo ->
                                            sessionHandler.docuHandler.investigation.value?.let { investigation ->
                                                sessionHandler.docuHandler.docuObject.value?.let { docuObject ->
                                                    docuDataRepo.saveAnnotation(
                                                        audio,
                                                        docuObject,
                                                        investigation,
                                                        userInfo.id
                                                    )
                                                }
                                            }
                                        }
                                        recorder.release()
                                        isRecording.value = false
                                        navigationState.value =
                                            NavDestination.getEntityDetailView(audio)
                                                .popUpTo(
                                                    NavDestination.AudioRecorder,
                                                    inclusive = true
                                                )
                                    }
                                }
                            },
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 32.dp)
                                .drawBehind {
                                    drawCircle(
                                        color = circleColor,
                                        radius = 96f
                                    )
                                },
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Stop,
                                contentDescription = IconContentDescriptions.audioRecordingStop(
                                    language.value
                                ),
                                tint = if(isRecording.value) iconColorIsRecording else iconColorDefault,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }
                }
            ) {
                onDispose {
                    mediaRecorder.value?.release()
                }
            }
        }
    )
}

internal class TimestampMillisecondsFormatter(private val startTime: Long) {

    companion object {
        const val DEFAULT_TIME = "00:00:000"
    }

    private fun format(timestamp: Long): String {
        val millisecondsFormatted = (timestamp % 1000).pad(3)
        val seconds = timestamp / 1000
        val secondsFormatted = (seconds % 60).pad(2)
        val minutes = seconds / 60
        val minutesFormatted = (minutes % 60).pad(2)
        val hours = minutes / 60
        return if (hours > 0) {
            val hoursFormatted = (minutes / 60).pad(2)
            "$hoursFormatted:$minutesFormatted:$secondsFormatted"
        } else {
            "$minutesFormatted:$secondsFormatted:$millisecondsFormatted"
        }
    }

    private fun Long.pad(desiredLength: Int) = this.toString().padStart(desiredLength, '0')

    fun getStringTimeRepresentation(currentTime: Long): String {
        val timePassedSinceStart = if (currentTime > startTime) {
            currentTime - startTime
        } else {
            0
        }
        return format(timePassedSinceStart)
    }
}
