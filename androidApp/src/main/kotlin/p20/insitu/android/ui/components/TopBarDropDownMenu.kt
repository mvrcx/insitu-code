package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import p20.insitu.android.ui.components.buttons.IconButtons
import p20.insitu.android.ui.components.buttons.MenuButtons
import p20.insitu.android.ui.components.dialogs.AlertDialogs
import p20.insitu.model.entities.Investigation
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

@Composable
fun TopBarDropDownMenu(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler
) {
    val expanded = remember { mutableStateOf(false) }
    val investigation = sessionHandler.docuHandler.investigation.collectAsState()
    val docuObject = sessionHandler.docuHandler.docuObject.collectAsState()
    val docuMode = uiStateHandler.docuMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Manage leave docu mode dialog visibility
    val showFinishDialog = uiStateHandler.showLeaveDocuModeDialog.collectAsState(false)
    if (showFinishDialog.value) {
        AlertDialogs.LeaveDocuMode(
            onDismiss = {
                uiStateHandler.showLeaveDocuModeDialog(false)
            },
            onConfirm = {
                uiStateHandler.deactivateDocuMode()
                navigationState.value = NavDestination.Start.popUpTo(inclusive = false)
            },
            language = language.value
        )
    }

    Box {
        IconButtons.Menu(language.value) {
            expanded.value = true
        }
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier.width(200.dp)
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded.value = false
                }
            ) {
                MenuButtons.ReleaseNotes(language.value) {
                    expanded.value = false
                    navigationState.value = NavDestination.ReleaseNotes.navigate()
                }
            }

            DropdownMenuItem(
                onClick = {
                    expanded.value = false
                }
            ) {
                MenuButtons.Help(language.value) {
                    expanded.value = false
                    navigationState.value = NavDestination.Help.navigate()
                }
            }

            DropdownMenuItem(onClick = {
                expanded.value = false
            }) {
                MenuButtons.Settings(language.value) {
                    expanded.value = false
                    navigationState.value = NavDestination.Settings.navigate()
                }
            }

            Divider()

            DropdownMenuItem(onClick = {
                expanded.value = false
            }) {
                if (docuMode.value) {
                    MenuButtons.ExitDocuMode(language.value) {
                        expanded.value = false
                        uiStateHandler.showLeaveDocuModeDialog(true)
                    }
                } else {
                    MenuButtons.Logout(language.value) {
                        expanded.value = false
                        navigationState.value = NavDestination.Logout.navigate()
                    }
                }
            }

            // Debugging view ------------------------------------------------
            /*
            Divider()

            DropdownMenuItem(
                onClick = {
                    expanded.value = false
                }
            ) {
                MenuButtons.DebugView(language.value) {
                    expanded.value = false
                    navigationState.value =
                        NavDestination.DebugView.navigate()
                }
            }
             */
            // ---------------------------------------------------------------
        }
    }
}