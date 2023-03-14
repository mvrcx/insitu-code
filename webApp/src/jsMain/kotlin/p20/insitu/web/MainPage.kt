package p20.insitu.web

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import p20.insitu.Greeting
import p20.insitu.web.composables.Buttons

//fun jsMain() {
//    document.getElementById("root")?.innerHTML = greet()
//}

//fun greet() = Greeting().greeting()

fun main() {
    var count: Int by mutableStateOf(0)
    renderComposable(rootElementId = "root") {
        Div({ style { padding(25.px) } }) {
            Buttons.ActionButton("-") {count--}

            Span({ style { padding(15.px) } }) {
                Text("$count")
            }

            Buttons.ActionButton("+") {count++}

            Span({ style { padding(15.px) } }) {
                Text(Greeting().greeting())
            }
        }
    }
}