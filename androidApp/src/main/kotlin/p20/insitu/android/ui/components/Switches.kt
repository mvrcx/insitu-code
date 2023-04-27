package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import p20.insitu.resources.Language
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TitleStrings

object Switches {

    @Composable
    fun SecureAsEvidence(
        modifier: Modifier = Modifier,
        securingSelected: Boolean,
        language: Language,
        onCheckedChange: (Boolean) -> Unit = {},
    ) {
        val switch = remember { mutableStateOf(securingSelected) }
        val update: (Boolean) -> Unit = { boolean ->
            switch.value = boolean
            onCheckedChange(switch.value)
        }
        Surface {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = switch.value,
                        role = Role.Switch,
                        onValueChange = { update(!switch.value) }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icon on the left
                Box(
                    modifier = modifier.size(64.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Inventory2,
                        contentDescription = IconContentDescriptions.secureAsEvidence(language),
                        modifier = Modifier.padding(end = 8.dp),
                        tint = MaterialTheme.colors.secondary
                    )
                }
                // The title and message
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                ) {
                    if (switch.value) {
                        Text(
                            text = TitleStrings.secureAsEvidence(language),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle1
                        )
                    } else {
                        Text(
                            text = TitleStrings.doNotSecureAsEvidence(language),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                    Spacer(modifier = Modifier.size(2.dp))
                    if (switch.value) {
                        Text(
                            text = MessageStrings.secureAsEvidence(language),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.caption
                        )
                    } else {
                        Text(
                            text = MessageStrings.doNotSecureAsEvidence(language),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
                // The actual switch
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    //val haptic = LocalHapticFeedback.current
                    Switch(
                        checked = switch.value,
                        onCheckedChange =
                            update
                            //haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    )
                }
            }
        }
    }

    @Composable
    private fun NestedAnnotations(
        modifier: Modifier = Modifier,
        messageObject: String,
        messageNested: String,
        language: Language,
        initialValue: Boolean,
        onCheckedChange: (Boolean) -> Unit = {},
    ) {
        val switch = remember { mutableStateOf(initialValue) }
        val update: (Boolean) -> Unit = { boolean ->
            switch.value = boolean
            onCheckedChange(switch.value)
        }
        Surface {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = switch.value,
                        role = Role.Switch,
                        onValueChange = { update(!switch.value) }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icon on the left
                Box(
                    modifier = modifier.size(64.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = IconContentDescriptions.mediaFilter(language),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                // The title and message
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = TitleStrings.filterNestedAnnotations(language),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.size(2.dp))
                    if (switch.value) {
                        Text(
                            text = messageNested,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.caption
                        )
                    } else {
                        Text(
                            text = messageObject,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
                // The actual switch
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Switch(
                        checked = switch.value,
                        onCheckedChange = update
                    )
                }
            }
        }
    }

    @Composable
    fun FilterUserAnnotations(
        modifier: Modifier = Modifier,
        initialValue: Boolean,
        language: Language,
        onCheckedChange: (Boolean) -> Unit = {},
    ) {
        val switch = remember { mutableStateOf(initialValue) }
        val update: (Boolean) -> Unit = { boolean ->
            switch.value = boolean
            onCheckedChange(switch.value)
        }
        val messageMyAnnotations = MessageStrings.showMyAnnotationsOnly(language)
        val messageAllAnnotations = MessageStrings.showAnnotationsOfAllUsers(language)

        Surface {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .toggleable(
                        value = switch.value,
                        role = Role.Switch,
                        onValueChange = { update(!switch.value) }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icon on the left
                Box(
                    modifier = modifier.size(64.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = IconContentDescriptions.mediaFilter(language),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                // The title and message
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = TitleStrings.filterUserAnnotations(language),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.size(2.dp))
                    if (switch.value) {
                        Text(
                            text = messageMyAnnotations,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.caption
                        )
                    } else {
                        Text(
                            text = messageAllAnnotations,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
                // The actual switch
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Switch(
                        checked = switch.value,
                        onCheckedChange = update
                    )
                }
            }
        }
    }

    @Composable
    fun NestedAudioAnnotations(
        modifier: Modifier = Modifier,
        initialValue: Boolean,
        language: Language,
        onCheckedChange: (Boolean) -> Unit = {},
    ) {
        NestedAnnotations(
            modifier = modifier,
            messageObject = MessageStrings.showObjectAudioRecordingsOnly(language),
            messageNested = MessageStrings.showNestedAudioRecordings(language),
            initialValue = initialValue,
            language = language,
            onCheckedChange = onCheckedChange
        )
    }

    @Composable
    fun NestedImageAnnotations(
        modifier: Modifier = Modifier,
        initialValue: Boolean,
        language: Language,
        onCheckedChange: (Boolean) -> Unit = {},
    ) {
        NestedAnnotations(
            modifier = modifier,
            messageObject = MessageStrings.showObjectImagesOnly(language),
            messageNested = MessageStrings.showNestedImages(language),
            initialValue = initialValue,
            language = language,
            onCheckedChange = onCheckedChange
        )
    }

    @Composable
    fun FilterNestedNoteAnnotations(
        modifier: Modifier = Modifier,
        initialValue: Boolean,
        language: Language,
        onCheckedChange: (Boolean) -> Unit = {},
    ) {
        NestedAnnotations(
            modifier = modifier,
            messageObject = MessageStrings.showObjectNotesOnly(language),
            messageNested = MessageStrings.showNestedNotes(language),
            initialValue = initialValue,
            language = language,
            onCheckedChange = onCheckedChange
        )
    }

    @Composable
    fun NestedVideoAnnotations(
        modifier: Modifier = Modifier,
        initialValue: Boolean,
        language: Language,
        onCheckedChange: (Boolean) -> Unit = {},
    ) {
        NestedAnnotations(
            modifier = modifier,
            messageObject = MessageStrings.showObjectVideosOnly(language),
            messageNested = MessageStrings.showNestedVideos(language),
            initialValue = initialValue,
            language = language,
            onCheckedChange = onCheckedChange
        )
    }
}