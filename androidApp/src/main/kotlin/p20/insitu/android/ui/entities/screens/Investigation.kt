package p20.insitu.android.ui.entities.screens

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.material.Scaffold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import org.koin.core.parameter.parametersOf
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.model.entities.Investigation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.nav.NavDestination
import p20.insitu.nav.NavRoute
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.util.TabType
import p20.insitu.viewmodels.entities.InvestigationViewModel
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.entities.tabs.InvestigationTabs
import p20.insitu.android.util.LockScreenOrientation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Investigation(
    uiStateHandler: UiStateHandler = get(),
    viewModel: InvestigationViewModel = get(),
    catalogRepo: CatalogRepo = get(),
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
    val showFilterButton = selectedTab.value?.isMediaTab() ?: false
    val entityCreation = remember { mutableStateOf(entityId == null) }

    // Init view model
    LaunchedEffect(key1 = Unit, block = {
        viewModel.init(
            entityId,
            navigationState,
            creationFinishedDestination?.let { NavRoute.valueOf(it) }
        )
    })

    // Content
    Scaffold(
        topBar = {
            TopAppBars.BaseEntityDetails(
                navigationState = navigationState,
                title = EntityTypeStrings.investigation(language.value),
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
        floatingActionButton = {
            when (selectedTab.value) {
                TabType.CRIMINAL_OFFENSES -> {
                    Buttons.AddBaseEntity(
                        title = EntityTypeStrings.typeString(
                            EntityType.CRIMINAL_OFFENSE,
                            language.value
                        )
                    ) {
                        navigationState.value =
                            NavDestination.getEntityCreationView(EntityType.CRIMINAL_OFFENSE)
                                .navigate()
                    }
                }
                TabType.CRIME_SCENES -> {
                    Buttons.AddBaseEntity(
                        title = EntityTypeStrings.typeString(
                            EntityType.CRIME_SCENE,
                            language.value
                        )
                    ) {
                        navigationState.value =
                            NavDestination.getEntityCreationView(EntityType.CRIME_SCENE)
                                .navigate()
                    }
                }
                TabType.PERSONS -> {
                    Buttons.AddBaseEntity(
                        title = EntityTypeStrings.typeString(
                            EntityType.PERSON,
                            language.value
                        )
                    ) {
                        navigationState.value =
                            NavDestination.getEntityCreationView(EntityType.PERSON).navigate()
                    }
                }
                TabType.NOTE_ANNOTATIONS,
                TabType.IMAGE_ANNOTATIONS,
                TabType.AUDIO_ANNOTATIONS,
                TabType.VIDEO_ANNOTATIONS -> {
                    Buttons.AddAnnotation(
                        selectedTab = selectedTab.value,
                        language = language.value
                    )
                }
                else -> {}
            }
        },
        content = {
            InvestigationTabs(
                navigationState = navigationState,
                sessionHandler = get(),
                uiStateHandler = get(),
                viewModel = viewModel,
                catalogRepo = catalogRepo,
                entityCreation = entityCreation.value
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun InvestigationPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Investigation()
        }
    }
}