package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpAuthorityAbbreviation
import p20.insitu.model.xpolizei.schema.Behoerdenkennzeichnung
import p20.insitu.model.xpolizei.schema.KatalogCode389

@Serializable
data class AuthorityAbbreviation(
    override var designation: String?,
    override var code: CatalogCodeFixed<KatalogCode389>?
) : Component(), XpAuthorityAbbreviation{

    override fun getBehoerdenkennzeichnung(): Behoerdenkennzeichnung {
        return Behoerdenkennzeichnung(
            bezeichnung = designation,
            behoerdenkatalog = code?.getKatalogCode()
        )
    }
}
