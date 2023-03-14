package p20.insitu.android

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.*
import p20.insitu.resources.Language
import p20.insitu.resources.strings.ButtonStrings
import p20.insitu.resources.strings.MessageStrings
import p20.insitu.resources.strings.TitleStrings

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionHandling(
    activity: Activity,
    language: Language
) {

    val openDialog = remember { mutableStateOf(false) }

    // Required permissions
    val permissionStates = rememberMultiplePermissionsState(
        listOf(
            // Location (Required for GPS Location)
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            // Camera (Photo and Video)
            Manifest.permission.CAMERA,
            // Microphone (Record Audio)
            Manifest.permission.RECORD_AUDIO,
            // Read and manage Bluetooth signals
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN,
            // Read and manage WiFi signals
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.CHANGE_WIFI_STATE,
            // Read and write from / to app external storage (e.g. sdcard)
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE, // is implied by write permission
            // Use near field communication
            Manifest.permission.NFC,
            // Enable haptic feedback
            Manifest.permission.VIBRATE
        )
    ) {
        // Exit app if not all permissions are given
        if (it.containsValue(false)) {
            openDialog.value = true
        }
    }

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    permissionStates.launchMultiplePermissionRequest()
                }
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })

    if (openDialog.value) {
        var missingPermissions = ""
        permissionStates.revokedPermissions.forEach { permissionState ->
            if(missingPermissions.isNotBlank()){
                missingPermissions += ", "
            }
            missingPermissions += permissionState.permission
        }

        AlertDialog(
            onDismissRequest = { },
            title = {
                Text(text = TitleStrings.permissionsMissing(language))
            },
            text = {
                Text(MessageStrings.missingPermissions(language) + " " + missingPermissions)
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Launch application settings to grant permissions manually
                        val intent = Intent()
                        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                        intent.data = Uri.fromParts("package", activity.packageName, null)
                        activity.startActivity(intent)
                    }) {
                    Text(ButtonStrings.goToAppPermissionSettings(language))
                }
            }
        )
    }
}
