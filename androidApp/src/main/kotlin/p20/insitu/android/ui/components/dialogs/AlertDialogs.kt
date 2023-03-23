package p20.insitu.android.ui.components.dialogs

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.launch
import p20.insitu.android.BuildConfig
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dialogs.AlertDialogs.InsituInfo
import p20.insitu.db.settings.SettingValueState
import p20.insitu.resources.Language
import p20.insitu.resources.strings.ButtonStrings
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.resources.strings.de.Strings
import p20.insitu.theme.InsituTheme
import p20.insitu.android.util.drawableResource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.PreviewParameter


object AlertDialogs {

    @Composable
    fun DeleteDialog(
        onDismiss: () -> Unit,
        onConfirm: () -> Unit,
        language: Language,
    ) {
        AlertDialog(

            properties = DialogProperties(
                dismissOnClickOutside = true,
                dismissOnBackPress = true,
            ),
            onDismissRequest = { onDismiss() },
            title = {
                Text(
                    text = TitleStrings.delete(language),
                    style = MaterialTheme.typography.h5
                )
            },
            text = {
                Text(
                    text = MessageStrings.delete(language),
                    style = MaterialTheme.typography.body1
                )
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        //modifier = Modifier.fillMaxWidth(),
                        onClick = {

                            onConfirm()
                            //uiStateHandler.showSnackbar(true)
                        }
                    ) {
                        Text(ButtonStrings.delete(language))
                    }
                    Button(
                        //modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onDismiss() }
                    ) {
                        Text(ButtonStrings.cancel(language))
                    }
                }
            }





            /*{
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    //SnackBars.DeleteSnackBar(language = language)
                    Button(onClick = onConfirm) {
                        Text(ButtonStrings.delete(language))

                        // TODO Toast wird aktuell beim druecken des Icons "Loeschen" angezeigt.
                        //  Sollte angezeigt werden, nachdem man im DeleteDialog auf "Loeschen"
                        //  gedrueckt hat.
                        //Toast.makeText(LocalContext.current, "Toast", Toast.LENGTH_SHORT).show()
                    }

                    //CustomSnackBar()
                    Button(onClick = onDismiss) {
                        //DeleteSnackBar(language)
                        Text(ButtonStrings.cancel(language))
                    }
                    SnackBars.DeleteSnackBar(language = language)
                }
            }*/
        )
    }


    @Composable
    fun ShowSnackbar(context: Context, message:String) {
        val snackState = remember { SnackbarHostState()}
        val scope = rememberCoroutineScope()
        fun launchSnackbar(message: String, actionLabel : String?=null, duration: SnackbarDuration = SnackbarDuration.Short){
            scope.launch {
                snackState.showSnackbar(message = message,actionLabel=actionLabel, duration=duration)
            }
        //Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }}

    @Composable
    fun PendingChanges(
        onDismiss: () -> Unit,
        onConfirm: () -> Unit,
        language: Language
    ) {
        AlertDialog(
            properties = DialogProperties(
                dismissOnClickOutside = false,
                dismissOnBackPress = true,
            ),
            onDismissRequest = { onDismiss() },
            title = {
                Text(
                    text = TitleStrings.unsavedChanges(language),
                    style = MaterialTheme.typography.h5
                )
            },
            text = {
                Text(
                    text = MessageStrings.discardChanges(language),
                    style = MaterialTheme.typography.body1
                )
            },
            buttons = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(onClick = onConfirm) {
                        Text(ButtonStrings.discardChanges(language))
                    }
                    Button(onClick = onDismiss) {
                        Text(ButtonStrings.cancel(language))
                    }
                }
            }
        )
    }

    @Composable
    fun LeaveDocuModeForCrimeScene(
        onDismiss: () -> Unit,
        onConfirm: () -> Unit,
        language: Language
    ) {
        AlertDialog(
            properties = DialogProperties(
                dismissOnClickOutside = true,
                dismissOnBackPress = true,
            ),
            onDismissRequest = { onDismiss() },
            title = {
                Text(
                    text = TitleStrings.leaveDocuMode(language),
                    style = MaterialTheme.typography.h5
                )
            },
            text = {
                Text(
                    text = MessageStrings.leaveDocuModeForCrimeScene(language),
                    style = MaterialTheme.typography.body1
                )
            },
            buttons = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(onClick = onConfirm) {
                        Text(ButtonStrings.leaveDocuMode(language))
                    }
                    Button(onClick = onDismiss) {
                        Text(ButtonStrings.cancel(language))
                    }
                }
            }
        )
    }

    @Composable
    fun LeaveDocuMode(
        onDismiss: () -> Unit,
        onConfirm: () -> Unit,
        language: Language
    ) {
        AlertDialog(
            properties = DialogProperties(
                dismissOnClickOutside = false,
                dismissOnBackPress = true,
            ),
            onDismissRequest = { onDismiss() },
            title = {
                Text(
                    text = TitleStrings.leaveDocuMode(language),
                    style = MaterialTheme.typography.h5
                )
            },
            text = {
                Text(
                    text = MessageStrings.leaveDocuMode(language),
                    style = MaterialTheme.typography.body1
                )
            },
            buttons = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(onClick = onConfirm) {
                        Text(ButtonStrings.leaveDocuMode(language))
                    }
                    Button(onClick = onDismiss) {
                        Text(ButtonStrings.cancel(language))
                    }
                }
            }
        )
    }

    @Composable
    fun InsituInfo(language: Language) {
        val openDialog = remember { mutableStateOf(false) }

        IconButton(onClick = { openDialog.value = true }) {
            Icon(
                painter = drawableResource(filename = "ic_insitu_logo.svg"),
                contentDescription = IconContentDescriptions.insituLogo(language)
            )
        }

        if (openDialog.value) {

            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onCloseRequest.
                    openDialog.value = false
                },
                title = { Text(text = "INSITU Version") },
                text = { Text(text = BuildConfig.VERSION_NAME) },
                confirmButton = {
                    Button(
                        onClick = {
                            openDialog.value = false
                        }) {
                        Text(Strings.button_close)
                    }
                }
            )
        }
    }

    @Composable
    fun SettingsList(
        title: @Composable () -> Unit,
        subtitle: (@Composable () -> Unit)?,
        onSelected: (Int) -> Unit,
        storage: SettingValueState<Int>,
        items: List<String>,
        showDialog: MutableState<Boolean>
    ) {
        AlertDialog(
            title = title,
            text = subtitle,
            onDismissRequest = { showDialog.value = false },
            buttons = {
                Column {
                    items.forEachIndexed { index, item ->
                        val isSelected by rememberUpdatedState(newValue = storage.value == index)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    role = Role.RadioButton,
                                    selected = isSelected,
                                    onClick = { if (!isSelected) onSelected(index) }
                                )
                                .padding(
                                    start = 32.dp,
                                    top = 16.dp,
                                    end = 32.dp,
                                    bottom = 16.dp
                                )
                        ) {
                            RadioButton(
                                selected = isSelected,
                                onClick = { if (!isSelected) onSelected(index) }
                            )
                            Text(
                                text = item,
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InsituInfoPreview() {
    InsituTheme {
        InsituInfo(language = Language.DE)
    }
}
