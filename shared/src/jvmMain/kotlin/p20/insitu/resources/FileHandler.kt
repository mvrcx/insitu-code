package p20.insitu.resources

import androidx.compose.ui.graphics.ImageBitmap
import org.koin.core.component.KoinComponent
import p20.insitu.model.entities.Image
import java.io.File

actual class FileHandler actual constructor() : KoinComponent {

    actual fun getBinaryFile(resourceDirectory: String, filename: String): ByteArray? {
        TODO()
    }

    actual fun getImageBitmap(image: Image): ImageBitmap?{
        TODO()
    }

    actual fun getImageFile(filename: String): File? {
        TODO()
    }

}