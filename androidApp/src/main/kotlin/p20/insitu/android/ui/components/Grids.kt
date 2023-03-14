package p20.insitu.android.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import kotlinx.coroutines.launch
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.catalogues.CatalogItem
import p20.insitu.model.entities.Video
import p20.insitu.resources.Language
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.android.ui.components.dimen.Spacing
import p20.insitu.model.entities.Audio
import p20.insitu.resources.icons.Icons

object Grids {

    @Composable
    fun ImageGallery(
        imageBitmaps: List<ImageBitmap>,
        language: Language,
        onClickAction: (Int) -> Unit
    ) {
        Box {
            val gridState = rememberLazyGridState()
            val coroutineScope = rememberCoroutineScope()

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = gridState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                verticalArrangement = Arrangement.spacedBy(Spacing.gridItemsSpacing),
                horizontalArrangement = Arrangement.spacedBy(Spacing.gridItemsSpacing),
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                items(imageBitmaps.size) { index ->
                    imageBitmaps[index].let { bitmap ->
                        Cards.Image(bitmap, language) {
                            onClickAction(index)
                        }
                    }
                }
            }

            val showScrollToTopButton = gridState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        gridState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun VideoGallery(
        items: List<Video>,
        language: Language,
        onClick: (Video) -> Unit
    ) {
        Box {
            val gridState = rememberLazyGridState()
            val coroutineScope = rememberCoroutineScope()

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = gridState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                verticalArrangement = Arrangement.spacedBy(Spacing.gridItemsSpacing),
                horizontalArrangement = Arrangement.spacedBy(Spacing.gridItemsSpacing),
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                items(items){ item ->
                    Cards.Video(item, language) {
                        onClick(item)
                    }
                }
            }

            val showScrollToTopButton = gridState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        gridState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun Catalog(
        catalogItems: List<CatalogItem>,
        language: Language,
        onClickAction:(item: CatalogItem) -> Unit
    ) {
        Box {
            val gridState = rememberLazyGridState()
            val coroutineScope = rememberCoroutineScope()

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = gridState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                verticalArrangement = Arrangement.spacedBy(Spacing.gridItemsSpacing),
                horizontalArrangement = Arrangement.spacedBy(Spacing.gridItemsSpacing),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                items(catalogItems.size) { i ->
                    catalogItems[i].let { catalogItem ->
                        Cards.CatalogItemCard(
                            designation = catalogItem.designation(language),
                            subtitle = catalogItem.subtitle(language),
                            imageVector = Icons.getEntityTypeIcon(catalogItem.entityType),
                            contentDescription = catalogItem.iconContentDescription(language)
                        ) {
                            onClickAction(catalogItem)
                        }
                    }
                }
            }

            val showScrollToTopButton = gridState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        gridState.scrollToItem(0)
                    }
                }
            }
        }
    }

    fun LazyGridScope.header(
        content: @Composable LazyGridItemScope.() -> Unit
    ) {
        item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
    }

}