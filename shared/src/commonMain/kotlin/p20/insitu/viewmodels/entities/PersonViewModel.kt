package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.components.*
import p20.insitu.model.components.Number
import p20.insitu.model.entities.Person
import p20.insitu.model.entities.enums.PersonType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.resources.FileHandler
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

class PersonViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Person>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {

    // Documentation number
    private val _docNumber = MutableStateFlow<DocNumber?>(null)
    val docNumber: StateFlow<DocNumber?> = _docNumber
    fun setDocNumber(docNumber: DocNumber?) {
        _docNumber.value = docNumber
        checkForPendingChanges()
    }

    // Types
    private val _types = MutableStateFlow<Set<PersonType>>(setOf())
    val types: StateFlow<Set<PersonType>> = _types
    fun addType(type: PersonType) {
        val tempSet = mutableSetOf<PersonType>()
        tempSet.addAll(_types.value)
        tempSet.add(type)
        _types.value = tempSet
        checkForPendingChanges()
    }

    fun removeType(type: PersonType) {
        val tempSet = mutableSetOf<PersonType>()
        tempSet.addAll(_types.value)
        tempSet.remove(type)
        _types.value = tempSet
        checkForPendingChanges()
    }

    //region Personal details
    // Type of personal information (alias, verified, not verified)
    private val _personalDetailsType = MutableStateFlow<CatalogCodeFixed<KatalogCode117>?>(null)
    val personalDetailsType: StateFlow<CatalogCodeFixed<KatalogCode117>?> = _personalDetailsType
    fun setPersonalDetailsType(type: CatalogCodeFixed<KatalogCode117>?) {
        _personalDetailsType.value = type
        checkForPendingChanges()
    }

    // Leadership role
    private val _leadership = MutableStateFlow<CatalogCodeFixed<KatalogCode217>?>(null)
    val leadership: StateFlow<CatalogCodeFixed<KatalogCode217>?> = _leadership
    fun setLeadership(leadership: CatalogCodeFixed<KatalogCode217>?) {
        _leadership.value = leadership
        checkForPendingChanges()
    }

    // Sex
    private val _sex = MutableStateFlow<CatalogCodeFixed<KatalogCode255>?>(null)
    val sex: StateFlow<CatalogCodeFixed<KatalogCode255>?> = _sex
    fun setSex(sex: CatalogCodeFixed<KatalogCode255>?) {
        _sex.value = sex
        checkForPendingChanges()
    }

    // Birthplace
    private val _birthplace = MutableStateFlow<String?>(null)
    val birthplace: StateFlow<String?> = _birthplace
    fun setBirthplace(birthplace: String?) {
        _birthplace.value = birthplace
        checkForPendingChanges()
    }

    // BirthCounty
    private val _birthCounty = MutableStateFlow<String?>(null)
    val birthCounty: StateFlow<String?> = _birthCounty
    fun setBirthCounty(birthCounty: String?) {
        _birthCounty.value = birthCounty
        checkForPendingChanges()
    }

    // BirthRegion
    private val _birthRegion = MutableStateFlow<String?>(null)
    val birthRegion: StateFlow<String?> = _birthRegion
    fun setBirthRegion(birthRegion: String?) {
        _birthRegion.value = birthRegion
        checkForPendingChanges()
    }

    // BirthCountry
    private val _birthCountry =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?>(null)
    val birthCountry: StateFlow<CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?> =
        _birthCountry

    fun setBirthCountry(birthCountry: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?) {
        _birthCountry.value = birthCountry
        checkForPendingChanges()
    }

    // Nationality
    private val _nationality =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?>(null)
    val nationality: StateFlow<CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?> =
        _nationality

    fun setNationality(nationality: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>?) {
        _nationality.value = nationality
        checkForPendingChanges()
    }

    // MaritalStatus
    private val _maritalStatus = MutableStateFlow<CatalogCodeFixed<KatalogCode254>?>(null)
    val maritalStatus: StateFlow<CatalogCodeFixed<KatalogCode254>?> = _maritalStatus
    fun setMaritalStatus(maritalStatus: CatalogCodeFixed<KatalogCode254>?) {
        _maritalStatus.value = maritalStatus
        checkForPendingChanges()
    }

    // Ethnicity
    private val _ethnicity =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode251_NichtAbgeschlossen>?>(null)
    val ethnicity: StateFlow<CatalogCodeNotComplete<KatalogCode251_NichtAbgeschlossen>?> =
        _ethnicity

    fun setEthnicity(ethnicity: CatalogCodeNotComplete<KatalogCode251_NichtAbgeschlossen>?) {
        _ethnicity.value = ethnicity
        checkForPendingChanges()
    }

    // Title
    private val _title =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode252_MitZusatz_NichtAbgeschlossen>?>(null)
    val title: StateFlow<CatalogCodeNotComplete<KatalogCode252_MitZusatz_NichtAbgeschlossen>?> =
        _title

    fun setTitle(title: CatalogCodeNotComplete<KatalogCode252_MitZusatz_NichtAbgeschlossen>?) {
        _title.value = title
        checkForPendingChanges()
    }

    // Comment
    private val _comment = MutableStateFlow<String?>(null)
    val comment: StateFlow<String?> = _comment
    fun setComment(comment: String?) {
        _comment.value = comment
        checkForPendingChanges()
    }

    // Birthday
    private val _birthday = MutableStateFlow<ZonedDateTime?>(null)
    val birthday: StateFlow<ZonedDateTime?> = _birthday
    fun setBirthday(birthday: ZonedDateTime?) {
        _birthday.value = birthday
        checkForPendingChanges()
    }

    // TimeOfDeath
    private val _timeOfDeath = MutableStateFlow<ZonedDateTime?>(null)
    val timeOfDeath: StateFlow<ZonedDateTime?> = _timeOfDeath
    fun setTimeOfDeath(timeOfDeath: ZonedDateTime?) {
        _timeOfDeath.value = timeOfDeath
        checkForPendingChanges()
    }

    // Religion
    private val _religion =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode257_NichtAbgeschlossen>?>(null)
    val religion: StateFlow<CatalogCodeNotComplete<KatalogCode257_NichtAbgeschlossen>?> =
        _religion

    fun setReligion(religion: CatalogCodeNotComplete<KatalogCode257_NichtAbgeschlossen>?) {
        _religion.value = religion
        checkForPendingChanges()
    }

    // FirstName
    private val _firstName = MutableStateFlow<String?>(null)
    val firstName: StateFlow<String?> = _firstName
    fun setFirstName(firstName: String?) {
        _firstName.value = firstName
        checkForPendingChanges()
    }

    // LastName
    private val _lastName = MutableStateFlow<String?>(null)
    val lastName: StateFlow<String?> = _lastName
    fun setLastName(lastName: String?) {
        _lastName.value = lastName
        checkForPendingChanges()
    }

    // BirthName
    private val _birthName = MutableStateFlow<String?>(null)
    val birthName: StateFlow<String?> = _birthName
    fun setBirthName(birthName: String?) {
        _birthName.value = birthName
        checkForPendingChanges()
    }

    // Alias
    private val _alias = MutableStateFlow<String?>(null)
    val alias: StateFlow<String?> = _alias
    fun setAlias(alias: String?) {
        _alias.value = alias
        checkForPendingChanges()
    }

    // PersonalID value
    private val _personalID = MutableStateFlow<String?>(null)
    val personalID: StateFlow<String?> = _personalID
    fun setPersonalID(personalID: String?) {
        _personalID.value = personalID
        checkForPendingChanges()
    }

    // PersonalID type
    private val _personalIDType =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode322_NichtAbgeschlossen>?>(null)
    val personalIDType: StateFlow<CatalogCodeNotComplete<KatalogCode322_NichtAbgeschlossen>?> =
        _personalIDType

    fun setPersonalIDType(personalIDType: CatalogCodeNotComplete<KatalogCode322_NichtAbgeschlossen>?) {
        _personalIDType.value = personalIDType
        checkForPendingChanges()
    }

    //endregion

    //region Contact information
    // Email
    private val _eMail = MutableStateFlow<String?>(null)
    val eMail: StateFlow<String?> = _eMail
    fun setEmail(eMail: String?) {
        _eMail.value = eMail
        checkForPendingChanges()
    }

    // PhoneNumber
    private val _phoneNumber = MutableStateFlow<String?>(null)
    val phoneNumber: StateFlow<String?> = _phoneNumber
    fun setPhoneNumber(phoneNumber: String?) {
        _phoneNumber.value = phoneNumber
        checkForPendingChanges()
    }

    // FaxNumber
    private val _faxNumber = MutableStateFlow<String?>(null)
    val faxNumber: StateFlow<String?> = _faxNumber
    fun setFaxNumber(faxNumber: String?) {
        _faxNumber.value = faxNumber
        checkForPendingChanges()
    }
    //endregion

    override fun createNewEntity(): Person {
        return ObjectFactory.createPerson()
    }

    override fun updateUiStates(entity: Person) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _docNumber.value = entity.docNumber
        _types.value = entity.types
        _personalDetailsType.value = entity.personalDetails.firstOrNull()?.type
        _leadership.value = entity.personalDetails.firstOrNull()?.leadership
        _sex.value = entity.personalDetails.firstOrNull()?.sex
        _birthplace.value = entity.personalDetails.firstOrNull()?.birthplace
        _birthCounty.value = entity.personalDetails.firstOrNull()?.birthCounty
        _birthRegion.value = entity.personalDetails.firstOrNull()?.birthRegion
        _birthCountry.value = entity.personalDetails.firstOrNull()?.birthCountry
        _nationality.value =
            entity.personalDetails.firstOrNull()?.nationality?.firstOrNull()?.country
        _maritalStatus.value = entity.personalDetails.firstOrNull()?.maritalStatus
        _ethnicity.value = entity.personalDetails.firstOrNull()?.ethnicity
        _title.value = entity.personalDetails.firstOrNull()?.title?.firstOrNull()
        _comment.value = entity.personalDetails.firstOrNull()?.comment
        _birthday.value = entity.personalDetails.firstOrNull()?.birthday
        _timeOfDeath.value = entity.personalDetails.firstOrNull()?.timeOfDeath
        _religion.value =
            entity.personalDetails.firstOrNull()?.religiousAffiliation?.firstOrNull()?.religion
        _firstName.value = entity.personalDetails.firstOrNull()?.firstName?.designation
        _lastName.value = entity.personalDetails.firstOrNull()?.lastName?.designation
        _birthName.value = entity.personalDetails.firstOrNull()?.birthName?.designation
        _alias.value = entity.personalDetails.firstOrNull()?.alias?.firstOrNull()?.designation
        _personalID.value =
            entity.personalDetails.firstOrNull()?.personalID?.firstOrNull()?.number?.value
        _personalIDType.value =
            entity.personalDetails.firstOrNull()?.personalID?.firstOrNull()?.type
        _eMail.value = entity.contactDetails.firstOrNull()?.eMail
        _phoneNumber.value = entity.contactDetails.firstOrNull()?.phoneNumber
        _faxNumber.value = entity.contactDetails.firstOrNull()?.faxNumber
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { person ->
            person.designation = designation.value
            person.thumbnailId = thumbnailId.value
            person.docNumber = docNumber.value
            person.types = types.value
            person.personalDetails = listOf(
                PersonalDetails().also { details ->
                    details.type = personalDetailsType.value
                    details.leadership = leadership.value
                    details.sex = sex.value
                    details.birthplace = birthplace.value
                    details.birthCounty = birthCounty.value
                    details.birthRegion = birthRegion.value
                    details.birthCountry = birthCountry.value
                    details.nationality = listOf(Nationality(country = nationality.value))
                    details.maritalStatus = maritalStatus.value
                    details.ethnicity = ethnicity.value
                    details.title = title.value?.let { listOf(it) } ?: listOf()
                    details.comment = comment.value
                    details.birthday = birthday.value
                    details.timeOfDeath = timeOfDeath.value
                    details.religiousAffiliation = religion.value?.let {
                        listOf(
                            ReligiousAffiliation(religion = it)
                        )
                    } ?: listOf()
                    details.firstName = firstName.value?.let { NameData(designation = it) }
                    details.lastName = lastName.value?.let { NameData(designation = it) }
                    details.birthName = birthName.value?.let { NameData(designation = it) }
                    details.alias = alias.value?.let { listOf(NameData(designation = it)) }
                        ?: listOf()
                    details.personalID = personalID.value?.let { pId ->
                        listOf(
                            PersonalID(
                                number = Number(value = pId),
                                type = personalIDType.value
                            )
                        )
                    } ?: listOf()
                }
            )
            person.contactDetails = listOf(
                Contact(
                    name = "${firstName.value ?: ""} ${lastName.value ?: ""}",
                    eMail = eMail.value,
                    phoneNumber = phoneNumber.value,
                    faxNumber = faxNumber.value
                )
            )
            setEntity(person)
        }
    }

    override fun getEditedEntityState(): Person {
        return Person().also { person ->
            person.designation = designation.value
            person.thumbnailId = thumbnailId.value
            person.docNumber = docNumber.value
            person.types = types.value
            person.personalDetails = listOf(
                PersonalDetails().also { details ->
                    details.type = personalDetailsType.value
                    details.leadership = leadership.value
                    details.sex = sex.value
                    details.birthplace = birthplace.value
                    details.birthCounty = birthCounty.value
                    details.birthRegion = birthRegion.value
                    details.birthCountry = birthCountry.value
                    details.nationality = listOf(Nationality(country = nationality.value))
                    details.maritalStatus = maritalStatus.value
                    details.ethnicity = ethnicity.value
                    details.title = title.value?.let { listOf(it) } ?: listOf()
                    details.comment = comment.value
                    details.birthday = birthday.value
                    details.timeOfDeath = timeOfDeath.value
                    details.religiousAffiliation = religion.value?.let {
                        listOf(
                            ReligiousAffiliation(religion = it)
                        )
                    } ?: listOf()
                    details.firstName = firstName.value?.let { NameData(designation = it) }
                    details.lastName = lastName.value?.let { NameData(designation = it) }
                    details.birthName = birthName.value?.let { NameData(designation = it) }
                    details.alias = alias.value?.let { listOf(NameData(designation = it)) }
                        ?: listOf()
                    details.personalID = personalID.value?.let { pId ->
                        listOf(
                            PersonalID(
                                number = Number(value = pId),
                                type = personalIDType.value
                            )
                        )
                    } ?: listOf()
                }
            )
            person.contactDetails = listOf(
                Contact().also { contact ->
                    contact.name = "${firstName.value ?: ""} ${lastName.value ?: ""}"
                }
            )
        }
    }

    override fun checkForPendingChanges(ignoreAttributes: List<String>): Boolean {
        return super.checkForPendingChanges(
            listOf(
                "id",
                "deleted",
                "spatialRepresentation"
            )
        )
    }
}