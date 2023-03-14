package p20.insitu.resources

import androidx.compose.ui.graphics.ImageBitmap
import org.koin.core.component.KoinComponent
import p20.insitu.model.entities.Image
import java.io.File

expect class FileHandler() : KoinComponent {

    fun getBinaryFile(resourceDirectory: String, filename: String): ByteArray?

    fun getImageBitmap(image: Image): ImageBitmap?

    fun getAudioFile(filename: String): File?

    fun getImageFile(filename: String): File?

    fun getVideoFile(filename: String): File?
}