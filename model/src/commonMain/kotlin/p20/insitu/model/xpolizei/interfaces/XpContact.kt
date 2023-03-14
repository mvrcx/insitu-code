package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Kontakt

interface XpContact {

    var name: String?
    var eMail: String?
    var phoneNumber: String?
    var faxNumber: String?
    var uID: String?

    fun getKontakt(): Kontakt
}