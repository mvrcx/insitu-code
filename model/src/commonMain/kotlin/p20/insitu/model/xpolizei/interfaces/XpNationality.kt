package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDate
import p20.insitu.model.xpolizei.schema.KatalogCode208_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Staatsangehoerigkeit
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpNationality {

    var country: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?
    var from: LocalDate?
    var until: LocalDate?

    fun getStaatsangehoerigkeit(): Staatsangehoerigkeit
}