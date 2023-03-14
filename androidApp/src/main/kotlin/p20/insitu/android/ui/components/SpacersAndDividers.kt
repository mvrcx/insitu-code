package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import p20.insitu.android.ui.components.dimen.Spacing

object SpacersAndDividers {

    @Composable
    fun VerticalSpacer(height: Dp = Spacing.default) {
        Spacer(modifier = Modifier.height(height))
    }

    @Composable
    fun HorizontalSpacer(width: Dp = Spacing.default) {
        Spacer(modifier = Modifier.width(width))
    }

    @Composable
    fun VerticalDivider(paddingLeft: Dp = Spacing.default, paddingRight: Dp = Spacing.default) {
        HorizontalSpacer(paddingLeft)
        Divider(
            modifier = Modifier.fillMaxHeight(),
            thickness = 1.dp,
            color = MaterialTheme.colors.onSurface
        )
        HorizontalSpacer(paddingRight)
    }

    @Composable
    fun HorizontalDivider(paddingTop: Dp = Spacing.default, paddingBottom: Dp = Spacing.default) {
        VerticalSpacer(paddingTop)
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colors.onSurface
        )
        VerticalSpacer(paddingBottom)
    }
}