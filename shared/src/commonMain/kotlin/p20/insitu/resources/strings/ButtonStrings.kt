package p20.insitu.resources.strings

import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.Language

object ButtonStrings {

    private const val add_address_DE = "Adresse hinzufügen"
    private const val add_address_EN = "Add address"
    fun addAddress(language: Language): String {
        return when (language) {
            Language.DE -> add_address_DE
            Language.EN -> add_address_EN
        }
    }

    fun addBaseEntity(entityType: EntityType, language: Language): String {
        return when (language) {
            Language.DE -> "${EntityTypeStrings.typeString(entityType, language)} hinzufügen"
            Language.EN -> "Add ${EntityTypeStrings.typeString(entityType, language)}"
        }
    }

    private const val add_evidence_to_list_DE = "Asservat oder Spurenbereich anlegen"
    private const val add_evidence_to_list_EN = "Add evidence or area"
    fun addEvidenceToList(language: Language): String {
        return when (language) {
            Language.DE -> add_evidence_to_list_DE
            Language.EN -> add_evidence_to_list_EN
        }
    }

    private const val catalog_database_reset_DE = "Katalogdatenbank zurücksetzen"
    private const val catalog_database_reset_EN = "Catalog database reset"
    fun catalogDatabaseReset(language: Language): String {
        return when (language) {
            Language.DE -> catalog_database_reset_DE
            Language.EN -> catalog_database_reset_EN
        }
    }

    private const val database_reset_DE = "Dokumentationsdaten löschen"
    private const val database_reset_EN = "Delete documentation data"
    fun databaseReset(language: Language): String {
        return when (language) {
            Language.DE -> database_reset_DE
            Language.EN -> database_reset_EN
        }
    }

    private const val select_or_add_sovereign_act_DE = "Hoheitliche Maßnahme anlegen oder auswählen"
    private const val select_or_add_sovereign_act_EN = "Select or add Sovereign act"
    fun selectOrAddSovereignAct(language: Language): String {
        return when (language) {
            Language.DE -> select_or_add_sovereign_act_DE
            Language.EN -> select_or_add_sovereign_act_EN
        }
    }

    private const val apply_value_DE = "Übernehmen"
    private const val apply_value_EN = "Apply"
    fun applyValue(language: Language): String {
        return when (language) {
            Language.DE -> apply_value_DE
            Language.EN -> apply_value_EN
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

    private const val continue_later_DE = "Speichern und später fortsetzen"
    private const val continue_later_EN = "Save and continue later"
    fun continueLater(language: Language): String {
        return when (language) {
            Language.DE -> continue_later_DE
            Language.EN -> continue_later_EN
        }
    }

    private const val debug_view_DE = "Debug View"
    private const val debug_view_EN = "Debug View"
    fun debugView(language: Language): String {
        return when (language) {
            Language.DE -> debug_view_DE
            Language.EN -> debug_view_EN
        }
    }

    private const val exit_docu_mode_DE = "Dokumentation verlassen"
    private const val exit_docu_mode_EN = "Exit documentation"
    fun exitDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> exit_docu_mode_DE
            Language.EN -> exit_docu_mode_EN
        }
    }

    private const val discard_changes_DE = "Änderungen verwerfen"
    private const val discard_changes_EN = "Discard changes"
    fun discardChanges(language: Language): String {
        return when (language) {
            Language.DE -> discard_changes_DE
            Language.EN -> discard_changes_EN
        }
    }

    private const val emergency_securing_DE = "Sofort-Sicherung"
    private const val emergency_securing_EN = "Emergency Securing"
    fun emergencySecuring(language: Language): String {
        return when (language) {
            Language.DE -> emergency_securing_DE
            Language.EN -> emergency_securing_EN
        }
    }

    private const val start_site_setup_DE = "Bereichseinteilung starten"
    private const val start_site_setup_EN = "Start site setup"
    fun startSiteSetup(language: Language): String {
        return when (language) {
            Language.DE -> start_site_setup_DE
            Language.EN -> start_site_setup_EN
        }
    }

    private const val finish_site_setup_DE = "Bereichseinteilung abschließen"
    private const val finish_site_setup_EN = "Finish site setup"
    fun finishSiteSetup(language: Language): String {
        return when (language) {
            Language.DE -> finish_site_setup_DE
            Language.EN -> finish_site_setup_EN
        }
    }

    private const val go_directly_to_docu_mode_DE = "Bereichseinteilung überspringen"
    private const val go_directly_to_docu_mode_EN = "Skip site setup"
    fun goDirectlyToDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> go_directly_to_docu_mode_DE
            Language.EN -> go_directly_to_docu_mode_EN
        }
    }

    private const val goto_crime_scene_list_DE = "Tippe hier um zur Liste der Tatorte zu gelangen"
    private const val goto_crime_scene_list_EN = "Tap here to go to the list of crime scenes"
    fun goToCrimeSceneList(language: Language): String {
        return when (language) {
            Language.DE -> goto_crime_scene_list_DE
            Language.EN -> goto_crime_scene_list_EN
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

    private const val goto_investigation_DE = "Zum Vorgang"
    private const val goto_investigation_EN = "Go to investigation"
    fun goToInvestigation(language: Language): String {
        return when (language) {
            Language.DE -> goto_investigation_DE
            Language.EN -> goto_investigation_EN
        }
    }

    private const val goto_permission_settings_DE = "Berechtigungen vergeben"
    private const val goto_permission_settings_EN = "Grant permissions"
    fun goToAppPermissionSettings(language: Language): String {
        return when (language) {
            Language.DE -> goto_permission_settings_DE
            Language.EN -> goto_permission_settings_EN
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

    private const val leave_docu_mode_DE = "Dokumentation beenden"
    private const val leave_docu_mode_EN = "Exit documentation"
    fun leaveDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> leave_docu_mode_DE
            Language.EN -> leave_docu_mode_EN
        }
    }

    private const val login_DE = "Anmelden"
    private const val login_EN = "Login"
    fun login(language: Language): String {
        return when (language) {
            Language.DE -> login_DE
            Language.EN -> login_EN
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

    private const val new_investigation_DE = "Neuer Vorgang"
    private const val new_investigation_EN = "New investigation"
    fun newInvestigation(language: Language): String {
        return when (language) {
            Language.DE -> new_investigation_DE
            Language.EN -> new_investigation_EN
        }
    }

    private const val ok_DE = "Ok"
    private const val ok_EN = "Ok"
    fun ok(language: Language): String {
        return when (language) {
            Language.DE -> ok_DE
            Language.EN -> ok_EN
        }
    }

    private const val release_notes_DE = "Was ist neu?"
    private const val release_notes_EN = "What's new?"
    fun releaseNotes(language: Language): String {
        return when (language) {
            Language.DE -> release_notes_DE
            Language.EN -> release_notes_EN
        }
    }

    private const val scan_evidence_DE = "Asservat scannen"
    private const val scan_evidence_EN = "Scan evidence"
    fun scanEvidence(language: Language): String {
        return when (language) {
            Language.DE -> scan_evidence_DE
            Language.EN -> scan_evidence_EN
        }
    }

    private const val select_investigations_DE = "Vorgang auswählen"
    private const val select_investigations_EN = "Select investigation"
    fun selectInvestigation(language: Language): String {
        return when (language) {
            Language.DE -> select_investigations_DE
            Language.EN -> select_investigations_EN
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

    private const val switch_docu_mode_DE = "Zu diesem Tatort wechseln"
    private const val switch_docu_mode_EN = "Switch to this crime scene"
    fun switchDocuMode(language: Language): String {
        return when (language) {
            Language.DE -> switch_docu_mode_DE
            Language.EN -> switch_docu_mode_EN
        }
    }
}