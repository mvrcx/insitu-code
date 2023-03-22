package p20.insitu.android

import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import p20.insitu.android.util.KeyEventHandler
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.db.catalogs.CatalogCsvImporter
import p20.insitu.nav.NavDestination
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.theme.colors.SystemUIDark
import p20.insitu.theme.colors.SystemUILight
import p20.insitu.util.userMessages.UserAction
import p20.insitu.util.userMessages.UserMessage

/**
 * The main activity
 *
 * Initializes the compose UI.
 *
 * @constructor Create MainActivity
 */
class MainActivity : ComponentActivity() {

    private val keyEventHandlers = mutableListOf<KeyEventHandler>()

    /**
     * Callback for the "onCreate" lifecycle state.
     *
     * Entry point for the compose UI.
     *
     * @param savedInstanceState
     */
    @RequiresApi(Build.VERSION_CODES.S)
    @OptIn(ExperimentalPermissionsApi::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val uiStateHandler: UiStateHandler = get()
            val scaffoldState: ScaffoldState = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()


            LaunchedEffect(Unit) {
                // Init catalog database
                coroutineScope.launch {
                    CatalogCsvImporter().initDatabase { inProgress, catalogCount, _ ->
                        if (inProgress && catalogCount == 0) {
                            uiStateHandler.setUserMessage(
                                // TODO make language dependent
                                UserMessage(
                                    "Initialisierung der Katalog-Datenbank gestartet.\"",
                                    UserAction.NONE
                                )
                            )
                        }
                        if (!inProgress) {
                            uiStateHandler.setUserMessage(
                                // TODO make language dependent
                                UserMessage(
                                    "Katalog-Datenbank initialisiert. " +
                                            "$catalogCount Kataloge verfügbar.",
                                    UserAction.NONE
                                )
                            )
                        }
                    }
                }
            }

            // App UI
            InsituTheme {
                // Lock the screen orientation in portrait mode
                LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

                val systemUiColor = if (isSystemInDarkTheme()) {
                    SystemUIDark
                } else {
                    SystemUILight
                }
                window.navigationBarColor = systemUiColor.toArgb()
                window.statusBarColor = systemUiColor.toArgb()

                // If the UI state demands for snackbar, show it
                if (uiStateHandler.showSnackBar.collectAsState().value) {

                    val scaffoldState = rememberScaffoldState()
                    LaunchedEffect(Unit) {
                        scaffoldState.snackbarHostState.showSnackbar("Hello, Jetpack Compose!")
                    }
                    Scaffold(
                        scaffoldState = scaffoldState,
                        content = { padding ->
                            Column(
                                modifier = Modifier
                                    .padding(padding)
                            ) {}
                        },
                        //backgroundColor = color.transparent
                        //contentColor = Color.Transparent
                    )

                    Toast.makeText(
                        applicationContext,
                        uiStateHandler.userMessage.value?.message ?: "TEST",
                        Toast.LENGTH_SHORT
                    ).show()
                    uiStateHandler.showSnackBar(false)
                }


                // If the UI state contains an error, show snackbar
                if (uiStateHandler.userMessage.collectAsState().value != null) {
                    Toast.makeText(
                        applicationContext,
                        uiStateHandler.userMessage.value?.message ?: "ohoh",
                        Toast.LENGTH_SHORT
                    ).show()
                    // TODO: Snackbar not working
//                    // `LaunchedEffect` will cancel and re-launch if
//                    // `scaffoldState.snackbarHostState` changes
//                    LaunchedEffect(scaffoldState.snackbarHostState) {
//                        // Show snackbar using a coroutine, when the coroutine is cancelled the
//                        // snackbar will automatically dismiss. This coroutine will cancel whenever
//                        // `state.hasError` is false, and only start when `state.hasError` is true
//                        // (due to the above if-check), or if `scaffoldState.snackbarHostState` changes.
//                        scaffoldState.snackbarHostState.showSnackbar(
//                            message = uiStateHandler.errorMessage.value?.message ?: "error",
//                            actionLabel = uiStateHandler.errorMessage.value?.relatedUserAction?.actionLabel,
//                            duration = if (uiStateHandler.errorMessage.value?.relatedUserAction?.actionLabel != null) {
//                                SnackbarDuration.Indefinite
//                            } else {
//                                SnackbarDuration.Long
//                            }
//                        )
//                    }
                    uiStateHandler.clearUserMessage()
                }

                // Hide the ui software keyboard when leaving edit mode
                val editMode = uiStateHandler.editMode.collectAsState()
                if (!editMode.value) {
                    LocalFocusManager.current.clearFocus()
                }

                val language = uiStateHandler.language.collectAsState()
                PermissionHandling(this, language = language.value)

                // UI content
                CompositionLocalProvider(LocalNavController provides rememberNavController()) {
                    InitNavigationGraph(scaffoldState = scaffoldState)

                    // App system UI back navigation
                    val navDestination = rememberNavigationState()
                    BackHandler {
                        navDestination.value = NavDestination.BACK.navigate()
                    }
                }
            }
        }
    }

    /*
    override fun onKeyDown(keyCode: Int, keyEvent: KeyEvent): Boolean {
        println("KEY PRESS: ${keyCode}")
        return if (keyCode == 25) {
            Toast.makeText(applicationContext, "Hallo ROOOOOOBERT", Toast.LENGTH_SHORT).show()
            true
        } else {
            keyEventHandlers.reversed().any { it(keyCode, keyEvent) } || super.onKeyDown(
                keyCode,
                keyEvent
            )
        }
    }
     */
}