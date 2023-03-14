package p20.insitu.model.util

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import p20.insitu.model.components.Component
import p20.insitu.model.components.ValueDifference
import p20.insitu.model.components.ZonedDateTime
import java.sql.Timestamp

expect fun randomUUID(): String

fun getDummyInvestigationNumber(zonedDateTime: ZonedDateTime): String {
    val number = "${zonedDateTime.getDatumZeit().datum}-${
        zonedDateTime.getDatumZeit().zeit
    }".replace(":", "")
        .replace(".", "")
        .replace("-", "")
    return "INSITU-$number"

}

fun Instant.toZonedDateTime(timeZone: TimeZone): ZonedDateTime {
    return ZonedDateTime(
        this.toLocalDateTime(timeZone),
        timeZone
    )
}

fun mapDifference(
    oldMap: Map<String, Any?>,
    newMap: Map<String, Any?>,
    ignoreKeys: List<String> = listOf()
): MapDifference {
    val entriesAdded: MutableMap<String, Any?> = mutableMapOf()
    val entriesInCommon: MutableMap<String, Any?> = mutableMapOf()
    val entriesRemoved: MutableMap<String, Any?> = mutableMapOf()
    val entriesDiffering: MutableMap<String, ValueDifference> = mutableMapOf()

    newMap.filter { !ignoreKeys.contains(it.key) }.forEach { newEntry ->
        val key = newEntry.key
        val newValue = newEntry.value
        if (oldMap.containsKey(key)) {
            val oldValue = oldMap[key]
            // This is a known entry
            if (oldValue == newValue) {
                // The value is the same
                entriesInCommon[key] = newValue
            } else {
                // The value was changed
                entriesDiffering[key] = ValueDifference(
                    oldValue = oldValue,
                    newValue = newValue
                )
            }
        } else {
            // This is a new entry
            entriesAdded[key] = newValue
        }
    }

    // Find all removed entries
    oldMap.entries.filter { !ignoreKeys.contains(it.key) }
        .filter { !newMap.containsKey(it.key) }
        .forEach { removedEntry ->
            entriesRemoved[removedEntry.key] = removedEntry.value
        }

    return MapDifference(
        entriesDiffering = entriesDiffering,
        entriesInCommon = entriesInCommon,
        entriesRemoved = entriesRemoved,
        entriesAdded = entriesAdded
    )
}