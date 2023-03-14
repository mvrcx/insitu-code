package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpIngredient
import p20.insitu.model.xpolizei.schema.Inhaltsstoff

@Serializable
data class Ingredient(
    override var ingredient: String?,
    override var percentage: Double?,
    override var volume: Volume?,
    override var weight: Weight?
) : Component(), XpIngredient{

    override fun getInhaltsstoff(): Inhaltsstoff {
        return Inhaltsstoff(
            inhaltsstoff = ingredient,
            anteilInProzent = percentage,
            volumen = volume?.getVolumen(),
            gewicht = weight?.getGewicht()
        )
    }
}
