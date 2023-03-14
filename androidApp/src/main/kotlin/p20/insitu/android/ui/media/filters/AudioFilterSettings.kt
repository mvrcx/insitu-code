package p20.insitu.android.ui.media.filters

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.GlobalMediaFilterSettings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.android.ui.components.SubTitles
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding

@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AudioFilterSettings(uiStateHandler: UiStateHandler = get()) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val language = uiStateHandler.language.collectAsState()

    // TopAppBar navigation block
    val navigationState = rememberNavigationState()

    Scaffold(
        topBar = {
            TopAppBars.FilterSettings(
                navigationState = navigationState,
                uiStateHandler = get()
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen)
            ) {
                GlobalMediaFilterSettings()

                SubTitles.SimpleSubtitle(text = TitleStrings.audioFilterSettings(language.value))

                Text(text = "TODO")
            }
        }
    )
}
