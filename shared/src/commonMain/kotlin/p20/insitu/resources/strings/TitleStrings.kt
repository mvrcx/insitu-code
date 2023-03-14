package p20.insitu.resources.strings

import p20.insitu.nav.NavRoute
import p20.insitu.resources.Language

object TitleStrings {

    fun docuModeNavItem(navRoute: NavRoute, language: Language): String {
        return when (navRoute) {
            NavRoute.DOCU_MODE_HOME -> docuModeHome(language)
            NavRoute.DOCU_MODE_LIST -> docuModeList(language)
            NavRoute.DOCU_MODE_DETAILS -> docuModeDetails(language)
            else -> ""
        }
    }

    private const val active_crime_scene_DE = "Aktiver Tatort"
    private const val active_crime_scene_EN = "Active crime scene"
    fun activeCrimeScene(language: Language): String {
        return when (language) {
            Language.DE -> active_crime_scene_DE
            Language.EN -> active_crime_scene_EN
        }
    }

    private const val additional_information_DE = "Zusatzangaben"
    private const val additional_information_EN = "Additional information"
    fun additionalInformation(language: Language): String {
        return when (language) {
            Language.DE -> additional_information_DE
            Language.EN -> additional_information_EN
        }
    }

    private const val address_geolocation_DE = "Adresse | Geolokalisierung"
    private const val address_geolocation_EN = "Address | Geolocation"
    fun addressGeolocation(language: Language): String {
        return when (language) {
            Language.DE -> address_geolocation_DE
            Language.EN -> address_geolocation_EN
        }
    }

    private const val administrative_encoding_DE = "Verwaltungspolitische Kodierung"
    private const val administrative_encoding_EN = "Administrative encoding"
    fun administrativeEncoding(language: Language): String {
        return when (language) {
            Language.DE -> administrative_encoding_DE
            Language.EN -> administrative_encoding_EN
        }
    }

    private const val appearance_DE = "Erscheinungsbild"
    private const val appearance_EN = "Appearance"
    fun appearance(language: Language): String {
        return when (language) {
            Language.DE -> appearance_DE
            Language.EN -> appearance_EN
        }
    }

    private const val associated_criminal_offenses_DE = "Im Zusammenhang stehende Delikte"
    private const val associated_criminal_offenses_EN = "Associated criminal offenses"
    fun associatedCriminalOffenses(language: Language): String {
        return when (language) {
            Language.DE -> associated_criminal_offenses_DE
            Language.EN -> associated_criminal_offenses_EN
        }
    }

    private const val associated_investigation_DE = "Verknüpfter Vorgang"
    private const val associated_investigation_EN = "Associated investigation"
    fun associatedInvestigation(language: Language): String {
        return when (language) {
            Language.DE -> associated_investigation_DE
            Language.EN -> associated_investigation_EN
        }
    }

    private const val audio_filter_settings_DE = "Audio-spezifische Filter"
    private const val audio_filter_settings_EN = "Specific audio filters"
    fun audioFilterSettings(language: Language): String {
        return when (language) {
            Language.DE -> audio_filter_settings_DE
            Language.EN -> audio_filter_settings_EN
        }
    }

    private const val audio_recorder_DE = "Audioaufnahme"
    private const val audio_recorder_EN = "Audio recorder"
    fun audioRecorder(language: Language): String {
        return when (language) {
            Language.DE -> audio_recorder_DE
            Language.EN -> audio_recorder_EN
        }
    }

    private const val building_sites_DE = "Gebäudebereiche"
    private const val building_sites_EN = "Building parts"
    fun buildingSites(language: Language): String {
        return when (language) {
            Language.DE -> building_sites_DE
            Language.EN -> building_sites_EN
        }
    }

    private const val catalog_DE = "Katalog"
    private const val catalog_EN = "Catalog"
    fun catalog(language: Language): String {
        return when (language) {
            Language.DE -> catalog_DE
            Language.EN -> catalog_EN
        }
    }

    private const val catalog_settings_DE = "Katalogdatenbank"
    private const val catalog_settings_EN = "Catalog database"
    fun catalogSettings(language: Language): String {
        return when (language) {
            Language.DE -> catalog_settings_DE
            Language.EN -> catalog_settings_EN
        }
    }

    private const val contact_details_DE = "Kontakdaten"
    private const val contact_details_EN = "Contact details"
    fun contactDetails(language: Language): String {
        return when (language) {
            Language.DE -> contact_details_DE
            Language.EN -> contact_details_EN
        }
    }

    private const val crime_scene_DE = "Tatort"
    private const val crime_scene_EN = "Crime Scene"
    fun crimeScene(language: Language): String {
        return when (language) {
            Language.DE -> crime_scene_DE
            Language.EN -> crime_scene_EN
        }
    }

    private const val crime_scenes_DE = "Tatorte"
    private const val crime_scenes_EN = "Crime Scenes"
    fun crimeScenes(language: Language): String {
        return when (language) {
            Language.DE -> crime_scenes_DE
            Language.EN -> crime_scenes_EN
        }
    }

    private const val crime_time_DE = "Tatzeit"
    private const val crime_time_EN = "Crime Scene"
    fun crimeTime(language: Language): String {
        return when (language) {
            Language.DE -> crime_time_DE
            Language.EN -> crime_time_EN
        }
    }

    private const val database_reset_DE = "Datenbanken"
    private const val database_reset_EN = "Databases"
    fun databases(language: Language): String {
        return when (language) {
            Language.DE -> database_reset_DE
            Language.EN -> database_reset_EN
        }
    }

    private const val description_DE = "Beschreibung"
    private const val description_EN = "Description"
    fun description(language: Language): String {
        return when (language) {
            Language.DE -> description_DE
            Language.EN -> description_EN
        }
    }

    private const val dimensions_DE = "Abmessungen"
    private const val dimensions_EN = "Dimensions"
    fun dimensions(language: Language): String {
        return when (language) {
            Language.DE -> dimensions_DE
            Language.EN -> dimensions_EN
        }
    }

    private const val docu_parameters_DE = "Weitere Angaben"
    private const val docu_parameters_EN = "Additional parameters"
    fun docuParameters(language: Language): String {
        return when (language) {
            Language.DE -> docu_parameters_DE
            Language.EN -> docu_parameters_EN
        }
    }

    private const val docu_mode_DE = "Dokumentation"
    private const val docu_mode_EN = "Documentation"
    fun docuMode(language: Language): String {
        return when (language) {
            Language.DE -> docu_mode_DE
            Language.EN -> docu_mode_EN
        }
    }

    private const val docu_mode_home_DE = "Vorgang"
    private const val docu_mode_home_EN = "Investigation"
    fun docuModeHome(language: Language): String {
        return when (language) {
            Language.DE -> docu_mode_home_DE
            Language.EN -> docu_mode_home_EN
        }
    }

    private const val docu_mode_persons_DE = "Personen"
    private const val docu_mode_persons_EN = "Persons"
    fun docuModePersons(language: Language): String {
        return when (language) {
            Language.DE -> docu_mode_persons_DE
            Language.EN -> docu_mode_persons_EN
        }
    }

    private const val docu_mode_list_DE = "Liste"
    private const val docu_mode_list_EN = "List"
    fun docuModeList(language: Language): String {
        return when (language) {
            Language.DE -> docu_mode_list_DE
            Language.EN -> docu_mode_list_EN
        }
    }

    private const val docu_mode_details_DE = "Objekt"//"Details"
    private const val docu_mode_details_EN = "Object"//"Details"
    fun docuModeDetails(language: Language): String {
        return when (language) {
            Language.DE -> docu_mode_details_DE
            Language.EN -> docu_mode_details_EN
        }
    }

    private const val docu_mode_media_DE = "Medien"
    private const val docu_mode_media_EN = "Media"
    fun docuModeMedia(language: Language): String {
        return when (language) {
            Language.DE -> docu_mode_media_DE
            Language.EN -> docu_mode_media_EN
        }
    }

    private const val do_not_secure_as_evidence_DE = "Keine Asservierung vornehmen"
    private const val do_not_secure_as_evidence_EN = "Do not secure as evidence"
    fun doNotSecureAsEvidence(language: Language): String {
        return when (language) {
            Language.DE -> do_not_secure_as_evidence_DE
            Language.EN -> do_not_secure_as_evidence_EN
        }
    }

    private const val filter_settings_DE = "Filtereinstellungen"
    private const val filter_settings_EN = "Filter settings"
    fun filterSettings(language: Language): String {
        return when (language) {
            Language.DE -> filter_settings_DE
            Language.EN -> filter_settings_EN
        }
    }

    private const val geolocation_DE = "Geolokalisierung"
    private const val geolocation_EN = "Geolocation"
    fun geolocation(language: Language): String {
        return when (language) {
            Language.DE -> geolocation_DE
            Language.EN -> geolocation_EN
        }
    }

    private const val global_media_filter_settings_DE = "Globale Filter"
    private const val global_media_filter_settings_EN = "Global filters"
    fun globalMediaFilterSettings(language: Language): String {
        return when (language) {
            Language.DE -> global_media_filter_settings_DE
            Language.EN -> global_media_filter_settings_EN
        }
    }

    private const val goto_docu_mode_DE = "Dokumentation starten"
    private const val goto_docu_mode_EN = "Start documentation"
    fun goToDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> goto_docu_mode_DE
            Language.EN -> goto_docu_mode_EN
        }
    }

    private const val help_DE = "Hilfe"
    private const val help_EN = "Help"
    fun help(language: Language): String {
        return when (language) {
            Language.DE -> help_DE
            Language.EN -> help_EN
        }
    }

    private const val image_filter_settings_DE = "Bild-spezifische Filter"
    private const val image_filter_settings_EN = "Specific image filters"
    fun imageFilterSettings(language: Language): String {
        return when (language) {
            Language.DE -> image_filter_settings_DE
            Language.EN -> image_filter_settings_EN
        }
    }

    private const val image_gallery_DE = "Galerie"
    private const val image_gallery_EN = "Gallery"
    fun imageGallery(language: Language): String {
        return when (language) {
            Language.DE -> image_gallery_DE
            Language.EN -> image_gallery_EN
        }
    }

    private const val investigation_DE = "Vorgang"
    private const val investigation_EN = "Investigation"
    fun investigation(language: Language): String {
        return when (language) {
            Language.DE -> investigation_DE
            Language.EN -> investigation_EN
        }
    }

    private const val investigations_DE = "Meine Vorgänge"
    private const val investigations_EN = "My investigations"
    fun investigations(language: Language): String {
        return when (language) {
            Language.DE -> investigations_DE
            Language.EN -> investigations_EN
        }
    }

    private const val language_settings_DE = "Spracheinstellungen"
    private const val language_settings_EN = "Language settings"
    fun languageSettings(language: Language): String {
        return when (language) {
            Language.DE -> language_settings_DE
            Language.EN -> language_settings_EN
        }
    }

    private const val leave_docu_mode_DE = "Dokumentation beenden"
    private const val leave_docu_mode_EN = "Exit documentation"
    fun leaveDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> leave_docu_mode_DE
            Language.EN -> leave_docu_mode_EN
        }
    }

    private const val modus_operandi_planning_phase_DE = "Vortat / Tatvorbereitung"
    private const val modus_operandi_planning_phase_EN = "Crime planning phase"
    fun modusOperandiPlanningPhase(language: Language): String {
        return when (language) {
            Language.DE -> modus_operandi_planning_phase_DE
            Language.EN -> modus_operandi_planning_phase_EN
        }
    }

    private const val modus_operandi_execution_phase_DE = "Tatdurchführung"
    private const val modus_operandi_execution_phase_EN = "Crime execution phase"
    fun modusOperandiExecutionPhase(language: Language): String {
        return when (language) {
            Language.DE -> modus_operandi_execution_phase_DE
            Language.EN -> modus_operandi_execution_phase_EN
        }
    }


    private const val modus_operandi_post_execution_phase_DE = "Nachtat (-verhalten)"
    private const val modus_operandi_post_execution_phase_EN = "Post execution phase"
    fun modusOperandiPostExecutionPhase(language: Language): String {
        return when (language) {
            Language.DE -> modus_operandi_post_execution_phase_DE
            Language.EN -> modus_operandi_post_execution_phase_EN
        }
    }

    private const val new_crimeScene_DE = "Neuer Tatort"
    private const val new_crimeScene_EN = "New Crime Scene"
    fun newCrimeScene(language: Language): String {
        return when (language) {
            Language.DE -> new_crimeScene_DE
            Language.EN -> new_crimeScene_EN
        }
    }

    private const val new_investigation_DE = "Neuer Vorgang"
    private const val new_investigation_EN = "New Investigation"
    fun newInvestigation(language: Language): String {
        return when (language) {
            Language.DE -> new_investigation_DE
            Language.EN -> new_investigation_EN
        }
    }

    private const val new_site_DE = "Neue Lage"
    private const val new_site_EN = "New Site"
    fun newSite(language: Language): String {
        return when (language) {
            Language.DE -> new_site_DE
            Language.EN -> new_site_EN
        }
    }

    private const val note_filter_settings_DE = "Notiz-spezifische Filter"
    private const val note_filter_settings_EN = "Specific note filters"
    fun noteFilterSettings(language: Language): String {
        return when (language) {
            Language.DE -> note_filter_settings_DE
            Language.EN -> note_filter_settings_EN
        }
    }

    private const val other_sites_DE = "Sonstige Bereiche"
    private const val other_sites_EN = "Other sites"
    fun otherSites(language: Language): String {
        return when (language) {
            Language.DE -> other_sites_DE
            Language.EN -> other_sites_EN
        }
    }

    private const val permissions_missing_DE = "Berechtigungen fehlen"
    private const val permissions_missing_EN = "Permissions missing"
    fun permissionsMissing(language: Language): String {
        return when (language) {
            Language.DE -> permissions_missing_DE
            Language.EN -> permissions_missing_EN
        }
    }

    private const val personal_details_DE = "Personalien"
    private const val personal_details_EN = "Personal details"
    fun personalDetails(language: Language): String {
        return when (language) {
            Language.DE -> personal_details_DE
            Language.EN -> personal_details_EN
        }
    }

    private const val person_sites_DE = "Personen"
    private const val person_sites_EN = "Persons"
    fun personSites(language: Language): String {
        return when (language) {
            Language.DE -> person_sites_DE
            Language.EN -> person_sites_EN
        }
    }

    private const val connection_to_investigation_DE = "Bezug zum Vorgang"
    private const val connection_to_investigation_EN = "Relation to investigation"
    fun connectionToInvestigation(language: Language): String {
        return when (language) {
            Language.DE -> connection_to_investigation_DE
            Language.EN -> connection_to_investigation_EN
        }
    }

    private const val postal_address_DE = "Anschrift"
    private const val postal_address_EN = "Postal Address"
    fun postalAddress(language: Language): String {
        return when (language) {
            Language.DE -> postal_address_DE
            Language.EN -> postal_address_EN
        }
    }

    private const val related_ids_DE = "Verknüpfte IDs"
    private const val related_ids_EN = "Related IDs"
    fun relatedIDs(language: Language): String {
        return when (language) {
            Language.DE -> related_ids_DE
            Language.EN -> related_ids_EN
        }
    }

    private const val settings_DE = "Einstellungen"
    private const val settings_EN = "Settings"
    fun settings(language: Language): String {
        return when (language) {
            Language.DE -> settings_DE
            Language.EN -> settings_EN
        }
    }

    private const val secure_as_evidence_DE = "Asservierung vornehmen"
    private const val secure_as_evidence_EN = "Secure as evidence"
    fun secureAsEvidence(language: Language): String {
        return when (language) {
            Language.DE -> secure_as_evidence_DE
            Language.EN -> secure_as_evidence_EN
        }
    }

    private const val securing_evidence_DE = "Angaben zur Sicherung"
    private const val securing_evidence_EN = "Securing circumstances"
    fun securingEvidence(language: Language): String {
        return when (language) {
            Language.DE -> securing_evidence_DE
            Language.EN -> securing_evidence_EN
        }
    }

    private const val filter_user_annotations_DE = "Nur meine Medien anzeigen"
    private const val filter_user_annotations_EN = "Show my annotations only"
    fun filterUserAnnotations(language: Language): String {
        return when (language) {
            Language.DE -> filter_user_annotations_DE
            Language.EN -> filter_user_annotations_EN
        }
    }

    private const val filter_nested_videos_DE = "Medien untergeordneter Bereiche Anzeigen"
    private const val filter_nested_videos_EN = "Show annotations of nested objects"
    fun filterNestedAnnotations(language: Language): String {
        return when (language) {
            Language.DE -> filter_nested_videos_DE
            Language.EN -> filter_nested_videos_EN
        }
    }

    private const val release_notes_DE = "Was ist neu?"
    private const val release_notes_EN = "Release notes"
    fun releaseNotes(language: Language): String {
        return when (language) {
            Language.DE -> release_notes_DE
            Language.EN -> release_notes_EN
        }
    }

    private const val site_DE = "Bereich"
    private const val site_EN = "Site"
    fun site(language: Language): String {
        return when (language) {
            Language.DE -> site_DE
            Language.EN -> site_EN
        }
    }

    private const val site_catalog_DE = "Art des Spurenbereichs"
    private const val site_catalog_EN = "Type of site"
    fun siteCatalog(language: Language): String {
        return when (language) {
            Language.DE -> site_catalog_DE
            Language.EN -> site_catalog_EN
        }
    }

    private const val size_input_DE = "Größenangabe"
    private const val size_input_EN = "Size"
    fun size(language: Language): String {
        return when (language) {
            Language.DE -> size_input_DE
            Language.EN -> size_input_EN
        }
    }

    private const val size_length_input_DE = "Längenangabe"
    private const val size_length_input_EN = "Length input"
    fun sizeLengthInput(language: Language): String {
        return when (language) {
            Language.DE -> size_length_input_DE
            Language.EN -> size_length_input_EN
        }
    }


    private const val size_width_input_DE = "Breitenangabe"
    private const val size_width_input_EN = "Width input"
    fun sizeWidthInput(language: Language): String {
        return when (language) {
            Language.DE -> size_width_input_DE
            Language.EN -> size_width_input_EN
        }
    }

    private const val size_height_input_DE = "Höhenangabe"
    private const val size_height_input_EN = "Height input"
    fun sizeHeightInput(language: Language): String {
        return when (language) {
            Language.DE -> size_height_input_DE
            Language.EN -> size_height_input_EN
        }
    }

    private const val size_diameter_input_DE = "Durchmesserangabe"
    private const val size_diameter_input_EN = "Diameter input"
    fun sizeDiameterInput(language: Language): String {
        return when (language) {
            Language.DE -> size_diameter_input_DE
            Language.EN -> size_diameter_input_EN
        }
    }

    private const val sovereign_act_DE = "Hoheitliche Maßnahme"
    private const val sovereign_act_EN = "Sovereign act"
    fun sovereignAct(language: Language): String {
        return when (language) {
            Language.DE -> sovereign_act_DE
            Language.EN -> sovereign_act_EN
        }
    }

    private const val start_DE = "INSITU"
    private const val start_EN = "INSITU"
    fun insitu(language: Language): String {
        return when (language) {
            Language.DE -> start_DE
            Language.EN -> start_EN
        }
    }

    private const val status_DE = "Status"
    private const val status_EN = "Status"
    fun status(language: Language): String {
        return when (language) {
            Language.DE -> status_DE
            Language.EN -> status_EN
        }
    }

    private const val transport_and_storage_DE = "Transport und Lagerung"
    private const val transport_and_storage_EN = "Transport and storage"
    fun transportAndStorage(language: Language): String {
        return when (language) {
            Language.DE -> transport_and_storage_DE
            Language.EN -> transport_and_storage_EN
        }
    }

    private const val unique_identification_data_DE = "Eindeutige Kennzeichnung"
    private const val unique_identification_data_EN = "Unique identification data"
    fun uniqueIdentificationData(language: Language): String {
        return when (language) {
            Language.DE -> unique_identification_data_DE
            Language.EN -> unique_identification_data_EN
        }
    }

    private const val unsaved_changes_DE = "Nicht gespeicherte Änderungen"
    private const val unsaved_changes_EN = "Unsaved changes"
    fun unsavedChanges(language: Language): String {
        return when (language) {
            Language.DE -> unsaved_changes_DE
            Language.EN -> unsaved_changes_EN
        }
    }

    private const val vehicle_sites_DE = "Fahrzeuge"
    private const val vehicle_sites_EN = "Vehicles"
    fun vehicleSites(language: Language): String {
        return when (language) {
            Language.DE -> vehicle_sites_DE
            Language.EN -> vehicle_sites_EN
        }
    }

    private const val video_filter_settings_DE = "Video-spezifische Filter"
    private const val video_filter_settings_EN = "Specific video filters"
    fun videoFilterSettings(language: Language): String {
        return when (language) {
            Language.DE -> video_filter_settings_DE
            Language.EN -> video_filter_settings_EN
        }
    }

    private const val volume_input_DE = "Volumenangabe"
    private const val volume_input_EN = "Volume input"
    fun volumeInput(language: Language): String {
        return when (language) {
            Language.DE -> volume_input_DE
            Language.EN -> volume_input_EN
        }
    }

    private const val weight_input_DE = "Gewichtsangabe"
    private const val weight_input_EN = "Weight input"
    fun weightInput(language: Language): String {
        return when (language) {
            Language.DE -> weight_input_DE
            Language.EN -> weight_input_EN
        }
    }
}