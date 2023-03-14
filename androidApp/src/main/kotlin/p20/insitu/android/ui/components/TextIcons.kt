package p20.insitu.android.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.components.dimen.TextIconSize
import p20.insitu.model.entities.enums.PersonType
import p20.insitu.theme.colors.DefaultEntityDark
import p20.insitu.theme.colors.DefaultEntityLight

object TextIcons {

    @Composable
    fun PersonTypeIcon(type: PersonType) {
        return when (type) {
            PersonType.OFFENDER -> Offender()
            PersonType.SUSPECT -> Suspect()
            PersonType.VICTIM -> Victim()
            PersonType.WITNESS -> Witness()
        }
    }

    @Composable
    private fun FilledCircleBehind(
        text: String,
        fontSize: TextUnit? = null,
        fillColor: Color? = null,
        strokeColor: Color? = null,
        radius: Float? = null,
        border: Float? = null
    ) {
        val circleFillColor = fillColor ?: MaterialTheme.colors.primary
        val circleStrokeColor = strokeColor ?: MaterialTheme.colors.onPrimary
        val circleFontSize = fontSize ?: TextIconSize.Font.default
        val circleRadius = radius ?: TextIconSize.Radius.default
        val circleBorder = border ?: TextIconSize.Border.default
        Box(modifier = Modifier.padding(horizontal = Padding.small)) {
            Text(
                modifier = Modifier
                    .padding(Padding.small)
                    .drawBehind {
                        drawCircle(
                            color = circleStrokeColor,
                            radius = circleRadius
                        )
                        drawCircle(
                            color = circleFillColor,
                            radius = circleRadius - circleBorder
                        )
                    },
                color = circleStrokeColor,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = circleFontSize
                ),
                text = text,
            )

        }
    }

    @Composable
    fun Offender() {
        // TODO special suspect color?
        FilledCircleBehind(
            text = "T",
            fillColor = if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight
        )
    }

    @Composable
    fun Suspect() {
        // TODO special suspect color?
        FilledCircleBehind(
            text = "V",
            fillColor = if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight
        )
    }

    @Composable
    fun Victim() {
        // TODO special victim color?
        FilledCircleBehind(
            text = "G",
            fillColor = if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight
        )
    }

    @Composable
    fun Witness() {
        // TODO special witness color?
        FilledCircleBehind(
            text = "Z",
            fillColor = if (isSystemInDarkTheme()) DefaultEntityDark else DefaultEntityLight
        )
    }

}