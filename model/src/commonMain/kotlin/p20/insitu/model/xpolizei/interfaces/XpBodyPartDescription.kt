package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode244_MitZusatz
import p20.insitu.model.xpolizei.schema.KatalogCode376
import p20.insitu.model.xpolizei.schema.Koerperteilangabe
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeWithAddition

interface XpBodyPartDescription {

    var bodyPart: CatalogCodeWithAddition<KatalogCode244_MitZusatz>?
    var location: List<CatalogCodeFixed<KatalogCode376>>?

    fun getKoerperteilangabe(): Koerperteilangabe
}