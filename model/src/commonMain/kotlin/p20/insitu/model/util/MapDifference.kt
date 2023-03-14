package p20.insitu.model.util

import kotlinx.serialization.json.JsonElement
import p20.insitu.model.components.ValueDifference

data class MapDifference (
    val entriesAdded: Map<String, Any?>? = null,
    val entriesInCommon: Map<String, Any?>? = null,
    val entriesRemoved: Map<String, Any?>? = null,
    val entriesDiffering: Map<String, ValueDifference>? = null
)