package p20.insitu.resources.strings

import p20.insitu.resources.Language

object TabStrings {

    private const val address_DE = "Adresse"
    private const val address_EN = "Address"
    fun address(language: Language): String {
        return when (language) {
            Language.DE -> address_DE
            Language.EN -> address_EN
        }
    }

    private const val audio_player_DE = "Wiedergabe"
    private const val audio_player_EN = "Audio player"
    fun audioPlayer(language: Language): String {
        return when (language) {
            Language.DE -> audio_player_DE
            Language.EN -> audio_player_EN
        }
    }

    private const val audio_recordings_DE = "Audio"
    private const val audio_recordings_EN = "Audio"
    fun audioRecordings(language: Language): String {
        return when (language) {
            Language.DE -> audio_recordings_DE
            Language.EN -> audio_recordings_EN
        }
    }

    private const val crimeScenes_DE = "Tatorte"
    private const val crimeScenes_EN = "Crime Scenes"
    fun crimeScenes(language: Language): String {
        return when (language) {
            Language.DE -> crimeScenes_DE
            Language.EN -> crimeScenes_EN
        }
    }

    private const val criminal_offenses_DE = "Straftaten"
    private const val criminal_offenses_EN = "Crimes"
    fun criminalOffenses(language: Language): String {
        return when (language) {
            Language.DE -> criminal_offenses_DE
            Language.EN -> criminal_offenses_EN
        }
    }

    private const val description_DE = "Merkmale"
    private const val description_EN = "Description"
    fun description(language: Language): String {
        return when (language) {
            Language.DE -> description_DE
            Language.EN -> description_EN
        }
    }

    private const val evidence_data_DE = "Asservierung"
    private const val evidence_data_EN = "Evidence data"
    fun evidenceData(language: Language): String {
        return when (language) {
            Language.DE -> evidence_data_DE
            Language.EN -> evidence_data_EN
        }
    }

    private const val images_DE = "Bilder"
    private const val images_EN = "Images"
    fun images(language: Language): String {
        return when (language) {
            Language.DE -> images_DE
            Language.EN -> images_EN
        }
    }

    private const val investigation_data_DE = "Vorgangsdaten"
    private const val investigation_data_EN = "Investigation data"
    fun investigationData(language: Language): String {
        return when (language) {
            Language.DE -> investigation_data_DE
            Language.EN -> investigation_data_EN
        }
    }

    private const val map_DE = "Karte"
    private const val map_EN = "Map"
    fun map(language: Language): String {
        return when (language) {
            Language.DE -> map_DE
            Language.EN -> map_EN
        }
    }

    private const val media_DE = "Medien"
    private const val media_EN = "Media"
    fun media(language: Language): String {
        return when (language) {
            Language.DE -> media_DE
            Language.EN -> media_EN
        }
    }

    private const val modus_operandi_DE = "Modus Operandi"
    private const val modus_operandi_EN = "Modus Operandi"
    fun modusOperandi(language: Language): String {
        return when (language) {
            Language.DE -> modus_operandi_DE
            Language.EN -> modus_operandi_EN
        }
    }

    private const val notes_DE = "Notizen"
    private const val notes_EN = "Notes"
    fun notes(language: Language): String {
        return when (language) {
            Language.DE -> notes_DE
            Language.EN -> notes_EN
        }
    }

    private const val persons_DE = "Personen"
    private const val persons_EN = "Persons"
    fun persons(language: Language): String {
        return when (language) {
            Language.DE -> persons_DE
            Language.EN -> persons_EN
        }
    }

    private const val sites_DE = "Bereiche"
    private const val sites_EN = "Sites"
    fun sites(language: Language): String {
        return when (language) {
            Language.DE -> sites_DE
            Language.EN -> sites_EN
        }
    }

    private const val videos_DE = "Videos"
    private const val videos_EN = "Videos"
    fun videos(language: Language): String {
        return when (language) {
            Language.DE -> videos_DE
            Language.EN -> videos_EN
        }
    }
}