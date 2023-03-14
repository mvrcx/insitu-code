package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpActiveSubstance
import p20.insitu.model.xpolizei.schema.Wirkstoff

@Serializable
data class ActiveSubstance(
    override var designation: String?,
    override var weight: Weight?
) : Component(), XpActiveSubstance {

    override fun getWirkstoff(): Wirkstoff {
        return Wirkstoff(
            bezeichnung = designation,
            gewicht = weight?.getGewicht()
        )
    }
}