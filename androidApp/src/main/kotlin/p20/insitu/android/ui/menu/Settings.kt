package p20.insitu.android.ui.menu

import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import co.touchlab.kermit.Logger
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import org.koin.core.parameter.parametersOf
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.db.catalogs.CatalogCsvImporter
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataApi
import p20.insitu.db.settings.SettingsRepo
import p20.insitu.resources.strings.ButtonStrings
import p20.insitu.resources.strings.MiscStrings
import p20.insitu.resources.strings.TitleStrings
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.SubTitles
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.nav.NavRoute
import kotlin.system.exitProcess

@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Settings(
    uiStateHandler: UiStateHandler = get(),
    catalogRepo: CatalogRepo = get(),
    docuDataApi: DocuDataApi = get(),
    settingsRepo: SettingsRepo = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val log: Logger = get(parameters = { parametersOf("Settings") })
    val language = uiStateHandler.language.collectAsState()

    // TopAppBar navigation block
    val navigationState = rememberNavigationState()

    Scaffold(
        topBar = {
            TopAppBars.Settings(
                navigationState = navigationState,
                uiStateHandler = uiStateHandler
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen)
            ) {

                SubTitles.SimpleSubtitle(
                    text = TitleStrings.databases(language.value)
                )

                // Delete all documentation data
                Buttons.ActionButton(caption = ButtonStrings.databaseReset(language.value)) {
                    coroutineScope.launch {
                        docuDataApi.deleteAll()
                        // TODO this might be a little dangerous?
                        (context as? Activity)?.finishAffinity()
                        exitProcess(0)
                    }
                }

                SpacersAndDividers.VerticalSpacer()

                // Rebuild catalog database
                val catalogCountText = remember { mutableStateOf(MiscStrings.availableCatalogs(language.value)) }
                val maxCatalogCount = remember { mutableStateOf(0) }
                val catalogCount = remember { mutableStateOf(0) }
                LaunchedEffect(key1 = Unit, block = {
                    maxCatalogCount.value = CatalogCsvImporter().numberOfAvailableCatalogs()
                    catalogCount.value = CatalogCsvImporter().numberOfSuccessfullyImportedCatalogs()
                    catalogCountText.value = MiscStrings.availableCatalogs(language.value, catalogCount.value, maxCatalogCount.value)
                })
                Buttons.ActionButton(caption = ButtonStrings.catalogDatabaseReset(language.value)) {
                    catalogCount.value = 0
                    coroutineScope.launch {
                        CatalogCsvImporter().updateDatabase { ip, count, progress ->
                            catalogCount.value = count
                            catalogCountText.value = MiscStrings.availableCatalogs(language.value, catalogCount.value, maxCatalogCount.value)
                        }
                    }
                }
                Text(text = catalogCountText.value)

                /*
                 Buttons.ActionButton(caption = "Wechsel die Sprache!") {
                     if (uiStateHandler.language.value == Language.EN) {
                         uiStateHandler.setLanguage(Language.DE)
                     } else {
                         uiStateHandler.setLanguage(Language.EN)
                     }
                 }

                 SubTitles.SimpleSubtitle(
                     text = TitleStrings.catalogSettings(language.value)
                 )

                 // Testing stuff
                 SubTitles.SimpleSubtitle(
                     text = "Tests..."
                 )

                 SettingsSwitch(
                     storage = rememberPersistentBooleanSettingState(
                         key = "TestBoolSwitch",
                         defaultValue = true,
                         settingsRepo = settingsRepo,
                         coroutineScope = coroutineScope
                     ),
                     icon = {
                         Icon(
                             imageVector = Icons.Default.LocalPolice,
                             contentDescription = "Clear"
                         )
                     },
                     title = { Text(text = "Hello") },
                     subtitle = { Text(text = "This is a longer text") },
                     onCheckedChange = { }
                 )

                 VerticalSpacer()

                 SettingsCheckbox(
                     storage = rememberPersistentBooleanSettingState(
                         key = "TestBoolCheckbox",
                         defaultValue = true,
                         settingsRepo = settingsRepo,
                         coroutineScope = coroutineScope
                     ),
                     icon = {
                         Icon(
                             imageVector = Icons.Default.Clear,
                             contentDescription = "Clear"
                         )
                     },
                     title = { Text(text = "Hello") },
                     subtitle = { Text(text = "This is a longer text") },
                     onCheckedChange = { }
                 )
 */
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            Settings()
        }
    }
}