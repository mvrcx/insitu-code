package p20.insitu.android.ui.components

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import p20.insitu.resources.Language
import p20.insitu.resources.strings.ButtonStrings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@Composable
fun DeleteSnackBar(language: Language) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    //val text:String = ButtonStrings.delete(language)

    Scaffold(scaffoldState = scaffoldState) {
        Button(onClick = {
            coroutineScope.launch {
                val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "This is your message",
                    actionLabel = "Do something"
                )
                when (snackbarResult) {
                    SnackbarResult.Dismissed -> TODO()
                    SnackbarResult.ActionPerformed -> TODO()
                }
            }
        }) {
            Text(ButtonStrings.delete(language))
        }
    }
}