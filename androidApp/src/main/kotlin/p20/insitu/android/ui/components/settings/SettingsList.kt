package p20.insitu.android.ui.components.settings

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import p20.insitu.android.ui.components.dialogs.AlertDialogs
import p20.insitu.db.settings.SettingValueState

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    storage: SettingValueState<Int>,
    title: @Composable () -> Unit,
    items: List<String>,
    icon: (@Composable () -> Unit)? = null,
    useSelectedValueAsSubtitle: Boolean = true,
    subtitle: (@Composable () -> Unit)? = null,
    closeDialogDelay: Long = 200,
    action: (@Composable () -> Unit)? = null,
) {

    if (storage.value >= items.size) {
        throw IndexOutOfBoundsException("Current value for $title list setting cannot be greater than items size")
    }

    var showDialog by remember { mutableStateOf(false) }

    val safeSubtitle = if (storage.value >= 0 && useSelectedValueAsSubtitle) {
        { Text(text = items[storage.value]) }
    } else subtitle

    SettingsMenuLink(
        modifier = modifier,
        icon = icon,
        title = title,
        subtitle = safeSubtitle,
        action = action,
        onClick = { showDialog = true },
    )

    if (!showDialog) return

    val coroutineScope = rememberCoroutineScope()
    val onSelected: (Int) -> Unit = { selectedIndex ->
        coroutineScope.launch {
            storage.value = selectedIndex
            delay(closeDialogDelay)
            showDialog = false
        }
    }

    val showDialog2 = remember { // TODO hä?
        mutableStateOf(false)
    }
    AlertDialogs.SettingsList(
        title = title,
        subtitle = subtitle,
        onSelected = onSelected,
        storage = storage,
        items = items,
        showDialog = showDialog2
    )
}