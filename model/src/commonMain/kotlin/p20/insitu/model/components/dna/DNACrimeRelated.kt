package p20.insitu.model.components.dna

import kotlinx.serialization.Serializable

@Serializable
enum class DNACrimeRelated(val designation: String) {

    UNKNOWN("Unbekannt"),
    YES("Ja"),
    NO("Nein")

}