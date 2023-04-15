package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import p20.insitu.android.ui.components.Containers
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.TextFields
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.SomeObjectViewModel
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier


@Composable
fun SomeObjectDetails(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: SomeObjectViewModel,
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()


    // PhysicalTrace fields
    val docNumber = viewModel.docNumber.collectAsState()
    // Description
    val designation = viewModel.designation.collectAsState()
    val typeOfObject = viewModel.typeOfObject.collectAsState()
    val numberOfPieces = viewModel.numberOfPieces.collectAsState()
    val specialFeatures = viewModel.specialFeatures.collectAsState()
    val comment = viewModel.comment.collectAsState()
    // Appearance
    val colors = viewModel.colors.collectAsState()
    val materials = viewModel.materials.collectAsState()
    // Dimensions
    val weight = viewModel.weight.collectAsState()
    val volume = viewModel.volume.collectAsState()
    val length = viewModel.length.collectAsState()
    val width = viewModel.width.collectAsState()
    val height = viewModel.height.collectAsState()

    // Catalogues
    val catalogTypeOfObject = catalogRepo.typeOfObject.collectAsState(listOf())

    // Init typeOfObject
    if (typeOfObject.value == null) {
        viewModel.catalogCode.collectAsState().value?.let { code ->
            viewModel.setTypeOfObject(catalogTypeOfObject.value.firstOrNull { it.code == code })
        }
    }

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

            // Type of object
            TextFields.SingleLineString(
                value = typeOfObject.value?.toString(),
                label = TextFieldStrings.typeOfObject(language.value),
                enabled = false
            ) {}

            SpacersAndDividers.VerticalSpacer()

            // Number of pieces
            TextFields.IntValue(
                initialValue = numberOfPieces.value?.toString(),
                label = TextFieldStrings.numberOfPieces(language.value),
                enabled = editMode.value
            ) {
                viewModel.setNumberOfPieces(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Special features
            TextFields.MultilineString(
                value = specialFeatures.value,
                label = TextFieldStrings.specialFeatures(language.value),
                enabled = editMode.value
            ) {
                viewModel.setSpecialFeatures(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Comment
            TextFields.MultilineString(
                value = comment.value,
                label = TextFieldStrings.comment(language.value),
                enabled = editMode.value
            ) {
                viewModel.setComment(it)
            }
        }

        /*
        Containers.SimpleAttributeGroup(
            title = TitleStrings.appearance(language.value)
        ) {
            // Colors
            // TODO

            SpacersAndDividers.VerticalSpacer()

            // Materials
            // TODO
        }
         */

        var isExpanded = remember { mutableStateOf(false) }
        val more = MessageStrings.showFields(language.value)
        val less = MessageStrings.hideFields(language.value)
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
            title = TitleStrings.size(language.value)
        ) {
            // Weight
            TextFields.WeightInput(
                value = weight.value,
                editMode = editMode.value,
                language = language.value,
                catalogRepo = catalogRepo,
                onValueChanged = {
                    viewModel.setWeight(it)
                }
            )

            SpacersAndDividers.VerticalSpacer()

            // Volume
            TextFields.VolumeInput(
                value = volume.value,
                editMode = editMode.value,
                language = language.value,
                catalogRepo = catalogRepo,
                onValueChanged = {
                    viewModel.setVolume(it)
                }
            )

            SpacersAndDividers.VerticalSpacer()

            // Length
            TextFields.SizeInput(
                title = TitleStrings.sizeLengthInput(language.value),
                text = MessageStrings.sizeLengthInput(language.value),
                label = TextFieldStrings.sizeLength(language.value),
                value = length.value,
                editMode = editMode.value,
                language = language.value,
                catalogRepo = catalogRepo,
                onValueChanged = {
                    viewModel.setLength(it)
                }
            )

            SpacersAndDividers.VerticalSpacer()

            // Width
            TextFields.SizeInput(
                title = TitleStrings.sizeWidthInput(language.value),
                text = MessageStrings.sizeWidthInput(language.value),
                label = TextFieldStrings.sizeWidth(language.value),
                value = width.value,
                editMode = editMode.value,
                language = language.value,
                catalogRepo = catalogRepo,
                onValueChanged = {
                    viewModel.setWidth(it)
                }
            )

            SpacersAndDividers.VerticalSpacer()

            // Height
            TextFields.SizeInput(
                title = TitleStrings.sizeHeightInput(language.value),
                text = MessageStrings.sizeHeightInput(language.value),
                label = TextFieldStrings.sizeHeight(language.value),
                value = height.value,
                editMode = editMode.value,
                language = language.value,
                catalogRepo = catalogRepo,
                onValueChanged = {
                    viewModel.setHeight(it)
                }
            )
        }
        }
    }
}