@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.entities.blocks.InvestigationHeader
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.strings.EntityTypeStrings

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
    val designation = viewModel.designation.collectAsState(EntityTypeStrings.typeString(EntityType.INVESTIGATION, language.value))
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
                ){
                    viewModel.setDesignation(it)
                }

                VerticalSpacer()

                // Type of process
                Text(text = TextFieldStrings.typeOfProcess(language.value))
                catalogTypeOfProcess.value.forEach { catalogCode ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.size(30.dp),
                            selected = typeOfProcess.value?.code ?: DefaultValues.typeOfProcessCode == catalogCode.code,
                            onClick = {
                                viewModel.setTypeOfProcess(catalogCode as? CatalogCodeFixed<KatalogCode123>)
                            },
                            enabled = editMode.value
                        )
                        Text(text = catalogCode.name!!)
                    }
                }

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