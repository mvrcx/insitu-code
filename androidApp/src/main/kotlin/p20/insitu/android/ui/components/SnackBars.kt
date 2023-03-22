package p20.insitu.android.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ShowSnackbar() {
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(Unit) {
        scaffoldState.snackbarHostState.showSnackbar("Hello, Jetpack Compose!")
    }
    Scaffold(
        scaffoldState = scaffoldState,
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) {}
        },
        contentColor = Color.Transparent,
        backgroundColor = Color.Transparent,
        //contentColor = Color.Transparent
    )
}



