package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class AuthorityInvolvement(
    override var typeOfAuthority: CatalogCodeNotComplete<KatalogCode212_NichtAbgeschlossen>?,
    override var fileNumbers: List<String>?,
    override var comment: String?,
    override var nationality: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?,
    override var countryCode: CatalogCodeFixed<KatalogCode287>?,
    override var postalAddress: PostalAddress?,
    override var postOfficeBox: PostOfficeBox?,
    override var assignedEmployees: List<Contact>?,
    override var policeOffice: Contact?,
    override var organizationalUnit: Contact?,
    override var authorityAbbreviation: AuthorityAbbreviation?,
    override var typeOfInvolvement: CatalogCodeFixed<KatalogCode213>?,
    override var from: ZonedDateTime?,
    override var until : ZonedDateTime?
) : Component(), XpAuthorityInvolvement{

    override fun getBeteiligteStelleBeteiligungsart(): BeteiligteStelleBeteiligungsart {
        return BeteiligteStelleBeteiligungsart().also {
            it.art = typeOfAuthority?.getKatalogCodeNichtAbgeschlossen()
            it.aktenzeichen = fileNumbers
            it.bemerkung = comment
            it.nationaleZugehoerigkeit = nationality?.getKatalogCodeNichtAbgeschlossen()
            it.laenderschluessel = countryCode?.getKatalogCode()
            it.anschrift = postalAddress?.getAnschrift()
            it.postfach = postOfficeBox?.getPostfach()
            it.sachbearbeiter = assignedEmployees?.map { it.getKontakt() }
            it.dienststelle = policeOffice?.getKontakt()
            it.organisationseinheit = organizationalUnit?.getKontakt()
            it.behoerdenkennzeichnung = authorityAbbreviation?.getBehoerdenkennzeichnung()
            it.artDerBeteiligung = typeOfInvolvement?.getKatalogCode()
            it.von = from?.getDatumZeit()
            it.bis = until?.getDatumZeit()
        }
    }
}
