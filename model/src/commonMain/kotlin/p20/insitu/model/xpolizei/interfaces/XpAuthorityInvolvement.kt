package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.BeteiligteStelleBeteiligungsart
import p20.insitu.model.xpolizei.schema.KatalogCode213
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ZonedDateTime

interface XpAuthorityInvolvement : XpAuthority {

    var typeOfInvolvement: CatalogCodeFixed<KatalogCode213>?
    var from: ZonedDateTime?
    var until: ZonedDateTime?

    fun getBeteiligteStelleBeteiligungsart(): BeteiligteStelleBeteiligungsart
}