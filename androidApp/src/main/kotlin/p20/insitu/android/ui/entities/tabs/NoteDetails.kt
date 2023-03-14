package p20.insitu.android.ui.entities.tabs

import androidx.compose.runtime.*
import p20.insitu.android.ui.components.Containers
import p20.insitu.android.ui.components.LoadingAnimations
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.TextFields
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.NoteViewModel

@Composable
fun NoteDetails(
    uiStateHandler: UiStateHandler,
    viewModel: NoteViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Note
    val note = viewModel.entity.collectAsState()

    // Note fields
    val designation = viewModel.designation.collectAsState()
    val keywords = viewModel.keywords.collectAsState()
    val text = viewModel.text.collectAsState()

    // Content
    if (note.value == null) {
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

            // Text
            TextFields.MultilineString(
                value = text.value,
                label = TextFieldStrings.noteText(language.value),
                enabled = editMode.value
            ) {
                viewModel.setText(it)
            }
        }
    }
}