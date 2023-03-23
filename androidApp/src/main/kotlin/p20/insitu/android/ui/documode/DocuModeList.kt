package p20.insitu.android.ui.documode

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.android.BottomNavigationBar
import p20.insitu.android.rememberNavigationState
import p20.insitu.model.entities.DocNumberObject
import p20.insitu.nav.NavDestination
import p20.insitu.nav.NavRoute
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.documode.DocuListViewModel
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.components.buttons.FabOption
import p20.insitu.android.ui.components.buttons.MultiFabItem
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.icons.Evidence
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.ButtonStrings
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.resources.strings.MessageStrings

@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun DocuModeList(
    scaffoldState: ScaffoldState,
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    viewModel: DocuListViewModel = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val language = uiStateHandler.language.collectAsState()

    // Get the logged in user
    val loggedInUser = sessionHandler.userInfo.collectAsState(null)

    // Get the active investigation
    val docuObject = sessionHandler.docuHandler.docuObject.collectAsState(null)
    val selectedListObject = sessionHandler.docuHandler.selectedListObject.collectAsState(null)
    val investigation = sessionHandler.docuHandler.investigation.collectAsState(null)
    val parent = sessionHandler.docuHandler.docNumberParent.collectAsState(null)

    // View model states
    val docItems = viewModel.docItems.collectAsState(null)
    val crimeScenes = viewModel.crimeScenes.collectAsState(listOf())
    val crimeSceneAddresses = viewModel.crimeSceneAddresses.collectAsState(mapOf())

    LaunchedEffect(key1 = Unit, block = {
        // In case it is not set yet, activate the documentation mode
        if (!uiStateHandler.docuMode.value) {
            uiStateHandler.activateDocuMode()
        }
        // Reset docu object to the last selected object (if there is one)
        selectedListObject.value?.let { lastSelectedObject ->
            if (lastSelectedObject.id != docuObject.value?.id) {
                sessionHandler.userInfo.value?.id?.let { userId ->
                    sessionHandler.docuHandler.setSelectedListObject(
                        selectedListObject = lastSelectedObject,
                        userId = userId
                    )
                }
            }
        }
    })

    // Content
    Scaffold(
        topBar = {
            TopAppBars.DocuMode(
                navigationState = navigationState,
                sessionHandler = get(),
                uiStateHandler = get()
            )
        },
        floatingActionButton = {
            if (selectedListObject.value == null) {
                Buttons.AddBaseEntity(
                    title = EntityTypeStrings.typeString(EntityType.CRIME_SCENE, language.value)
                ) {
                    navigationState.value =
                        NavDestination.getEntityCreationView(EntityType.CRIME_SCENE)
                            .navigate()
                }
            } else {
                Buttons.MultiFloatingActionButton(
                    fabOption = FabOption(
                        iconTint = MaterialTheme.colors.onSecondary,
                        showLabels = true,
                        backgroundTint = MaterialTheme.colors.secondary,
                    ),
                    itemsMultiFab = listOf(
                        MultiFabItem(
                            icon = Icons.getEntityTypeIcon(EntityType.NOTE),
                            label = ButtonStrings.addBaseEntity(EntityType.NOTE, language.value),
                            id = EntityType.NOTE.toString()
                        ),
                        MultiFabItem(
                            icon = Icons.getEntityTypeIcon(EntityType.AUDIO),
                            label = ButtonStrings.addBaseEntity(EntityType.AUDIO, language.value),
                            id = EntityType.AUDIO.toString()
                        ),
                        MultiFabItem(
                            icon = Icons.getEntityTypeIcon(EntityType.IMAGE),
                            label = ButtonStrings.addBaseEntity(EntityType.IMAGE, language.value),
                            id = EntityType.IMAGE.toString()
                        ),
                        MultiFabItem(
                            icon = Icons.getEntityTypeIcon(EntityType.VIDEO),
                            label = ButtonStrings.addBaseEntity(EntityType.VIDEO, language.value),
                            id = EntityType.VIDEO.toString()
                        ),
                        MultiFabItem(
                            icon = Icons.Filled.Evidence,
                            label = ButtonStrings.addEvidenceToList(language.value),
                            id = "Evidence"
                        )
                    )
                ) {
                    when (it.id) {
                        EntityType.NOTE.toString() -> {
                            navigationState.value =
                                NavDestination.getEntityCreationView(EntityType.NOTE).navigate()
                        }
                        EntityType.AUDIO.toString() -> {
                            navigationState.value = NavDestination.AudioRecorder.navigate()
                        }
                        EntityType.IMAGE.toString() -> {
                            navigationState.value = NavDestination.Camera.navigate()
                        }
                        EntityType.VIDEO.toString() -> {
                            navigationState.value = NavDestination.VideoRecorder.navigate()
                        }
                        "Evidence" -> {
                            navigationState.value = NavDestination.Catalog.Groups.withCatalogArgs(
                                categoryGroup = null,
                                category = null,
                                subCategory = null,
                                sourceDestination = NavRoute.DOCU_MODE_LIST
                            ).navigate()
                        }
                    }
                }
            }
        },
        snackbarHost = { SnackbarHost(hostState = scaffoldState.snackbarHostState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = Padding.docuModeBottom),
                verticalArrangement = Arrangement.Top
            ) {
                if (selectedListObject.value == null) {
                    investigation.value?.let {
                        MiscComponents.DocuObjectBar(
                            docuObject = it,
                            language = language.value
                        )
                    }
                    if (crimeScenes.value.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(Padding.screen),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = MessageStrings.createCrimeScene(language.value),
                                style = MaterialTheme.typography.h5
                            )
                        }
                    } else {
                        Lists.CrimeScenes(
                            items = crimeScenes.value.map { Pair(it, crimeSceneAddresses.value[it.id]) },
                            language = language.value,
                            onClickAction = { item ->
                                sessionHandler.userInfo.value?.id?.let { userId ->
                                    sessionHandler.docuHandler.setSelectedListObject(
                                        selectedListObject = item,
                                        userId = userId
                                    )
                                }
                            }
                        )
                    }
                } else {
                    // Parent object
                    parent.value?.let {
                        MiscComponents.DocuObjectBar(
                            docuObject = it,
                            showMoveListUpBtn = true,
                            language = language.value,
                            onClickAction = {
                                parent.value?.let { parentObject ->
                                    sessionHandler.userInfo.value?.id?.let { userId ->
                                        sessionHandler.docuHandler.setSelectedListObject(
                                            selectedListObject = parentObject,
                                            userId = userId
                                        )
                                    }
                                }
                            }
                        )
                    } ?: run {
                        // Show "Go to crime scenes list" button
                        MiscComponents.DocuObjectBarGoToCrimeSceneList(language = language.value) {
                            sessionHandler.userInfo.value?.id?.let { userId ->
                                sessionHandler.docuHandler.setSelectedListObject(
                                    selectedListObject = null,
                                    userId = userId
                                )
                            }
                        }
                    }

                    SpacersAndDividers.VerticalSpacer()

                    //SubTitles.SimpleSubtitle(text = TitleStrings.selectedListObject(language.value))
                    // The currently active documentation object
                    selectedListObject.value?.let { selectedObject ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = Padding.screen),
                        ) {
                            Cards.DocuObjectLarge(
                                docuModeActive = uiStateHandler.docuMode.value,
                                docuObject = selectedObject,
                                address = sessionHandler.docuHandler.crimeSceneAddress.value,
                                language = language.value
                            ) {
                                navigationState.value =
                                    NavDestination.DocuMode.Details.popUpTo(
                                        popUpDestination = NavDestination.DocuMode.List
                                    )
                            }
                        }
                    }

                    SpacersAndDividers.HorizontalDivider()

                    // The list oif child objects
                    docItems.value?.let {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Lists.DocNumberObjects(
                                items = it,
                                uiStateHandler = uiStateHandler,
                                onStartEditing = viewModel::startEditing,
                                onSwap = viewModel::swapDocItems,
                                onStopEditing = viewModel::stopEditing,
                                onClickAction = { item ->
                                    sessionHandler.userInfo.value?.id?.let { userId ->
                                        sessionHandler.docuHandler.setSelectedListObject(
                                            selectedListObject = item,
                                            userId = userId
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                navigationState = navigationState,
                hostScreen = NavDestination.DocuMode.List,
                uiStateHandler = uiStateHandler
            )
        }
    )
}