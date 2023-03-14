package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import p20.insitu.android.ui.components.Containers
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.SubTitles
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.TextFields
import p20.insitu.android.ui.components.autocomplete.AutoCompleteTextFields
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.CriminalOffenseViewModel


@Composable
fun CriminalOffenseModusOperandi(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: CriminalOffenseViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Modus Operandi fields
    val modusOperandiPlanning = viewModel.modusOperandiPlanning.collectAsState()
    val modusOperandiExecution = viewModel.modusOperandiExecution.collectAsState()
    val modusOperandiPostExecution = viewModel.modusOperandiPostExecution.collectAsState()

    // Catalog
    val catalogModusOperandiType = catalogRepo.modusOperandi.collectAsState(listOf())

    // AutoCompleteTextField drop down options
    val modusOperandiTypeNames = catalogModusOperandiType.value.map { it.name }

    // AutoCompleteTextField search values
    val modusOperandiPlanningTypeSearchText = remember { mutableStateOf("") }
    modusOperandiPlanning.value.type?.let {
        if (!editMode.value) {
            modusOperandiPlanningTypeSearchText.value = it.toString()
        } else if (modusOperandiPlanningTypeSearchText.value.isBlank()) {
            modusOperandiPlanningTypeSearchText.value = it.toString()
        }
    }
    val modusOperandiExecutionTypeSearchText = remember { mutableStateOf("") }
    modusOperandiExecution.value.type?.let {
        if (!editMode.value) {
            modusOperandiExecutionTypeSearchText.value = it.toString()
        } else if (modusOperandiExecutionTypeSearchText.value.isBlank()) {
            modusOperandiExecutionTypeSearchText.value = it.toString()
        }
    }
    val modusOperandiPostExecutionTypeSearchText = remember { mutableStateOf("") }
    modusOperandiPostExecution.value.type?.let {
        if (!editMode.value) {
            modusOperandiPostExecutionTypeSearchText.value = it.toString()
        } else if (modusOperandiPostExecutionTypeSearchText.value.isBlank()) {
            modusOperandiPostExecutionTypeSearchText.value = it.toString()
        }
    }

    Containers.StandardAttributeContainer(
        uiStateHandler = uiStateHandler
    ) {
        SubTitles.SimpleSubtitle(
            text = TitleStrings.modusOperandiPlanningPhase(language.value),
            paddingTop = 0.dp
        )

        // Designation
        TextFields.SingleLineString(
            value = modusOperandiPlanning.value.designation,
            label = TextFieldStrings.designation(language.value),
            enabled = editMode.value
        ) {
            viewModel.setModusOperandiPlanning(
                p20.insitu.model.components.ModusOperandi(
                    type = modusOperandiPlanning.value.type,
                    designation = it,
                    crimePhase = modusOperandiPlanning.value.crimePhase
                )
            )
        }

        SpacersAndDividers.VerticalSpacer()

        // Modus Operandi planning phase
        if (editMode.value) {
            AutoCompleteTextFields.StringValue(
                label = TextFieldStrings.modusOperandiType(language.value),
                value = modusOperandiPlanningTypeSearchText.value,
                items = modusOperandiTypeNames,
                enabled = true,
                language = language.value,
                onValueChanged = {
                    modusOperandiPlanningTypeSearchText.value = it
                    viewModel.setModusOperandiPlanning(
                        p20.insitu.model.components.ModusOperandi(
                            type = catalogModusOperandiType.value.firstOrNull { catalogCode -> catalogCode.name == it },
                            designation = modusOperandiPlanning.value.designation,
                            crimePhase = modusOperandiPlanning.value.crimePhase
                        )
                    )
                }
            )
        } else {
            TextField(
                value = modusOperandiPlanning.value.type?.toString() ?: "",
                enabled = false,
                onValueChange = {},
                label = { Label(text = TextFieldStrings.modusOperandiType(language.value)) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        SubTitles.SimpleSubtitle(text = TitleStrings.modusOperandiExecutionPhase(language.value))

        // Designation
        TextFields.SingleLineString(
            value = modusOperandiExecution.value.designation,
            label = TextFieldStrings.designation(language.value),
            enabled = editMode.value
        ) {
            viewModel.setModusOperandiExecution(
                p20.insitu.model.components.ModusOperandi(
                    type = modusOperandiExecution.value.type,
                    designation = modusOperandiExecution.value.designation,
                    crimePhase = modusOperandiExecution.value.crimePhase
                )
            )
        }

        SpacersAndDividers.VerticalSpacer()

        // Modus Operandi execution phase
        if (editMode.value) {
            AutoCompleteTextFields.StringValue(
                label = TextFieldStrings.modusOperandiType(language.value),
                value = modusOperandiExecutionTypeSearchText.value,
                items = modusOperandiTypeNames,
                enabled = true,
                language = language.value,
                onValueChanged = {
                    modusOperandiExecutionTypeSearchText.value = it
                    viewModel.setModusOperandiExecution(
                        p20.insitu.model.components.ModusOperandi(
                            type = catalogModusOperandiType.value.firstOrNull { catalogCode -> catalogCode.name == it },
                            designation = modusOperandiExecution.value.designation,
                            crimePhase = modusOperandiExecution.value.crimePhase
                        )
                    )
                }
            )
        } else {
            TextField(
                value = modusOperandiExecution.value.type?.toString() ?: "",
                enabled = false,
                onValueChange = {},
                label = { Label(text = TextFieldStrings.modusOperandiType(language.value)) },
                modifier = Modifier.fillMaxWidth()
            )
        }

        SubTitles.SimpleSubtitle(text = TitleStrings.modusOperandiPostExecutionPhase(language.value))

        // Designation
        TextFields.SingleLineString(
            value = modusOperandiPostExecution.value.designation,
            label = TextFieldStrings.designation(language.value),
            enabled = editMode.value
        ) {
            viewModel.setModusOperandiPostExecution(
                p20.insitu.model.components.ModusOperandi(
                    type = modusOperandiPostExecution.value.type,
                    designation = it,
                    crimePhase = modusOperandiPostExecution.value.crimePhase
                )
            )
        }

        SpacersAndDividers.VerticalSpacer()

        // Modus Operandi post execution phase
        if (editMode.value) {
            AutoCompleteTextFields.StringValue(
                label = TextFieldStrings.modusOperandiType(language.value),
                value = modusOperandiPostExecutionTypeSearchText.value,
                items = modusOperandiTypeNames,
                enabled = true,
                language = language.value,
                onValueChanged = {
                    modusOperandiPostExecutionTypeSearchText.value = it
                    viewModel.setModusOperandiPostExecution(
                        p20.insitu.model.components.ModusOperandi(
                            type = catalogModusOperandiType.value.firstOrNull { catalogCode -> catalogCode.name == it },
                            designation = modusOperandiPostExecution.value.designation,
                            crimePhase = modusOperandiPostExecution.value.crimePhase
                        )
                    )
                }
            )
        } else {
            TextField(
                value = modusOperandiPostExecution.value.type?.toString() ?: "",
                enabled = false,
                onValueChange = {},
                label = { Label(text = TextFieldStrings.modusOperandiType(language.value)) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}