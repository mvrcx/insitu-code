package p20.insitu.android.util

import android.view.KeyEvent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.rememberUpdatedState

val LocalKeyEventHandlers = compositionLocalOf<MutableList<KeyEventHandler>> {
    error("LocalKeyEventHandlers is not provided")
}

typealias KeyEventHandler = (Int, KeyEvent) -> Boolean

@Composable
fun ListenKeyEvents(handler: KeyEventHandler) {
    val handlerState = rememberUpdatedState(handler)
    val eventHandlers = LocalKeyEventHandlers.current
    DisposableEffect(handlerState) {
        val localHandler: KeyEventHandler = { keyCode, keyEvent ->
            handlerState.value(keyCode, keyEvent)
        }
        eventHandlers.add(localHandler)
        onDispose {
            eventHandlers.remove(localHandler)
        }
    }
}