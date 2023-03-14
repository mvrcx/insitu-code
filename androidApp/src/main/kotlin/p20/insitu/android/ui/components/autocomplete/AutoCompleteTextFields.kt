package p20.insitu.android.ui.components.autocomplete

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.resources.Language
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.android.ui.components.autocomplete.utils.asAutoCompleteEntities
import p20.insitu.android.ui.components.buttons.IconButtons
import p20.insitu.android.ui.components.dimen.Padding

object AutoCompleteTextFields {

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun StringValue(
        label: String,
        value: String,
        items: List<String>,
        enabled: Boolean,
        language: Language,
        onValueChanged: (String) -> Unit,
        onItemSelect: (String) -> Unit = { onValueChanged(it) }
    ) {
        val autoCompleteEntities = items.asAutoCompleteEntities(
            filter = { item, query ->
                item.lowercase()
                    .contains(query.lowercase())
            }
        )

        AutoCompleteBox(
            items = autoCompleteEntities,
            itemContent = { item ->
                ValueAutoCompleteItem(item.value)
            }
        ) {
            val focus = LocalFocusManager.current

            onItemSelected { item ->
                onItemSelect(item.value)
                focus.clearFocus()
            }

            TextSearchBar(
                value = value,
                language = language,
                enabled = enabled,
                label = label,
                onDoneActionClick = {
                    focus.clearFocus()
                },
                onClearClick = {
                    onValueChanged("")
                    filter("")
                    focus.clearFocus()
                },
                onFocusChanged = { focusState ->
                    isSearching = focusState.hasFocus
                },
                onValueChanged = {
                    filter(query = it)
                    onValueChanged(it)
                }
            )
        }
    }

    @Composable
    private fun ValueAutoCompleteItem(item: String) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Padding.medium),
            verticalArrangement = Arrangement.spacedBy(Padding.small)
        ) {
            Text(text = item, style = MaterialTheme.typography.subtitle2)
        }
    }

    @Composable
    private fun TextSearchBar(
        modifier: Modifier = Modifier,
        value: String,
        language: Language,
        enabled: Boolean,
        label: String,
        onDoneActionClick: () -> Unit = {},
        onClearClick: () -> Unit = {},
        onFocusChanged: (FocusState) -> Unit = {},
        onValueChanged: (String) -> Unit
    ) {
        val trailingIconView = @Composable {
            IconButtons.Clear(language = language, onClickAction = onClearClick)
        }
        val showListIconView = @Composable {
            Icon(
                Icons.Filled.ArrowDropDown,
                contentDescription = IconContentDescriptions.showList(language)
            )
        }
        TextField(
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { onFocusChanged(it) },
            value = value,
            enabled = enabled,
            onValueChange = { query ->
                onValueChanged(query)
            },
            label = { Label(text = label) },
            textStyle = MaterialTheme.typography.subtitle1,
            singleLine = true,
            trailingIcon = if (value.isNotEmpty() && enabled) trailingIconView else showListIconView,
            keyboardActions = KeyboardActions(onDone = { onDoneActionClick() }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            )
        )
    }
}