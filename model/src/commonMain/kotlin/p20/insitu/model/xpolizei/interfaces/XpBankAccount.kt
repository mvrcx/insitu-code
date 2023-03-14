package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Bankkontoinformation
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpBankAccount {

    var accountNumber: String?
    var bankCode: String?
    var iBAN: String?
    var bIC: String?
    var bankName: String?
    var bankLocation: String?
    var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?

    fun getBankkontoinformation(): Bankkontoinformation
}