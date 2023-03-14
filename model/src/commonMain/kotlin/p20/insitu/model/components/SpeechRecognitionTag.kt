package p20.insitu.model.components

import kotlinx.serialization.Serializable

@Serializable
data class SpeechRecognitionTag(
    var word: String?,
    var confidence: Float?,
    var start: Float?,
    var end: Float?,
    var modelName: String?
): Component()
