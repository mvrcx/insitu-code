package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Falschgeld
import p20.insitu.model.xpolizei.schema.KatalogCode226_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode227
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpCounterfeitMoney : XpMoney {

    var forgeryType: List<CatalogCodeNotComplete<KatalogCode226_NichtAbgeschlossen>>?
    var specialFeatures: String?
    var plateNumber: String?
    var coinMark: String?
    var detectedBy: CatalogCodeFixed<KatalogCode227>?
    var numberOfPiecesWithSameFeatures: Int?
    var seriesDesignation: String?

    fun getFalschgeld(): Falschgeld

}