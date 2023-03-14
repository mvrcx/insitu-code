package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed

interface XpVolume {

    var value: Float
    var unit: CatalogCodeFixed<KatalogCode278>?
    var typeOfDetermination: CatalogCodeFixed<KatalogCode206>?

    fun getVolumen(): Volumen
}