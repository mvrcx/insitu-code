package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.DropdownField
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.model.entities.enums.RoomType
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.RoomViewModel

@Composable
fun RoomDetails(
    uiStateHandler: UiStateHandler,
    viewModel: RoomViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Room fields
    val docNumber = viewModel.docNumber.collectAsState()
    val designation = viewModel.designation.collectAsState()
    val roomType = viewModel.roomType.collectAsState()
    val width = viewModel.width.collectAsState()
    val length = viewModel.length.collectAsState()
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
            // Room type
            if (editMode.value) {
                DropdownField.StringList(
                    label = TextFieldStrings.roomType(language.value),
                    value = roomType.value?.designation,
                    list = RoomType.values().map { it.designation },
                    enabled = editMode.value,
                    language = language.value
                ) {
                    viewModel.setRoomType(RoomType.getRoomTypeByDesignation(it))
                }
            } else {
                TextField(
                    value = roomType.value?.designation ?: "",
                    enabled = false,
                    onValueChange = {},
                    label = { Label(text = TextFieldStrings.roomType(language.value)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            SpacersAndDividers.VerticalSpacer()

            // Designation
            TextFields.SingleLineString(
                value = designation.value,
                label = TextFieldStrings.designation(language.value),
                enabled = editMode.value
            ) {
                viewModel.setDesignation(it)
            }

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

        }

        var isExpanded = remember { mutableStateOf(false) }
        // Show more button
        TextButton(
            onClick = { isExpanded.value = !isExpanded.value },
        ) {
            Text( text = if (isExpanded.value) {
                "Ausblenden"
            } else {
                "Weitere Angaben"
            }
            )
        }

        if (isExpanded.value) {
            Containers.SimpleAttributeGroup(
                title = TitleStrings.dimensions(language.value)
            ) {
                // Width
                TextFields.FloatValue(
                    initialValue = width.value?.toString(),
                    label = TextFieldStrings.widthInMeter(language.value),
                    enabled = editMode.value
                ) {
                    viewModel.setWidth(it)
                }

                SpacersAndDividers.VerticalSpacer()

                // Length
                TextFields.FloatValue(
                    initialValue = length.value?.toString(),
                    label = TextFieldStrings.lengthInMeter(language.value),
                    enabled = editMode.value
                ) {
                    viewModel.setLength(it)
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
}