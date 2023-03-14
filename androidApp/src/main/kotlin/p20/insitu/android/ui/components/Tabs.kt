package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import p20.insitu.util.TabType

@Composable
fun Tabs(
    selectedTab: TabType?,
    titles: List<Triple<TabType, String, ImageVector>> = listOf(),
    onTabClick: (TabType) -> Unit
) {
    Column {
        var selectedTabIndex = titles.indexOfFirst { it.first == selectedTab }
        if(selectedTabIndex == -1) selectedTabIndex = 0

        if (titles.size > 4) {
            ScrollableTabRow(selectedTabIndex = selectedTabIndex, edgePadding = 0.dp) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        text = {
                            Text(
                                text = title.second,
                                style = MaterialTheme.typography.subtitle2
                            )
                        },
                        selected = selectedTabIndex == index,
                        onClick = { onTabClick(title.first) },
                        icon = {
                            Icon(
                                imageVector = title.third,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        } else {
            TabRow(selectedTabIndex = selectedTabIndex) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        text = {
                            Text(
                                text = title.second,
                                style = MaterialTheme.typography.subtitle2
                            )
                        },
                        selected = selectedTabIndex == index,
                        onClick = { onTabClick(title.first) },
                        icon = {
                            Icon(
                                imageVector = title.third,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        }
    }
}