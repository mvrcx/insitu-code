package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.autocomplete.AutoCompleteTextFields
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.components.datetime.DateAndTimePickers
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.toZonedDateTime
import p20.insitu.viewmodels.entities.CrimeSceneViewModel
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun CrimeSceneDetails(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: CrimeSceneViewModel
) {
    // UiStateHandler states
    val newEntity = uiStateHandler.newEntity.collectAsState()
    val editMode = uiStateHandler.editMode.collectAsState()
    val docuMode = uiStateHandler.docuMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    val showDocuModeButton = !docuMode.value && !editMode.value

    // Crime scene fields
    val designation = viewModel.designation.collectAsState()
    val docNumber = viewModel.docNumber.collectAsState()
    val locationType = viewModel.locationType.collectAsState()
    val shortDescription = viewModel.shortDescription.collectAsState()
    val timeOfArrival = viewModel.timeOfArrival.collectAsState()

    // Catalogues
    val catalogLocationType = catalogRepo.locationType.collectAsState(listOf())

    // Address
    val address = viewModel.address.collectAsState(initial = null)

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

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = if (showDocuModeButton) 70.dp else Padding.screen)
                .align(Alignment.TopCenter)
        ) {
            Containers.StandardAttributeContainer(
                uiStateHandler = uiStateHandler
            ) {
                // Documentation number
                TextFields.DocNumber(
                    docNumber = docNumber.value?.docNumberString
                        ?: MessageStrings.automaticAssignment(
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

                    SpacersAndDividers.VerticalSpacer()

                    // Time of arrival
                    if (editMode.value) {
                        DateAndTimePickers.DateTimePicker(
                            initDateTime = timeOfArrival.value?.dateTime,
                            label = TextFieldStrings.timeOfArrival(language.value)
                        ) {
                            viewModel.setTimeOfArrival(it?.toZonedDateTime())
                        }
                    } else {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextField(
                                value = timeOfArrival.value?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                                    ?: "",
                                label = { Label(text = TextFieldStrings.timeOfArrival(language.value)) },
                                enabled = false,
                                onValueChange = { },
                                modifier = Modifier.fillMaxWidth(0.6f)
                            )
                            SpacersAndDividers.HorizontalSpacer()
                            TextField(
                                value = timeOfArrival.value?.getFormattedTimeString() ?: "",
                                label = { Label(text = TextFieldStrings.time(language.value)) },
                                enabled = false,
                                onValueChange = { },
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    // Short description
                    // Currently not used -> users should create notes instead
                    /*
                    TextFields.MultilineString(
                        value = shortDescription.value,
                        label = TextFieldStrings.shortDescription(language.value),
                        enabled = editMode.value
                    ) {
                        viewModel.setShortDescription(it)
                    }
                     */
                }
            }
        }
    }
}