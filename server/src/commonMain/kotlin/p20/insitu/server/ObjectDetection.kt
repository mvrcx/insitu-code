package p20.insitu.server

const val topK = "topK"
const val classLabelNames = "classLabelNames"

expect fun initObjectDetectionModels()
expect fun closeObjectDetectionModels()

expect fun detectObjects(fileName: String, fileBytes: ByteArray, topK: Int = 20, classLabels: List<String>? = null) : String