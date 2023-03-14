package p20.insitu.model.components.dna

import kotlinx.serialization.Serializable
import p20.insitu.model.components.Component

@Serializable
data class DNAClassification(
    var crimeRelatedTrace: DNACrimeRelated?,
    var secretionSuspiciousAttachment: Boolean?,
    var secretionSuspiciousSecuringLocation: Boolean?,
    var objectBelongsToCrimeScenePersonnel: Boolean?,
    var securingLocationWasUsedByPerpetrator: Boolean?,
    var manyDNAContributors: Boolean?,
    var contactTraceDetails: DNAContactTraceDetails?,
    var traceClass: DNATraceClass?
): Component()
