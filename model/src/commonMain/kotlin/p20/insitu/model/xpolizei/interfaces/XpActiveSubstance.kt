package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Wirkstoff
import p20.insitu.model.components.Weight

interface XpActiveSubstance {

    var designation: String?
    var weight: Weight?

    fun getWirkstoff(): Wirkstoff
}