package p20.insitu.android.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import p20.insitu.resources.Language
import p20.insitu.resources.icons.CrimeScene
import p20.insitu.resources.icons.CriminalOffense
import p20.insitu.resources.icons.Evidence
import p20.insitu.resources.strings.TabStrings
import p20.insitu.util.TabType

object TabTitles {

    fun getTabTitles(
        types: Set<TabType>,
        language: Language
    ): List<Triple<TabType, String, ImageVector>> {
        return types.mapNotNull { getTabTitle(it, language) }
    }

    fun getDefaultDocuObjectTabTitles(
        language: Language
    ): List<Triple<TabType, String, ImageVector>> {
        return getTabTitles(
            setOf(
                TabType.ENTITY_DETAILS,
                TabType.NOTE_ANNOTATIONS,
                TabType.AUDIO_ANNOTATIONS,
                TabType.IMAGE_ANNOTATIONS,
                TabType.VIDEO_ANNOTATIONS
            ), language
        )
    }

    fun getEditEvidenceTabTitles(
        language: Language
    ): List<Triple<TabType, String, ImageVector>> {
        return getTabTitles(
            setOf(
                TabType.ENTITY_DETAILS,
                TabType.EVIDENCE_DATA
            ), language
        )
    }

    fun getViewEvidenceTabTitles(
        language: Language
    ): List<Triple<TabType, String, ImageVector>> {
        return getTabTitles(
            setOf(
                TabType.ENTITY_DETAILS,
                TabType.EVIDENCE_DATA,
                TabType.NOTE_ANNOTATIONS,
                TabType.AUDIO_ANNOTATIONS,
                TabType.IMAGE_ANNOTATIONS,
                TabType.VIDEO_ANNOTATIONS
            ), language
        )
    }

    private fun getTabTitle(
        type: TabType,
        language: Language
    ): Triple<TabType, String, ImageVector>? {
        return when (type) {
            TabType.ADDRESS_DETAILS -> Triple(
                type,
                TabStrings.address(language),
                Icons.Filled.LocationOn
            )
            TabType.AUDIO_ANNOTATIONS -> Triple(
                type,
                TabStrings.audioRecordings(language),
                Icons.Filled.LibraryMusic
            )
            TabType.AUDIO_PLAYER -> Triple(
                type,
                TabStrings.audioPlayer(language),
                Icons.Filled.Audiotrack
            )
            TabType.IMAGE_ANNOTATIONS -> Triple(
                type,
                TabStrings.images(language),
                Icons.Filled.PhotoLibrary
            )
            TabType.NOTE_ANNOTATIONS -> Triple(
                type,
                TabStrings.notes(language),
                Icons.Filled.LibraryBooks
            )
            TabType.VIDEO_ANNOTATIONS -> Triple(
                type,
                TabStrings.videos(language),
                Icons.Filled.VideoLibrary
            )
            TabType.CRIME_SCENES,
            TabType.NEW_INVESTIGATION_CRIME_SCENES -> Triple(
                type,
                TabStrings.crimeScenes(language),
                p20.insitu.resources.icons.Icons.Filled.CrimeScene
            )
            TabType.CRIMINAL_OFFENSES,
            TabType.NEW_INVESTIGATION_CRIMINAL_OFFENSES -> Triple(
                type,
                TabStrings.criminalOffenses(language),
                p20.insitu.resources.icons.Icons.Filled.CriminalOffense
            )
            TabType.ENTITY_DETAILS -> Triple(
                type,
                TabStrings.description(language),
                Icons.Filled.Info
            )
            TabType.EVIDENCE_DATA -> Triple(
                type,
                TabStrings.evidenceData(language),
                p20.insitu.resources.icons.Icons.Filled.Evidence
            )
            TabType.MAP -> Triple(
                type,
                TabStrings.map(language),
                Icons.Filled.Map
            )
            TabType.MODUS_OPERANDI -> Triple(
                type,
                TabStrings.modusOperandi(language),
                Icons.Filled.SelfImprovement
            )
            TabType.PERSONS -> Triple(
                type,
                TabStrings.persons(language),
                Icons.Filled.Groups
            )
            else -> {
                null
            }
        }
    }

}