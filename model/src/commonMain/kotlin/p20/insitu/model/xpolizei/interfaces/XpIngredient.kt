package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Inhaltsstoff
import p20.insitu.model.components.Volume
import p20.insitu.model.components.Weight

interface XpIngredient {

    var ingredient: String?
    var percentage: Double?
    var volume: Volume?
    var weight: Weight?

    fun getInhaltsstoff(): Inhaltsstoff
}