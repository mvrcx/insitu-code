package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpCash : XpMoney {

    var numberOfPieces: Int?
    var specialFeatures: String?
    var designation: String?
    var pertinentNote: List<CatalogCodeFixed<KatalogCode386>>?
    var issuingCountry: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?
    var issuer: CatalogCodeNotComplete<KatalogCode209_NichtAbgeschlossen>?

    fun getBargeld(): Bargeld

}