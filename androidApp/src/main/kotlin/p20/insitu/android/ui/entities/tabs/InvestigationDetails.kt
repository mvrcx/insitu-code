@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.util.DefaultValues
import p20.insitu.viewmodels.entities.InvestigationViewModel
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.SpacersAndDividers.VerticalSpacer
import p20.insitu.android.ui.components.autocomplete.AutoCompleteTextFields
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.entities.blocks.InvestigationHeader
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.EntityTypeStrings

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InvestigationDetails(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    entityCreation: Boolean,
    viewModel: InvestigationViewModel
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Entity fields
    val investigation = viewModel.entity.collectAsState()
    val number = viewModel.number.collectAsState(null)
    val designation = viewModel.designation.collectAsState(
        EntityTypeStrings.typeString(
            EntityType.INVESTIGATION,
            language.value
        )
    )
    val startDate = viewModel.startDate.collectAsState(null)
    val typeOfProcess = viewModel.typeOfProcess.collectAsState(null)
    val keywords = viewModel.keywords.collectAsState(listOf())
    val comment = viewModel.comment.collectAsState(null)

    // Catalogues
    val catalogTypeOfProcess = catalogRepo.typeOfProcess.collectAsState(listOf())

    // Content
    if (investigation.value == null) {
        LoadingAnimations.StandardLoadingAnimation()
    } else {
        Containers.StandardAttributeContainer(
            uiStateHandler = uiStateHandler
        ) {
            // Investigation header
            InvestigationHeader(
                investigationNumber = number.value,
                zonedDateTime = startDate.value,
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

                VerticalSpacer()


                // Type of process
                Text(text = TextFieldStrings.typeOfProcess(language.value))
                //Text(text = typeOfProcess.value.toString())

                // ExposedDropdownMenu
                /* MISSING FEATURE
                - Art des Vorgangs muss nach dem Speichern stehen bleiben
                */
                val options = listOf("Vorgang zur Gefahrenabwehr", "Vorgang zur Strafverfolgung", "Sammelvorgang", "Registervorgang", "Vorgang zur OWi-Verfolgung")
                var expanded by remember { mutableStateOf(false) }
                var selectedOptionText by remember { mutableStateOf(options[0]) }
                // We want to react on tap/press on TextField to show menu
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    },
                ) {
                    OutlinedTextField(
                        readOnly = true,
                        value = selectedOptionText,
                        onValueChange = { },
                        label = { Text(text = TextFieldStrings.typeOfProcess(language.value)) },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        enabled = editMode.value,
                        modifier = Modifier.fillMaxWidth(),
                        )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        catalogTypeOfProcess.value.forEach { catalogCode ->
                            DropdownMenuItem(
                                modifier = Modifier.fillMaxWidth(),
                                enabled = editMode.value,
                                onClick = {
                                selectedOptionText = catalogCode.name
                                expanded = false
                                viewModel.setTypeOfProcess(catalogCode as? CatalogCodeFixed<KatalogCode123>)
                                },
                            ) {
                                Text(text = catalogCode.name)
                            }
                        }
                    }
                }



                            /*Radio Box
                catalogTypeOfProcess.value.forEach { catalogCode ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.size(30.dp),
                            selected = (typeOfProcess.value?.code
                                ?: DefaultValues.typeOfProcessCode) == catalogCode.code,
                            onClick = {
                                viewModel.setTypeOfProcess(catalogCode as? CatalogCodeFixed<KatalogCode123>)
                            },
                            enabled = editMode.value
                        )
                        Text(text = catalogCode.name!!)
                    }
                }*/

                            VerticalSpacer()

                            // Keywords
                            TextFields.Keywords(
                                keywords = keywords.value.toMutableList(),
                                enabled = editMode.value,
                                language = language.value
                            ) {
                                viewModel.setKeywords(it)
                            }

//            VerticalSpacer()
//
//            Chips.Keyword(
//                text = "HelloWorld",
//                editMode = editMode.value,
//                language = language.value
//            ) {
//
//            }

                            VerticalSpacer()

                            // Comment
                            TextFields.MultilineString(
                                value = comment.value,
                                label = TextFieldStrings.comment(language.value),
                                enabled = editMode.value
                            ) {
                                viewModel.setComment(it)
                            }

                        }
                    }
                }
            }
