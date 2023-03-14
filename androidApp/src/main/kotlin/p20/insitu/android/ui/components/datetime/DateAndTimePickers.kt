package p20.insitu.android.ui.components.datetime

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.datetime.*
import org.koin.androidx.compose.get
import p20.insitu.android.ui.components.Text.Label
import p20.insitu.android.ui.components.buttons.IconButtons
import p20.insitu.resources.strings.*
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.getCurrentDateTime
import p20.insitu.android.ui.components.datetime.date.datepicker
import p20.insitu.android.ui.components.datetime.time.Timepicker
import p20.insitu.android.ui.components.dialogs.MaterialDialog
import p20.insitu.android.ui.components.dialogs.rememberMaterialDialogState
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object DateAndTimePickers {

    // TODO delete/replace as soon as kotlinx.datetime.LocalTime is available
    fun LocalDateTime.toJavaLocalTime(): LocalTime {
        return LocalTime.of(
            this.hour,
            this.minute,
            this.second
        )
    }

    // TODO delete/replace as soon as kotlinx.datetime.LocalTime is available
    fun LocalTime.toKotlinLocalDateTime(): LocalDateTime {
        getCurrentDateTime().let { now ->
            return LocalDateTime(
                now.year,
                now.month,
                now.dayOfMonth,
                this.hour,
                this.minute,
                this.second
            )
        }
    }

    fun getKotlinLocalDateTime(
        javaLocalDate: java.time.LocalDate?,
        javaLocalTime: LocalTime?
    ): LocalDateTime? {
        return javaLocalDate?.let { date ->
            javaLocalTime?.let { time ->
                LocalDateTime(
                    date.year,
                    date.month,
                    date.dayOfMonth,
                    time.hour,
                    time.minute,
                    time.second,
                    time.nano
                )
            }
        }
    }

    @Composable
    fun DateTimePicker(
        initDateTime: LocalDateTime?,
        label: String?,
        onValueChanged: (LocalDateTime?) -> Unit
    ) {
        // UiStateHandler states
        val uiStateHandler: UiStateHandler = get()
        val language = uiStateHandler.language.collectAsState()

        // State objects to store the selected date and time
        val selectedDate = remember { mutableStateOf(initDateTime?.date?.toJavaLocalDate()) }
        val selectedTime = remember {
            mutableStateOf(initDateTime?.let {
                LocalTime.of(
                    it.hour,
                    it.minute,
                    0,
                    0
                )
            })
        }

        // String formatters for date and time
        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

        // Prepare date picker dialog
        val dateDialogState = rememberMaterialDialogState()
        MaterialDialog(
            dialogState = dateDialogState,
            buttons = {
                positiveButton(ButtonStrings.ok(language.value))
                negativeButton(ButtonStrings.cancel(language.value))
            }
        ) {
            datepicker(
                initialDate = selectedDate.value ?: Clock.System.now()
                    .toLocalDateTime(TimeZone.currentSystemDefault()).toJavaLocalDateTime()
                    .toLocalDate(),
                title = DialogStrings.datePicker(language.value)
            ) {
                selectedDate.value = it
                // We have to make sure that there can't be a date without a time
                if (selectedTime.value == null) {
                    // If the selected date is today, then we assume the user also wants the current time
                    if (it == Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
                            .toJavaLocalDateTime().toLocalDate()
                    ) {
                        selectedTime.value =
                            Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
                                .toJavaLocalDateTime().toLocalTime()
                    } else {
                        // Else, we choose 00:00 as the default time
                        selectedTime.value = LocalTime.of(0, 0, 0, 0)
                    }
                }
                // If we have a valid date and time selected, we trigger the callback
                getKotlinLocalDateTime(selectedDate.value, selectedTime.value)?.let { datetime ->
                    onValueChanged(datetime)
                }
            }
        }

        // Prepare time picker dialog
        val timeDialogState = rememberMaterialDialogState()
        MaterialDialog(
            dialogState = timeDialogState,
            buttons = {
                positiveButton(ButtonStrings.ok(language.value))
                negativeButton(ButtonStrings.cancel(language.value))
            }
        ) {
            Timepicker(
                initialTime = selectedTime.value ?: Clock.System.now()
                    .toLocalDateTime(TimeZone.currentSystemDefault())
                    .toJavaLocalDateTime().toLocalTime(),
                title = DialogStrings.timePicker(language.value),
                is24HourClock = true
            ) { time ->
                selectedTime.value = time
                // If we have a valid date and time selected, we trigger the callback
                getKotlinLocalDateTime(selectedDate.value, selectedTime.value)?.let { datetime ->
                    onValueChanged(datetime)
                }
            }
        }

        // Create two text fields that show the selected date and time
        // When clicking on a text field the associated dialog gets shown
        // Changing the selected date or time triggers a callback
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = selectedDate.value?.format(dateFormatter) ?: "",
                label = { Label(text = label ?: TextFieldStrings.dateTime(language.value)) },
                enabled = true,
                readOnly = true,
                onValueChange = { },
                trailingIcon = {
                    if (selectedDate.value != null) {
                        IconButtons.Clear(language = language.value) {
                            selectedDate.value = null
                            selectedTime.value = null
                            onValueChanged(null)
                        }
                    } else {
                        IconButtons.DatePicker(language = language.value) {
                            dateDialogState.show()
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(0.6f)
            )

            Spacer(modifier = Modifier.width(p20.insitu.android.ui.components.dimen.Padding.small))

            TextField(
                value = selectedTime.value?.format(timeFormatter) ?: "",
                label = { Label(text = TextFieldStrings.time(language.value)) },
                enabled = true,
                readOnly = true,
                onValueChange = { },
                trailingIcon = {
                    if (selectedTime.value != null) {
                        IconButtons.TimePicker(language = language.value) {
                            timeDialogState.show()
                        }
                    }
                }
            )
        }
    }


    @Composable
    fun DatePicker(
        initDate: LocalDate?,
        label: String?,
        onValueChanged: (LocalDate?) -> Unit
    ) {
        // UiStateHandler states
        val uiStateHandler: UiStateHandler = get()
        val editMode = uiStateHandler.editMode.collectAsState()
        val language = uiStateHandler.language.collectAsState()

        // State object to store the selected date
        val selectedDate = remember { mutableStateOf(initDate?.toJavaLocalDate()) }

        // String formatter
        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        // Prepare date picker dialog
        val dateDialogState = rememberMaterialDialogState()
        MaterialDialog(
            dialogState = dateDialogState,
            buttons = {
                positiveButton(ButtonStrings.ok(language.value))
                negativeButton(ButtonStrings.cancel(language.value))
            }
        ) {
            datepicker(
                initialDate = selectedDate.value ?: Clock.System.now()
                    .toLocalDateTime(TimeZone.currentSystemDefault()).toJavaLocalDateTime()
                    .toLocalDate(),
                title = DialogStrings.datePicker(language.value)
            ) { date ->
                selectedDate.value = date
                onValueChanged(date.toKotlinLocalDate())
            }
        }

        TextField(
            value = selectedDate.value?.format(dateFormatter) ?: "",
            label = { Label(text = label ?: TextFieldStrings.date(language.value)) },
            enabled = editMode.value,
            readOnly = true,
            onValueChange = { /* do nothing, see date picker dialog instead*/ },
            trailingIcon = {
                if (selectedDate.value != null) {
                    IconButtons.Clear(
                        language = language.value
                    ) {
                        selectedDate.value = null
                        onValueChanged(null)
                    }
                } else if (editMode.value) {
                    IconButtons.DatePicker(
                        language = language.value
                    ) {
                        dateDialogState.show()
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun TimePicker(
        initTime: LocalDateTime?,
        label: String?,
        onValueChanged: (LocalDateTime?) -> Unit
    ) {
        // UiStateHandler states
        val uiStateHandler: UiStateHandler = get()
        val editMode = uiStateHandler.editMode.collectAsState()
        val language = uiStateHandler.language.collectAsState()

        // State object to store the selected time
        val selectedTime = remember { mutableStateOf(initTime?.toJavaLocalTime()) }

        // String formatter
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

        // Prepare time picker dialog
        val timeDialogState = rememberMaterialDialogState()
        MaterialDialog(
            dialogState = timeDialogState,
            buttons = {
                positiveButton(ButtonStrings.ok(language.value))
                negativeButton(ButtonStrings.cancel(language.value))
            }
        ) {
            Timepicker(
                initialTime = selectedTime.value ?: getCurrentDateTime().toJavaLocalTime(),
                title = DialogStrings.timePicker(language.value),
                is24HourClock = true
            ) { time ->
                selectedTime.value = time
                onValueChanged(time.toKotlinLocalDateTime())
            }
        }

        // Placeholder TextField
        TextField(
            value = selectedTime.value?.format(timeFormatter) ?: "",
            label = { Label(text = label ?: TextFieldStrings.time(language.value)) },
            enabled = editMode.value,
            readOnly = true,
            onValueChange = { /* do nothing, see time picker dialog instead*/ },
            trailingIcon = {
                if (selectedTime.value != null) {
                    IconButtons.Clear(
                        language = language.value
                    ) {
                        selectedTime.value = null
                        onValueChanged(null)
                    }
                } else if (editMode.value) {
                    IconButtons.TimePicker(
                        language = language.value
                    ) {
                        timeDialogState.show()
                    }
                }
            }
        )
    }
}