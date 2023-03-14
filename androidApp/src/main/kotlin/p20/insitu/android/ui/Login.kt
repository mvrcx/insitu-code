package p20.insitu.android.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import p20.insitu.android.BuildConfig
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.*
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.nav.NavDestination
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.util.password
import p20.insitu.util.username
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.components.dimen.Spacing
import p20.insitu.android.util.LockScreenOrientation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Login(
    uiStateHandler: UiStateHandler = get(),
    sessionHandler: SessionHandler = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    // Setup navigation change listener
    val navigationState = rememberNavigationState()

    // Context
    val context = LocalContext.current

    // UiStateHandler states
    val language = uiStateHandler.language.collectAsState()

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MiscComponents.InsituLogo(language.value)

                SpacersAndDividers.VerticalSpacer(height = Spacing.huge)
                Text(text = "v${BuildConfig.VERSION_NAME}")
                SpacersAndDividers.VerticalSpacer(height = Spacing.huge)

                val username = remember { mutableStateOf(username) }
                TextFields.Username(username = username, language = language.value)

                SpacersAndDividers.VerticalSpacer(height = Spacing.huge)

                val password = remember { mutableStateOf(password) }
                TextFields.Password(password = password, language = language.value)

                SpacersAndDividers.VerticalSpacer(height = Spacing.ultra)

                Buttons.Login(
                    username = username.value,
                    password = password.value,
                    sessionHandler = sessionHandler,
                    language = language.value
                ) { authResult ->
                    if (authResult) {
                        navigationState.value = NavDestination.Start.navigate()
                    } else {
                        Toast.makeText(
                            context,
                            MessageStrings.loginFailed(language.value),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Login()
        }
    }
}