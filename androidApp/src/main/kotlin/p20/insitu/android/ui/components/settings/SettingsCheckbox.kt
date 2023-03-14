package p20.insitu.android.ui.components.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import p20.insitu.db.settings.*
import p20.insitu.android.ui.components.settings.internal.SettingsTileAction
import p20.insitu.android.ui.components.settings.internal.SettingsTileIcon
import p20.insitu.android.ui.components.settings.internal.SettingsTileTexts
import p20.insitu.theme.InsituTheme

@Composable
fun SettingsCheckbox(
    modifier: Modifier = Modifier,
    storage: SettingValueState<Boolean>,
    icon: @Composable (() -> Unit)? = null,
    title: @Composable () -> Unit,
    subtitle: @Composable (() -> Unit)? = null,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    var storageValue = storage.value
    val update: (Boolean) -> Unit = { boolean ->
        storageValue = boolean
        onCheckedChange(storageValue)
    }
    Surface {
        Row(
            modifier = modifier
              .fillMaxWidth()
              .toggleable(
                value = storageValue,
                role = Role.Checkbox,
                onValueChange = { update(!storageValue) }
              ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SettingsTileIcon(icon = icon)
            SettingsTileTexts(title = title, subtitle = subtitle)
            SettingsTileAction {
                Checkbox(
                    checked = storageValue,
                    onCheckedChange = update
                )
            }
        }
    }
}

@Preview
@Composable
internal fun SettingsCheckboxPreview() {
    InsituTheme {
        val storage = rememberBooleanSettingState(defaultValue = true)
        SettingsCheckbox(
            storage = storage,
            icon = { Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear") },
            title = { Text(text = "Hello") },
            subtitle = { Text(text = "This is a longer text") },
            onCheckedChange = { }
        )
    }
}