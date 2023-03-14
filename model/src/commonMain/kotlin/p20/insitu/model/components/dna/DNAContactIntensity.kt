package p20.insitu.model.components.dna

import kotlinx.serialization.Serializable

@Serializable
enum class DNAContactIntensity(val designation: String) {

    UNKNOWN("Unbekannt"),
    INTENSE("Intensive Nutzung / Nutzung mit hohem Kraftaufwand"),
    ONCE_FOR_A_LONG_PERIOD("Einmalige Nutzung über einen längeren Zeitraum")

}