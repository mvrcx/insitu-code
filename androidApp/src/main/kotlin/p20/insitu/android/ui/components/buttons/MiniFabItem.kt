package p20.insitu.android.ui.components.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import p20.insitu.android.ui.components.dimen.Padding

@Composable
fun MiniFabItem(
    item: MultiFabItem,
    showLabel: Boolean,
    backgroundColor: Color,
    tintColor: Color,
    onFabItemClicked: (item: MultiFabItem) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 12.dp)
    ) {
        if (showLabel) {
            Box(modifier = Modifier
                .padding(Padding.xsmall)
                .drawBehind {
                drawRoundRect(
                    color = backgroundColor,
                    cornerRadius = CornerRadius(10f)
                ) }, contentAlignment = Alignment.CenterEnd)
            {
                Text(
                    item.label,
                    style = MaterialTheme.typography.subtitle2,
                    color = tintColor,
                    modifier = Modifier
                        .padding(start = 6.dp, end = 6.dp, top = 4.dp, bottom = 4.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
        FloatingActionButton(
            modifier = Modifier.size(40.dp),
            onClick = { onFabItemClicked(item) },
            backgroundColor = backgroundColor
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                tint = tintColor
            )
        }
    }
}