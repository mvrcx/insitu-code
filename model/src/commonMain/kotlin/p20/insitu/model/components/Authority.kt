package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class Authority(
    override var typeOfAuthority: CatalogCodeNotComplete<KatalogCode212_NichtAbgeschlossen>? = null,
    override var fileNumbers: List<String>? = listOf(),
    override var comment: String? = null,
    override var nationality: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>? = null,
    override var countryCode: CatalogCodeFixed<KatalogCode287>? = null,
    override var postalAddress: PostalAddress? = null,
    override var postOfficeBox: PostOfficeBox? = null,
    override var assignedEmployees: List<Contact>? = listOf(),
    override var policeOffice: Contact? = null,
    override var organizationalUnit: Contact? = null,
    override var authorityAbbreviation: AuthorityAbbreviation? = null
) : Component(), XpAuthority
