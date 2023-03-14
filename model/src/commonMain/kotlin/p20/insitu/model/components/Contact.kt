package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpContact
import p20.insitu.model.xpolizei.schema.Kontakt

@Serializable
data class Contact(
    override var name: String? = null,
    override var eMail: String? = null,
    override var phoneNumber: String? = null,
    override var faxNumber: String? = null,
    override var uID: String? = null
) : Component(), XpContact{

    override fun getKontakt(): Kontakt {
        return Kontakt(
            name = name,
            eMail = eMail,
            telefonnummer = phoneNumber,
            faxnummer = faxNumber,
            uID = uID
        )
    }
}
