package p20.insitu.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

object Images {

    @Composable
    fun ZoomableImage(
        bitmap: ImageBitmap,
        contentDescription: String? = null
    ) {
        val scale = remember { mutableStateOf(1f) }
        Box(
            modifier = Modifier
                .clip(RectangleShape) // Clip the box content
                .fillMaxSize() // Give the size you want...
                .background(MaterialTheme.colors.background)
                .pointerInput(Unit) {
                    detectTransformGestures { centroid, pan, zoom, rotation ->
                        scale.value *= zoom
                    }
                }
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.Center) // keep the image centralized into the Box
                    .graphicsLayer(
                        // adding some zoom limits (min 50%, max 200%)
                        scaleX = maxOf(.5f, minOf(3f, scale.value)),
                        scaleY = maxOf(.5f, minOf(3f, scale.value)),
                    ),
                contentDescription = contentDescription,
                bitmap = bitmap
            )
        }
    }

    @Composable
    fun ZoomPanImage(
        bitmap: ImageBitmap,
        contentDescription: String? = null
    ) {
        var zoom by remember { mutableStateOf(1f) }
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        Image(
            modifier = Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .graphicsLayer(
                    scaleX = zoom,
                    scaleY = zoom
                )
                .pointerInput(Unit) {
                    detectTransformGestures(
                        onGesture = { _, pan, gestureZoom, _ ->
                            zoom *= gestureZoom
                            val x = pan.x * zoom
                            val y = pan.y * zoom
                            offsetX += x
                            offsetY += y
                        }
                    )
                }
                .fillMaxSize(),
            contentDescription = contentDescription,
            bitmap = bitmap
        )
    }
}