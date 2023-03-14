package p20.insitu.resources

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.exifinterface.media.ExifInterface
import co.touchlab.kermit.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import p20.insitu.model.entities.Image
import java.io.*


actual class FileHandler actual constructor() : KoinComponent {

    val context: Context by inject()
    val application: Application by inject()
    private val log: Logger = get(parameters = { parametersOf(FileHandler::class.simpleName) })

    actual fun getBinaryFile(resourceDirectory: String, filename: String): ByteArray? {
        return try {
            val ipStream: InputStream? = when (resourceDirectory) {
                FileDir.RAW.path -> context.resources.openRawResource(
                    application.resources.getIdentifier(
                        filename.split(".")[0], // no extension allowed
                        "raw", application.packageName
                    )
                )
                FileDir.ASSETS.path -> context.assets.open(filename)
                "application" -> {
                    log.i(application.filesDir.absoluteFile.toString())
                    log.i(application.dataDir.absoluteFile.toString())
                    log.i(application.cacheDir.absoluteFile.toString())
                    log.i(application.externalCacheDir?.absoluteFile.toString())
                    null
                }
                else -> {
                    context.openFileInput("${resourceDirectory.trimEnd('/')}/$filename")
                }
            }
            ipStream?.readBytes()
        } catch (e: FileNotFoundException) {
            log.e(e.stackTraceToString())
            null
        } catch (e: UnsupportedEncodingException) {
            log.e(e.stackTraceToString())
            null
        } catch (e: IOException) {
            log.e(e.stackTraceToString())
            null
        }
    }

    actual fun getImageBitmap(image: Image): ImageBitmap? {
        image.filename?.let { filename ->
            getImageFile(filename)?.let { imgFile ->
                if (imgFile.exists()) {
                    return getRotatedAndScaledBitmap(imgFile)?.asImageBitmap()
                }
            }
        }
        return null
    }
    actual fun getAudioFile(filename: String): File? {
        return getAudioFolder()?.let { audioFolder ->
            File(audioFolder, filename)
        }
    }

    actual fun getImageFile(filename: String): File? {
        return getImageFolder()?.let { imageFolder ->
            File(imageFolder, filename)
        }
    }

    actual fun getVideoFile(filename: String): File? {
        return getVideoFolder()?.let { videoFolder ->
            File(videoFolder, filename)
        }
    }

    private fun getAudioFolder(): File? {
        val externalFileDir: File? = context.getExternalFilesDir(null)
        externalFileDir?.let {
            // Get audio folder
            val audioDir = File(externalFileDir.absoluteFile, "audiorecordings")
            if (!audioDir.exists()) {
                // Create directory if not exists
                audioDir.mkdir()
            }
            return audioDir
        }
        return null
    }

    private fun getImageFolder(): File? {
        val externalFileDir: File? = context.getExternalFilesDir(null)
        externalFileDir?.let {
            // Get image folder
            val imageDir = File(externalFileDir.absoluteFile, "images")
            if (!imageDir.exists()) {
                // Create directory if not exists
                imageDir.mkdir()
            }
            return imageDir
        }
        return null
    }

    private fun getVideoFolder(): File? {
        val externalFileDir: File? = context.getExternalFilesDir(null)
        externalFileDir?.let {
            // Get video folder
            val videoDir = File(externalFileDir.absoluteFile, "videos")
            if (!videoDir.exists()) {
                // Create directory if not exists
                videoDir.mkdir()
            }
            return videoDir
        }
        return null
    }

    private fun getRotatedAndScaledBitmap(imageFile: File): Bitmap?{
        val exif = ExifInterface(imageFile.absolutePath)
        val rotation =
            exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
        val rotationInDegrees: Int = exifToDegrees(rotation)
        val matrix = Matrix()
        if (rotation != 0) {
            matrix.preRotate(rotationInDegrees.toFloat())
            val srcBitmap = BitmapFactory.decodeFile(imageFile.absolutePath)
            val scaledBitmap = scaleBitmap(srcBitmap)
            return Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.width, scaledBitmap.height, matrix, true)
        }
        return null
    }

    private fun scaleBitmap(srcBitmap: Bitmap): Bitmap{
        val maxHeight = 1024
        val maxWidth = 1024
        val scale: Float =
            (maxHeight.toFloat() / srcBitmap.width).coerceAtMost(maxWidth.toFloat() / srcBitmap.height)
        val matrix = Matrix()
        matrix.postScale(scale, scale)
        return Bitmap.createBitmap(srcBitmap, 0, 0, srcBitmap.width, srcBitmap.height, matrix, true)
    }

    private fun exifToDegrees(exifOrientation: Int): Int {
        return when (exifOrientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> {
                90
            }
            ExifInterface.ORIENTATION_ROTATE_180 -> {
                180
            }
            ExifInterface.ORIENTATION_ROTATE_270 -> {
                270
            }
            else -> 0
        }
    }
}