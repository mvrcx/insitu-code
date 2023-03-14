package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*
import p20.insitu.model.xpolizei.schema.*

/**
 * Interface for the XPolizei object [BeteiligteStelle].
 * Declares a (sub-)set of relevant properties and maps them to its XPolizei counterparts.
 * Provides a Getter function to export an instance of [BeteiligteStelle].
 */
interface XpAuthority {

    /**
     * The type of authority. Maps to [BeteiligteStelle.art].
     */
    var typeOfAuthority: CatalogCodeNotComplete<KatalogCode212_NichtAbgeschlossen>?

    /**
     * The file numbers associated with this authority in a given context (i.e. investigation).
     * Maps to [BeteiligteStelle.aktenzeichen].
     */
    var fileNumbers: List<String>?

    /**
     * A comment referring to the authority or its involvement. Maps to [BeteiligteStelle.bemerkung].
     */
    var comment: String?

    /**
     * The nationality of the authority. Maps to [BeteiligteStelle.nationaleZugehoerigkeit].
     */
    var nationality: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?

    /**
     * The country code of the authority. Maps to [BeteiligteStelle.laenderschluessel].
     */
    var countryCode: CatalogCodeFixed<KatalogCode287>?

    /**
     * The postal address of the authority. Maps to [BeteiligteStelle.anschrift].
     */
    var postalAddress: PostalAddress?

    /**
     * The address information of the authority's post office box. Maps to [BeteiligteStelle.postfach].
     */
    var postOfficeBox: PostOfficeBox?

    /**
     * Contact information of the employees / officials that are involved in
     * a given context (i.e. investigation). Maps to [BeteiligteStelle.sachbearbeiter].
     */
    var assignedEmployees: List<Contact>?

    /**
     * The contact information of the police office involved. Maps to [BeteiligteStelle.dienststelle].
     */
    var policeOffice: Contact?

    /**
     * The contact information of the organizational unit involved.
     * Maps to [BeteiligteStelle.organisationseinheit].
     */
    var organizationalUnit: Contact?

    /**
     * The abbreviation of the authority. Maps to [BeteiligteStelle.behoerdenkennzeichnung].
     */
    var authorityAbbreviation: AuthorityAbbreviation?

    /**
     * Get an instance of [BeteiligteStelle] by mapping the interface properties.
     *
     * @return An instance of [BeteiligteStelle].
     */
    fun getBeteiligteStelle(): BeteiligteStelle {
        return BeteiligteStelle(
            art = typeOfAuthority?.getKatalogCodeNichtAbgeschlossen(),
            aktenzeichen = fileNumbers,
            bemerkung = comment,
            nationaleZugehoerigkeit = nationality?.getKatalogCodeNichtAbgeschlossen(),
            laenderschluessel = countryCode?.getKatalogCode(),
            anschrift = postalAddress?.getAnschrift(),
            postfach = postOfficeBox?.getPostfach(),
            sachbearbeiter = assignedEmployees?.map { it.getKontakt() },
            dienststelle = policeOffice?.getKontakt(),
            organisationseinheit = organizationalUnit?.getKontakt(),
            behoerdenkennzeichnung = authorityAbbreviation?.getBehoerdenkennzeichnung()
        )
    }

}