package p20.insitu.android.ui.previews

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun SettingsIconPreview() {
    MaterialTheme {
        p20.insitu.android.ui.components.settings.internal.SettingsTileIcon {
            Icon(imageVector = Icons.Default.Clear, contentDescription = "")
        }
    }
}

@Preview
@Composable
fun SettingsIconPreviewEmpty() {
    MaterialTheme {
        p20.insitu.android.ui.components.settings.internal.SettingsTileIcon()
    }
}
