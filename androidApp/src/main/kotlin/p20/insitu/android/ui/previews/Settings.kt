package p20.insitu.android.ui.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import p20.insitu.db.settings.rememberBooleanSettingState
import p20.insitu.db.settings.rememberIntSettingState
import p20.insitu.theme.InsituTheme


@Preview
@Composable
internal fun SettingsCheckboxPreview() {
    InsituTheme {
        val storage = rememberBooleanSettingState(defaultValue = true)
        p20.insitu.android.ui.components.settings.SettingsCheckbox(
            storage = storage,
            icon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
            onCheckedChange = { }
        )
    }
}

@Preview
@Composable
internal fun SettingsGroupPreview() {
    InsituTheme {
        p20.insitu.android.ui.components.settings.SettingsGroup(
            title = { Text(text = "Title") }
        ) {
            Box(
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Settings group")
            }
        }
    }
}

@Preview
@Composable
internal fun ListLinkPreview() {
    InsituTheme {
        val storage = rememberIntSettingState(defaultValue = 0)
        p20.insitu.android.ui.components.settings.SettingsList(
            storage = storage,
            items = listOf("Banana", "Kiwi", "Pineapple"),
            icon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
        )
    }
}



@Preview
@Composable
internal fun SettingsMenuLinkPreview() {
    InsituTheme {
        p20.insitu.android.ui.components.settings.SettingsMenuLink(
            icon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
        ) {

        }
    }
}

@Preview
@Composable
internal fun SettingsMenuLinkActionPreview() {
    var rememberCheckBoxState by remember { mutableStateOf(true) }
    InsituTheme {
        p20.insitu.android.ui.components.settings.SettingsMenuLink(
            icon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
            action = {
                Checkbox(checked = rememberCheckBoxState, onCheckedChange = { newState ->
                    rememberCheckBoxState = newState
                })
            },
        ) {

        }
    }
}


@Preview
@Composable
internal fun SettingsSwitchPreview() {
    InsituTheme {
        val storage = rememberBooleanSettingState(defaultValue = true)
        p20.insitu.android.ui.components.settings.SettingsSwitch(
            storage = storage,
            icon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
            onCheckedChange = { }
        )
    }
}