package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode104
import p20.insitu.model.components.BankNoteSeries
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.MoneyAmount

interface XpMoney : XpCommonBaseClass {

    var type: CatalogCodeFixed<KatalogCode104>?
    var serialNumber: String?
    var yearIssued: Int?
    var comment: String?
    var amount: MoneyAmount?
    var serialNumberSeries: BankNoteSeries?

}