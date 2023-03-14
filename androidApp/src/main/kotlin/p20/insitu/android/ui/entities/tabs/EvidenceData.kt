@file:Suppress("UNCHECKED_CAST", "OPT_IN_USAGE")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.DropdownField
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.autocomplete.AutoCompleteTextFields
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.entities.DNATrace
import p20.insitu.model.entities.PhysicalTrace
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.EvidenceDataViewModel

@Composable
fun EvidenceData(
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: EvidenceDataViewModel<*>
) {
    // UiStateHandler states
    val newEntity = uiStateHandler.newEntity.collectAsState()
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    val evidence = viewModel.entity.collectAsState()

    // Evidence data fields
    val securedByUserId = viewModel.securedByUserId.collectAsState()
    val documentedByUserId = viewModel.documentedByUserId.collectAsState()
    val securingTimestamp = viewModel.securingTimestamp.collectAsState()
    val barcodes = viewModel.barcodes.collectAsState()
    val externalSystemId = viewModel.externalSystemId.collectAsState()
    val suspectedTraceCarrier = viewModel.suspectedTraceCarrier.collectAsState()
    val securingMethod = viewModel.securingMethod.collectAsState()
    val purposeOfSecuring = viewModel.purposeOfSecuring.collectAsState()
    val damagePermission = viewModel.damagePermission.collectAsState()
    val forensicAnalysis = viewModel.forensicAnalysis.collectAsState()
    val hazardWarning = viewModel.hazardWarning.collectAsState()
    val transportAndStorageAdvice = viewModel.transportAndStorageAdvice.collectAsState()
    val storageStatus = viewModel.storageStatus.collectAsState()
    val unDangerousGoodsNumber = viewModel.unDangerousGoodsNumber.collectAsState()
    val dangerousGoodsNumber = viewModel.dangerousGoodsNumber.collectAsState()

    // Catalogues
    val catalogSecuringMethod = catalogRepo.securingMethod.collectAsState(listOf())
    val catalogPurposeOfSecuring = catalogRepo.purposeOfSecuring.collectAsState(listOf())
    val catalogYesNo = catalogRepo.yesNo.collectAsState(listOf())
    val catalogStorageStatus = catalogRepo.storageStatus.collectAsState(listOf())
    val catalogUnDangerousGoodsNumber =
        catalogRepo.unDangerousGoodsNumber.collectAsState(listOf())
    val catalogDangerousGoodsNumber = catalogRepo.dangerousGoodsNumber.collectAsState(listOf())

    // AutoCompleteTextField drop down options
    val unDangerousGoodsNumbers = catalogUnDangerousGoodsNumber.value.map { it.name }
    val dangerousGoodsNumbers = catalogDangerousGoodsNumber.value.map { it.name }

    // AutoCompleteTextField search values
    val unDangerousGoodsNumberSearchText = remember { mutableStateOf("") }
    unDangerousGoodsNumber.value?.let {
        if (!editMode.value) {
            unDangerousGoodsNumberSearchText.value = it.toString()
        } else if (unDangerousGoodsNumberSearchText.value.isBlank()) {
            unDangerousGoodsNumberSearchText.value = it.toString()
        }
    }
    val dangerousGoodsNumberSearchText = remember { mutableStateOf("") }
    dangerousGoodsNumber.value?.let {
        if (!editMode.value) {
            dangerousGoodsNumberSearchText.value = it.toString()
        } else if (dangerousGoodsNumberSearchText.value.isBlank()) {
            dangerousGoodsNumberSearchText.value = it.toString()
        }
    }

    val isTrace = remember { evidence.value is PhysicalTrace || evidence.value is DNATrace}
    val secureAsEvidence = remember { mutableStateOf(evidence.value?.evidenceData != null) }
    if(isTrace){
        viewModel.setSecureAsEvidence(true)
    }

    Containers.StandardAttributeContainer(uiStateHandler = uiStateHandler) {
        // We show the switch when we are in edit mode and the object is not yet secured
        // We do not need to show the switch when we are creating a physical trace object, these are
        // always going to be secured
        if (editMode.value && evidence.value?.evidenceData == null && !isTrace) {
            Switches.SecureAsEvidence(
                language = language.value,
                securingSelected = secureAsEvidence.value
            ) { switchState ->
                secureAsEvidence.value = switchState
                viewModel.setSecureAsEvidence(switchState)
            }
            SpacersAndDividers.VerticalSpacer()
        }

        if (!editMode.value && evidence.value?.evidenceData == null) {
            Text(
                modifier = Modifier.padding(top = Padding.large),
                text = MessageStrings.notSecuredAsEvidence(language.value),
                style = MaterialTheme.typography.h6
            )
        } else if (evidence.value?.evidenceData != null || (editMode.value && secureAsEvidence.value)) {
            Containers.SimpleAttributeGroup(
                title = TitleStrings.securingEvidence(language.value)
            ) {
                // Securing timestamp
                Row(modifier = Modifier.fillMaxWidth()) {
                    TextField(
                        value = securingTimestamp.value?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                            ?: "",
                        label = { Label(text = TextFieldStrings.securingTimestamp(language.value)) },
                        enabled = false,
                        onValueChange = { },
                        modifier = Modifier.fillMaxWidth(0.6f)
                    )

                    SpacersAndDividers.HorizontalSpacer()

                    TextField(
                        value = securingTimestamp.value?.getFormattedTimeString() ?: "",
                        label = { Label(text = TextFieldStrings.time(language.value)) },
                        enabled = false,
                        onValueChange = { }
                    )
                }

                SpacersAndDividers.VerticalSpacer()

                // Securing method
                if (editMode.value) {
                    DropdownField.CatalogList(
                        label = TextFieldStrings.securingMethod(language.value),
                        value = securingMethod.value,
                        list = catalogSecuringMethod.value,
                        enabled = editMode.value,
                        language = language.value
                    ) {
                        viewModel.setSecuringMethod(it as? CatalogCodeNotComplete<KatalogCode405_NichtAbgeschlossen>)
                    }
                } else {
                    TextField(
                        value = securingMethod.value?.toString() ?: "",
                        enabled = false,
                        onValueChange = {},
                        label = { Label(text = TextFieldStrings.securingMethod(language.value)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                SpacersAndDividers.VerticalSpacer()

                // Purpose of securing
                val mutablePurposeOfSecuringList = purposeOfSecuring.value.toMutableList()
                DropdownField.MultiDropDownPicker(
                    editMode = editMode.value,
                    values = purposeOfSecuring.value,
                    list = catalogPurposeOfSecuring.value,
                    label = TextFieldStrings.purposeOfSecuring(language.value),
                    language = language.value,
                    onItemSelect = { catalogCode ->
                        (catalogCode as? CatalogCodeFixed<KatalogCode369>)?.let {
                            if (!purposeOfSecuring.value.map { it.code }.contains(it.code)) {
                                mutablePurposeOfSecuringList.add(it)
                                viewModel.setPurposeOfSecuring(mutablePurposeOfSecuringList)
                            }
                        }
                    },
                    onDelete = {
                        mutablePurposeOfSecuringList.removeAt(it)
                        viewModel.setPurposeOfSecuring(mutablePurposeOfSecuringList)
                    },
                )

                SpacersAndDividers.VerticalSpacer()

                // Suspected trace carrier
                if (editMode.value) {
                    DropdownField.CatalogList(
                        label = TextFieldStrings.suspectedTraceCarrier(language.value),
                        value = suspectedTraceCarrier.value?.let { suspected ->
                            catalogYesNo.value.firstOrNull { it.code == (if (suspected) "217_1" else "217_2") }
                        },
                        list = catalogYesNo.value,
                        enabled = editMode.value,
                        language = language.value
                    ) {
                        viewModel.setSuspectedTraceCarrier(it?.code == "217_1") // "Ja"
                    }
                } else {
                    TextField(
                        value = suspectedTraceCarrier.value?.let { suspected ->
                            catalogYesNo.value.firstOrNull { it.code == (if (suspected) "217_1" else "217_2") }
                        }?.toString() ?: "",
                        enabled = false,
                        onValueChange = {},
                        label = { Label(text = TextFieldStrings.suspectedTraceCarrier(language.value)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                SpacersAndDividers.VerticalSpacer()

                // Forensic analysis
                if (editMode.value) {
                    DropdownField.CatalogList(
                        label = TextFieldStrings.forensicAnalysis(language.value),
                        value = forensicAnalysis.value,
                        list = catalogYesNo.value,
                        enabled = editMode.value,
                        language = language.value
                    ) {
                        viewModel.setForensicAnalysis(it as? CatalogCodeFixed<KatalogCode217>)
                    }
                } else {
                    TextField(
                        value = forensicAnalysis.value?.toString() ?: "",
                        enabled = false,
                        onValueChange = {},
                        label = { Label(text = TextFieldStrings.forensicAnalysis(language.value)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                SpacersAndDividers.VerticalSpacer()

                // Damage permission
                if (editMode.value) {
                    DropdownField.CatalogList(
                        label = TextFieldStrings.damagePermission(language.value),
                        value = damagePermission.value,
                        list = catalogYesNo.value,
                        enabled = editMode.value,
                        language = language.value
                    ) {
                        viewModel.setDamagePermission(it as? CatalogCodeFixed<KatalogCode217>)
                    }
                } else {
                    TextField(
                        value = damagePermission.value?.toString() ?: "",
                        enabled = false,
                        onValueChange = {},
                        label = { Label(text = TextFieldStrings.damagePermission(language.value)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Containers.SimpleAttributeGroup(
                title = TitleStrings.transportAndStorage(language.value)
            ) {
                // Hazard warning
                TextFields.SingleLineString(
                    value = hazardWarning.value,
                    label = TextFieldStrings.hazardWarning(language.value),
                    enabled = editMode.value
                ) {
                    viewModel.setHazardWarning(it)
                }

                SpacersAndDividers.VerticalSpacer()

                // Transport and storage advice
                TextFields.SingleLineString(
                    value = transportAndStorageAdvice.value,
                    label = TextFieldStrings.transportAndStorageAdvice(language.value),
                    enabled = editMode.value
                ) {
                    viewModel.setTransportAndStorageAdvice(it)
                }

                SpacersAndDividers.VerticalSpacer()

                // Storage status
                if (editMode.value) {
                    DropdownField.CatalogList(
                        label = TextFieldStrings.storageStatus(language.value),
                        value = storageStatus.value,
                        list = catalogStorageStatus.value,
                        enabled = editMode.value,
                        language = language.value
                    ) {
                        viewModel.setStorageStatus(it as? CatalogCodeFixed<KatalogCode331>)
                    }
                } else {
                    TextField(
                        value = storageStatus.value?.toString() ?: "",
                        enabled = false,
                        onValueChange = {},
                        label = { Label(text = TextFieldStrings.storageStatus(language.value)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                SpacersAndDividers.VerticalSpacer()

                // UN dangerous goods number
                if (editMode.value) {
                    AutoCompleteTextFields.StringValue(
                        label = TextFieldStrings.unDangerousGoodsNumber(language.value),
                        value = unDangerousGoodsNumberSearchText.value,
                        items = unDangerousGoodsNumbers,
                        enabled = true,
                        language = language.value,
                        onValueChanged = {
                            unDangerousGoodsNumberSearchText.value = it
                            viewModel.setUnDangerousGoodsNumber(
                                catalogUnDangerousGoodsNumber.value.firstOrNull { catalogCode -> catalogCode.name == it }
                                        as? CatalogCodeFixed<KatalogCode349>
                            )
                        }
                    )
                } else {
                    TextField(
                        value = unDangerousGoodsNumber.value?.toString() ?: "",
                        enabled = false,
                        onValueChange = {},
                        label = { Label(text = TextFieldStrings.unDangerousGoodsNumber(language.value)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                SpacersAndDividers.VerticalSpacer()

                // Federal dangerous goods number
                if (editMode.value) {
                    AutoCompleteTextFields.StringValue(
                        label = TextFieldStrings.dangerousGoodsNumber(language.value),
                        value = dangerousGoodsNumberSearchText.value,
                        items = dangerousGoodsNumbers,
                        enabled = true,
                        language = language.value,
                        onValueChanged = {
                            dangerousGoodsNumberSearchText.value = it
                            viewModel.setDangerousGoodsNumber(
                                catalogDangerousGoodsNumber.value.firstOrNull { catalogCode -> catalogCode.name == it }
                                        as? CatalogCodeFixed<KatalogCode395>
                            )
                        }
                    )
                } else {
                    TextField(
                        value = dangerousGoodsNumber.value?.toString() ?: "",
                        enabled = false,
                        onValueChange = {},
                        label = { Label(text = TextFieldStrings.dangerousGoodsNumber(language.value)) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Containers.SimpleAttributeGroup(title = TitleStrings.relatedIDs(language.value)) {
                // External system ID
                TextFields.SingleLineString(
                    value = externalSystemId.value?.id,
                    label = TextFieldStrings.externalSystemId(
                        externalSystemId.value?.systemName,
                        language.value
                    ),
                    enabled = false
                ) {}

                SpacersAndDividers.VerticalSpacer()

                // Secured by user
                // TODO drop down field with available users
                TextFields.SingleLineString(
                    value = sessionHandler.userInfo.value?.username ?: "",
                    label = TextFieldStrings.securedBy(language.value),
                    enabled = false
                ) {}

                SpacersAndDividers.VerticalSpacer()

                // Documented by user
                // TODO drop down field with available users
                TextFields.SingleLineString(
                    value = sessionHandler.userInfo.value?.username ?: "",
                    label = TextFieldStrings.documentedBy(language.value),
                    enabled = false
                ) {}

                //SpacersAndDividers.VerticalSpacer()

                // TODO Barcodes
                //TextFields.ToDo("Barcode")
            }
        }
    }
}