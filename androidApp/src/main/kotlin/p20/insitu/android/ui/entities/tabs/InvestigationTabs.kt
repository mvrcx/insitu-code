@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import p20.insitu.nav.NavAction
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.InvestigationViewModel
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.media.*
import p20.insitu.model.entities.Investigation

@Composable
fun InvestigationTabs(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: InvestigationViewModel,
    entityCreation: Boolean
) {
    // UiStateHandler states
    val docuMode = uiStateHandler.docuMode.collectAsState()
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // DocuHandler states
    val docuObject = sessionHandler.docuHandler.docuObject.collectAsState()

    // Init view model when in docu mode
    if (docuMode.value && !entityCreation) {
        (docuObject.value as? Investigation)?.let {
            // Init view model
            LaunchedEffect(key1 = Unit, block = {
                viewModel.init(
                    it.id,
                    navigationState,
                    null
                )
            })
        }
    }

    // Entity
    val investigation = viewModel.entity.collectAsState()
    // Related entity lists
    val criminalOffenses = viewModel.criminalOffenses.collectAsState(listOf())
    val crimeScenes = viewModel.crimeScenes.collectAsState(listOf())
    val crimeSceneAddresses = viewModel.crimeSceneAddresses.collectAsState(mapOf())
    val persons = viewModel.persons.collectAsState(listOf())

    // UI
    val tabTitles = TabTitles.getTabTitles(
        setOf(
            TabType.ENTITY_DETAILS,
            TabType.CRIMINAL_OFFENSES,
            TabType.CRIME_SCENES,
            TabType.PERSONS,
            TabType.NOTE_ANNOTATIONS,
            TabType.IMAGE_ANNOTATIONS,
            TabType.AUDIO_ANNOTATIONS,
            TabType.VIDEO_ANNOTATIONS
        ),
        language.value
    )
    val selectedTab = viewModel.selectedTab.collectAsState()

    // Content
    if (investigation.value == null) {
        LoadingAnimations.StandardLoadingAnimation()
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            if (editMode.value) {
                InvestigationDetails(
                    uiStateHandler = uiStateHandler,
                    catalogRepo = catalogRepo,
                    entityCreation = entityCreation,
                    viewModel = viewModel
                )
            } else {
                Tabs(
                    selectedTab = selectedTab.value,
                    titles = tabTitles
                ) {
                    viewModel.setSelectedTab(it)
                }
                when (selectedTab.value) {
                    TabType.ENTITY_DETAILS -> {
                        InvestigationDetails(
                            uiStateHandler = uiStateHandler,
                            catalogRepo = catalogRepo,
                            entityCreation = entityCreation,
                            viewModel = viewModel
                        )
                    }
                    TabType.CRIMINAL_OFFENSES -> {
                        InvestigationCriminalOffenses(
                            navigationState = navigationState,
                            sessionHandler = sessionHandler,
                            criminalOffenses = criminalOffenses,
                            language = language.value
                        )
                    }
                    TabType.NEW_INVESTIGATION_CRIMINAL_OFFENSES -> {
                        NewInvestigationCriminalOffenses(
                            uiStateHandler = uiStateHandler,
                            catalogRepo = catalogRepo
                        )
                    }
                    TabType.CRIME_SCENES -> {
                        InvestigationCrimeScenes(
                            navigationState = navigationState,
                            sessionHandler = sessionHandler,
                            uiStateHandler = uiStateHandler,
                            crimeScenes = crimeScenes.value,
                            crimeSceneAddresses = crimeSceneAddresses.value
                        )
                    }
                    TabType.NEW_INVESTIGATION_CRIME_SCENES -> {
                        NewInvestigationCrimeScenes(
                            navigationState = navigationState,
                            uiStateHandler = uiStateHandler
                        )
                    }
                    TabType.PERSONS -> {
                        InvestigationPersons(
                            navigationState = navigationState,
                            sessionHandler = sessionHandler,
                            uiStateHandler = uiStateHandler,
                            persons = persons.value
                        )
                    }
                    TabType.NOTE_ANNOTATIONS -> {
                        NoteGallery(
                            navigationState = navigationState,
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    TabType.IMAGE_ANNOTATIONS -> {
                        ImageGallery(
                            navigationState = navigationState,
                            sessionHandler = sessionHandler,
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    TabType.AUDIO_ANNOTATIONS -> {
                        AudioGallery(
                            navigationState = navigationState,
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    TabType.VIDEO_ANNOTATIONS -> {
                        VideoGallery(
                            navigationState = navigationState,
                            uiStateHandler = uiStateHandler,
                            viewModel = viewModel
                        )
                    }
                    else -> {
                        // Set the start tab for this screen
                        viewModel.setSelectedTab(tabTitles[0].first)
                    }
                }
            }
        }
    }
}
