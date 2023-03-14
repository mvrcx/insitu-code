package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.autocomplete.AutoCompleteTextFields
import p20.insitu.android.ui.components.buttons.IconButtons
import p20.insitu.model.components.CatalogCode
import p20.insitu.resources.Language
import p20.insitu.resources.strings.IconContentDescriptions

object DropdownField {

    @Composable
    fun SearchableMultiDropDownPicker(
        searchText: String,
        values: List<CatalogCode>,
        itemNames: List<String>,
        label: String,
        editMode: Boolean,
        language: Language,
        onValueChanged: (String) -> Unit,
        onItemSelect: (String) -> Unit,
        onDelete: (Int) -> Unit
    ) {
        if (editMode) {
            AutoCompleteTextFields.StringValue(
                label = label,
                value = searchText,
                items = itemNames,
                enabled = true,
                language = language,
                onValueChanged = {
                    onValueChanged(it)
                },
                onItemSelect = {
                    onItemSelect(it)
                }
            )
            p20.insitu.android.ui.components.SpacersAndDividers.VerticalSpacer()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
                    .padding(horizontal = p20.insitu.android.ui.components.dimen.Padding.screen)
                    .verticalScroll(rememberScrollState())
            ) {
                values.forEachIndexed { index, value ->
                    if (index > 0) {
                        p20.insitu.android.ui.components.SpacersAndDividers.VerticalSpacer(height = p20.insitu.android.ui.components.dimen.Spacing.small)
                    }
                    OutlinedButton(
                        onClick = {
                            onDelete(index)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = value.toString(),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        Spacer(modifier = Modifier.width(p20.insitu.android.ui.components.dimen.Padding.xsmall))
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = IconContentDescriptions.delete(language)
                        )
                    }
                }
            }
        } else {
            p20.insitu.android.ui.components.TextFields.MultilineString(
                value = values.joinToString("; ") { it.toString() },
                label = label,
                enabled = false
            )
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun MultiDropDownPicker(
        label: String,
        values: List<CatalogCode>,
        list: List<CatalogCode>,
        editMode: Boolean,
        language: Language,
        onItemSelect: (CatalogCode?) -> Unit,
        onDelete: (Int) -> Unit
    ) {
        if (editMode) {
            // State objects to keep track of the selected item and the drop down expansion
            val isOpen = remember { mutableStateOf(false) } // initial value

            ExposedDropdownMenuBox(
                expanded = isOpen.value,
                onExpandedChange = { isOpen.value = !isOpen.value },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextField(
                    readOnly = true,
                    value = "",
                    enabled = true,
                    onValueChange = {},
                    label = { Label(text = label) },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = isOpen.value
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = isOpen.value,
                    onDismissRequest = {
                        isOpen.value = false
                    }
                ) {
                    list.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                onItemSelect(selectionOption)
                                isOpen.value = false
                            }
                        ) {
                            Text(text = selectionOption.toString())
                        }
                    }
                }
            }
            p20.insitu.android.ui.components.SpacersAndDividers.VerticalSpacer()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp)
                    .padding(horizontal = p20.insitu.android.ui.components.dimen.Padding.screen)
                    .verticalScroll(rememberScrollState())
            ) {
                values.forEachIndexed { index, value ->
                    if (index > 0) {
                        p20.insitu.android.ui.components.SpacersAndDividers.VerticalSpacer(height = p20.insitu.android.ui.components.dimen.Spacing.small)
                    }
                    OutlinedButton(
                        onClick = {
                            onDelete(index)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = value.toString(),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        Spacer(modifier = Modifier.width(p20.insitu.android.ui.components.dimen.Padding.xsmall))
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = IconContentDescriptions.delete(language)
                        )
                    }
                }
            }
        } else {
            p20.insitu.android.ui.components.TextFields.MultilineString(
                value = values.joinToString("; ") { it.toString() },
                label = label,
                enabled = false
            )
        }
    }

    /**
     * DropDown field that can hold a list of strings.
     *
     * CAUTION: This is very slow when used with more than a few list items.
     * This is a known issue. Currently no fix intended.
     * See for example:
     * https://stackoverflow.com/questions/72001258/dropdownmenu-frame-drops-and-lags-in-jetpack-compose
     * https://issuetracker.google.com/issues/203328119
     * Workaround: Use AutoCompleteTextField.StringValue or make a custom implementation of
     * ExposedDropDownMenuBox that utilizes LazyColumn (which would likely increase performance).
     *
     * @param label The label of the drop down field.
     * @param value The initial value of the field.
     * @param list The list of strings, i.e. drop down options.
     * @param onValueChanged Callback that is triggered when a drop down option is selected.
     */
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun StringList(
        label: String,
        value: String?,
        list: List<String>,
        enabled: Boolean,
        language: Language,
        onValueChanged: (String?) -> Unit
    ) {
        // State objects to keep track of the selected item and the drop down expansion
        val isOpen = remember { mutableStateOf(false) } // initial value
        val selectedItem = remember { mutableStateOf(value) }
        val setSelectedItem: (String?) -> Unit = {
            selectedItem.value = it
            onValueChanged(it)
            isOpen.value = false
        }

        ExposedDropdownMenuBox(
            expanded = isOpen.value,
            onExpandedChange = { isOpen.value = !isOpen.value },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = selectedItem.value ?: "",
                enabled = enabled,
                onValueChange = {},
                label = { Label(text = label) },
                trailingIcon = {
                    if (selectedItem.value != null) {
                        IconButtons.Clear(language) {
                            setSelectedItem(null)
                        }
                    } else {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = isOpen.value
                        )
                    }
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isOpen.value,
                onDismissRequest = {
                    isOpen.value = false
                }
            ) {
                list.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            setSelectedItem(selectionOption)
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }

    /**
     * DropDown field that can hold a list of catalog codes.
     *
     * CAUTION: This is very slow when used with more than a few list items.
     * This is a known issue. Currently no fix intended.
     * See for example:
     * https://stackoverflow.com/questions/72001258/dropdownmenu-frame-drops-and-lags-in-jetpack-compose
     * https://issuetracker.google.com/issues/203328119
     * Workaround: Use AutoCompleteTextField.StringValue or make a custom implementation of
     * ExposedDropDownMenuBox that utilizes LazyColumn (which would likely increase performance).
     *
     * @param label The label of the drop down field.
     * @param value The initial value of the field.
     * @param list The list of catalog codes, i.e. drop down options.
     * @param onItemSelect Callback that is triggered when a drop down option is selected.
     */
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun CatalogList(
        label: String,
        value: CatalogCode?,
        list: List<CatalogCode>,
        enabled: Boolean,
        language: Language,
        onItemSelect: (CatalogCode?) -> Unit
    ) {
        // State objects to keep track of the selected item and the drop down expansion
        val isOpen = remember { mutableStateOf(false) } // initial value
        val selectedItem = remember { mutableStateOf(value) }
        val setSelectedItem: (CatalogCode?) -> Unit = {
            selectedItem.value = it
            onItemSelect(it)
            isOpen.value = false
        }

        ExposedDropdownMenuBox(
            expanded = isOpen.value,
            onExpandedChange = { isOpen.value = !isOpen.value },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                readOnly = true,
                value = selectedItem.value?.toString() ?: "",
                enabled = enabled,
                onValueChange = {},
                label = { Label(text = label) },
                trailingIcon = {
                    if (selectedItem.value != null) {
                        IconButtons.Clear(language) {
                            setSelectedItem(null)
                        }
                    } else {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = isOpen.value
                        )
                    }
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isOpen.value,
                onDismissRequest = {
                    isOpen.value = false
                }
            ) {
                list.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            setSelectedItem(selectionOption)
                        }
                    ) {
                        Text(text = selectionOption.toString())
                    }
                }
            }
        }
    }

    /**
     * Searchable DropDown field that can hold a list of catalog codes.
     *
     * CAUTION: This is very slow when used with more than a few list items.
     * This is a known issue. Currently no fix intended.
     * See for example:
     * https://stackoverflow.com/questions/72001258/dropdownmenu-frame-drops-and-lags-in-jetpack-compose
     * https://issuetracker.google.com/issues/203328119
     * Workaround: Use AutoCompleteTextField.StringValue or make a custom implementation of
     * ExposedDropDownMenuBox that utilizes LazyColumn (which would likely increase performance).
     *
     * @param label The label of the drop down field.
     * @param value The initial value of the field.
     * @param list The list of catalog codes, i.e. drop down options.
     * @param onValueChanged Callback that is triggered when a drop down option is selected.
     */
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun SearchableCatalogList(
        label: String,
        value: CatalogCode?,
        list: List<CatalogCode>,
        onValueChanged: (CatalogCode?) -> Unit
    ) {
        var exp by remember { mutableStateOf(false) }
        var selectedOptionText by remember { mutableStateOf(value?.toString() ?: "") }

        ExposedDropdownMenuBox(expanded = exp, onExpandedChange = { exp = !exp }) {
            TextField(
                value = selectedOptionText,
                onValueChange = { selectedOptionText = it },
                label = { Label(text = label) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = exp)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            // Filter options based on text field value (i.e. crude autocomplete)
            val filterOpts =
                list.filter { it.name?.contains(selectedOptionText, ignoreCase = true) ?: false }
            if (filterOpts.isNotEmpty()) {
                ExposedDropdownMenu(expanded = exp, onDismissRequest = { exp = false }) {
                    filterOpts.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                onValueChanged(option)
                                selectedOptionText = option.toString()
                                exp = false
                            }
                        ) {
                            Text(text = option.toString())
                        }
                    }
                }
            }
        }
    }
}