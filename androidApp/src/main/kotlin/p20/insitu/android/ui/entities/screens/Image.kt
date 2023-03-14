package p20.insitu.android.ui.entities.screens

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.LoadingAnimations
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.viewmodels.entities.ImageViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Image(
    uiStateHandler: UiStateHandler = get(),
    viewModel: ImageViewModel = get(),
    entityId: String? = null,
    creationFinishedDestination: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    val language = uiStateHandler.language.collectAsState()

    val imageBitmap = viewModel.imageBitmap.collectAsState(null)

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
                navigationState = navigationState,
                title = EntityTypeStrings.image(language.value),
                sessionHandler = get(),
                uiStateHandler = get(),
                showEditButton = true,
                viewModel = viewModel
            )
        },
        content = {
            imageBitmap.value?.let {
                androidx.compose.foundation.Image(
                    modifier = Modifier.fillMaxSize(),
                    bitmap = it,
                    contentDescription = EntityTypeStrings.image(language.value)
                )
            } ?: LoadingAnimations.StandardLoadingAnimation()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Image()
        }
    }
}