package p20.insitu.android

import android.app.Activity
import android.os.Build
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.koin.androidx.compose.get
import p20.insitu.android.ui.*
import p20.insitu.android.ui.media.recordings.Camera
import p20.insitu.android.ui.catalogs.CatalogItems
import p20.insitu.android.ui.catalogs.CatalogCategories
import p20.insitu.android.ui.catalogs.CatalogCategoryGroups
import p20.insitu.android.ui.catalogs.CatalogSubCategories
import p20.insitu.android.ui.documode.*
import p20.insitu.android.ui.entities.screens.*
import p20.insitu.android.ui.media.filters.AudioFilterSettings
import p20.insitu.android.ui.media.filters.ImageFilterSettings
import p20.insitu.android.ui.media.filters.NoteFilterSettings
import p20.insitu.android.ui.media.filters.VideoFilterSettings
import p20.insitu.android.ui.media.ImagePager
import p20.insitu.android.ui.menu.Help
import p20.insitu.android.ui.menu.Settings
import p20.insitu.android.ui.media.recordings.AudioRecorder
import p20.insitu.android.ui.media.recordings.VideoRecorder
import p20.insitu.android.ui.menu.ReleaseNotes
import p20.insitu.nav.*
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler

/**
 * Provides the local nav controller
 */
val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

/**
 * Init compose navigation graph
 *
 * Navigation destinations are defined in:
 *      module  "shared"
 *      srcSet  "commonMain"
 *      package "p20.insitu.nav"
 *      file    "NavDestination.kt"
 *
 * @param scaffoldState
 */
@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun InitNavigationGraph(scaffoldState: ScaffoldState) =
    NavHost(
        navController = LocalNavController.current,
        startDestination = NavDestination.Login.baseRoute.toString()
    ) {
        // Misc
        composable(route = NavDestination.AudioFilterSettings.baseRoute.toString()) { AudioFilterSettings() }
        composable(route = NavDestination.AudioRecorder.baseRoute.toString()) { AudioRecorder() }
        composable(route = NavDestination.Camera.baseRoute.toString()) { Camera() }
        composable(route = NavDestination.FunctionNotAvailable.baseRoute.toString()) { FunctionNotAvailable() }
        composable(route = NavDestination.Help.baseRoute.toString()) { Help() }
        composable(route = NavDestination.ImageFilterSettings.baseRoute.toString()) { ImageFilterSettings() }
        composable(route = NavDestination.InvestigationList.baseRoute.toString()) { InvestigationList() }
        composable(route = NavDestination.Login.baseRoute.toString()) { Login() }
        composable(route = NavDestination.NoteFilterSettings.baseRoute.toString()) { NoteFilterSettings() }
        composable(route = NavDestination.QrCodeScanner.baseRoute.toString()) { QrCodeScanner() }
        composable(route = NavDestination.ReleaseNotes.baseRoute.toString()) { ReleaseNotes() }
        composable(route = NavDestination.Settings.baseRoute.toString()) { Settings() }
        composable(route = NavDestination.Start.baseRoute.toString()) { Start(scaffoldState = scaffoldState) }
        composable(route = NavDestination.VideoFilterSettings.baseRoute.toString()) { VideoFilterSettings() }
        composable(route = NavDestination.VideoRecorder.baseRoute.toString()) { VideoRecorder() }

        // DocuMode
        composable(route = NavDestination.DocuMode.Home.baseRoute.toString()) { DocuModeHome() }
        composable(route = NavDestination.DocuMode.List.baseRoute.toString()) { DocuModeList() }
        composable(route = NavDestination.DocuMode.Details.baseRoute.toString() +
                "?${NavArg.INITIAL_TAB.argName}={${NavArg.INITIAL_TAB.argName}}",
            arguments = listOf(
                navArgument(NavArg.INITIAL_TAB.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                }
            )
        ) {
            DocuModeDetails(initialTab = it.arguments?.getString(NavArg.INITIAL_TAB.argName))
        }

        // Image pager
        composable(
            route = NavDestination.ImagePager.baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.IMAGE_INDEX.argName}={${NavArg.IMAGE_INDEX.argName}}" +
                    "&${NavArg.SHOW_NESTED.argName}={${NavArg.SHOW_NESTED.argName}}",
            arguments = listOf(
                navArgument(NavArg.ENTITY_ID.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                },
                navArgument(NavArg.IMAGE_INDEX.argName) {
                    type = NavType.IntType
                    defaultValue = 0
                    nullable = false
                },
                navArgument(NavArg.SHOW_NESTED.argName) {
                    type = NavType.BoolType
                    defaultValue = false
                    nullable = false
                }
            )
        )
        {
            ImagePager(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                imageIndex = it.arguments?.getInt(NavArg.IMAGE_INDEX.argName) ?: 0,
                showNested = it.arguments?.getBoolean(NavArg.SHOW_NESTED.argName) ?: false
            )
        }

        // Debug view
        composable(route = NavDestination.DebugView.baseRoute.toString() +
                "?${NavArg.MESSAGE.argName}={${NavArg.MESSAGE.argName}}",
            arguments = listOf(
                navArgument(NavArg.MESSAGE.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                }
            )
        ) {
            DebugView(message = it.arguments?.getString(NavArg.MESSAGE.argName))
        }

        //region Catalog
        composable(
            route = NavDestination.Catalog.Groups.baseRoute.toString() +
                    "?${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = listOf(
                navArgument(NavArg.DESTINATION.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                }
            )
        ) {
            CatalogCategoryGroups(
                sourceDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.Catalog.Categories.baseRoute.toString() +
                    "?${NavArg.CATALOG_GROUP.argName}={${NavArg.CATALOG_GROUP.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = listOf(
                navArgument(NavArg.CATALOG_GROUP.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                },
                navArgument(NavArg.DESTINATION.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                }
            )
        ) {
            CatalogCategories(
                catalogGroup = it.arguments?.getString(NavArg.CATALOG_GROUP.argName),
                sourceDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.Catalog.SubCategories.baseRoute.toString() +
                    "?${NavArg.CATALOG_GROUP.argName}={${NavArg.CATALOG_GROUP.argName}}" +
                    "&${NavArg.CATALOG_CATEGORY.argName}={${NavArg.CATALOG_CATEGORY.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = listOf(
                navArgument(NavArg.CATALOG_GROUP.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                },
                navArgument(NavArg.CATALOG_CATEGORY.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                },
                navArgument(NavArg.DESTINATION.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                }
            )
        ) {
            CatalogSubCategories(
                catalogGroup = it.arguments?.getString(NavArg.CATALOG_GROUP.argName),
                catalogCategory = it.arguments?.getString(NavArg.CATALOG_CATEGORY.argName),
                sourceDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.Catalog.Items.baseRoute.toString() +
                    "?${NavArg.CATALOG_GROUP.argName}={${NavArg.CATALOG_GROUP.argName}}" +
                    "&${NavArg.CATALOG_CATEGORY.argName}={${NavArg.CATALOG_CATEGORY.argName}}" +
                    "&${NavArg.CATALOG_SUB_CATEGORY.argName}={${NavArg.CATALOG_SUB_CATEGORY.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = listOf(
                navArgument(NavArg.CATALOG_CATEGORY.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                },
                navArgument(NavArg.CATALOG_SUB_CATEGORY.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                },
                navArgument(NavArg.DESTINATION.argName) {
                    type = NavType.StringType
                    defaultValue = null
                    nullable = true
                }
            )
        ) {
            CatalogItems(
                catalogGroup = it.arguments?.getString(NavArg.CATALOG_GROUP.argName),
                catalogCategory = it.arguments?.getString(NavArg.CATALOG_CATEGORY.argName),
                catalogSubCategory = it.arguments?.getString(NavArg.CATALOG_SUB_CATEGORY.argName),
                sourceDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        //endregion

        //region EntityDetailViews
        val defaultEntityNavArgs = listOf(
            navArgument(NavArg.ENTITY_ID.argName) {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            },
            navArgument(NavArg.DESTINATION.argName) {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            }
        )
        val catalogEntityNavArgs = listOf(
            navArgument(NavArg.ENTITY_ID.argName) {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            },
            navArgument(NavArg.DESTINATION.argName) {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            },
            navArgument(NavArg.CATALOG_CODE.argName) {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            }
        )
        composable(
            route = NavDestination.EntityDetailViews.Apartment().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            Apartment(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)

            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Audio().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            Audio(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Building().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            Building(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.CrimeScene().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            CrimeScene(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.CriminalOffense().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            CriminalOffense(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.DNATrace().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}" +
                    "&${NavArg.CATALOG_CODE.argName}={${NavArg.CATALOG_CODE.argName}}",
            arguments = catalogEntityNavArgs
        ) {
            DNATrace(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName),
                catalogCode = it.arguments?.getString(NavArg.CATALOG_CODE.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Door().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}" +
                    "&${NavArg.CATALOG_CODE.argName}={${NavArg.CATALOG_CODE.argName}}",
            arguments = catalogEntityNavArgs
        ) {
            Door(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName),
                catalogCode = it.arguments?.getString(NavArg.CATALOG_CODE.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Floor().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = catalogEntityNavArgs
        ) {
            Floor(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Image().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            Image(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Investigation().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            Investigation(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Note().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            Note(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Person().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}" +
                    "&${NavArg.CATALOG_CODE.argName}={${NavArg.CATALOG_CODE.argName}}",
            arguments = catalogEntityNavArgs
        ) {
            Person(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName),
                catalogCode = it.arguments?.getString(NavArg.CATALOG_CODE.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.PhysicalTrace().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}" +
                    "&${NavArg.CATALOG_CODE.argName}={${NavArg.CATALOG_CODE.argName}}",
            arguments = catalogEntityNavArgs
        ) {
            PhysicalTrace(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName),
                catalogCode = it.arguments?.getString(NavArg.CATALOG_CODE.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Room().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            Room(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.SomeObject().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}" +
                    "&${NavArg.CATALOG_CODE.argName}={${NavArg.CATALOG_CODE.argName}}",
            arguments = catalogEntityNavArgs
        ) {
            SomeObject(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName),
                catalogCode = it.arguments?.getString(NavArg.CATALOG_CODE.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.SomeSite().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            SomeSite(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        composable(
            route = NavDestination.EntityDetailViews.Video().baseRoute.toString() +
                    "?${NavArg.ENTITY_ID.argName}={${NavArg.ENTITY_ID.argName}}" +
                    "&${NavArg.DESTINATION.argName}={${NavArg.DESTINATION.argName}}",
            arguments = defaultEntityNavArgs
        ) {
            Video(
                entityId = it.arguments?.getString(NavArg.ENTITY_ID.argName),
                creationFinishedDestination = it.arguments?.getString(NavArg.DESTINATION.argName)
            )
        }
        //endregion

    }

/**
 * Setup nav destination change listener
 *
 * @return
 */
@Composable
fun rememberNavigationState(): MutableState<NavAction?> {
    val uiStateHandler: UiStateHandler = get()
    val navController = LocalNavController.current
    val navBundle = remember { mutableStateOf<NavAction?>(null) }
    navBundle.value?.let {
        HandleNavigation(
            navController = navController,
            navAction = it,
            uiStateHandler = uiStateHandler
        )
        navBundle.value = null
    }
    return navBundle
}

/**
 * Handle navigation events
 *
 * @param navController
 * @param navAction    The destination the app should navigate to
 * @param uiStateHandler
 */
@Composable
private fun HandleNavigation(
    navController: NavController,
    navAction: NavAction,
    uiStateHandler: UiStateHandler
) {
    // UiStateHandler states
    val editMode = uiStateHandler.editMode.collectAsState()
    val newEntity = uiStateHandler.newEntity.collectAsState()
    val pendingChanges = uiStateHandler.pendingChanges.collectAsState()
    val docuMode = uiStateHandler.docuMode.collectAsState()

    when (navAction.destination) {
        NavDestination.BACK -> {
            var navigateUp = false
            var deactivateEditMode = false

            if (editMode.value) {
                if (pendingChanges.value) {
                    uiStateHandler.showPendingChangesDialog(true)
                } else {
                    if (newEntity.value) {
                        navigateUp = true
                    }
                    deactivateEditMode = true
                }
            } else {
                when (navController.currentDestination?.route) {
                    NavDestination.Login.baseRoute.toString() -> {
                        (LocalContext.current as? Activity)?.finish()
                    }
                    NavDestination.DocuMode.List.baseRoute.toString(),
                    NavDestination.DocuMode.Home.baseRoute.toString(),
                    NavDestination.DocuMode.Details.baseRoute.toString() -> {
                        navigateUp = false
                    }
                    else -> {
                        navigateUp = true
                    }
                }
            }

            if (navigateUp) {
                if (uiStateHandler.specificBackNavDestination != null) {
                    handleNavigation(navController, uiStateHandler.specificBackNavDestination!!)
                    uiStateHandler.specificBackNavDestination = null
                } else {
                    navController.navigateUp()
                }
            }

            if (deactivateEditMode) {
                uiStateHandler.deactivateEditMode()
            }
        }
        else -> {
            handleNavigation(navController, navAction)
        }
    }
}

private fun handleNavigation(
    navController: NavController,
    navAction: NavAction
) {
    when (navAction.navOptions) {
        is NavOptions.Navigate -> {
            (navAction.navOptions as NavOptions.Navigate).let { options ->
                navController.navigate(navAction.destination.route()) {
                    launchSingleTop = options.launchSingleTop
                }
            }
        }
        is NavOptions.PopUpTo -> {
            (navAction.navOptions as NavOptions.PopUpTo).let { options ->
                navController.navigate(navAction.destination.route()) {
                    popUpTo(options.popUpDestination.route()) {
                        saveState = options.saveState
                        inclusive = options.inclusive
                    }
                    launchSingleTop = options.launchSingleTop
                    restoreState = options.restoreState
                }
            }
        }
    }
}

/**
 * Back handler
 *
 * @param enabled
 * @param onBack
 * @receiver
 */
@Composable
fun BackHandler(enabled: Boolean = true, onBack: () -> Unit) {
    // Safely update the current `onBack` lambda when a new one is provided
    val currentOnBack by rememberUpdatedState(onBack)
    // Remember in Composition a back callback that calls the `onBack` lambda
    val backCallback = remember {
        object : OnBackPressedCallback(enabled) {
            override fun handleOnBackPressed() {
                currentOnBack()
            }
        }
    }
    // On every successful composition, update the callback with the `enabled` value
    SideEffect {
        backCallback.isEnabled = enabled
    }
    val backDispatcher = checkNotNull(LocalOnBackPressedDispatcherOwner.current) {
        "No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner"
    }.onBackPressedDispatcher
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner, backDispatcher) {
        // Add callback to the backDispatcher
        backDispatcher.addCallback(lifecycleOwner, backCallback)
        // When the effect leaves the Composition, remove the callback
        onDispose {
            backCallback.remove()
        }
    }
}


@Composable
fun BottomNavigationBar(
    navigationState: MutableState<NavAction?>,
    hostScreen: NavDestination,
    uiStateHandler: UiStateHandler
) {
    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    val items = listOf(
        NavDestination.DocuMode.Home,
        NavDestination.DocuMode.List,
        NavDestination.DocuMode.Details
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.docuModeNavItem(item.baseRoute),
                        contentDescription = IconContentDescriptions.docuModeNavItem(
                            item.baseRoute,
                            language.value
                        )
                    )
                },
                label = {
                    Text(
                        text = TitleStrings.docuModeNavItem(
                            item.baseRoute,
                            language.value
                        ),
                        style = MaterialTheme.typography.subtitle2
                    )
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onSurface,
                alwaysShowLabel = true,
                selected = hostScreen == item,
                onClick = {
                    navigationState.value =
                        item.popUpTo(popUpDestination = hostScreen, inclusive = false)
                }
            )
        }
    }
}