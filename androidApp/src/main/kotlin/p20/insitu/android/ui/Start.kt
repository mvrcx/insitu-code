@file:OptIn(ExperimentalSerializationApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package p20.insitu.android.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.*
import p20.insitu.model.entities.*
import p20.insitu.nav.NavDestination
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.viewmodels.StartViewModel
import p20.insitu.android.ui.components.SpacersAndDividers.VerticalSpacer
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.components.dimen.CardSize
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.components.dimen.Spacing
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.util.userMessages.PredefinedErrorMessages

/**
 * The INSITU app start screen.
 *
 * @param sessionHandler
 */
@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Start(
    scaffoldState: ScaffoldState,
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    viewModel: StartViewModel = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val language = uiStateHandler.language.collectAsState()

    // ViewModel states
    val lastActiveInvestigation = viewModel.lastActiveInvestigation.collectAsState(null)
    val lastActiveCrimeScene = viewModel.lastActiveCrimeScene.collectAsState(null)
    val lastActiveDocuObject = viewModel.lastActiveDocuObject.collectAsState(null)

    // TopAppBar navigation block
    val navigationState = rememberNavigationState()

    LaunchedEffect(key1 = Unit, block = {
        sessionHandler.docuHandler.clear()
        uiStateHandler.clearSelectedTab()
    })

    // The scaffold implements the basic material design layout structure (TopBar, BottomBar, FAB, Drawer)
    Scaffold(
        topBar = {
            TopAppBars.Main(
                title = TitleStrings.insitu(language.value),
                navigationState = navigationState,
                sessionHandler = sessionHandler,
                uiStateHandler = uiStateHandler,
                showBackNavigation = false
            )
        },
        snackbarHost = { SnackbarHost(hostState = scaffoldState.snackbarHostState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .padding(
                        top = Padding.screen,
                        start = Padding.screen,
                        end = Padding.screen,
                        bottom = Padding.large
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MiscComponents.UserImage(
                    language = language.value,
                    defaultImage = true
                )

                Text(
                    text = "${MessageStrings.hello(language.value)} " +
                            "${sessionHandler.userInfo.collectAsState().value?.firstName}"
                )

                VerticalSpacer(height = Spacing.large)

                // Show last edited object card
                lastActiveDocuObject.value?.let { docuObject ->
                    Text(text = MessageStrings.lastActiveObject(language.value))
                    VerticalSpacer()
                    when (docuObject) {
                        is Investigation -> {
                            Cards.Investigation(
                                docuModeActive = uiStateHandler.docuMode.value,
                                investigation = docuObject,
                                language = language.value
                            ) {
                                lastActiveCrimeScene.value?.let { crimeScene ->
                                    sessionHandler.docuHandler.setDocuHandler(
                                        docuObject = docuObject,
                                        crimeScene = crimeScene,
                                        investigation = docuObject,
                                        selectedDetailsObject = crimeScene,
                                        selectedListObject = crimeScene,
                                        userId = sessionHandler.userInfo.value?.id
                                    )
                                } ?: run {
                                    sessionHandler.docuHandler.setDocuHandler(
                                        docuObject = docuObject,
                                        crimeScene = null,
                                        investigation = docuObject,
                                        selectedDetailsObject = null,
                                        selectedListObject = null,
                                        userId = sessionHandler.userInfo.value?.id
                                    )
                                }
                                navigationState.value = NavDestination.DocuMode.Home.navigate()
                            }
                        }
                        is CrimeScene -> {
                            Cards.CrimeScene(
                                docuModeActive = uiStateHandler.docuMode.value,
                                crimeScene = docuObject,
                                address = sessionHandler.docuHandler.crimeSceneAddress.value,
                                language = language.value
                            ) {
                                lastActiveInvestigation.value?.let { investigation ->
                                    sessionHandler.docuHandler.setDocuHandler(
                                        docuObject = docuObject,
                                        crimeScene = docuObject,
                                        investigation = investigation,
                                        selectedDetailsObject = docuObject,
                                        selectedListObject = docuObject,
                                        userId = sessionHandler.userInfo.value?.id
                                    )
                                    navigationState.value =
                                        NavDestination.DocuMode.Details.navigate()
                                }
                            }
                        }
                        is Person -> {
                            Cards.Person(
                                person = docuObject,
                                language = language.value
                            ) {
                                lastActiveInvestigation.value?.let { investigation ->
                                    lastActiveCrimeScene.value?.let { crimeScene ->
                                        sessionHandler.docuHandler.setDocuHandler(
                                            docuObject = docuObject,
                                            crimeScene = crimeScene,
                                            investigation = investigation,
                                            selectedDetailsObject = docuObject,
                                            selectedListObject = crimeScene,
                                            userId = sessionHandler.userInfo.value?.id
                                        )
                                    }
                                    sessionHandler.docuHandler.setDocuHandler(
                                        docuObject = docuObject,
                                        crimeScene = null,
                                        investigation = investigation,
                                        selectedDetailsObject = docuObject,
                                        selectedListObject = null,
                                        userId = sessionHandler.userInfo.value?.id
                                    )
                                    navigationState.value =
                                        NavDestination.DocuMode.Details.navigate()
                                }
                            }
                        }
                        is DocNumberObject -> {
                            Cards.DocuObjectLarge(
                                docuModeActive = uiStateHandler.docuMode.value,
                                docuObject = docuObject,
                                language = language.value
                            ) {
                                lastActiveInvestigation.value?.let { investigation ->
                                    lastActiveCrimeScene.value?.let { crimeScene ->
                                        sessionHandler.docuHandler.setDocuHandler(
                                            docuObject = docuObject,
                                            crimeScene = crimeScene,
                                            investigation = investigation,
                                            selectedDetailsObject = docuObject,
                                            selectedListObject = docuObject,
                                            userId = sessionHandler.userInfo.value?.id
                                        )
                                        navigationState.value =
                                            NavDestination.DocuMode.Details.navigate()
                                    }
                                }
                            }
                        }
                    }
                    VerticalSpacer(height = Spacing.large)
                } ?: run {
                    VerticalSpacer(height = Spacing.large + Spacing.large + CardSize.large)
                }

                Buttons.NewInvestigation(language.value) {
                    navigationState.value =
                        NavDestination.getEntityCreationView(EntityType.INVESTIGATION).navigate()
                }

                VerticalSpacer()

                Buttons.SelectInvestigation(language.value) {
                    navigationState.value = NavDestination.InvestigationList.navigate()
                }

                VerticalSpacer(height = Spacing.large)

                Buttons.EmergencyDocu(language.value) {
                    uiStateHandler.setUserMessage(
                        PredefinedErrorMessages.NOT_YET_AVAILABEL(
                            uiStateHandler.language.value
                        )
                    )
                    // TODO navigationState.value = NavDestinations.EmergencyDocu.navigate()
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun StartPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Start(rememberScaffoldState())
        }
    }
}