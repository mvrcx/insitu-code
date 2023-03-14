package p20.insitu.resources.strings

import p20.insitu.resources.Language

object CatalogItemStrings {

    private const val customizable_dimensions_DE = "Benutzerdefinierte Abmessungen"
    private const val customizable_dimensions_EN = "Customizable measurements"
    fun customizableDimensions(language: Language): String {
        return when (language) {
            Language.DE -> customizable_dimensions_DE
            Language.EN -> customizable_dimensions_EN
        }
    }

    private const val dna_trace_DE = "DNA-Spur"
    private const val dna_trace_EN = "DNA trace"
    fun dnaTrace(language: Language): String {
        return when (language) {
            Language.DE -> dna_trace_DE
            Language.EN -> dna_trace_EN
        }
    }

    private const val single_wing_door_DE = "Einflügelige Tür"
    private const val single_wing_door_EN = "Single-wing door"
    fun singleWingDoor(language: Language): String {
        return when (language) {
            Language.DE -> single_wing_door_DE
            Language.EN -> single_wing_door_EN
        }
    }

    private const val parametric_dimensions_DE = "Parametrische Abmessungen"
    private const val parametric_dimensions_EN = "Parametric dimensions"
    fun parametricDimensions(language: Language): String {
        return when (language) {
            Language.DE -> parametric_dimensions_DE
            Language.EN -> parametric_dimensions_EN
        }
    }

    private const val rectangular_table_DE = "Rechteckiger Tisch"
    private const val rectangular_table_EN = "Rectangular table"
    fun rectangularTable(language: Language): String {
        return when (language) {
            Language.DE -> rectangular_table_DE
            Language.EN -> rectangular_table_EN
        }
    }

    private const val some_object_DE = "Sonstiges Objekt"
    private const val some_object_EN = "Some object"
    fun someObject(language: Language): String {
        return when (language) {
            Language.DE -> some_object_DE
            Language.EN -> some_object_EN
        }
    }
}