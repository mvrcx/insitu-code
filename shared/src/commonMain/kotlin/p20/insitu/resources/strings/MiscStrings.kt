package p20.insitu.resources.strings

import p20.insitu.model.entities.enums.PersonType
import p20.insitu.resources.Language

object MiscStrings {

    fun personType(type: PersonType, language: Language): String {
        return when(type){
            PersonType.OFFENDER-> offender(language)
            PersonType.SUSPECT -> suspect(language)
            PersonType.VICTIM -> victim(language)
            PersonType.WITNESS -> witness(language)
        }
    }

    private const val offender_DE = "Täter/in"
    private const val offender_EN = "Offender"
    fun offender(language: Language): String {
        return when (language) {
            Language.DE -> offender_DE
            Language.EN -> offender_EN
        }
    }

    private const val suspect_DE = "Verdächtige/r"
    private const val suspect_EN = "Suspect"
    fun suspect(language: Language): String {
        return when (language) {
            Language.DE -> suspect_DE
            Language.EN -> suspect_EN
        }
    }

    private const val victim_DE = "Geschädigte/r"
    private const val victim_EN = "Victim"
    fun victim(language: Language): String {
        return when (language) {
            Language.DE -> victim_DE
            Language.EN -> victim_EN
        }
    }

    private const val witness_DE = "Zeuge/in"
    private const val witness_EN = "Witness"
    fun witness(language: Language): String {
        return when (language) {
            Language.DE -> witness_DE
            Language.EN -> witness_EN
        }
    }

    private const val app_name_DE = "INSITU"
    private const val app_name_EN = "INSITU"
    fun appName(language: Language): String {
        return when (language) {
            Language.DE -> app_name_DE
            Language.EN -> app_name_EN
        }
    }

    private const val available_catalogs_DE = "Verfügbare Kataloge werden ermittelt..."
    private const val available_catalogs_EN = "Calculating available catalogs..."
    fun availableCatalogs(language: Language, count: Int = 0, max: Int = 0): String {
        if(count > 0 && max > 0) {
            return when (language) {
                Language.DE -> "Verfügbare Kataloge: $count/$max"
                Language.EN -> "Available catalogs: $count/$max"
            }
        } else {
            return when (language) {
                Language.DE -> available_catalogs_DE
                Language.EN -> available_catalogs_EN
            }
        }
    }

}