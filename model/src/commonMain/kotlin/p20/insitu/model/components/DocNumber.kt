package p20.insitu.model.components

import kotlinx.serialization.Serializable

@Serializable
data class DocNumber(
    val docNumberEntries: List<Int>,
) : Component() {

    val docNumberString: String
        get() {
            val stringBuilder = StringBuilder()
            docNumberEntries.forEachIndexed { index, docNumberEntry ->
                if (index > 0) {
                    stringBuilder.append(".").append(docNumberEntry)
                } else {
                    stringBuilder.append(docNumberEntry)
                }
            }
            return stringBuilder.toString()
        }

}