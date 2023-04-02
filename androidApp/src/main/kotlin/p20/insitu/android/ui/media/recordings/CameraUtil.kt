package p20.insitu.android.ui.media.recordings

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaActionSound
import android.net.Uri
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.*
import androidx.camera.view.PreviewView
import androidx.core.util.Consumer
import androidx.lifecycle.LifecycleOwner
import p20.insitu.resources.FileHandler
import java.io.File
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun Context.getCameraProvider(): ProcessCameraProvider = suspendCoroutine { continuation ->
    ProcessCameraProvider.getInstance(this).also { cameraProvider ->
        cameraProvider.addListener({
            continuation.resume(cameraProvider.get())
        }, mainExecutor)
    }
}

fun ImageCapture.takePicture(
    fileHandler: FileHandler,
    lensFacing: Int,
    filename: String,
    onImageCaptured: (Uri) -> Unit,
    onError: (ImageCaptureException) -> Unit
) {
    // Create output file to hold the image
    fileHandler.getImageFile( filename)?.let { photoFile ->
        this.takePicture(
            getOutputFileOptions(lensFacing, photoFile),
            Executors.newSingleThreadExecutor(),
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    val savedUri = output.savedUri ?: Uri.fromFile(photoFile)
                    onImageCaptured(savedUri)

                    // shutter sound
                    val sound = MediaActionSound()
                    sound.play(MediaActionSound.SHUTTER_CLICK)
                }
                override fun onError(exception: ImageCaptureException) {
                    onError(exception)
                }
            })
    }
}

fun getOutputFileOptions(
    lensFacing: Int,
    photoFile: File
): ImageCapture.OutputFileOptions {
    // Setup image capture metadata
    val metadata = ImageCapture.Metadata().apply {
        // Mirror image when using the front camera
        isReversedHorizontal = lensFacing == CameraSelector.LENS_FACING_FRONT
    }
    // Create output options object which contains file + metadata
    return ImageCapture.OutputFileOptions.Builder(photoFile)
        .setMetadata(metadata)
        .build()
}

suspend fun Context.createVideoCaptureUseCase(
    lifecycleOwner: LifecycleOwner,
    cameraSelector: CameraSelector,
    previewView: PreviewView
): VideoCapture<Recorder> {
    val preview = Preview.Builder()
        .build()
        .apply { setSurfaceProvider(previewView.surfaceProvider) }

    val qualitySelector = QualitySelector.from(
        Quality.FHD,
        FallbackStrategy.lowerQualityOrHigherThan(Quality.FHD)
    )
    val recorder = Recorder.Builder()
        .setExecutor(mainExecutor)
        .setQualitySelector(qualitySelector)
        .build()
    val videoCapture = VideoCapture.withOutput(recorder)

    val cameraProvider = getCameraProvider()
    cameraProvider.unbindAll()
    cameraProvider.bindToLifecycle(
        lifecycleOwner,
        cameraSelector,
        preview,
        videoCapture
    )

    return videoCapture
}

// TODO check the permission instead of throwing exception
@Throws(IllegalStateException::class)
@SuppressLint("MissingPermission")
fun recordVideo(
    context: Context,
    outputOptions: FileOutputOptions,
    videoCapture: VideoCapture<Recorder>,
    executor: Executor,
    audioEnabled: Boolean,
    consumer: Consumer<VideoRecordEvent>
): Recording {
    return videoCapture.output
        .prepareRecording(context, outputOptions)
        .apply { if (audioEnabled) withAudioEnabled() } // This will lead to an IllegalStateException if audio recording permission is not given
        .start(executor, consumer)
}
