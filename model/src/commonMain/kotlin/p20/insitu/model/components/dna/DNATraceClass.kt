package p20.insitu.model.components.dna

import kotlinx.serialization.Serializable

@Serializable
enum class DNATraceClass(val designation: String) {

    NOT_CRIME_RELATED("DNA-Spur ohne Tatrelevanz"),
    UNVERIFIED_SECRETION_TRACE("Sekretspur (ungeprüft)"),
    POTENTIAL_SECRETION_TRACE("Potentielle Sekretspur"),
    PROMISING_USAGE_TRACE("Erfolgsversprechende Gebrauchsspur"),
    UNPROMISING_USAGE_TRACE("Nicht erfolgsversprechende Gebrauchsspur"),
    CONTACT_TRACE_TYPE_1("DNA-Kontaktspur Typ I"), // Ranking value -1
    CONTACT_TRACE_TYPE_2("DNA-Kontaktspur Typ II"), // Ranking value 0
    CONTACT_TRACE_TYPE_3("DNA-Kontaktspur Typ III"), // Ranking value 1
    CONTACT_TRACE_TYPE_4("DNA-Kontaktspur Typ IV"), // Ranking value 2
    CONTACT_TRACE_TYPE_5("DNA-Kontaktspur Typ V") // Ranking value 3

}