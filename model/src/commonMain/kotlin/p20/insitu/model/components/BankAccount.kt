package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpBankAccount
import p20.insitu.model.xpolizei.schema.Bankkontoinformation
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen

@Serializable
data class BankAccount(
    override var accountNumber: String?,
    override var bankCode: String?,
    override var iBAN: String?,
    override var bIC: String?,
    override var bankName: String?,
    override var bankLocation: String?,
    override var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?
) : Component(), XpBankAccount{

    override fun getBankkontoinformation(): Bankkontoinformation {
        return Bankkontoinformation(
            kontonummer = accountNumber,
            bankleitzahl = bankCode,
            iBAN = iBAN,
            bIC = bIC,
            bankname = bankName,
            bankstandort = bankLocation,
            staat = country?.getKatalogCodeNichtAbgeschlossen()
        )
    }
}
