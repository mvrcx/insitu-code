package p20.insitu.android.ui.entities.screens

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.rememberNavController
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.LoadingAnimations
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.nav.NavRoute
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.viewmodels.entities.AudioViewModel
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dialogs.AlertDialogs
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.entities.tabs.AudioTabs
import p20.insitu.android.ui.entities.tabs.FloorTabs
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.stateHandler.SessionHandler

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Audio(
    uiStateHandler: UiStateHandler = get(),
    viewModel: AudioViewModel = get(),
    entityId: String? = null,
    creationFinishedDestination: String? = null
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
                title = EntityTypeStrings.audio(language.value),
                sessionHandler = get(),
                uiStateHandler = get(),
                showEditButton = true,
                viewModel = viewModel
            )
        },
        content = {
            AudioTabs(
                uiStateHandler = get(),
                viewModel = viewModel
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AudioPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Audio()
        }
    }
}