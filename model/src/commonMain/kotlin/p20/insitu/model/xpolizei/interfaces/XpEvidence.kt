package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.DocNumber
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpEvidence {

    var securingMethod: CatalogCodeNotComplete<KatalogCode405_NichtAbgeschlossen>?
    var purposeOfSecuring: List<CatalogCodeFixed<KatalogCode369>>?
    var damagePermission: CatalogCodeFixed<KatalogCode217>?
    var forensicAnalysis: CatalogCodeFixed<KatalogCode217>?
    var hazardWarning: String?
    var transportAndStorageAdvice: String?
    var storageStatus: CatalogCodeFixed<KatalogCode331>?
    var unDangerousGoodsNumber: CatalogCodeFixed<KatalogCode349>?
    var dangerousGoodsNumber: CatalogCodeFixed<KatalogCode395>?

    fun getAsservat(baseEntityId: String, docNumber: DocNumber?): Asservat
}