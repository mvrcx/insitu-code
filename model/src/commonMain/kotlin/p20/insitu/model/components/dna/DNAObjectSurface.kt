package p20.insitu.model.components.dna

import kotlinx.serialization.Serializable

@Serializable
enum class DNAObjectSurface(val designation: String) {

    UNKNOWN("Unbekannt"),
    ROUGH("Rau oder noppig"),
    SHARP_EDGED("Scharfkantig"),
    TOO_SMALL_FOR_FINGER_PRINTS("Zu klein für Daktyloskopie")

}