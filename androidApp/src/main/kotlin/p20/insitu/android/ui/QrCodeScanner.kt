package p20.insitu.android.ui

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import p20.insitu.android.util.LockScreenOrientation
import p20.insitu.theme.InsituTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun QrCodeScanner() {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)

    // Screen content
    // A surface container using the 'background' color from the theme
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = MaterialTheme.colors.primary)
            ) {
                Text(modifier = Modifier.align(Alignment.Center), text = "QrCodeScanner")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun QrCodeScannerPreview() {
    InsituTheme(true) {
        QrCodeScanner()
    }
}