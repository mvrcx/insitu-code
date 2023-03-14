package p20.insitu.android.ui.entities.screens

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.CriminalOffenseViewModel
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dialogs.AlertDialogs
import p20.insitu.android.ui.entities.tabs.CriminalOffenseTabs
import p20.insitu.android.util.LockScreenOrientation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CriminalOffense(
    uiStateHandler: UiStateHandler = get(),
    viewModel: CriminalOffenseViewModel = get(),
    entityId: String? = null,
    creationFinishedDestination: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    // UI
    val selectedTab = viewModel.selectedTab.collectAsState()
    val showEditButton = selectedTab.value == TabType.ENTITY_DETAILS ||
            selectedTab.value == TabType.MODUS_OPERANDI
    val entityCreation = remember { mutableStateOf(entityId == null) }

    // Init view model
    LaunchedEffect(key1 = Unit, block = {
        viewModel.init(
            entityId,
            navigationState
        )
    })

    Scaffold(
        topBar = {
            TopAppBars.BaseEntityDetails(
                title = EntityTypeStrings.typeString(EntityType.CRIMINAL_OFFENSE, language.value),
                navigationState = navigationState,
                sessionHandler = get(),
                uiStateHandler = get(),
                showEditButton = showEditButton,
                viewModel = viewModel
            )
        },
        content = {
            CriminalOffenseTabs(
                navigationState = navigationState,
                sessionHandler = get(),
                uiStateHandler = get(),
                catalogRepo = get(),
                viewModel = viewModel,
                entityCreation = entityCreation.value
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CriminalOffensePreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            CriminalOffense()
        }
    }
}