package p20.insitu.model.components.dna

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component

@Serializable
data class DNAContactTraceDetails(
    var additionalDNAContributors: DNAContributors,
    var objectSurface: DNAObjectSurface,
    var contactIntensity: DNAContactIntensity
): Component()