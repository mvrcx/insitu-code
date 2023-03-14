package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.DocNumber
import p20.insitu.model.components.spatial.SpatialRepresentation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.xpolizei.schema.Person
import p20.insitu.model.components.Contact
import p20.insitu.model.components.PersonalDetails
import p20.insitu.model.entities.enums.PersonType

@Serializable
data class Person(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var docNumber: DocNumber? = null,
    override var spatialRepresentation: SpatialRepresentation? = null,
    var personalDetails: List<PersonalDetails> = listOf(),
    var contactDetails: List<Contact> = listOf(),
    var types: Set<PersonType> = setOf()
) : BaseEntity(), Site, XpPerson {

    override val entityType: String = EntityType.PERSON.toString()

    fun getShortName(): String? {
        val firstName = personalDetails.firstOrNull()?.firstName?.designation?:""
        val lastName = personalDetails.firstOrNull()?.lastName?.designation?:""
        return "$firstName $lastName"
    }

    fun getPersonalien(): List<Personalie> {
        return personalDetails.map { it.getPersonalie() }
    }

    fun getKontakte(): List<Kontakt> {
        return contactDetails.map { it.getKontakt() }
    }

    override fun getPerson(): Person {
        return Person().also {
            // Base class attributes
            it.id = id
        }
    }
}
