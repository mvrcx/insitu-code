package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDate
import p20.insitu.model.xpolizei.schema.KatalogCode214
import p20.insitu.model.xpolizei.schema.KatalogCode257_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Religionszugehoerigkeit
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpReligiousAffiliation {

    var religion: CatalogCodeNotComplete<KatalogCode257_NichtAbgeschlossen>?
    var converted: CatalogCodeFixed<KatalogCode214>?
    var from: LocalDate?
    var until: LocalDate?

    fun getReligionszugehoerigkeit(): Religionszugehoerigkeit
}