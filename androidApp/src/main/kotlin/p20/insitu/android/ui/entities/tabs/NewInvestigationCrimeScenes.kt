@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.runtime.*
import p20.insitu.android.ui.components.Containers
import p20.insitu.model.entities.CrimeScene
import p20.insitu.nav.NavAction
import p20.insitu.resources.Language
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.nav.NavDestination
import p20.insitu.android.ui.components.Lists
import p20.insitu.android.ui.components.dialogs.AlertDialogs

@Composable
fun NewInvestigationCrimeScenes(
    navigationState: MutableState<NavAction?>,
    uiStateHandler: UiStateHandler
) {
    val language = uiStateHandler.language.collectAsState()

    Containers.StandardAttributeContainer(
        uiStateHandler = uiStateHandler
    ) {

    }

}
