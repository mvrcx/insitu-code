package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed

interface XpWeight {

    var value: Float
    var unit: CatalogCodeFixed<KatalogCode232>?
    var typeOfDetermination: CatalogCodeFixed<KatalogCode206>?

    fun getGewicht(): Gewicht
}