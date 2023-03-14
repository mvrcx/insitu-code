@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.autocomplete.AutoCompleteTextFields
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.SomeSiteViewModel

@Composable
fun SomeSiteDetails(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: SomeSiteViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // SomeSite fields
    val docNumber = viewModel.docNumber.collectAsState()
    val designation = viewModel.designation.collectAsState()
    val locationType = viewModel.locationType.collectAsState()

    // Catalogues
    val catalogLocationType = catalogRepo.locationType.collectAsState(listOf())

    // AutoCompleteTextField drop down options
    val locationTypeNames = catalogLocationType.value.mapNotNull { it.name }.sorted()

    // AutoCompleteTextField search values
    val locationTypeSearchText = remember { mutableStateOf("") }
    locationType.value?.let {
        if (!editMode.value) {
            locationTypeSearchText.value = it.toString()
        } else if (locationTypeSearchText.value.isBlank()) {
            locationTypeSearchText.value = it.toString()
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

            // Type of location
            if (editMode.value) {
                AutoCompleteTextFields.StringValue(
                    label = TextFieldStrings.locationType(language.value),
                    value = locationTypeSearchText.value,
                    items = locationTypeNames,
                    enabled = true,
                    language = language.value,
                    onValueChanged = {
                        locationTypeSearchText.value = it
                        viewModel.setLocationType(
                            catalogLocationType.value.firstOrNull { catalogCode -> catalogCode.name == it }
                                    as? CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>
                        )
                    }
                )
            } else {
                TextField(
                    value = locationType.value?.toString() ?: "",
                    enabled = false,
                    onValueChange = {},
                    label = { Label(text = TextFieldStrings.locationType(language.value)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
