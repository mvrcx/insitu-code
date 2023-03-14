@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.runtime.*
import kotlinx.serialization.ExperimentalSerializationApi
import p20.insitu.model.entities.Person
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.ui.components.Lists
import p20.insitu.stateHandler.SessionHandler

@OptIn(ExperimentalSerializationApi::class)
@Composable
fun InvestigationPersons(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    persons: List<Person>
) {
    val language = uiStateHandler.language.collectAsState()

    Lists.Persons(
        items = persons,
        language = language.value,
        onClickAction = { item ->
            sessionHandler.userInfo.value?.id?.let { userId ->
                sessionHandler.docuHandler.setSelectedDetailsObject(
                    selectedDetailsObject = item,
                    userId = userId
                )
                navigationState.value = NavDestination.DocuMode.Details.popUpTo(
                    popUpDestination = NavDestination.DocuMode.Home
                )
            }
        }
    )
}