package p20.insitu.web.composables

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

object Buttons {
    @Composable
    fun ActionButton(caption: String, onClickAction: () -> Unit) {
        Button(attrs = {
            onClick { onClickAction() }
        }) {
            Text(caption)
        }
    }
}