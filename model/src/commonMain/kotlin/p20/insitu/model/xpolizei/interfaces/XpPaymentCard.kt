package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.BankAccount
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.MoneyAmount

interface XpPaymentCard : XpCommonBaseClass {

    var designation: String?
    var type: CatalogCodeFixed<KatalogCode125>?
    var provider: String?
    var number: String?
    var name: String?
    var comment: String?
    var validFrom: String?
    var validUntil: String?
    var bankAccount: BankAccount?
    var creditBalance: MoneyAmount?
    var numberOfPieces: Int?

    fun getZahlungskarte(): Zahlungskarte

}
