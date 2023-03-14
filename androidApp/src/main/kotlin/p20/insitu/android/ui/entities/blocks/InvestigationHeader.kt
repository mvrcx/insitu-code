package p20.insitu.android.ui.entities.blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.resources.Language
import p20.insitu.resources.strings.TextFieldStrings
import p20.insitu.theme.colors.*
import p20.insitu.android.ui.components.SpacersAndDividers
import p20.insitu.android.ui.components.TextFields
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.resources.strings.TitleStrings

@Composable
fun InvestigationHeader(
    investigationNumber: String?,
    zonedDateTime : ZonedDateTime?,
    language: Language
) {
    Column(
        modifier = Modifier
            .background(color = if (isSystemInDarkTheme()) HighlightingDark else HighlightingLight)
            .fillMaxWidth()
            .padding(Padding.default)
    ) {

        Text(
            text = TitleStrings.uniqueIdentificationData(language),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.fillMaxWidth().align(Alignment.Start)
        )

        SpacersAndDividers.VerticalSpacer()

        Row {
            // Investigation number
            Column {
                BasicTextField(
                    value = TextFieldStrings.investigationNumber(language),
                    enabled = false,
                    onValueChange = {
                        // do nothing
                    },
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onSurface
                    )
                )

                SpacersAndDividers.VerticalSpacer()

                BasicTextField(
                    value = TextFieldStrings.startDate(language),
                    enabled = false,
                    onValueChange = {
                        // do nothing
                    },
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onSurface
                    )
                )
            }

            SpacersAndDividers.HorizontalSpacer()

            // Start date and time
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicTextField(
                    value = investigationNumber ?: "",
                    enabled = false,
                    onValueChange = {
                        // do nothing
                    },
                    textStyle = TextStyle(
                        color = MaterialTheme.colors.onSurface
                    )
                )

                SpacersAndDividers.VerticalSpacer()

                Row {
                    // TODO language dependent date format
                    BasicTextField(
                        value = zonedDateTime?.getFormattedDateString(ZonedDateTime.DateFormat.DDMMYYYY)
                            ?: "",
                        enabled = false,
                        onValueChange = {
                            // do nothing
                        },
                        textStyle = TextStyle(
                            color = MaterialTheme.colors.onSurface
                        )
                    )

                    SpacersAndDividers.HorizontalSpacer()

                    // TODO language dependent time format
                    BasicTextField(
                        value = "${zonedDateTime?.getFormattedTimeString()} ${
                            TextFieldStrings.timeOfDay(
                                language
                            )
                        }",
                        enabled = false,
                        onValueChange = {
                            // do nothing
                        },
                        textStyle = TextStyle(
                            color = MaterialTheme.colors.onSurface
                        )
                    )
                }
            }
        }
    }
}