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
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.nav.NavDestination
import p20.insitu.nav.NavRoute
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.CrimeSceneViewModel
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.entities.tabs.CrimeSceneTabs
import p20.insitu.android.util.LockScreenOrientation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CrimeScene(
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    catalogRepo: CatalogRepo = get(),
    viewModel: CrimeSceneViewModel = get(),
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
    val showEditButton = selectedTab.value == TabType.ENTITY_DETAILS
    val showFilterButton = selectedTab.value?.isMediaTab()?:false
    val entityCreation = remember { mutableStateOf(entityId == null) }

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
                title = EntityTypeStrings.crimeScene(language.value),
                sessionHandler = get(),
                uiStateHandler = get(),
                viewModel = viewModel,
                showEditButton = showEditButton,
                showFilterButton = showFilterButton,
                onFilterBtnClick = {
                    when (selectedTab.value) {
                        TabType.NOTE_ANNOTATIONS -> {
                            navigationState.value = NavDestination.NoteFilterSettings.navigate()
                        }
                        TabType.IMAGE_ANNOTATIONS -> {
                            navigationState.value = NavDestination.ImageFilterSettings.navigate()
                        }
                        TabType.AUDIO_ANNOTATIONS -> {
                            navigationState.value = NavDestination.AudioFilterSettings.navigate()
                        }
                        TabType.VIDEO_ANNOTATIONS -> {
                            navigationState.value = NavDestination.VideoFilterSettings.navigate()
                        }
                        else -> {}
                    }
                }
            )
        },
        floatingActionButton = { Buttons.AddAnnotation(selectedTab.value, language.value) },
        content = {
            CrimeSceneTabs(
                navigationState = navigationState,
                sessionHandler = sessionHandler,
                uiStateHandler = uiStateHandler,
                catalogRepo = catalogRepo,
                viewModel = viewModel,
                entityCreation = entityCreation.value
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CrimeScenePreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            CrimeScene()
        }
    }
}