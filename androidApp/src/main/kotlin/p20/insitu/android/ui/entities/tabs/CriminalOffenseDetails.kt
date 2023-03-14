package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import p20.insitu.android.ui.components.DropdownField
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.autocomplete.AutoCompleteTextFields
import p20.insitu.android.ui.components.datetime.DateAndTimePickers
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.xpolizei.schema.KatalogCode121
import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.toZonedDateTime
import p20.insitu.viewmodels.entities.CriminalOffenseViewModel


@Composable
fun CriminalOffenseDetails(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: CriminalOffenseViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Entity fields
    val typeOfCrime = viewModel.typeOfCrime.collectAsState(null)
    val attempt = viewModel.attempt.collectAsState(null)
    val timeOfReporting = viewModel.timeOfReporting.collectAsState(null)
    val start = viewModel.start.collectAsState(null)
    val end = viewModel.end.collectAsState(null)
    val characteristics = viewModel.characteristics.collectAsState(listOf())

    // Catalogues
    val catalogTypeOfCrime = catalogRepo.typeOfCrime.collectAsState(listOf())
    val catalogYesNo = catalogRepo.yesNo.collectAsState(listOf())
    val catalogCrimeCharacteristics = catalogRepo.crimeCharacteristics.collectAsState(listOf())

    // AutoCompleteTextField drop down options
    val typeOfCrimeNames = catalogTypeOfCrime.value.map { it.name }
    val crimeCharacteristicsNames = catalogCrimeCharacteristics.value.mapNotNull { it.name }

    // AutoCompleteTextField search values
    val typeOfCrimeSearchText = remember { mutableStateOf("") }
    typeOfCrime.value?.let {
        if (!editMode.value) {
            typeOfCrimeSearchText.value = it.toString()
        } else if (typeOfCrimeSearchText.value.isBlank()) {
            typeOfCrimeSearchText.value = it.toString()
        }
    }
    val crimeCharacteristicsSearchText = remember { mutableStateOf("") }

    Containers.StandardAttributeContainer(
        uiStateHandler = uiStateHandler
    ) {
        Containers.SimpleAttributeGroup(
            title = TitleStrings.description(language.value),
            paddingTop = 0.dp
        ) {
            // Type of crime
            if (editMode.value) {
                AutoCompleteTextFields.StringValue(
                    label = TextFieldStrings.criminalOffenseType(language.value),
                    value = typeOfCrimeSearchText.value,
                    items = typeOfCrimeNames,
                    enabled = true,
                    language = language.value,
                    onValueChanged = {
                        typeOfCrimeSearchText.value = it
                        viewModel.setTypeOfCrime(
                            catalogTypeOfCrime.value.firstOrNull { catalogCode -> catalogCode.name == it }
                                    as? CatalogCodeFixed<KatalogCode121>
                        )
                    }
                )
            } else {
                TextField(
                    value = typeOfCrime.value?.toString() ?: "",
                    enabled = false,
                    onValueChange = {},
                    label = { Label(text = TextFieldStrings.criminalOffenseType(language.value)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            SpacersAndDividers.VerticalSpacer()

            // Attempt
            if (editMode.value) {
                DropdownField.CatalogList(
                    label = TextFieldStrings.attempt(language.value),
                    value = attempt.value,
                    list = catalogYesNo.value,
                    enabled = editMode.value,
                    language = language.value
                ) {
                    viewModel.setAttempt(it as? CatalogCodeFixed<KatalogCode217>)
                }
            } else {
                TextField(
                    value = attempt.value?.toString() ?: "",
                    enabled = false,
                    onValueChange = {},
                    label = { Label(text = TextFieldStrings.attempt(language.value)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }


            SpacersAndDividers.VerticalSpacer()

            // Crime characteristics
            val mutableCharacteristicsList = characteristics.value.toMutableList()
            DropdownField.SearchableMultiDropDownPicker(
                editMode = editMode.value,
                searchText = crimeCharacteristicsSearchText.value,
                values = characteristics.value,
                itemNames = crimeCharacteristicsNames,
                label = TextFieldStrings.crimeCharacteristics(language.value),
                language = language.value,
                onValueChanged = {
                    crimeCharacteristicsSearchText.value = it
                },
                onItemSelect = {
                    catalogCrimeCharacteristics.value.firstOrNull { catalogCode -> catalogCode.name == it }
                        ?.let { category ->
                            if (!mutableCharacteristicsList.map { it.code }
                                    .contains(category.code)) {
                                mutableCharacteristicsList.add(category)
                                viewModel.setCharacteristics(mutableCharacteristicsList)
                            }
                            crimeCharacteristicsSearchText.value = ""
                        }
                },
                onDelete = {
                    mutableCharacteristicsList.removeAt(it)
                    viewModel.setCharacteristics(mutableCharacteristicsList)
                },
            )

            SpacersAndDividers.VerticalSpacer()

            // Time of reporting
            if (editMode.value) {
                DateAndTimePickers.DateTimePicker(
                    initDateTime = timeOfReporting.value?.dateTime,
                    label = TextFieldStrings.timeOfReporting(language.value)
                ) {
                    viewModel.setTimeOfReporting(it?.toZonedDateTime())
                }
            } else {
                Row(modifier = Modifier.fillMaxWidth()) {
                    TextField(
                        value = timeOfReporting.value?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                            ?: "",
                        label = { Label(text = TextFieldStrings.timeOfReporting(language.value)) },
                        enabled = false,
                        onValueChange = { },
                        modifier = Modifier.fillMaxWidth(0.6f)
                    )
                    SpacersAndDividers.HorizontalSpacer()
                    TextField(
                        value = timeOfReporting.value?.getFormattedTimeString() ?: "",
                        label = { Label(text = TextFieldStrings.time(language.value)) },
                        enabled = false,
                        onValueChange = { }
                    )
                }
            }
        }

        Containers.SimpleAttributeGroup(
            title = TitleStrings.crimeTime(language.value)
        ) {

            // Start time
            if (editMode.value) {
                DateAndTimePickers.DateTimePicker(
                    initDateTime = start.value?.dateTime,
                    label = TextFieldStrings.startDateTime(language.value)
                ) {
                    viewModel.setStart(it?.toZonedDateTime())
                }
            } else {
                Row(modifier = Modifier.fillMaxWidth()) {
                    TextField(
                        value = start.value?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                            ?: "",
                        label = { Label(text = TextFieldStrings.startDateTime(language.value)) },
                        enabled = false,
                        onValueChange = { },
                        modifier = Modifier.fillMaxWidth(0.6f)
                    )
                    SpacersAndDividers.HorizontalSpacer()
                    TextField(
                        value = start.value?.getFormattedTimeString() ?: "",
                        label = { Label(text = TextFieldStrings.time(language.value)) },
                        enabled = false,
                        onValueChange = { }
                    )
                }
            }

            SpacersAndDividers.VerticalSpacer()

            // End time
            if (editMode.value) {
                DateAndTimePickers.DateTimePicker(
                    initDateTime = end.value?.dateTime,
                    label = TextFieldStrings.endDateTime(language.value)
                ) {
                    viewModel.setEnd(it?.toZonedDateTime())
                }
            } else {
                Row(modifier = Modifier.fillMaxWidth()) {
                    TextField(
                        value = end.value?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                            ?: "",
                        label = { Label(text = TextFieldStrings.endDateTime(language.value)) },
                        enabled = false,
                        onValueChange = { },
                        modifier = Modifier.fillMaxWidth(0.6f)
                    )
                    SpacersAndDividers.HorizontalSpacer()
                    TextField(
                        value = end.value?.getFormattedTimeString() ?: "",
                        label = { Label(text = TextFieldStrings.time(language.value)) },
                        enabled = false,
                        onValueChange = { }
                    )
                }
            }
        }
    }
}