package p20.insitu.model.components.dna

import kotlinx.serialization.Serializable

@Serializable
enum class DNAContributors(val designation: String) {
    UNKNOWN("Unbekannt"),
    ONE_OR_LESS("Bis zu 1 Mitverursacher"),
    THREE_OR_LESS("Bis zu 3 Mitverursacher"),
    MORE_THAN_THREE("Mehr als 3 Mitverursacher"),
}