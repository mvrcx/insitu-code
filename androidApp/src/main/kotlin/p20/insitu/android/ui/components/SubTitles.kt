package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import p20.insitu.android.ui.components.buttons.IconButtons
import p20.insitu.resources.Language
import p20.insitu.android.ui.components.dimen.ButtonSize
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.components.dimen.Spacing

object SubTitles {

    @Composable
    fun SimpleSubtitle(
        text: String,
        paddingTop: Dp = Padding.medium
    ) {
        Column {
            SpacersAndDividers.VerticalSpacer(height = paddingTop)
            Text(
                text = text,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )
            SpacersAndDividers.HorizontalDivider()
        }
    }

    @Composable
    fun CollapsableSubtitle(
        text: String,
        collapsed: Boolean = false,
        language: Language,
        onCollapseStateChanged: (Boolean) -> Unit
    ) {
        Column {
            SpacersAndDividers.VerticalSpacer(height = Spacing.medium)
            Row(modifier = Modifier.heightIn(max = ButtonSize.height_small)) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.subtitle1,
                )
                Spacer(Modifier.weight(1f))
                if (collapsed) {
                    IconButtons.ExpandMore(
                        language = language,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        onCollapseStateChanged(!collapsed)
                    }
                } else {
                    IconButtons.ExpandLess(
                        language = language,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        onCollapseStateChanged(!collapsed)
                    }
                }
            }
            SpacersAndDividers.HorizontalDivider()
        }
    }

}