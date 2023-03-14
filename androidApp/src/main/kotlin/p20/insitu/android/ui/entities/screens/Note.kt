package p20.insitu.android.ui.entities.screens

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.material.Scaffold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.nav.NavRoute
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.viewmodels.entities.NoteViewModel
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.entities.tabs.NoteDetails
import p20.insitu.android.util.LockScreenOrientation

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun Note(
    uiStateHandler: UiStateHandler = get(),
    docuDataRepo: DocuDataRepo = get(),
    viewModel: NoteViewModel = get(),
    entityId: String? = null,
    creationFinishedDestination: String? = null,
    catalogCode: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    // Init view model
    LaunchedEffect(key1 = Unit, block = {
        viewModel.init(
            entityId,
            navigationState,
            creationFinishedDestination?.let { NavRoute.valueOf(it) }
        )
    })

    Scaffold(
        topBar = {
            TopAppBars.BaseEntityDetails(
                navigationState = navigationState,
                title = EntityTypeStrings.note(language.value),
                sessionHandler = get(),
                uiStateHandler = get(),
                showEditButton = true,
                viewModel = viewModel
            )
        },
        content = {
            NoteDetails(
                uiStateHandler = get(),
                viewModel = viewModel
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun NotePreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Note()
        }
    }
}