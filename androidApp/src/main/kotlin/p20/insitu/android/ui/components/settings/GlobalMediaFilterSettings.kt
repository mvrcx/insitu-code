package p20.insitu.android.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.Containers
import p20.insitu.android.ui.components.SpacersAndDividers.VerticalSpacer
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.android.ui.components.SubTitles
import p20.insitu.android.ui.components.Switches
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding

@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GlobalMediaFilterSettings(uiStateHandler: UiStateHandler = get()) {

    val language = uiStateHandler.language.collectAsState()
    val showNestedAnnotationsInit =
        remember { mutableStateOf(uiStateHandler.showNestedAnnotations.value) }
    val showUserAnnotationsInit =
        remember { mutableStateOf(uiStateHandler.showUserAnnotationsOnly.value) }

    SubTitles.SimpleSubtitle(text = TitleStrings.globalMediaFilterSettings(language.value))

    Switches.FilterNestedNoteAnnotations(
        language = language.value,
        initialValue = showNestedAnnotationsInit.value
    ) {
        uiStateHandler.setShowNestedAnnotations(it)
    }

    /*
    VerticalSpacer()

    Switches.FilterUserAnnotations(
        language = language.value,
        initialValue = showUserAnnotationsInit.value
    ) {
        uiStateHandler.setShowUserAnnotationsOnly(it)
    }
    */
}
