package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDate
import p20.insitu.model.components.*
import p20.insitu.model.xpolizei.schema.*

interface XpMedicine : XpMedicineDrugRawMaterial {

    var type: CatalogCodeFixed<KatalogCode323>?
    var numberOfPieces: Int?
    var dosageForm: CatalogCodeFixed<KatalogCode324>?
    var pharmaceuticalNumber: String?
    var intendedUse: CatalogCodeFixed<KatalogCode325>?
    var dopingSubstance: CatalogCodeFixed<KatalogCode217>?
    var batchNumber: String?
    var expiryDate: LocalDate?
    var subsituteDrug: CatalogCodeFixed<KatalogCode217>?
    var packaging: Packaging?
    var illegalSubstance: List<IllegalSubstance>?
    var forgery: Forgery?
    var activeSubstance: List<ActiveSubstance>?

    fun getArzneimittel(): Arzneimittel
}