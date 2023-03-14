@file:OptIn(ExperimentalSerializationApi::class)

package p20.insitu.android.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.material.Scaffold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.nav.NavDestination
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.viewmodels.InvestigationListViewModel
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.Lists
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.util.LockScreenOrientation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "FlowOperatorInvokedInComposition")
@Composable
fun InvestigationList(
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    docuDataRepo: DocuDataRepo = get(),
    coroutineScope: CoroutineScope = get(),
    viewModel: InvestigationListViewModel = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    // View model states
    val investigations = viewModel.investigations.collectAsState(listOf())

    // Init
    LaunchedEffect(key1 = Unit, block = {
        sessionHandler.docuHandler.clear()
        uiStateHandler.clearSelectedTab()

        // WARNING: Don't do this at home...
        /*
        // Every 3 seconds randomly changing the designation of the first Investigation found in
        // the list. Used to test if Flow updates are coming through from the database.
        coroutineScope.launch {
            while (true) {
                delay(3000L)
                investigations.value.let {
                    if (it.isNotEmpty()) {
                        it[0].designation = randomUUID()
                        it[0].comment = randomUUID()
                        sessionHandler.userInfo.value?.id?.let { userId ->
                            docuDataRepo.update(
                                it[0],
                                userId
                            )
                        }
                    }
                }
            }
        }
         */
    })

    // UI
    Scaffold(
        topBar = {
            TopAppBars.Main(
                title = TitleStrings.investigations(language.value),
                sessionHandler = sessionHandler,
                navigationState = navigationState,
                uiStateHandler = uiStateHandler
            )
        },
        content = {
            Lists.Investigations(
                items = investigations.value,
                language = language.value,
                onClickAction = { item ->
                    sessionHandler.docuHandler.setInvestigation(
                        investigation = item,
                        userId = sessionHandler.userInfo.value?.id
                    )
                    uiStateHandler.activateDocuMode()
                    navigationState.value = NavDestination.DocuMode.Home.navigate()
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun InvestigationListPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            InvestigationList()
        }
    }
}