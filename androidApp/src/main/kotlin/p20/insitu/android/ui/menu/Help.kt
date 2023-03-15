package p20.insitu.android.ui.menu

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding
import kotlin.random.Random

/**
 * Screen used to display context sensitive help information.
 */
@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Help(
    uiStateHandler: UiStateHandler = get(),
    sessionHandler: SessionHandler = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // TopAppBar navigation block
    val navigationState = rememberNavigationState()

    Scaffold(
        topBar = {
            TopAppBars.Help(
                navigationState = navigationState,
                uiStateHandler = uiStateHandler
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

                // ;-)
                if (Random.nextBoolean()) {
                    Text("DON'T PANIC")
                } else {
                    Text("422")
                }

                //Text(text = "Hallo ${sessionHandler.userInfo.collectAsState().value?.firstName}! Hier wird dir geholfen")
                //Text(text = "Ich sehe du brauchst Hilfe zu: $previousDestination")
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun HelpPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Help()
        }
    }
}