@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.nav.NavAction
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.PersonViewModel
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.SpacersAndDividers.VerticalSpacer
import p20.insitu.android.ui.components.datetime.DateAndTimePickers
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.entities.enums.PersonType
import p20.insitu.model.xpolizei.schema.KatalogCode255
import p20.insitu.resources.strings.MiscStrings
import p20.insitu.util.DefaultValues
import p20.insitu.util.toZonedDateTime

@Composable
fun PersonDetails(
    navigationState: MutableState<NavAction?>,
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: PersonViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val docuMode = uiStateHandler.docuMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Person fields
    val types = viewModel.types.collectAsState()
    val personalDetailsType = viewModel.personalDetailsType.collectAsState()
    val leadership = viewModel.leadership.collectAsState()
    val sex = viewModel.sex.collectAsState()
    val birthplace = viewModel.birthplace.collectAsState()
    val birthCounty = viewModel.birthCounty.collectAsState()
    val birthRegion = viewModel.birthRegion.collectAsState()
    val birthCountry = viewModel.birthCountry.collectAsState()
    val nationality = viewModel.nationality.collectAsState()
    val maritalStatus = viewModel.maritalStatus.collectAsState()
    val ethnicity = viewModel.ethnicity.collectAsState()
    val title = viewModel.title.collectAsState()
    val comment = viewModel.comment.collectAsState()
    val birthday = viewModel.birthday.collectAsState()
    val timeOfDeath = viewModel.timeOfDeath.collectAsState()
    val religion = viewModel.religion.collectAsState()
    val firstName = viewModel.firstName.collectAsState()
    val lastName = viewModel.lastName.collectAsState()
    val birthName = viewModel.birthName.collectAsState()
    val alias = viewModel.alias.collectAsState()
    val personalID = viewModel.personalID.collectAsState()
    val personalIDType = viewModel.personalIDType.collectAsState()
    val eMail = viewModel.eMail.collectAsState()
    val phoneNumber = viewModel.phoneNumber.collectAsState()
    val faxNumber = viewModel.faxNumber.collectAsState()

    // Catalogues
    val catalogCountry = catalogRepo.country.collectAsState(listOf())
    val catalogCountryOrArea = catalogRepo.countryOrArea.collectAsState(listOf())
    val catalogEthnicity = catalogRepo.ethnicity.collectAsState(listOf())
    val catalogMaritalStatus = catalogRepo.maritalStatus.collectAsState(listOf())
    val catalogPersonalIDType = catalogRepo.personalIDType.collectAsState(listOf())
    val catalogReligion = catalogRepo.religion.collectAsState(listOf())
    val catalogSex = catalogRepo.sex.collectAsState(listOf())
    val catalogTitle = catalogRepo.title.collectAsState(listOf())
    val catalogTypeOfPersonalDetails = catalogRepo.typeOfPersonalDetails.collectAsState(listOf())
    val catalogYesNo = catalogRepo.yesNo.collectAsState(listOf())

    Containers.StandardAttributeContainer(
        uiStateHandler = uiStateHandler
    ) {
        Containers.SimpleAttributeGroup(
            title = TitleStrings.personalDetails(language.value)
        ) {
            // First name
            TextFields.SingleLineString(
                value = firstName.value,
                label = TextFieldStrings.firstName(language.value),
                enabled = editMode.value
            ) {
                viewModel.setFirstName(it)
            }

            VerticalSpacer()

            // Last name
            TextFields.SingleLineString(
                value = lastName.value,
                label = TextFieldStrings.lastName(language.value),
                enabled = editMode.value
            ) {
                viewModel.setLastName(it)
            }

            VerticalSpacer()

            // Birth name
            TextFields.SingleLineString(
                value = birthName.value,
                label = TextFieldStrings.birthName(language.value),
                enabled = editMode.value
            ) {
                viewModel.setBirthName(it)
            }

            VerticalSpacer()

            // Birthday
            if (editMode.value) {
                DateAndTimePickers.DatePicker(
                    initDate = birthday.value?.dateTime?.date,
                    label = TextFieldStrings.birthday(language.value)
                ) {
                    viewModel.setBirthday(it?.toZonedDateTime())
                }
            } else {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = birthday.value?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                        ?: "",
                    label = { Text(text = TextFieldStrings.birthday(language.value)) },
                    enabled = false,
                    onValueChange = { }
                )
            }

            VerticalSpacer()

            // Sex
            Text(text = TextFieldStrings.sex(language.value))
            catalogSex.value.forEach { catalogCode ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        modifier = Modifier.size(30.dp),
                        selected = sex.value?.code ?: DefaultValues.sexCode == catalogCode.code,
                        onClick = {
                            viewModel.setSex(catalogCode as? CatalogCodeFixed<KatalogCode255>)
                        },
                        enabled = editMode.value
                    )
                    Text(text = catalogCode.name!!)
                }
            }
        }

        Containers.SimpleAttributeGroup(
            title = TitleStrings.contactDetails(language.value)
        ) {
            // Email
            TextFields.SingleLineString(
                value = eMail.value,
                label = TextFieldStrings.eMail(language.value),
                enabled = editMode.value
            ) {
                viewModel.setEmail(it)
            }

            VerticalSpacer()

            // Phone number
            TextFields.SingleLineString(
                value = phoneNumber.value,
                label = TextFieldStrings.phoneNumber(language.value),
                enabled = editMode.value
            ) {
                viewModel.setPhoneNumber(it)
            }

            VerticalSpacer()

            // Fax number
            TextFields.SingleLineString(
                value = faxNumber.value,
                label = TextFieldStrings.faxNumber(language.value),
                enabled = editMode.value
            ) {
                viewModel.setFaxNumber(it)
            }
        }

        Containers.SimpleAttributeGroup(
            title = TitleStrings.connectionToInvestigation(language.value)
        ) {
            // Person type
            PersonType.values().forEach { type ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        modifier = Modifier.size(30.dp),
                        checked = types.value.contains(type),
                        onCheckedChange = { checked ->
                            if (checked) {
                                viewModel.addType(type)
                            } else {
                                viewModel.removeType(type)
                            }
                        },
                        enabled = editMode.value
                    )
                    Text(text = MiscStrings.personType(type, language.value))
                }
            }
        }
    }
}