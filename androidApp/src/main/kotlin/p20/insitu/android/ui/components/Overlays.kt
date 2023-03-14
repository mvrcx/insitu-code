package p20.insitu.android.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import p20.insitu.android.ui.components.dimen.MiscSize

object Overlays {

    @Composable
    fun TopGradientFade(
        visible: Boolean,
        modifier: Modifier
    ) {
        AnimatedVisibility(
            visible = visible,
            modifier = modifier,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(MiscSize.brushSize)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.background,
                                Color.Transparent
                            )
                        )
                    )
            )
        }
    }

    @Composable
    fun BottomGradientFade(
        visible: Boolean,
        modifier: Modifier
    ) {
        AnimatedVisibility(
            visible = visible,
            modifier = modifier,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(MiscSize.brushSize)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colors.background
                            )
                        )
                    )
            )
        }
    }
}