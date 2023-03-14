@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import p20.insitu.android.ui.components.*
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.entities.CriminalOffense
import p20.insitu.nav.NavAction
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.CriminalOffenseViewModel

@Composable
fun CriminalOffenseTabs(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: CriminalOffenseViewModel,
    entityCreation: Boolean
) {
    // UiStateHandler states
    val docuMode = uiStateHandler.docuMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // DocuHandler states
    val docuObject = sessionHandler.docuHandler.docuObject.collectAsState()

    // Init view model when in docu mode
    if (docuMode.value && !entityCreation) {
        (docuObject.value as? CriminalOffense)?.let { docuObject ->
            // Init view model
            LaunchedEffect(key1 = Unit, block = {
                viewModel.init(
                    docuObject.id,
                    navigationState,
                    null
                )
            })
        }
    }

    // Entity
    val criminalOffense = viewModel.entity.collectAsState()

    // UI
    val tabTitles = TabTitles.getTabTitles(
        setOf(
            TabType.ENTITY_DETAILS,
            TabType.MODUS_OPERANDI
        ), language.value
    )
    val selectedTab = viewModel.selectedTab.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        if (entityCreation) {
            // Always start with the first tab
            viewModel.setSelectedTab(tabTitles[0].first)
        }
    })

    // Content
    if (criminalOffense.value == null) {
        LoadingAnimations.StandardLoadingAnimation()
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Tabs(
                selectedTab = selectedTab.value,
                titles = tabTitles
            ) {
                viewModel.setSelectedTab(it)
            }
            when (selectedTab.value) {
                TabType.ENTITY_DETAILS -> {
                    CriminalOffenseDetails(
                        uiStateHandler = uiStateHandler,
                        catalogRepo = catalogRepo,
                        viewModel = viewModel
                    )
                }
                TabType.MODUS_OPERANDI -> {
                    CriminalOffenseModusOperandi(
                        uiStateHandler = uiStateHandler,
                        catalogRepo = catalogRepo,
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