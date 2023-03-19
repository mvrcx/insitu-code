package p20.insitu.android.ui.components.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import p20.insitu.resources.Language
import p20.insitu.resources.strings.ButtonStrings
import p20.insitu.resources.strings.IconContentDescriptions

object MenuButtons {

    @Composable
    fun Delete(
        language: Language,
        onClickAction: () -> Unit
    ) {
        TextButton(
            onClick = { onClickAction() }
        ) {
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = IconContentDescriptions.logout(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Text(
                text = ButtonStrings.exitDocuMode(language),
                style = TextStyle(color = MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }

    @Composable
    fun Settings(
        language: Language,
        onClickAction: () -> Unit
    ) {
        TextButton(
            onClick = { onClickAction() }
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = IconContentDescriptions.settings(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Text(
                text = ButtonStrings.settings(language),
                style = TextStyle(color = MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }

    @Composable
    fun ExitDocuMode(
        language: Language,
        onClickAction: () -> Unit
    ) {
        TextButton(
            onClick = { onClickAction() }
        ) {
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = IconContentDescriptions.logout(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Text(
                text = ButtonStrings.exitDocuMode(language),
                style = TextStyle(color = MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }

    @Composable
    fun Logout(
        language: Language,
        onClickAction: () -> Unit
    ) {
        TextButton(
            onClick = { onClickAction() }
        ) {
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = IconContentDescriptions.logout(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Text(
                text = ButtonStrings.logout(language),
                style = TextStyle(color = MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }

    @Composable
    fun ReleaseNotes(
        language: Language,
        onClickAction: () -> Unit
    ) {
        TextButton(
            onClick = { onClickAction() }
        ) {
            Icon(
                imageVector = Icons.Filled.NewReleases,
                contentDescription = IconContentDescriptions.releaseNotes(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Text(
                text = ButtonStrings.releaseNotes(language),
                style = TextStyle(color = MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }

    @Composable
    fun Help(
        language: Language,
        onClickAction: () -> Unit
    ) {
        TextButton(
            onClick = { onClickAction() }
        ) {
            Icon(
                imageVector = Icons.Filled.Help,
                contentDescription = IconContentDescriptions.help(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Text(
                text = ButtonStrings.help(language),
                style = TextStyle(color = MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }

    @Composable
    fun DebugView(
        language: Language,
        onClickAction: () -> Unit
    ) {
        TextButton(
            onClick = { onClickAction() }
        ) {
            Icon(
                imageVector = Icons.Filled.Android,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Text(
                text = ButtonStrings.debugView(language),
                style = TextStyle(color = MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }

    @Composable
    fun GoToInvestigation(
        language: Language,
        onClickAction: () -> Unit
    ) {
        TextButton(
            onClick = { onClickAction() }
        ) {
            Icon(
                imageVector = Icons.Filled.Folder,
                contentDescription = IconContentDescriptions.goToInvestigation(language),
                modifier = Modifier.padding(end = 8.dp),
                tint = MaterialTheme.colors.onSurface
            )
            Text(
                text = ButtonStrings.goToInvestigation(language),
                style = TextStyle(color = MaterialTheme.colors.onSurface)
            )
            Spacer(modifier = Modifier.fillMaxWidth())
        }
    }
}