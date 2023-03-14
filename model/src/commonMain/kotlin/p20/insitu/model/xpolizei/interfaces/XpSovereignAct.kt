package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.AuthorityInvolvement
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.LegalBasis
import p20.insitu.model.components.ZonedDateTime

interface XpSovereignAct {

    var type: CatalogCodeFixed<KatalogCode108>?
    var category: CatalogCodeFixed<KatalogCode404>?
    var designation: String?
    var specification: String?
    var comment: String?
    var start: ZonedDateTime?
    var end: ZonedDateTime?
    var involvedAgencies: List<AuthorityInvolvement>?
    var priority: CatalogCodeFixed<KatalogCode235>?
    var objection: CatalogCodeFixed<KatalogCode217>?
    var legalBasis: LegalBasis?

    fun getHoheitlicheMassnahme(): HoheitlicheMassnahme
}