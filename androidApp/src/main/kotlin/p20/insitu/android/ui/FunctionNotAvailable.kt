package p20.insitu.android.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.get
import p20.insitu.android.rememberNavigationState
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.stateHandler.SessionHandler

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun FunctionNotAvailable(
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    docuDataRepo: DocuDataRepo = get(),
    message: String? = null
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    Scaffold(
        topBar = {
            TopAppBars.Main(
                title = TitleStrings.insitu(language.value),
                navigationState = navigationState,
                sessionHandler = sessionHandler,
                uiStateHandler = uiStateHandler,
                showBackNavigation = true
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = MessageStrings.featureNotImplementedYet(language.value))
            }
        }
    )
}