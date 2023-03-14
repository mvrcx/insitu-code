@file:Suppress("OPT_IN_USAGE")

package p20.insitu.android.ui.media.recordings

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.view.PreviewView
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import p20.insitu.android.rememberNavigationState
import p20.insitu.model.util.ObjectFactory
import p20.insitu.nav.NavDestination
import p20.insitu.resources.FileHandler
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Investigation
import p20.insitu.resources.FileType
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.TabType

@Composable
fun Camera(
    fileHandler: FileHandler = get(),
    sessionHandler: SessionHandler = get(),
    uiStateHandler: UiStateHandler = get(),
    docuDataRepo: DocuDataRepo = get()
) {
    val navigationState = rememberNavigationState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    var lensFacing by remember { mutableStateOf(CameraSelector.LENS_FACING_BACK) }
    val imageCapture: ImageCapture = remember {
        ImageCapture.Builder().build()
    }
    val flash = remember { mutableStateOf(value = false) }
    val preview = Preview.Builder().build()
    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(lensFacing)
        .build()
    val previewView = remember { PreviewView(context) }
    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageCapture
        )
        preview.setSurfaceProvider(previewView.surfaceProvider)
    }
    val animatedColor = animateColorAsState(
        if (flash.value) Color.White else Color.Transparent
    )

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView({ previewView }, modifier = Modifier.fillMaxSize()) {}
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(animatedColor.value)
                .align(Alignment.Center)
        ) {}
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom
        ) {
            CameraControls(uiStateHandler) { cameraUIAction ->
                when (cameraUIAction) {
                    is CameraUIAction.OnCameraClick -> {
                        coroutineScope.launch {
                            flash.value = true
                            delay(150L)
                            flash.value = false
                        }
                        val imageAnnotation =
                            ObjectFactory.createImageAnnotation(FileType.PHOTO.extension)
                        imageCapture.takePicture(
                            fileHandler,
                            lensFacing,
                            imageAnnotation.filename!!,
                            onImageCaptured = { uri ->
                                sessionHandler.userInfo.value?.let { userInfo ->
                                    sessionHandler.docuHandler.investigation.value?.let { investigation ->
                                        sessionHandler.docuHandler.docuObject.value?.let { docuObject ->
                                            docuDataRepo.saveAnnotation(
                                                imageAnnotation,
                                                docuObject,
                                                investigation,
                                                userInfo.id
                                            )
                                        }
                                    }
                                }
                            },
                            onError = {
                                // TODO error handling
                            })
                    }
                    is CameraUIAction.OnSwitchCameraClick -> {
                        lensFacing =
                            if (lensFacing == CameraSelector.LENS_FACING_BACK)
                                CameraSelector.LENS_FACING_FRONT
                            else
                                CameraSelector.LENS_FACING_BACK
                    }
                    is CameraUIAction.OnGalleryViewClick -> {
                        if (sessionHandler.docuHandler.docuObject.value is Investigation) {
                            navigationState.value = NavDestination.BACK.navigate()
                        } else {
                            navigationState.value = NavDestination.DocuMode.Details.setSelectedTab(
                                TabType.IMAGE_ANNOTATIONS
                            ).popUpTo()
                        }
                    }
                }
            }
        }
    }
}