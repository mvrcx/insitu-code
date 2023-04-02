package p20.insitu.android.ui.components.buttons

import android.widget.Toast
import androidx.camera.core.impl.utils.ContextUtil.getApplicationContext
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

import p20.insitu.android.ui.components.dialogs.AlertDialogs
import p20.insitu.com.authApi.AuthService
import p20.insitu.resources.Language
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.android.ui.components.dimen.IconSize

object IconButtons {

    @Composable
    fun Logout(
        language: Language,
        modifier: Modifier = Modifier,
        authService: AuthService
    ) {
        val coroutineScope = rememberCoroutineScope()
        IconButton(
            onClick = {
                coroutineScope.launch {
                    authService.logout()
                }
            },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = IconContentDescriptions.logout(language)
            )
        }
    }

    @Composable
    fun Settings(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = IconContentDescriptions.settings(language)
            )
        }
    }

    @Composable
    fun MoveUp(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowCircleUp,
                modifier = Modifier.size(IconSize.medium),
                contentDescription = IconContentDescriptions.moveUpInList(language)
            )
        }
    }

    @Composable
    fun MoveDown(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowCircleDown,
                modifier = Modifier.size(IconSize.medium),
                contentDescription = IconContentDescriptions.moveDownInList(language)
            )
        }
    }

    @Composable
    fun ExpandMore(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.ExpandMore,
                contentDescription = IconContentDescriptions.expandMore(language)
            )
        }
    }

    @Composable
    fun ExpandLess(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.ExpandLess,
                contentDescription = IconContentDescriptions.expandLess(language)
            )
        }
    }

    @Composable
    fun Menu(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = IconContentDescriptions.menu(language)
            )
        }
    }

    @Composable
    fun Back(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = IconContentDescriptions.back(language)
            )
        }
    }

    @Composable
    fun Close(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = IconContentDescriptions.close(language)
            )
        }
    }

    @Composable
    fun Done(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = IconContentDescriptions.done(language)
            )
        }
    }

    @Composable
    fun Clear(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Clear,
                contentDescription = IconContentDescriptions.clear(language)
            )
        }
    }

    @Composable
    fun Edit(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = IconContentDescriptions.edit(language)
            )
        }
    }

    @Composable
    fun Filter(
        modifier: Modifier = Modifier,
        language: Language,
        filterOn: Boolean,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = if (filterOn) Icons.Filled.FilterAlt else Icons.Filled.FilterAltOff,
                tint = if (filterOn) MaterialTheme.colors.secondary else MaterialTheme.colors.onPrimary,
                contentDescription = IconContentDescriptions.mediaFilter(language)
            )
        }
    }

    @Composable
    fun Save(
        language: Language,
        modifier: Modifier = Modifier,
        enabled: Boolean,
        onClickAction: () -> Unit
    ) {
        IconButton(
            enabled = enabled,
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = IconContentDescriptions.save(language)
            )
        }
    }


    @Composable
    fun Delete(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = IconContentDescriptions.delete(language)
            )
        }
    }



    @Composable
    fun QrCodeScanner(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                modifier = Modifier.size(IconSize.medium),
                imageVector = Icons.Filled.QrCodeScanner,
                contentDescription = IconContentDescriptions.qrCodeScanner(language),
                tint = MaterialTheme.colors.secondary
            )
        }
    }

    @Composable
    fun DatePicker(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = IconContentDescriptions.pickDate(language)
            )
        }
    }

    @Composable
    fun TimePicker(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.Schedule,
                contentDescription = IconContentDescriptions.pickTime(language)
            )
        }
    }

    @Composable
    fun Location(
        language: Language,
        modifier: Modifier = Modifier,
        onClickAction: () -> Unit
    ) {
        IconButton(
            onClick = { onClickAction() },
            modifier = modifier
        ) {
            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = IconContentDescriptions.geolocation(language)
            )
        }
    }

    object CameraControls {
        @Composable
        fun FlipCameraAndroid(
            language: Language,
            modifier: Modifier = Modifier,
            onClickAction: () -> Unit
        ) {
            IconButton(
                onClick = { onClickAction() },
                modifier = modifier
            ) {
                Icon(
                    imageVector = Icons.Filled.FlipCameraAndroid,
                    contentDescription = IconContentDescriptions.flipCamera(language),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }

        @Composable
        fun TakePhoto(
            language: Language,
            modifier: Modifier = Modifier,
            onClickAction: () -> Unit
        ) {
            IconButton(
                onClick = { onClickAction() },
                modifier = modifier
            ) {
                Icon(
                    imageVector = Icons.Filled.Lens,
                    contentDescription = IconContentDescriptions.takePhoto(language),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }

        @Composable
        fun PhotoLibrary(
            language: Language,
            modifier: Modifier = Modifier,
            onClickAction: () -> Unit
        ) {
            IconButton(
                onClick = { onClickAction() },
                modifier = modifier
            ) {
                Icon(
                    imageVector = Icons.Filled.PhotoLibrary,
                    contentDescription = IconContentDescriptions.photoLibrary(language),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    }

    object VideoCameraControls {
        @Composable
        fun FlipCameraAndroid(
            language: Language,
            modifier: Modifier = Modifier,
            onClickAction: () -> Unit
        ) {
            IconButton(
                onClick = { onClickAction() },
                modifier = modifier
            ) {
                Icon(
                    imageVector = Icons.Filled.FlipCameraAndroid,
                    contentDescription = IconContentDescriptions.flipCamera(language),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }

        @Composable
        fun RecordVideo(
            isRecording: Boolean,
            language: Language,
            modifier: Modifier = Modifier,
            onClickAction: () -> Unit
        ) {
            IconButton(
                onClick = { onClickAction() },
                modifier = modifier
            ) {
                Icon(
                    imageVector = if (isRecording) Icons.Filled.Stop else Icons.Filled.Lens,
                    contentDescription = if (isRecording) IconContentDescriptions.videoRecordingStop(
                        language
                    ) else IconContentDescriptions.videoRecordingStart(language),
                    tint = if (isRecording) MaterialTheme.colors.secondary else MaterialTheme.colors.onPrimary
                )
            }
        }

        @Composable
        fun RecordAudio(
            isRecording: Boolean,
            language: Language,
            modifier: Modifier = Modifier,
            onClickAction: () -> Unit
        ) {
            IconButton(
                onClick = { onClickAction() },
                modifier = modifier
            ) {
                Icon(
                    imageVector = if (isRecording) Icons.Filled.Mic else Icons.Filled.MicOff,
                    contentDescription = if (isRecording) IconContentDescriptions.audioRecordingStop(
                        language
                    ) else IconContentDescriptions.audioRecordingStart(language),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    }

}