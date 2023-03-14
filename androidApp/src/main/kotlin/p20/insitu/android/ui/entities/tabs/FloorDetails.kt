package p20.insitu.android.ui.entities.tabs

import androidx.compose.runtime.*
import p20.insitu.android.ui.components.Containers
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.TextFields
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.FloorViewModel

@Composable
fun FloorDetails(
    uiStateHandler: UiStateHandler,
    viewModel: FloorViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Floor fields
    val designation = viewModel.designation.collectAsState()
    val docNumber = viewModel.docNumber.collectAsState()
    val locationType = viewModel.locationType.collectAsState()
    val height = viewModel.height.collectAsState()
    val shortDescription = viewModel.shortDescription.collectAsState()

    // Content
    Containers.StandardAttributeContainer(
        uiStateHandler = uiStateHandler
    ) {
        // Documentation number
        TextFields.DocNumber(
            docNumber = docNumber.value?.docNumberString ?: MessageStrings.automaticAssignment(
                language.value
            ),
            leadingNumber = true,
            language = language.value
        )

        Containers.SimpleAttributeGroup(
            title = TitleStrings.description(language.value)
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

            // Type of location
            TextFields.SingleLineString(
                value = locationType.value?.name ?: "",
                readonly = true,
                label = TextFieldStrings.locationType(language.value),
                enabled = editMode.value
            ) {}

            SpacersAndDividers.VerticalSpacer()

            // Short description
            TextFields.MultilineString(
                value = shortDescription.value,
                label = TextFieldStrings.shortDescription(language.value),
                enabled = editMode.value
            ) {
                viewModel.setShortDescription(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Height
            TextFields.FloatValue(
                initialValue = height.value?.toString(),
                label = TextFieldStrings.heightInMeter(language.value),
                enabled = editMode.value
            ) {
                viewModel.setHeight(it)
            }
        }
    }
}