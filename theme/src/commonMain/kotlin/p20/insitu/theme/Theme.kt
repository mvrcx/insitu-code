package p20.insitu.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import p20.insitu.theme.colors.*

val DarkColorPalette = darkColors(
    primary = PrimaryDark,
    primaryVariant = EditModeDark,
    secondary = P20Orange, //PrimaryDark, // we do not have a secondary color for INSITU
    secondaryVariant = P20Orange, // we do not have a secondary color for INSITU
    background = DarkBlueGrey100,
    surface = DarkBlueGrey60,
    onPrimary = DarkBlueGrey100,
    onSecondary = DarkBlueGrey100,
    onBackground = LightGrey80,
    onSurface = LightGrey100,
)

val LightColorPalette = lightColors(
    primary = PrimaryLight,
    primaryVariant = EditModeLight,
    secondary = P20Orange, //PrimaryLight, // we do not have a secondary color for INSITU
    secondaryVariant = P20Orange,// we do not have a secondary color for INSITU
    background = LightGrey20,
    surface = LightGrey80,
    onPrimary = LightGrey20,
    onSecondary = LightGrey20,
    onBackground = DarkBlueGrey100,
    onSurface = DarkBlueGrey100,
)

@Composable
fun InsituTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}