package p20.insitu.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import com.google.accompanist.pager.ExperimentalPagerApi
import p20.insitu.model.entities.Audio
import p20.insitu.model.entities.Image
import p20.insitu.model.entities.Video
import p20.insitu.resources.Language

object Galleries {

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun ImageGallery(
        items: List<Image>,
        imageBitmaps: Map<String, ImageBitmap>,
        language: Language,
        onClickAction: (Int) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(all = p20.insitu.android.ui.components.dimen.Padding.screen),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Grids.ImageGallery(
                imageBitmaps = imageBitmaps.values.toList(),
                language = language
            ) { selectedIndex ->
                onClickAction(selectedIndex)
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun VideoGallery(
        items: List<Video>,
        language: Language,
        onClickAction: (Video) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(all = p20.insitu.android.ui.components.dimen.Padding.screen),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Grids.VideoGallery(
                items = items,
                language = language
            ) { item ->
                onClickAction(item)
            }
        }
    }

}