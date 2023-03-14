package p20.insitu.server

import org.jetbrains.kotlinx.dl.api.inference.loaders.ONNXModelHub
import org.jetbrains.kotlinx.dl.api.inference.objectdetection.DetectedObject
import org.jetbrains.kotlinx.dl.api.inference.onnx.ONNXModels
import org.jetbrains.kotlinx.dl.api.inference.onnx.OnnxInferenceModel
import org.jetbrains.kotlinx.dl.api.inference.onnx.objectdetection.SSDObjectDetectionModel
import java.awt.*
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.abs

var modelSSD: SSDObjectDetectionModel? = null
var modelYOLO: OnnxInferenceModel? = null

actual fun detectObjects(fileName: String, fileBytes: ByteArray, topK: Int, classLabels: List<String>?): String {

    val imageFile = File("server/serverFiles/$fileName")
    imageFile.writeBytes(fileBytes)
    val newFileName = fileName.replace("image", "detectedObjects")

        modelSSD?.detectObjects(imageFile = imageFile, topK = topK)?.let { detectedObjects ->
            if (!classLabels.isNullOrEmpty()) {
                detectedObjects.filter {
                        it.classLabel in classLabels
                }.also { filteredObjects ->
                    drawRectanglesForDetectedObjects(newFileName, imageFile, filteredObjects)
                }
            } else {
                drawRectanglesForDetectedObjects(newFileName, imageFile, detectedObjects)
            }
        }

    return newFileName
}

fun drawRectanglesForDetectedObjects(
    fileName: String,
    image: File,
    detectedObjects: List<DetectedObject>
) {
    val bufferedImage = ImageIO.read(image)

    val newGraphics = bufferedImage.createGraphics()
    newGraphics.drawImage(bufferedImage, 0, 0, null)

    detectedObjects.forEach {

        // draw bounding box
        val top = it.yMin * bufferedImage.height
        val left = it.xMin * bufferedImage.width
        val bottom = it.yMax * bufferedImage.height
        val right = it.xMax * bufferedImage.width
        if (abs(top - bottom) > 400 || abs(right - left) > 400) return@forEach

        newGraphics as Graphics2D
        val stroke1: Stroke = BasicStroke(4f)
        when (it.classLabel) {
            "person" -> newGraphics.color = Color.RED
            "bicycle" -> newGraphics.color = Color.BLUE
            "car" -> newGraphics.color = Color.GREEN
            else -> newGraphics.color = Color.WHITE
        }
        newGraphics.stroke = stroke1
        newGraphics.drawRect(left.toInt(), bottom.toInt(), (right - left).toInt(), (top - bottom).toInt())

        // draw label
        newGraphics.color = Color.ORANGE
        newGraphics.font = Font("Courier New", 1, 17)
        newGraphics.drawString(" ${it.classLabel} : ${"%.2f".format(it.probability)}", left.toInt(), bottom.toInt() - 8)
    }

    ImageIO.write(bufferedImage, "jpg", File("server/serverFiles/$fileName"))
}

actual fun initObjectDetectionModels() {
    println("initializing object detection models")
    val modelHub = ONNXModelHub(cacheDirectory = File("server/cache/pretrainedModels"))
    modelSSD = ONNXModels.ObjectDetection.SSD.pretrainedModel(modelHub)
    //modelYOLO = ONNXModels.ObjectDetection.YOLOv4.pretrainedModel(modelHub) // not yet implemented
}

actual fun closeObjectDetectionModels() {
    println("closing object detection models")
    modelSSD?.close()
    modelYOLO?.close()
}