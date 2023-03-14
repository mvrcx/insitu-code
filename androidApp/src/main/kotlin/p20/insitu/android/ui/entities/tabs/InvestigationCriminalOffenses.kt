@file:Suppress("UNCHECKED_CAST")

package p20.insitu.android.ui.entities.tabs

import androidx.compose.runtime.*
import kotlinx.serialization.ExperimentalSerializationApi
import p20.insitu.model.entities.CriminalOffense
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavDestination
import p20.insitu.resources.Language
import p20.insitu.android.ui.components.*
import p20.insitu.stateHandler.SessionHandler

@OptIn(ExperimentalSerializationApi::class)
@Composable
fun InvestigationCriminalOffenses(
    navigationState: MutableState<NavAction?>,
    sessionHandler: SessionHandler,
    criminalOffenses: State<List<CriminalOffense>?>,
    language: Language
) {
    Lists.CriminalOffenses(
        list = criminalOffenses,
        language = language,
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