package p20.insitu.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.buttons.IconButtons
import p20.insitu.android.ui.components.dialogs.InputDialogs
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.components.Size
import p20.insitu.model.components.Volume
import p20.insitu.model.components.Weight
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.resources.Language
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.android.ui.components.dimen.MultilineTextfieldSize
import p20.insitu.android.ui.components.dimen.Padding

object TextFields {

    @Composable
    fun Keywords(
        keywords: MutableList<String>,
        enabled: Boolean,
        language: Language,
        onValueChanged: (List<String>) -> Unit
    ) {
        val newKeyword = remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = if (enabled) newKeyword.value else keywords.joinToString("; "),
                label = {
                    Text(
                        text = if (enabled) {
                            TextFieldStrings.addKeyword(language)
                        } else {
                            TextFieldStrings.keywords(language)
                        }
                    )
                },
                enabled = enabled,
                onValueChange = {
                    newKeyword.value = it
                },
                trailingIcon = {
                    if (enabled && newKeyword.value.isNotBlank() && !keywords.contains(newKeyword.value)) {
                        IconButtons.Done(
                            language = language
                        ) {
                            keywords.add(newKeyword.value)
                            onValueChanged(keywords)
                            newKeyword.value = ""
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            if (enabled && keywords.size > 0) {
                Spacer(modifier = Modifier.height(Padding.small))

                Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                    keywords.forEachIndexed { index, keyword ->
                        OutlinedButton(
                            onClick = {
                                keywords.removeAt(index)
                                onValueChanged(keywords)
                            }
                        ) {
                            Text(
                                text = keyword,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.fillMaxWidth(0.8f)
                            )
                            Spacer(modifier = Modifier.width(Padding.xsmall))
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = IconContentDescriptions.delete(language)
                            )
                        }
                        Spacer(modifier = Modifier.width(Padding.small))
                    }
                }
            }
        }
    }


    @Composable
    fun Password(
        password: MutableState<String>,
        language: Language
    ) {
        var passwordVisibility by remember { mutableStateOf(false) }
        TextField(
            value = password.value,
            label = { Label(text = TextFieldStrings.password(language)) },
            onValueChange = {
                password.value = it
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(imageVector = image, "")
                }
            }
        )
    }

    @Composable
    fun Username(
        username: MutableState<String>,
        language: Language
    ) {
        TextField(
            value = username.value,
            label = { Label(text = TextFieldStrings.username(language)) },
            onValueChange = {
                username.value = it
            })
    }

    @Composable
    fun SingleLineString(
        value: String?,
        label: String,
        enabled: Boolean,
        readonly: Boolean = false,
        onValueChanged: (String?) -> Unit
    ) {
        TextField(
            value = value ?: "",
            label = { Label(text = label) },
            enabled = enabled,
            readOnly = readonly,
            onValueChange = {
                onValueChanged(it.ifBlank { null })
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun WeightInput(
        value: Weight?,
        editMode: Boolean,
        language: Language,
        catalogRepo: CatalogRepo,
        onValueChanged: (Weight?) -> Unit
    ) {
        val openDialog = remember { mutableStateOf(false) }
        TextField(
            value = value?.toString() ?: "",
            label = { Label(text = TextFieldStrings.weight(language)) },
            enabled = false,
            onValueChange = { },
            modifier = if (editMode) {
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (editMode) {
                            openDialog.value = true
                        }
                    }
            } else {
                Modifier.fillMaxWidth()
            },
            trailingIcon = {
                if (editMode) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = IconContentDescriptions.edit(language)
                    )
                }
            }
        )
        if (openDialog.value) {
            InputDialogs.Weight(
                initialValue = value,
                onDismiss = { openDialog.value = false },
                onConfirm = {
                    openDialog.value = false
                    onValueChanged(it)
                },
                language = language,
                catalogRepo
            )
        }
    }

    @Composable
    fun VolumeInput(
        value: Volume?,
        editMode: Boolean,
        language: Language,
        catalogRepo: CatalogRepo,
        onValueChanged: (Volume?) -> Unit
    ) {
        val openDialog = remember { mutableStateOf(false) }
        TextField(
            value = value?.toString() ?: "",
            label = { Label(text = TextFieldStrings.volume(language)) },
            enabled = false,
            onValueChange = { },
            modifier = if (editMode) {
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (editMode) {
                            openDialog.value = true
                        }
                    }
            } else {
                Modifier.fillMaxWidth()
            },
            trailingIcon = {
                if (editMode) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = IconContentDescriptions.edit(language)
                    )
                }
            }
        )
        if (openDialog.value) {
            InputDialogs.Volume(
                initialValue = value,
                onDismiss = { openDialog.value = false },
                onConfirm = {
                    openDialog.value = false
                    onValueChanged(it)
                },
                language = language,
                catalogRepo
            )
        }
    }

    @Composable
    fun SizeInput(
        value: Size?,
        title: String,
        text: String,
        label: String,
        editMode: Boolean,
        language: Language,
        catalogRepo: CatalogRepo,
        onValueChanged: (Size?) -> Unit
    ) {
        val openDialog = remember { mutableStateOf(false) }
        TextField(
            value = value?.toString() ?: "",
            label = { Label(text = label) },
            enabled = false,
            onValueChange = { },
            modifier = if (editMode) {
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (editMode) {
                            openDialog.value = true
                        }
                    }
            } else {
                Modifier.fillMaxWidth()
            },
            trailingIcon = {
                if (editMode) {
                    Icon(
                        Icons.Filled.Edit,
                        contentDescription = IconContentDescriptions.edit(language)
                    )
                }
            }
        )
        if (openDialog.value) {
            InputDialogs.Size(
                title = title,
                text = text,
                initialValue = value,
                onDismiss = { openDialog.value = false },
                onConfirm = {
                    openDialog.value = false
                    onValueChanged(it)
                },
                language = language,
                catalogRepo
            )
        }
    }

    @Composable
    fun IntValue(
        initialValue: String?,
        label: String,
        enabled: Boolean,
        readonly: Boolean = false,
        onValueChanged: (Int?) -> Unit
    ) {
        val inputText = remember { mutableStateOf(initialValue ?: "") }
        val errorColor = TextStyle(color = MaterialTheme.colors.error)
        val nAn = remember { mutableStateOf(false) }
        TextField(
            value = inputText.value,
            textStyle = if (nAn.value) errorColor else TextStyle(),
            label = { Label(text = label) },
            enabled = enabled,
            readOnly = readonly,
            onValueChange = {
                inputText.value = it
                nAn.value = it.toFloatOrNull() == null
                onValueChanged(it.toIntOrNull())
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun FloatValue(
        initialValue: String?,
        label: String,
        enabled: Boolean,
        readonly: Boolean = false,
        onValueChanged: (Float?) -> Unit
    ) {
        val inputText = remember { mutableStateOf(initialValue ?: "") }
        val errorColor = TextStyle(color = MaterialTheme.colors.error)
        val nAn = remember { mutableStateOf(false) }
        TextField(
            value = inputText.value,
            textStyle = if (nAn.value) errorColor else TextStyle(),
            label = { Label(text = label) },
            enabled = enabled,
            readOnly = readonly,
            onValueChange = {
                inputText.value = it
                nAn.value = it.toFloatOrNull() == null
                onValueChanged(it.toFloatOrNull())
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun MultilineString(
        value: String?,
        label: String,
        enabled: Boolean,
        maxSize: Boolean = false,
        onValueChanged: (String?) -> Unit = {}
    ) {
        val scrollState = rememberScrollState(0)
        TextField(
            value = value ?: "",
            label = { Label(text = label) },
            enabled = enabled,
            onValueChange = {
                onValueChanged(it.ifBlank { null })
            },
            modifier = if (maxSize) Modifier.fillMaxSize() else // TODO not working
                Modifier.fillMaxWidth()
                    .heightIn(
                        min = MultilineTextfieldSize.min,
                        max = MultilineTextfieldSize.max
                    )
                    .verticalScroll(scrollState)
        )
    }

    @Composable
    fun DocNumber(
        docNumber: String?,
        leadingNumber: Boolean,
        language: Language
    ) {
        TextField(
            value = docNumber ?: "",
            label = {
                Text(
                    text = if (leadingNumber) {
                        TextFieldStrings.leadingDocNumber(language)
                    } else {
                        TextFieldStrings.evidenceDocNumber(language)
                    }
                )
            },
            enabled = false,
            onValueChange = { },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun InvestigationNumber(
        number: String?,
        language: Language
    ) {
        TextField(
            value = number ?: "",
            label = { Label(text = TextFieldStrings.investigationNumber(language)) },
            enabled = false,
            onValueChange = {
                // do nothing
            },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun SimpleSearchBar(
        modifier: Modifier = Modifier,
        value: String,
        language: Language,
        enabled: Boolean,
        label: String,
        onClearClick: () -> Unit = {},
        onValueChanged: (String) -> Unit
    ) {
        val trailingIconView = @Composable {
            IconButtons.Clear(language = language, onClickAction = onClearClick)
        }
        val showListIconView = @Composable {
            Icon(
                Icons.Filled.Search,
                contentDescription = IconContentDescriptions.search(language)
            )
        }
        TextField(
            modifier = modifier,
            value = value,
            enabled = enabled,
            onValueChange = { query ->
                onValueChanged(query)
            },
            label = { Label(text = label) },
            textStyle = MaterialTheme.typography.subtitle1,
            singleLine = true,
            trailingIcon = if (value.isNotEmpty() && enabled) trailingIconView else showListIconView
        )
    }

    @Composable
    fun Date(
        modifier: Modifier = Modifier,
        zonedDateTime : ZonedDateTime?,
        language: Language,
        enabled: Boolean,
        label: String
    ){
        //TODO language dependent date format
        TextField(
            value = zonedDateTime?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                ?: "",
            enabled = enabled,
            label = { Label(text = label) },
            onValueChange = { },
            modifier = modifier
        )
    }

    @Composable
    fun StartDate(
        modifier: Modifier = Modifier,
        zonedDateTime : ZonedDateTime?,
        language: Language,
        enabled: Boolean
    ){
        //TODO language dependent date format
        TextField(
            value = zonedDateTime?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                ?: "",
            enabled = enabled,
            label = { Label(text = TextFieldStrings.startDate(language)) },
            onValueChange = { },
            modifier = modifier
        )
    }

    @Composable
    fun EndDate(
        modifier: Modifier = Modifier,
        zonedDateTime : ZonedDateTime?,
        language: Language,
        enabled: Boolean
    ){
        //TODO language dependent date format
        TextField(
            value = zonedDateTime?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                ?: "",
            enabled = enabled,
            label = { Label(text = TextFieldStrings.endDate(language)) },
            onValueChange = { },
            modifier = modifier
        )
    }

    @Composable
    fun ToDo(label: String = "") {
        TextField(
            value = "TODO",
            enabled = false,
            label = { Label(text = label) },
            onValueChange = {
                // do nothing
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}