package p20.insitu.resources.strings

import p20.insitu.resources.Language

object DialogStrings {
    private const val datePicker_DE = "Datum wählen"
    private const val datePicker_EN = "Select Date"
    fun datePicker(language: Language): String {
        return when (language) {
            Language.DE -> datePicker_DE
            Language.EN -> datePicker_EN
        }
    }

    private const val dateTimePicker_DE = "Zeitpunkt wählen"
    private const val dateTimePicker_EN = "Select Datetime"
    fun dateTimePicker(language: Language): String {
        return when (language) {
            Language.DE -> dateTimePicker_DE
            Language.EN -> dateTimePicker_EN
        }
    }

    private const val timePicker_DE = "Zeit wählen"
    private const val timePicker_EN = "Select Time"
    fun timePicker(language: Language): String {
        return when (language) {
            Language.DE -> timePicker_DE
            Language.EN -> timePicker_EN
        }
    }
}