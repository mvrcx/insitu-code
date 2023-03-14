package p20.insitu.model.components

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ValueDifference(
    val oldValue: @Contextual Any?,
    val newValue: @Contextual Any?
) : Component()
