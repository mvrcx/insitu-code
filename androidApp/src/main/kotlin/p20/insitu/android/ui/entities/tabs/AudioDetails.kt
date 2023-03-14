package p20.insitu.android.ui.entities.tabs

import androidx.compose.runtime.*
import p20.insitu.android.ui.components.Containers
import p20.insitu.android.ui.components.LoadingAnimations
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.TextFields
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.AudioViewModel

@Composable
fun AudioDetails(
    uiStateHandler: UiStateHandler,
    viewModel: AudioViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Audio
    val audio = viewModel.entity.collectAsState()

    // Note fields
    val designation = viewModel.designation.collectAsState()
    val transcription = viewModel.transcription.collectAsState()

    // Content
    if (audio.value == null) {
        LoadingAnimations.StandardLoadingAnimation()
    } else {
        Containers.StandardAttributeContainer(
            uiStateHandler = uiStateHandler
        ) {
            // Designation
            TextFields.SingleLineString(
                value = designation.value,
                label = TextFieldStrings.designation(language.value),
                enabled = editMode.value
            ) {
                viewModel.setDesignation(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Transcription
            TextFields.MultilineString(
                value = transcription.value,
                label = TextFieldStrings.audioTranscription(language.value),
                enabled = editMode.value
            ) {
                viewModel.setTranscription(it)
            }
        }
    }
}