package p20.insitu.resources.strings

import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogCategoryGroup
import p20.insitu.catalogues.CatalogSubCategory
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.nav.NavRoute
import p20.insitu.resources.Language

object IconContentDescriptions {

    fun entityType(entityType: EntityType, language: Language): String {
        return EntityTypeStrings.typeString(entityType, language)
    }
    fun catalogCategoryGroup(category: CatalogCategoryGroup, language: Language): String {
        return CatalogStrings.categoryGroup(category, language)
    }

    fun catalogCategory(category: CatalogCategory, language: Language): String {
        return CatalogStrings.category(category, language)
    }

    fun catalogSubCategory(category: CatalogSubCategory, language: Language): String {
        return CatalogStrings.subCategory(category, language)
    }

    fun docuModeNavItem(navRoute: NavRoute, language: Language): String? {
        return when (navRoute) {
            NavRoute.DOCU_MODE_HOME -> docuModeHome(language)
            NavRoute.DOCU_MODE_LIST -> docuModeList(language)
            NavRoute.DOCU_MODE_DETAILS -> docuModeDetails(language)
            else -> null
        }
    }

    private const val add_DE = "Hinzufügen"
    private const val add_EN = "Add"
    fun add(language: Language): String {
        return when (language) {
            Language.DE -> add_DE
            Language.EN -> add_EN
        }
    }

    private const val audio_recording_start_DE = "Audioaufnahme starten"
    private const val audio_recording_start_EN = "Start audio recording"
    fun audioRecordingStart(language: Language): String {
        return when (language) {
            Language.DE -> audio_recording_start_DE
            Language.EN -> audio_recording_start_EN
        }
    }

    private const val audio_recording_stop_DE = "Audioaufnahme stoppen"
    private const val audio_recording_stop_EN = "Stop audio recording"
    fun audioRecordingStop(language: Language): String {
        return when (language) {
            Language.DE -> audio_recording_stop_DE
            Language.EN -> audio_recording_stop_EN
        }
    }

    private const val back_DE = "Zurück"
    private const val back_EN = "Back"
    fun back(language: Language): String {
        return when (language) {
            Language.DE -> back_DE
            Language.EN -> back_EN
        }
    }

    private const val cancel_DE = "Abbrechen"
    private const val cancel_EN = "Cancel"
    fun cancel(language: Language): String {
        return when (language) {
            Language.DE -> cancel_DE
            Language.EN -> cancel_EN
        }
    }

    private const val clear_DE = "Löschen"
    private const val clear_EN = "Clear"
    fun clear(language: Language): String {
        return when (language) {
            Language.DE -> clear_DE
            Language.EN -> clear_EN
        }
    }

    private const val close_DE = "Schließen"
    private const val close_EN = "Close"
    fun close(language: Language): String {
        return when (language) {
            Language.DE -> close_DE
            Language.EN -> close_EN
        }
    }

    private const val delete_DE = "Löschen"
    private const val delete_EN = "Delete"
    fun delete(language: Language): String {
        return when (language) {
            Language.DE -> delete_DE
            Language.EN -> delete_EN
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

    private const val docu_mode_home_DE = "Aktiver Vorgang"
    private const val docu_mode_home_EN = "Active investigation"
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

    private const val docu_mode_list_DE = "Dokumentationsliste"
    private const val docu_mode_list_EN = "Documentation list"
    fun docuModeList(language: Language): String {
        return when (language) {
            Language.DE -> docu_mode_list_DE
            Language.EN -> docu_mode_list_EN
        }
    }

    private const val docu_mode_details_DE = "Objekt-Informationen"
    private const val docu_mode_details_EN = "Object information"
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

    private const val done_DE = "Fertig"
    private const val done_EN = "Done"
    fun done(language: Language): String {
        return when (language) {
            Language.DE -> done_DE
            Language.EN -> done_EN
        }
    }

    private const val door_DE = "Tür"
    private const val door_EN = "Door"
    fun door(language: Language): String {
        return when (language) {
            Language.DE -> door_DE
            Language.EN -> door_EN
        }
    }

    private const val edit_DE = "Bearbeiten"
    private const val edit_EN = "Edit"
    fun edit(language: Language): String {
        return when (language) {
            Language.DE -> edit_DE
            Language.EN -> edit_EN
        }
    }

    private const val emergency_securing_DE = "Notsicherung"
    private const val emergency_securing_EN = "Emergency securing"
    fun emergencySecuring(language: Language): String {
        return when (language) {
            Language.DE -> emergency_securing_DE
            Language.EN -> emergency_securing_EN
        }
    }

    private const val expand_more_DE = "Mehr anzeigen"
    private const val expand_more_EN = "Expand more"
    fun expandMore(language: Language): String {
        return when (language) {
            Language.DE -> expand_more_DE
            Language.EN -> expand_more_EN
        }
    }

    private const val expand_less_DE = "Weniger anzeigen"
    private const val expand_less_EN = "Expand less"
    fun expandLess(language: Language): String {
        return when (language) {
            Language.DE -> expand_less_DE
            Language.EN -> expand_less_EN
        }
    }

    private const val exit_docu_mode_DE = "Dokumentations-Modus verlassen"
    private const val exit_docu_mode_EN = "Exit documentation mode"
    fun exitDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> exit_docu_mode_DE
            Language.EN -> exit_docu_mode_EN
        }
    }

    private const val exit_site_setup_DE = "Bereichseinteilung verlassen"
    private const val exit_site_setup_EN = "Exit site setup"
    fun exitSiteSetup(language: Language): String {
        return when (language) {
            Language.DE -> exit_site_setup_DE
            Language.EN -> exit_site_setup_EN
        }
    }

    private const val flip_camera_DE = "Kamera wechseln"
    private const val flip_camera_EN = "Flip camera"
    fun flipCamera(language: Language): String {
        return when (language) {
            Language.DE -> flip_camera_DE
            Language.EN -> flip_camera_EN
        }
    }

    private const val generic_object_DE = "Generisches Objekt"
    private const val generic_object_EN = "Generic object"
    fun genericObject(language: Language): String {
        return when (language) {
            Language.DE -> generic_object_DE
            Language.EN -> generic_object_EN
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

    private const val goto_investigation_DE = "Zum Vorgang"
    private const val goto_investigation_EN = "Go to investigation"
    fun goToInvestigation(language: Language): String {
        return when (language) {
            Language.DE -> goto_investigation_DE
            Language.EN -> goto_investigation_EN
        }
    }

    private const val goto_investigations_DE = "Zu den Vorgängen"
    private const val goto_investigations_EN = "Go to investigations"
    fun goToInvestigations(language: Language): String {
        return when (language) {
            Language.DE -> goto_investigations_DE
            Language.EN -> goto_investigations_EN
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

    private const val insitu_logo_DE = "Das INSITU Logo"
    private const val insitu_logo_EN = "The INSITU logo"
    fun insituLogo(language: Language): String {
        return when (language) {
            Language.DE -> insitu_logo_DE
            Language.EN -> insitu_logo_EN
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

    private const val leaveDocuMode_DE = "Dokumentationsmodus verlassen"
    private const val leaveDocuMode_EN = "Leave documentation mode"
    fun leaveDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> leaveDocuMode_DE
            Language.EN -> leaveDocuMode_EN
        }
    }

    private const val logout_DE = "Abmelden"
    private const val logout_EN = "Logout"
    fun logout(language: Language): String {
        return when (language) {
            Language.DE -> logout_DE
            Language.EN -> logout_EN
        }
    }

    private const val media_filter_DE = "Medienfilter"
    private const val media_filter_EN = "Media filter"
    fun mediaFilter(language: Language): String {
        return when (language) {
            Language.DE -> media_filter_DE
            Language.EN -> media_filter_EN
        }
    }

    private const val menu_DE = "Menü"
    private const val menu_EN = "Menu"
    fun menu(language: Language): String {
        return when (language) {
            Language.DE -> menu_DE
            Language.EN -> menu_EN
        }
    }

    private const val move_up_in_list_DE =
        "Bewege das ausgewählte Listen-Element eine Position höher"
    private const val move_up_in_list_EN = "Move the selected list element up"
    fun moveUpInList(language: Language): String {
        return when (language) {
            Language.DE -> move_up_in_list_DE
            Language.EN -> move_up_in_list_EN
        }
    }

    private const val move_down_in_list_DE =
        "Bewege das ausgewählte Listen-Element eine Position tiefer"
    private const val move_down_in_list_EN = "Move the selected list element down"
    fun moveDownInList(language: Language): String {
        return when (language) {
            Language.DE -> move_down_in_list_DE
            Language.EN -> move_down_in_list_EN
        }
    }

    private const val navigate_docu_list_up_DE = "Navigiere Dokumentationsliste eine Ebene hoch"
    private const val navigate_docu_list_up_EN = "Navigate documentation list one level up"
    fun navigateDocuListUp(language: Language): String {
        return when (language) {
            Language.DE -> navigate_docu_list_up_DE
            Language.EN -> navigate_docu_list_up_EN
        }
    }

    private const val new_investigation_DE = "Neuer Vorgang"
    private const val new_investigation_EN = "New investigation"
    fun newInvestigation(language: Language): String {
        return when (language) {
            Language.DE -> new_investigation_DE
            Language.EN -> new_investigation_EN
        }
    }

    private const val photo_library_DE = "Fotogalerie"
    private const val photo_library_EN = "Photo library"
    fun photoLibrary(language: Language): String {
        return when (language) {
            Language.DE -> photo_library_DE
            Language.EN -> photo_library_EN
        }
    }

    private const val pick_date_DE = "Wähle ein Datum"
    private const val pick_date_EN = "Pick a date"
    fun pickDate(language: Language): String {
        return when (language) {
            Language.DE -> pick_date_DE
            Language.EN -> pick_date_EN
        }
    }

    private const val pick_time_DE = "Wähle eine Zeit"
    private const val pick_time_EN = "Pick a time"
    fun pickTime(language: Language): String {
        return when (language) {
            Language.DE -> pick_time_DE
            Language.EN -> pick_time_EN
        }
    }

    private const val qr_code_scanner_DE = "QR-Code Scanner"
    private const val qr_code_scanner_EN = "QR code scanner"
    fun qrCodeScanner(language: Language): String {
        return when (language) {
            Language.DE -> qr_code_scanner_DE
            Language.EN -> qr_code_scanner_EN
        }
    }

    private const val release_notes_DE = "Release notes"
    private const val release_notes_EN = "Release notes"
    fun releaseNotes(language: Language): String {
        return when (language) {
            Language.DE -> release_notes_DE
            Language.EN -> release_notes_EN
        }
    }

    private const val save_DE = "Speichern"
    private const val save_EN = "Save"
    fun save(language: Language): String {
        return when (language) {
            Language.DE -> save_DE
            Language.EN -> save_EN
        }
    }

    private const val search_DE = "Suche"
    private const val search_EN = "Search"
    fun search(language: Language): String {
        return when (language) {
            Language.DE -> search_DE
            Language.EN -> search_EN
        }
    }

    private const val secure_as_evidence_DE = "Asservierung"
    private const val secure_as_evidence_EN = "Securing evidence"
    fun secureAsEvidence(language: Language): String {
        return when (language) {
            Language.DE -> secure_as_evidence_DE
            Language.EN -> secure_as_evidence_EN
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

    private const val show_list_DE = "Zeige Liste"
    private const val show_list_EN = "Show list"
    fun showList(language: Language): String {
        return when (language) {
            Language.DE -> show_list_DE
            Language.EN -> show_list_EN
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

    private const val table_DE = "Bearbeiten"
    private const val table_EN = "Edit"
    fun table(language: Language): String {
        return when (language) {
            Language.DE -> table_DE
            Language.EN -> table_EN
        }
    }

    private const val take_photo_DE = "Foto aufnehmen"
    private const val take_photo_EN = "Take photo"
    fun takePhoto(language: Language): String {
        return when (language) {
            Language.DE -> take_photo_DE
            Language.EN -> take_photo_EN
        }
    }

    private const val user_image_DE = "Benutzerfoto"
    private const val user_image_EN = "User image"
    fun userImage(language: Language): String {
        return when (language) {
            Language.DE -> user_image_DE
            Language.EN -> user_image_EN
        }
    }

    private const val video_recording_start_DE = "Videoaufnahme starten"
    private const val video_recording_start_EN = "Start video recording"
    fun videoRecordingStart(language: Language): String {
        return when (language) {
            Language.DE -> video_recording_start_DE
            Language.EN -> video_recording_start_EN
        }
    }

    private const val video_recording_stop_DE = "Videoaufnahme stoppen"
    private const val video_recording_stop_EN = "Stop video recording"
    fun videoRecordingStop(language: Language): String {
        return when (language) {
            Language.DE -> video_recording_stop_DE
            Language.EN -> video_recording_stop_EN
        }
    }
}