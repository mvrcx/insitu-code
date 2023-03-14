package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import p20.insitu.android.ui.components.Containers
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.Text
import p20.insitu.android.ui.components.TextFields
import p20.insitu.android.ui.components.autocomplete.AutoCompleteTextFields
import p20.insitu.android.ui.components.buttons.IconButtons
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode321
import p20.insitu.model.xpolizei.schema.KatalogCode371
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.CrimeSceneViewModel

@Composable
fun CrimeSceneAddressDetails(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: CrimeSceneViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Address fields
    val comment = viewModel.comment.collectAsState()
    val street = viewModel.street.collectAsState()
    val houseNumber = viewModel.houseNumber.collectAsState()
    val district = viewModel.district.collectAsState()
    val streetCode = viewModel.streetCode.collectAsState()
    val alternativeAddress = viewModel.alternativeAddress.collectAsState()
    val city = viewModel.city.collectAsState()
    val postalCode = viewModel.postalCode.collectAsState()
    val country = viewModel.country.collectAsState()
    val municipalityCode = viewModel.municipalityCode.collectAsState()
    val county = viewModel.county.collectAsState()
    val regionCode = viewModel.regionCode.collectAsState()
    val federalState = viewModel.federalState.collectAsState()
    val geolocation = viewModel.geolocation.collectAsState()
    val region = viewModel.region.collectAsState()

    // Catalogues
    val catalogCountry = catalogRepo.countryOrArea.collectAsState(listOf())
    val catalogMunicipalityCode = catalogRepo.municipalityCode.collectAsState(listOf())
    val catalogFederalState = catalogRepo.federalState.collectAsState(listOf())

    // AutoCompleteTextField drop down options
    val countryNames = catalogCountry.value.mapNotNull { it.name }.sorted()
    val municipalityCodeNames = catalogMunicipalityCode.value.mapNotNull { it.name }.sorted()
    val federalStateNames = catalogFederalState.value.mapNotNull { it.name }.sorted()

    // AutoCompleteTextField search values
    val countrySearchText = remember { mutableStateOf("") }
    country.value?.let {
        if (!editMode.value) {
            countrySearchText.value = it.toString()
        } else if (countrySearchText.value.isBlank()) {
            countrySearchText.value = it.toString()
        }
    }
    val municipalityCodeSearchText = remember { mutableStateOf("") }
    municipalityCode.value?.let {
        if (!editMode.value) {
            municipalityCodeSearchText.value = it.toString()
        } else if (municipalityCodeSearchText.value.isBlank()) {
            municipalityCodeSearchText.value = it.toString()
        }
    }
    val federalStateSearchText = remember { mutableStateOf("") }
    federalState.value?.let {
        if (!editMode.value) {
            federalStateSearchText.value = it.toString()
        } else if (federalStateSearchText.value.isBlank()) {
            federalStateSearchText.value = it.toString()
        }
    }

    Containers.StandardAttributeContainer(
        uiStateHandler = uiStateHandler
    ) {
        Containers.SimpleAttributeGroup(
            title = TitleStrings.postalAddress(language.value)
        ) {
            // Street
            TextFields.SingleLineString(
                value = street.value,
                label = TextFieldStrings.street(language.value),
                enabled = editMode.value
            ) {
                viewModel.setStreet(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // House number
            TextFields.SingleLineString(
                value = houseNumber.value,
                label = TextFieldStrings.houseNumber(language.value),
                enabled = editMode.value
            ) {
                viewModel.setHouseNumber(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Postal code
            TextFields.SingleLineString(
                value = postalCode.value,
                label = TextFieldStrings.postalCode(language.value),
                enabled = editMode.value
            ) {
                viewModel.setPostalCode(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // City
            TextFields.SingleLineString(
                value = city.value,
                label = TextFieldStrings.city(language.value),
                enabled = editMode.value
            ) {
                viewModel.setCity(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Country
            @Suppress("UNCHECKED_CAST")
            if (editMode.value) {
                AutoCompleteTextFields.StringValue(
                    label = TextFieldStrings.country(language.value),
                    value = countrySearchText.value,
                    items = countryNames,
                    enabled = true,
                    language = language.value,
                    onValueChanged = {
                        countrySearchText.value = it
                        viewModel.setCountry(
                            catalogCountry.value.firstOrNull { catalogCode -> catalogCode.name == it }
                        )
                    }
                )
            } else {
                TextField(
                    value = country.value?.toString() ?: "",
                    enabled = false,
                    onValueChange = {},
                    label = { Text.Label(text = TextFieldStrings.country(language.value)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Containers.SimpleAttributeGroup(
            title = TitleStrings.geolocation(language.value)
        ) {
            // Geolocation
            TextField(
                value = geolocation.value?.toString() ?: "",
                label = { Text.Label(text = TextFieldStrings.coordinates(language.value)) },
                onValueChange = { },
                enabled = editMode.value,
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    if (editMode.value) {
                        IconButtons.Location(language = language.value) {
                            // TODO get current GPS Location
                            // goToMapView()
                        }
                    }
                }
            )
        }

        Containers.CollapsableAttributeGroup(
            title = TitleStrings.administrativeEncoding(language.value),
            language = language.value,
            initiallyCollapsed = !editMode.value
        ) {
            // Street code
            TextFields.SingleLineString(
                value = streetCode.value,
                label = TextFieldStrings.streetCode(language.value),
                enabled = editMode.value
            ) {
                viewModel.setStreetCode(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // District
            TextFields.SingleLineString(
                value = district.value,
                label = TextFieldStrings.district(language.value),
                enabled = editMode.value
            ) {
                viewModel.setDistrict(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // County
            TextFields.SingleLineString(
                value = county.value,
                label = TextFieldStrings.county(language.value),
                enabled = editMode.value
            ) {
                viewModel.setCounty(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Municipality code
            if (editMode.value) {
                AutoCompleteTextFields.StringValue(
                    label = TextFieldStrings.municipalityCode(language.value),
                    value = municipalityCodeSearchText.value,
                    items = municipalityCodeNames,
                    enabled = true,
                    language = language.value,
                    onValueChanged = {
                        municipalityCodeSearchText.value = it
                        @Suppress("UNCHECKED_CAST")
                        viewModel.setMunicipalityCode(
                            catalogMunicipalityCode.value.firstOrNull { catalogCode -> catalogCode.name == it }
                                    as? CatalogCodeFixed<KatalogCode371>
                        )
                    }
                )
            } else {
                TextField(
                    value = municipalityCode.value?.toString() ?: "",
                    enabled = false,
                    onValueChange = {},
                    label = { Text.Label(text = TextFieldStrings.municipalityCode(language.value)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            SpacersAndDividers.VerticalSpacer()

            // Region
            TextFields.SingleLineString(
                value = region.value,
                label = TextFieldStrings.region(language.value),
                enabled = editMode.value
            ) {
                viewModel.setRegion(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Region code
            TextFields.SingleLineString(
                value = regionCode.value,
                label = TextFieldStrings.regionCode(language.value),
                enabled = editMode.value
            ) {
                viewModel.setRegionCode(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Federal state
            if (editMode.value) {
                AutoCompleteTextFields.StringValue(
                    label = TextFieldStrings.federalState(language.value),
                    value = federalStateSearchText.value,
                    items = federalStateNames,
                    enabled = true,
                    language = language.value,
                    onValueChanged = {
                        federalStateSearchText.value = it
                        @Suppress("UNCHECKED_CAST")
                        viewModel.setFederalState(
                            catalogFederalState.value.firstOrNull { catalogCode -> catalogCode.name == it }
                                    as? CatalogCodeFixed<KatalogCode321>
                        )
                    }
                )
            } else {
                TextField(
                    value = federalState.value?.toString() ?: "",
                    enabled = false,
                    onValueChange = {},
                    label = { Text.Label(text = TextFieldStrings.federalState(language.value)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Containers.CollapsableAttributeGroup(
            title = TitleStrings.additionalInformation(language.value),
            language = language.value,
            initiallyCollapsed = !editMode.value
        ) {
            // Comment
            TextFields.SingleLineString(
                value = comment.value,
                label = TextFieldStrings.comment(language.value),
                enabled = editMode.value
            ) {
                viewModel.setComment(it)
            }

            SpacersAndDividers.VerticalSpacer()

            // Alternative address
            TextFields.SingleLineString(
                value = alternativeAddress.value,
                label = TextFieldStrings.alternativeAddress(language.value),
                enabled = editMode.value
            ) {
                viewModel.setAlternativeAddress(it)
            }
        }
    }
}
