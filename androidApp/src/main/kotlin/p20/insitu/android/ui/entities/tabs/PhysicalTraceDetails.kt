package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import p20.insitu.android.ui.components.*
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.xpolizei.schema.KatalogCode327
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.PhysicalTraceViewModel

@Composable
fun PhysicalTraceDetails(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: PhysicalTraceViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // PhysicalTrace fields
    val docNumber = viewModel.docNumber.collectAsState()
    // Description
    val designation = viewModel.designation.collectAsState()
    val typeOfPhysicalTrace = viewModel.typeOfPhysicalTrace.collectAsState()
    val numberOfPieces = viewModel.numberOfPieces.collectAsState()
    val position = viewModel.position.collectAsState()
    val comment = viewModel.comment.collectAsState()
    val quality = viewModel.quality.collectAsState()
    // Appearance
    val colors = viewModel.colors.collectAsState()
    val materials = viewModel.materials.collectAsState()
    // Dimensions
    val weight = viewModel.weight.collectAsState()
    val volume = viewModel.volume.collectAsState()
    val length = viewModel.length.collectAsState()
    val width = viewModel.width.collectAsState()
    val height = viewModel.height.collectAsState()
    val diameter = viewModel.diameter.collectAsState()

    // Catalogues
    val catalogTypeOfPhysicalTrace = catalogRepo.typeOfPhysicalTrace.collectAsState(listOf())
    val catalogQualityOfTrace = catalogRepo.qualityOfTrace.collectAsState(listOf())

    // Init typeOfPhysicalTrace from passed catalog code
    if (typeOfPhysicalTrace.value == null) {
        viewModel.catalogCode.collectAsState().value?.let { code ->
            viewModel.setTypeOfPhysicalTrace(catalogTypeOfPhysicalTrace.value.firstOrNull { it.code == code })
        }
    }

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

            // Type of physical trace
            TextFields.SingleLineString(
                value = typeOfPhysicalTrace.value?.toString(),
                label = TextFieldStrings.typeOfPhysicalTrace(language.value),
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

            // Quality of trace
            if (editMode.value) {
                DropdownField.CatalogList(
                    label = TextFieldStrings.qualityOfTrace(language.value),
                    value = quality.value,
                    list = catalogQualityOfTrace.value,
                    enabled = editMode.value,
                    language = language.value
                ) {
                    viewModel.setQuality(it as? CatalogCodeFixed<KatalogCode327>)
                }
            } else {
                TextField(
                    value = quality.value?.toString() ?: "",
                    enabled = false,
                    onValueChange = {},
                    label = { Text.Label(text = TextFieldStrings.qualityOfTrace(language.value)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            SpacersAndDividers.VerticalSpacer()

            // Position description
            TextFields.MultilineString(
                value = position.value,
                label = TextFieldStrings.positionDescription(language.value),
                enabled = editMode.value
            ) {
                viewModel.setPosition(it)
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

        Containers.SimpleAttributeGroup(
            title = TitleStrings.appearance(language.value)
        ) {
            // Colors
            TextFields.ToDo(TextFieldStrings.color(language.value))

            SpacersAndDividers.VerticalSpacer()

            // Materials
            TextFields.ToDo(TextFieldStrings.material(language.value))
        }

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

            SpacersAndDividers.VerticalSpacer()

            // Diameter
            TextFields.SizeInput(
                title = TitleStrings.sizeDiameterInput(language.value),
                text = MessageStrings.sizeDiameterInput(language.value),
                label = TextFieldStrings.sizeDiameter(language.value),
                value = diameter.value,
                editMode = editMode.value,
                language = language.value,
                catalogRepo = catalogRepo,
                onValueChanged = {
                    viewModel.setDiameter(it)
                }
            )
        }
    }
}