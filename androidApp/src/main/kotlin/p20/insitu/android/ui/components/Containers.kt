package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import p20.insitu.resources.Language
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.stateHandler.UiStateHandler

object Containers {

    @Composable
    fun StandardAttributeContainer(
        uiStateHandler: UiStateHandler,
        content: @Composable () -> Unit
    ) {
        val docuMode = uiStateHandler.docuMode.collectAsState()

        Box(
            Modifier
                .fillMaxSize()
                .padding(bottom = if (docuMode.value) Padding.docuModeBottom else Padding.screen)
        ) {
            val listScrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .verticalScroll(listScrollState)
                    .padding(all = Padding.screen),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                content()
            }
            // Top gradient overlay
            Overlays.TopGradientFade(
                visible = listScrollState.value > 0,
                modifier = Modifier.align(Alignment.TopCenter)
            )
            // Bottom gradient overlay
            Overlays.BottomGradientFade(
                visible = listScrollState.value != listScrollState.maxValue,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }


    }

    @Composable
    fun StaticAttributeGroup(
        title: String,
        paddingTop: Dp = Padding.small,
        content: @Composable () -> Unit
    ) {
        Column(
            //Modifier.background()
        ) {
            SubTitles.SimpleSubtitle(title, paddingTop)
            content()
        }
    }

    @Composable
    fun SimpleAttributeGroup(
        title: String,
        paddingTop: Dp = Padding.small,
        content: @Composable () -> Unit
    ) {
        Column {
            SubTitles.SimpleSubtitle(title, paddingTop)
            content()
        }
    }

    @Composable
    fun CollapsableAttributeGroup(
        title: String,
        language: Language,
        initiallyCollapsed: Boolean = false,
        content: @Composable () -> Unit
    ) {
        val collapsed = remember { mutableStateOf(initiallyCollapsed) }
        Column {
            SubTitles.CollapsableSubtitle(
                title,
                collapsed.value,
                language,
            ) {
                collapsed.value = it
            }
            if (!collapsed.value) {
                content()
            }
        }
    }

}