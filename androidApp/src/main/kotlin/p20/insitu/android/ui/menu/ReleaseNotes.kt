package p20.insitu.android.ui.menu

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.compose.get
import p20.insitu.android.BuildConfig
import p20.insitu.android.LocalNavController
import p20.insitu.android.rememberNavigationState
import p20.insitu.android.ui.components.Containers
import p20.insitu.android.ui.components.Containers.SimpleAttributeGroup
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.theme.InsituTheme
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.android.ui.components.TopAppBars
import p20.insitu.android.ui.components.dimen.Padding

/**
 * Screen used to display context sensitive help information.
 */
@OptIn(ExperimentalSerializationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ReleaseNotes(
    uiStateHandler: UiStateHandler = get()
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val navigationState = rememberNavigationState()

    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
    val bulletPoint = "\u2022"
    val textIndent = "\t\t"

    Scaffold(
        topBar = {
            TopAppBars.ReleaseNotes(
                navigationState = navigationState,
                uiStateHandler = uiStateHandler
            )
        },
        content = {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
                // Header
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = Padding.xsmall),
                    verticalArrangement = Arrangement.Top
                ) {
                    // Heading
                    val releaseGreeting = "INSITU ${BuildConfig.VERSION_NAME} ist da!"
                    Text(text = releaseGreeting, style = MaterialTheme.typography.h5)
                    SpacersAndDividers.VerticalSpacer()
                    // Subheading
                    Text(
                        text = "Die wichtigsten Änderungen für Testzyklus 2 in Kürze:",
                        style = MaterialTheme.typography.h6
                    )
                }

                SpacersAndDividers.HorizontalDivider()

                // Notes
                Containers.StandardAttributeContainer(
                    uiStateHandler = uiStateHandler
                ) {
                    SimpleAttributeGroup(title = "Allgemein", paddingTop = 0.dp) {
                        val releaseNotes = listOf(
                            "Perfomance-Verbesserungen",
                            "Bug-Fixes",
                            "Leichte Anpassung des Farbschemas",
                            "Integration von Release Notes",
                            "Über die \"Einstellungen\" ist ein manuelles Reset der Katalog-Datenbank möglich."
                        )
                        Text(
                            buildAnnotatedString {
                                releaseNotes.forEach {
                                    withStyle(style = paragraphStyle) {
                                        append(bulletPoint) // bullet point
                                        append(textIndent)
                                        append(it)
                                    }
                                }
                            }
                        )
                    }

                    SimpleAttributeGroup(title = "Startseite") {
                        val releaseNotes = listOf(
                            "Neue Vorgänge können direkt von der Startseite aus angelegt werden.",
                            "Auf der Startseite gibt es nun eine Kachel mit direktem Link zum zuletzt bearbeiteten " +
                                    "Vorgang bzw. Tatort, Asservat oder sonstigem Objekt."
                        )
                        Text(
                            buildAnnotatedString {
                                releaseNotes.forEach {
                                    withStyle(style = paragraphStyle) {
                                        append(bulletPoint) // bullet point
                                        append(textIndent)
                                        append(it)
                                    }
                                }
                            }
                        )
                    }

                    SimpleAttributeGroup(title = "Dokumentationsmodus") {
                        val releaseNotes = listOf(
                            "Die Bereichseinteilung wurde entfernt. Alle Funktionen zur Einteilung des Tatorts sind über " +
                                    "die Listenansicht des Dokumentationsmodus verfügbar.",
                            "Der Dokumentationsmodus wird automatisch betreten wenn ein Vorgang erstellt oder ausgewählt wird.",
                            "Die Bedienung und Darstellung des Dokumentationsmodus wurde überarbeitet. Es gibt nun 3 " +
                                    "Reiter: Vorgang, Liste und Objekt. Der Vorgangs-Reiter zeigt die Daten des " +
                                    "aktuellen Vorgangs, dieser kann dort auch bearbeitet werden. Der Listen-Reiter " +
                                    "dient der Dokumentation von Spurenbereichen und Asservaten. Über den Listen-Reiter " +
                                    "kann auch der Tatort gewechselt bzw. angelegt werden. Der Objekt-Reiter zeigt Daten " +
                                    "zum aktuell im Fokus stehenden Objekt, z.B. Asservat.",
                            "In der Listenansicht können die \"Kind-Elemente\" per Touch verschoben und dadurch neu nummeriert werden. " +
                                    "Die jeweilige Objekt-Kachel muss dafür zunächst länger gedrückt werden, dann kann sie nach oben bzw. unten verschoben werden.",
                            "Der Dokumentationsmodus kann über das Kontext-Menü in der Kopfzeile oben rechts verlassen werden."
                        )
                        Text(
                            buildAnnotatedString {
                                releaseNotes.forEach {
                                    withStyle(style = paragraphStyle) {
                                        append(bulletPoint) // bullet point
                                        append(textIndent)
                                        append(it)
                                    }
                                }
                            }
                        )
                    }

                    SimpleAttributeGroup(title = "Personen") {
                        val releaseNotes = listOf(
                            "Zu einem Vorgang können jetzt Personen zugeordnet werden. Das Anlegen erfolgt über einen " +
                                    "entsprechenden Reiter in der Vorgangs-Ansicht.",
                            "Personen können mit Personalien und Kontakdaten beschrieben werden. ZU Personen können " +
                                    "Medien (Bilder, Audioaufnahmen, etc.) zugeordnet werden."
                        )
                        Text(
                            buildAnnotatedString {
                                releaseNotes.forEach {
                                    withStyle(style = paragraphStyle) {
                                        append(bulletPoint) // bullet point
                                        append(textIndent)
                                        append(it)
                                    }
                                }
                            }
                        )
                    }

                    SimpleAttributeGroup(title = "Medien") {
                        val releaseNotes = listOf(
                            "Es können Audioaufnahmen getätigt werden. Eine Audioaufnahme kann " +
                                    "entweder über die entsprechende Mediengallerie eines Objekts " +
                                    "gestartet werden oder über die Liste des Dokumentationsmodus. " +
                                    "Audioaufnahmen können über die Mediengallerie jederzeit wieder " +
                                    "abgespielt werden.",
                            "Es können Videoaufnahmen getätigt werden. Eine Videoaufnahme kann " +
                                    "entweder über die entsprechende Mediengallerie eines Objekts " +
                                    "gestartet werden oder über die Liste des Dokumentationsmodus. " +
                                    "Videos können über die Mediengallerie jederzeit wieder " +
                                    "abgespielt werden.",
                            "Es können Notizen erstellt werden. Eine Notiz kann " +
                                    "entweder über die entsprechende Medien-Gallerie eines Objekts " +
                                    "erstellt werden oder über die Liste des Dokumentationsmodus. " +
                                    "Notizen können über die Mediengallerie jederzeit wieder gelesen " +
                                    "oder bearbeitet werden."
                        )
                        Text(
                            buildAnnotatedString {
                                releaseNotes.forEach {
                                    withStyle(style = paragraphStyle) {
                                        append(bulletPoint) // bullet point
                                        append(textIndent)
                                        append(it)
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun ReleaseNotesPreview() {
    CompositionLocalProvider(LocalNavController provides rememberNavController()) {
        InsituTheme(true) {
            ReleaseNotes()
        }
    }
}