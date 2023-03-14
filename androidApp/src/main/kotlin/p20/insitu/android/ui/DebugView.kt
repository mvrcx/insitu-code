package p20.insitu.android.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.model.components.Weight
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.theme.colors.*
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.TextFields
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.util.LockScreenOrientation

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun DebugView(
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
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
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Debug-Ausgabe", style = MaterialTheme.typography.h6)
                message?.let {
                    Text(text = it)
                } ?: run {
                    Text(text = " - ")
                }

                SpacersAndDividers.HorizontalDivider()

                // IDs
                val idColors = mutableMapOf<String, Color>()

                Text(text = "Investigation", style = MaterialTheme.typography.h6)
                sessionHandler.docuHandler.investigation.value?.let {
                    idColors[it.id] = InvestigationLight
                    Text(text = "Comment: {${it.comment}}")
                    Text(text = "ID: {${it.id}}", color = idColors[it.id]!!)
                } ?: run {
                    Text(text = " - ")
                }

                SpacersAndDividers.HorizontalDivider()

                Text(text = "CrimeScene", style = MaterialTheme.typography.h6)
                sessionHandler.docuHandler.crimeScene.value?.let {
                    idColors[it.id] = CrimeSceneLight
                    Text(text = it.designation ?: it.entityType)
                    Text(text = "ID: {${it.id}}", color = idColors[it.id]!!)
                } ?: run {
                    Text(text = " - ")
                }

                SpacersAndDividers.HorizontalDivider()

                Text(text = "DocumentationObject", style = MaterialTheme.typography.h6)
                sessionHandler.docuHandler.docuObject.value?.let {
                    if (!idColors.contains(it.id)) {
                        idColors[it.id] =
                            if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight
                    }
                    Text(text = it.designation ?: it.entityType)
                    Text(text = "ID: {${it.id}}", color = idColors[it.id]!!)
                } ?: run {
                    Text(text = " - ")
                }

                SpacersAndDividers.HorizontalDivider()

                val weightTest = remember { mutableStateOf<Weight?>(null) }
                val testEditMode = remember { mutableStateOf(false) }
                // Weight
                TextFields.WeightInput(
                    value = weightTest.value,
                    editMode = testEditMode.value,
                    language = language.value,
                    catalogRepo = get(),
                    onValueChanged = {
                        weightTest.value = it
                    }
                )
                Button(onClick = {testEditMode.value = !testEditMode.value}) {
                    Text(text = "EditMode On|Off")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DebugViewPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            DebugView()
        }
    }
}