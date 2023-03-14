package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

/**
 * This class describes an official (police) authority involved in the investigation or crime scene
 * documentation. An authority is typically associated to a [Person] or [SovereignAct].
 *
 * ## XPolizei
 * The class implements the [XpAuthority] interface which exposes a [BeteiligteStelle] object.
 *
 * @property deleted Indicates if the object should be regarded as deleted. Default: `false`
 * @property designation The name or short description of the authority.
 * @property thumbnailId Reference to an [Image] object that represents the thumbnail / icon of the
 * authority.
 * @property typeOfAuthority The type of authority. Maps to [BeteiligteStelle.art].
 * @property fileNumbers The file numbers associated with this authority in a given context
 * (i.e. investigation). Maps to [BeteiligteStelle.aktenzeichen].
 * @property comment A comment referring to the authority or its involvement.
 * Maps to [BeteiligteStelle.bemerkung].
 * @property nationality The nationality of the authority.
 * Maps to [BeteiligteStelle.nationaleZugehoerigkeit].
 * @property countryCode The country code of the authority.
 * Maps to [BeteiligteStelle.laenderschluessel].
 * @property postalAddress The postal address of the authority. Maps to [BeteiligteStelle.anschrift].
 * @property postOfficeBox The address information of the authority's post office box.
 * Maps to [BeteiligteStelle.postfach].
 * @property assignedEmployees Contact information of the employees / officials that are involved in
 * a given context (i.e. investigation). Maps to [BeteiligteStelle.sachbearbeiter].
 * @property policeOffice The contact information of the police office involved.
 * Maps to [BeteiligteStelle.dienststelle].
 * @property organizationalUnit The contact information of the organizational unit involved.
 * Maps to [BeteiligteStelle.organisationseinheit].
 * @property authorityAbbreviation The abbreviation of the authority.
 * Maps to [BeteiligteStelle.behoerdenkennzeichnung].
 * @constructor Create a new Authority object.
 */
@Serializable
data class Authority(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var typeOfAuthority: CatalogCodeNotComplete<KatalogCode212_NichtAbgeschlossen>? = null,
    override var fileNumbers: List<String>? = null,
    override var comment: String? = null,
    override var nationality: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>? = null,
    override var countryCode: CatalogCodeFixed<KatalogCode287>? = null,
    override var postalAddress: PostalAddress? = null,
    override var postOfficeBox: PostOfficeBox? = null,
    override var assignedEmployees: List<Contact>? = null,
    override var policeOffice: Contact? = null,
    override var organizationalUnit: Contact? = null,
    override var authorityAbbreviation: AuthorityAbbreviation? = null
) : BaseEntity(), DocumentationObject, XpAuthority {

    /**
     * The unique object type for this entity class is [p20.insitu.model.entities.ObjectType.AUTHORITY].
     *
     * @see p20.insitu.model.entities.ObjectType
     */
    override val entityType: String = EntityType.AUTHORITY.toString()

}
