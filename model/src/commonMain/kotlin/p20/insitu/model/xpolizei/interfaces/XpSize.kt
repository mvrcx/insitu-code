package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Ausmass
import p20.insitu.model.xpolizei.schema.KatalogCode206
import p20.insitu.model.xpolizei.schema.KatalogCode207
import p20.insitu.model.components.CatalogCodeFixed

interface XpSize {

    var value: Float
    var unit: CatalogCodeFixed<KatalogCode207>?
    var typeOfDetermination: CatalogCodeFixed<KatalogCode206>?

    fun getAusmass(): Ausmass
}