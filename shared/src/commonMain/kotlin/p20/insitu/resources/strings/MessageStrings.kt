package p20.insitu.resources.strings

import p20.insitu.resources.Language

object MessageStrings {

    private const val deleted_successfully_DE = "Eintrag erfolgreich gelöscht"
    private const val deleted_successfully_EN = "Entry deleted successfully"

    fun deleted_successfully(language: Language): String {
        return when (language) {
            Language.DE -> deleted_successfully_DE
            Language.EN -> deleted_successfully_EN
        }
    }

    private const val saved_successfully_DE = "Eintrag erfolgreich gespeichert"
    private const val saved_successfully_EN = "Entry saved successfully"

    fun saved_successfully(language: Language): String {
        return when (language) {
            Language.DE -> saved_successfully_DE
            Language.EN -> saved_successfully_EN
        }
    }

    private const val added_successfully_DE = "Eintrag erfolgreich hinzugefuegt"
    private const val added_successfully_EN = "Entry added successfully"

    fun added_successfully(language: Language): String{
        return when (language) {
            Language.DE -> added_successfully_DE
            Language.EN -> added_successfully_EN
        }
    }

    private const val delete_dialog_DE = "Ausgewaehlter Eintrag wird gelöscht. Möchten Sie fortfahren?"
    private const val delete_dialog_EN = "Deleting selected entry. Are you sure?"

    fun delete(language: Language): String {
        return when (language) {
            Language.DE -> delete_dialog_DE
            Language.EN -> delete_dialog_EN
        }
    }

    private const val discard_changes_dialog_DE =
        "Nicht gespeicherte Änderungern gehen verloren. Möchten Sie fortfahren?"
    private const val discard_changes_dialog_EN =
        "Unsaved changes will be discarded. Do you want to continue?"

    fun discardChanges(language: Language): String {
        return when (language) {
            Language.DE -> discard_changes_dialog_DE
            Language.EN -> discard_changes_dialog_EN
        }
    }

    private const val automatic_assignment_DE = "Wird automatisch ermittelt"
    private const val automatic_assignment_EN = "Will be assigned automatically"
    fun automaticAssignment(language: Language): String {
        return when (language) {
            Language.DE -> automatic_assignment_DE
            Language.EN -> automatic_assignment_EN
        }
    }

    private const val create_crime_scene_DE =
        "Legen Sie einen Tatort an, um mit der Dokumentation zu beginnen."
    private const val create_crime_scene_EN = "Create a crime scene to start documenting evidence."
    fun createCrimeScene(language: Language): String {
        return when (language) {
            Language.DE -> create_crime_scene_DE
            Language.EN -> create_crime_scene_EN
        }
    }

    private const val do_not_secure_as_evidence_DE =
        "Das Objekt wird nicht asserviert, es wird lediglich eine Leitzahl vergeben."
    private const val do_not_secure_as_evidence_EN =
        "The object will not be secured as evidence. It will just receive a documentation number."

    fun doNotSecureAsEvidence(language: Language): String {
        return when (language) {
            Language.DE -> do_not_secure_as_evidence_DE
            Language.EN -> do_not_secure_as_evidence_EN
        }
    }

    private const val feature_not_implemented_yet_DE = "Funktion noch nicht verfügbar."
    private const val feature_not_implemented_yet_EN = "Feature not implemented yet."
    fun featureNotImplementedYet(language: Language): String {
        return when (language) {
            Language.DE -> feature_not_implemented_yet_DE
            Language.EN -> feature_not_implemented_yet_EN
        }
    }

    private const val hello_DE = "Hallo"
    private const val hello_EN = "Hello"
    fun hello(language: Language): String {
        return when (language) {
            Language.DE -> hello_DE
            Language.EN -> hello_EN
        }
    }

    private const val unknownError_DE = "Unbekannter Fehler"
    private const val unknownError_EN = "Unknown Error"
    fun unknownError(language: Language): String {
        return when (language) {
            Language.DE -> unknownError_DE
            Language.EN -> unknownError_EN
        }
    }

    private const val insitu_service_unavailable_DE = "INSITU-Service nicht verfügbar."
    private const val insitu_service_unavailable_EN = "INSITU-Service unavailable."
    fun insituServiceUnavailable(language: Language): String {
        return when (language) {
            Language.DE -> insitu_service_unavailable_DE
            Language.EN -> insitu_service_unavailable_EN
        }
    }

    private const val last_active_object_DE = "Zuletzt bearbeitet:"
    private const val last_active_object_EN = "Last edited:"
    fun lastActiveObject(language: Language): String {
        return when (language) {
            Language.DE -> last_active_object_DE
            Language.EN -> last_active_object_EN
        }
    }

    private const val leave_docu_mode_DE = "Möchten Sie den Dokumentations-Modus verlassen?"
    private const val leave_docu_mode_EN = "Do you want to exit the documentation mode?"
    fun leaveDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> leave_docu_mode_DE
            Language.EN -> leave_docu_mode_EN
        }
    }

    private const val leave_docu_mode_for_crime_scene_DE =
        "Möchten Sie den Dokumentations-Modus verlassen und zum ausgewählten Tatort wechseln?"
    private const val leave_docu_mode_for_crime_scene_EN =
        "Do you want to exit the documentation mode and access the selected crime scene?"

    fun leaveDocuModeForCrimeScene(language: Language): String {
        return when (language) {
            Language.DE -> leave_docu_mode_for_crime_scene_DE
            Language.EN -> leave_docu_mode_for_crime_scene_EN
        }
    }

    private const val login_failed_DE = "Anmeldung fehlgeschlagen."
    private const val login_failed_EN = "Login failed."
    fun loginFailed(language: Language): String {
        return when (language) {
            Language.DE -> login_failed_DE
            Language.EN -> login_failed_EN
        }
    }

    private const val missing_permission_DE =
        "Die folgenden Berechtigungen werden für die Ausführung der App zwingend benötigt:"
    private const val missing_permission_EN =
        "The following permissions are required for running the app:"

    fun missingPermissions(language: Language): String {
        return when (language) {
            Language.DE -> missing_permission_DE
            Language.EN -> missing_permission_EN
        }
    }

    private const val no_address_geolocation_DE = "Keine Geolokalisierung der Adresse vorhanden."
    private const val no_address_geolocation_EN = "No geolocation for address available."
    fun noGeolocationForAddress(language: Language): String {
        return when (language) {
            Language.DE -> no_address_geolocation_DE
            Language.EN -> no_address_geolocation_EN
        }
    }

    private const val no_map_available_DE = "Keine Karte verfügbar."
    private const val no_map_available_EN = "No map available."
    fun noMapAvailable(language: Language): String {
        return when (language) {
            Language.DE -> no_map_available_DE
            Language.EN -> no_map_available_EN
        }
    }

    private const val not_secured_as_evidence_DE = "Nicht asserviert"
    private const val not_secured_as_evidence_EN = "Not secured as evidence"
    fun notSecuredAsEvidence(language: Language): String {
        return when (language) {
            Language.DE -> not_secured_as_evidence_DE
            Language.EN -> not_secured_as_evidence_EN
        }
    }

    private const val secure_as_evidence_DE =
        "Das Objekt wird asserviert. Es können Angaben zur Sicherung gemacht werden."
    private const val secure_as_evidence_EN =
        "The object will be secured as evidence. You can add additional information."

    fun secureAsEvidence(language: Language): String {
        return when (language) {
            Language.DE -> secure_as_evidence_DE
            Language.EN -> secure_as_evidence_EN
        }
    }

    private const val select_details_object_DE =
        "Kein Objekt ausgewählt. Tippen Sie auf eine Objekt-Kachel, z.B. in der Listenansicht, um Details zu einem Objekt anzuzeigen."
    private const val select_details_object_EN =
        "No object selected. Tap on an object card, e.g. in the documentation list, to show detail information of an object."

    fun selectDetailsObject(language: Language): String {
        return when (language) {
            Language.DE -> select_details_object_DE
            Language.EN -> select_details_object_EN
        }
    }

    private const val show_annotations_of_all_users_DE = "Zeige Medienobjekte aller BenutzerInnen."
    private const val show_annotations_of_all_users_EN = "Show annotations of all users."
    fun showAnnotationsOfAllUsers(language: Language): String {
        return when (language) {
            Language.DE -> show_annotations_of_all_users_DE
            Language.EN -> show_annotations_of_all_users_EN
        }
    }

    private const val show_my_annotations_only_DE = "Zeige nur von mir erstellte Medienobjekte."
    private const val show_my_annotations_only_EN = "Show my annotations only."
    fun showMyAnnotationsOnly(language: Language): String {
        return when (language) {
            Language.DE -> show_my_annotations_only_DE
            Language.EN -> show_my_annotations_only_EN
        }
    }

    private const val show_nested_audio_DE =
        "Anzeigen aller Audioaufnahmen des Objekts zzgl. aller Aufnahmen von untergeordneten Objekten."
    private const val show_nested_audio_EN =
        "Show all audio recordings of the object plus all recordings of child objects."

    fun showNestedAudioRecordings(language: Language): String {
        return when (language) {
            Language.DE -> show_nested_audio_DE
            Language.EN -> show_nested_audio_EN
        }
    }

    private const val show_nested_images_DE =
        "Anzeigen aller Bilder des Objekts zzgl. aller Bilder von untergeordneten Objekten."
    private const val show_nested_images_EN =
        "Show all images of the object plus all images of child objects."

    fun showNestedImages(language: Language): String {
        return when (language) {
            Language.DE -> show_nested_images_DE
            Language.EN -> show_nested_images_EN
        }
    }

    private const val show_nested_notes_DE =
        "Anzeigen aller Notizen des Objekts zzgl. aller Notizen von untergeordneten Objekten."
    private const val show_nested_notes_EN =
        "Show all notes of the object plus all notes of child objects."

    fun showNestedNotes(language: Language): String {
        return when (language) {
            Language.DE -> show_nested_notes_DE
            Language.EN -> show_nested_notes_EN
        }
    }

    private const val show_nested_videos_DE =
        "Anzeigen aller Videos des Objekts zzgl. aller Videos von untergeordneten Objekten."
    private const val show_nested_videos_EN =
        "Show all videos of the object plus all videos of child objects."

    fun showNestedVideos(language: Language): String {
        return when (language) {
            Language.DE -> show_nested_videos_DE
            Language.EN -> show_nested_videos_EN
        }
    }

    private const val show_object_audio_only_DE =
        "Zeige nur Audioaufnahmen des ausgewählten Objekts."
    private const val show_object_audio_only_EN =
        "Show only audio recordings of the selected object."

    fun showObjectAudioRecordingsOnly(language: Language): String {
        return when (language) {
            Language.DE -> show_object_audio_only_DE
            Language.EN -> show_object_audio_only_EN
        }
    }

    private const val show_object_images_only_DE = "Zeige nur Bilder des ausgewählten Objekts."
    private const val show_object_images_only_EN = "Show only images of the selected object."
    fun showObjectImagesOnly(language: Language): String {
        return when (language) {
            Language.DE -> show_object_images_only_DE
            Language.EN -> show_object_images_only_EN
        }
    }

    private const val show_object_notes_only_DE = "Zeige nur Notizen des ausgewählten Objekts."
    private const val show_object_notes_only_EN = "Show only notes of the selected object."
    fun showObjectNotesOnly(language: Language): String {
        return when (language) {
            Language.DE -> show_object_notes_only_DE
            Language.EN -> show_object_notes_only_EN
        }
    }

    private const val show_object_videos_only_DE = "Zeige nur Videos des ausgewählten Objekts."
    private const val show_object_videos_only_EN = "Show only videos of the selected object."
    fun showObjectVideosOnly(language: Language): String {
        return when (language) {
            Language.DE -> show_object_videos_only_DE
            Language.EN -> show_object_videos_only_EN
        }
    }

    private const val size_input_DE = "Bitte geben Sie die ermittelte / geschätzte Größe ein."
    private const val size_input_EN = "Please enter the determined size."
    fun sizeInput(language: Language): String {
        return when (language) {
            Language.DE -> size_input_DE
            Language.EN -> size_input_EN
        }
    }


    private const val size_length_input_DE =
        "Bitte geben Sie die ermittelte / geschätzte Länge ein."
    private const val size_length_input_EN = "Please enter the determined length."
    fun sizeLengthInput(language: Language): String {
        return when (language) {
            Language.DE -> size_length_input_DE
            Language.EN -> size_length_input_EN
        }
    }


    private const val size_width_input_DE =
        "Bitte geben Sie die ermittelte / geschätzte Breite ein."
    private const val size_width_input_EN = "Please enter the determined width."
    fun sizeWidthInput(language: Language): String {
        return when (language) {
            Language.DE -> size_width_input_DE
            Language.EN -> size_width_input_EN
        }
    }

    private const val size_height_input_DE = "Bitte geben Sie die ermittelte / geschätzte Höhe ein."
    private const val size_height_input_EN = "Please enter the determined height."
    fun sizeHeightInput(language: Language): String {
        return when (language) {
            Language.DE -> size_height_input_DE
            Language.EN -> size_height_input_EN
        }
    }

    private const val size_diameter_input_DE =
        "Bitte geben Sie den ermittelte / geschätzten Durchmesser ein."
    private const val size_diameter_input_EN = "Please enter the determined diameter."
    fun sizeDiameterInput(language: Language): String {
        return when (language) {
            Language.DE -> size_diameter_input_DE
            Language.EN -> size_diameter_input_EN
        }
    }

    private const val value_missing_DE = "Kein Wert"
    private const val value_missing_EN = "Value missing"
    fun valueMissing(language: Language): String {
        return when (language) {
            Language.DE -> value_missing_DE
            Language.EN -> value_missing_EN
        }
    }

    private const val volume_input_DE = "Bitte geben Sie das ermittelte / geschätzte Volumen ein."
    private const val volume_input_EN = "Please enter the determined volume."
    fun volumeInput(language: Language): String {
        return when (language) {
            Language.DE -> volume_input_DE
            Language.EN -> volume_input_EN
        }
    }

    private const val weight_input_DE = "Bitte geben Sie das ermittelte / geschätzte Gewicht ein."
    private const val weight_input_EN = "Please enter the determined weight."
    fun weightInput(language: Language): String {
        return when (language) {
            Language.DE -> weight_input_DE
            Language.EN -> weight_input_EN
        }
    }

    private const val server_na_DE = "Anmeldeserver nicht erreichbar"
    private const val server_na_EN = "Login-Server not available"
    fun serverNA(language: Language): String {
        return when (language) {
            Language.DE -> server_na_DE
            Language.EN -> server_na_EN
        }
    }

    private const val hideFields_DE = "Verbergen"
    private const val hideFields_EN = "Hide"
    fun hideFields(language: Language): String {
        return when (language) {
            Language.DE -> hideFields_DE
            Language.EN -> hideFields_EN
        }
    }

    private const val showFields_DE = "Mehr"
    private const val showFields_EN = "More"
    fun showFields(language: Language): String {
        return when (language) {
            Language.DE -> hideFields_DE
            Language.EN -> hideFields_EN
        }
    }
}