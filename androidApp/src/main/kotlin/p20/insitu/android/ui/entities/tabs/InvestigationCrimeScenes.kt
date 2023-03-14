@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.runtime.*
import kotlinx.serialization.ExperimentalSerializationApi
import p20.insitu.model.entities.CrimeScene
import p20.insitu.nav.NavAction
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.nav.NavDestination
import p20.insitu.android.ui.components.Lists
import p20.insitu.model.entities.Address
import p20.insitu.stateHandler.SessionHandler

@OptIn(ExperimentalSerializationApi::class)
@Composable
fun InvestigationCrimeScenes(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    crimeScenes: List<CrimeScene>,
    crimeSceneAddresses: Map<String, Address?>
) {
    val language = uiStateHandler.language.collectAsState()

    Lists.CrimeScenes(
        items = crimeScenes.map { Pair(it, crimeSceneAddresses[it.id]) },
        language = language.value,
        onClickAction = { item ->
            sessionHandler.userInfo.value?.id?.let { userId ->
                sessionHandler.docuHandler.setSelectedListObject(
                    selectedListObject = item,
                    userId = userId
                )
                navigationState.value = NavDestination.DocuMode.Details.popUpTo(
                    popUpDestination = NavDestination.DocuMode.Home
                )
            }
        }
    )
}
