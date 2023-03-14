@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.runtime.*
import org.koin.androidx.compose.get
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.*
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.nav.NavRoute
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.entities.CriminalOffenseViewModel

@Composable
fun NewInvestigationCriminalOffenses(
    uiStateHandler: UiStateHandler,
    catalogRepo: CatalogRepo,
    viewModel: CriminalOffenseViewModel = get()
) {
    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Entity fields
    val typeOfCrime = viewModel.typeOfCrime.collectAsState(null)

    // Init view model
    LaunchedEffect(key1 = Unit, block = {
        viewModel.init(
            null,
            navigationState,
            null
        )
    })

    Containers.StandardAttributeContainer(
        uiStateHandler = uiStateHandler
    ) {

    }
}