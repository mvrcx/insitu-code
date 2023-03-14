package p20.insitu.viewmodels.entities

import androidx.compose.runtime.MutableState
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.db.util.toMap
import p20.insitu.model.components.*
import p20.insitu.model.components.spatial.geodetic.shapes.GeoPositionMarker
import p20.insitu.model.entities.*
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.util.mapDifference
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode321
import p20.insitu.model.xpolizei.schema.KatalogCode371
import p20.insitu.nav.NavAction
import p20.insitu.nav.NavRoute
import p20.insitu.resources.FileHandler
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.GlobalSettings
import p20.insitu.util.getCurrentZonedDateTime

@OptIn(ExperimentalCoroutinesApi::class)
class CrimeSceneViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<CrimeScene>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {
    //region Crime scene
    // Documentation number
    private val _docNumber = MutableStateFlow<DocNumber?>(null)
    val docNumber: StateFlow<DocNumber?> = _docNumber
    fun setDocNumber(docNumber: DocNumber?) {
        _docNumber.value = docNumber
        checkForPendingChanges()
    }

    // Type of location
    private val _locationType =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>?>(null)
    val locationType: StateFlow<CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>?> =
        _locationType

    fun setLocationType(locationType: CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>?) {
        _locationType.value = locationType
        checkForPendingChanges()
    }

    // Short description
    private val _shortDescription = MutableStateFlow<String?>(null)
    val shortDescription: StateFlow<String?> = _shortDescription
    fun setShortDescription(shortDescription: String?) {
        _shortDescription.value = shortDescription
        checkForPendingChanges()
    }

    // Time of arrival
    private val _timeOfArrival = MutableStateFlow<ZonedDateTime?>(null)
    val timeOfArrival: StateFlow<ZonedDateTime?> = _timeOfArrival
    fun setTimeOfArrival(timeOfArrival: ZonedDateTime?) {
        _timeOfArrival.value = timeOfArrival
        checkForPendingChanges()
    }
    //endregion

    //region Related address
    private val _address: MutableStateFlow<Address?> = MutableStateFlow(null)
    val address: StateFlow<Address?> =
        _address.flatMapLatest { entity ->
            entity?.id?.let { entityId ->
                docuDataRepo.observeEntity<Address>(entityId)
                    .onStart {
                        emit(entity)
                    }
            } ?: flow { emit(null) }
        }.onEach {
            // TODO: Maybe ignore updates when in edit mode?
            it?.let { updateAddressUiStates(it) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    // Street
    private val _street = MutableStateFlow<String?>(null)
    val street: StateFlow<String?> = _street
    fun setStreet(street: String?) {
        _street.value = street
        checkForPendingChanges()
    }

    // House number
    private val _houseNumber = MutableStateFlow<String?>(null)
    val houseNumber: StateFlow<String?> = _houseNumber
    fun setHouseNumber(houseNumber: String?) {
        _houseNumber.value = houseNumber
        checkForPendingChanges()
    }

    // District
    private val _district = MutableStateFlow<String?>(null)
    val district: StateFlow<String?> = _district
    fun setDistrict(district: String?) {
        _district.value = district
        checkForPendingChanges()
    }

    // Street code
    private val _streetCode = MutableStateFlow<String?>(null)
    val streetCode: StateFlow<String?> = _streetCode
    fun setStreetCode(streetCode: String?) {
        _streetCode.value = streetCode
        checkForPendingChanges()
    }

    // Alternative address description
    private val _alternativeAddress = MutableStateFlow<String?>(null)
    val alternativeAddress: StateFlow<String?> = _alternativeAddress
    fun setAlternativeAddress(alternativeAddress: String?) {
        _alternativeAddress.value = alternativeAddress
        checkForPendingChanges()
    }

    // City
    private val _city = MutableStateFlow<String?>(null)
    val city: StateFlow<String?> = _city
    fun setCity(city: String?) {
        _city.value = city
        checkForPendingChanges()
    }

    // Postal code
    private val _postalCode = MutableStateFlow<String?>(null)
    val postalCode: StateFlow<String?> = _postalCode
    fun setPostalCode(postalCode: String?) {
        _postalCode.value = postalCode
        checkForPendingChanges()
    }

    // Country
    private val _country =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?>(null)
    val country: StateFlow<CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?> =
        _country

    fun setCountry(country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?) {
        _country.value = country
        checkForPendingChanges()
    }

    // Comment
    private val _comment = MutableStateFlow<String?>(null)
    val comment: StateFlow<String?> = _comment
    fun setComment(comment: String?) {
        _comment.value = comment
        checkForPendingChanges()
    }

    // Geo position
    private val _geolocation = MutableStateFlow<GeoPositionMarker?>(null)
    val geolocation: StateFlow<GeoPositionMarker?> = _geolocation
    fun setGeolocation(geolocation: GeoPositionMarker?) {
        _geolocation.value = geolocation
        checkForPendingChanges()
    }

    // Region
    private val _region = MutableStateFlow<String?>(null)
    val region: StateFlow<String?> = _region
    fun setRegion(region: String?) {
        _region.value = region
        checkForPendingChanges()
    }

    // County
    private val _county = MutableStateFlow<String?>(null)
    val county: StateFlow<String?> = _county
    fun setCounty(county: String?) {
        _county.value = county
        checkForPendingChanges()
    }

    // Region code
    private val _regionCode = MutableStateFlow<String?>(null)
    val regionCode: StateFlow<String?> = _regionCode
    fun setRegionCode(regionCode: String?) {
        _regionCode.value = regionCode
        checkForPendingChanges()
    }

    // Municipality code
    private val _municipalityCode =
        MutableStateFlow<CatalogCodeFixed<KatalogCode371>?>(null)
    val municipalityCode: StateFlow<CatalogCodeFixed<KatalogCode371>?> =
        _municipalityCode

    fun setMunicipalityCode(municipalityCode: CatalogCodeFixed<KatalogCode371>?) {
        _municipalityCode.value = municipalityCode
        checkForPendingChanges()
    }

    // Federal state
    private val _federalState =
        MutableStateFlow<CatalogCodeFixed<KatalogCode321>?>(null)
    val federalState: StateFlow<CatalogCodeFixed<KatalogCode321>?> =
        _federalState

    fun setFederalState(federalState: CatalogCodeFixed<KatalogCode321>?) {
        _federalState.value = federalState
        checkForPendingChanges()
    }
    //endregion

    private var initialAddressAttributeMap: Map<String, Any?> = mapOf()

    override suspend fun init(
        entityId: String?,
        navigationState: MutableState<NavAction?>,
        onCreationFinishedDestination: NavRoute?,
        catalogCode: String?
    ) {
        super.init(entityId, navigationState, onCreationFinishedDestination, catalogCode)
        entityId?.let {
            docuDataRepo.getRelatedAddress(it)?.let { address->
                setAddress(address)
                initialAttributeMap = toMap(address as BaseEntity)
            }
        }?:run{
            setAddress( Address())
        }
    }

    fun setAddress(entity: Address) {
        _address.value = entity
        updateAddressUiStates(entity)
    }

    override fun createNewEntity(): CrimeScene {
        return ObjectFactory.createCrimeScene(
            timeOfArrival = getCurrentZonedDateTime()
        )
    }

    @OptIn(ExperimentalSerializationApi::class)
    private fun saveAddress(crimeScene: CrimeScene) {
        updateEntityFromUiStates() // TODO can be removed? (has already been called by saveEntity())
        sessionHandler.userInfo.value?.id?.let { userId ->
            sessionHandler.docuHandler.investigation.value?.let { investigation ->
                address.value?.let {
                    docuDataRepo.saveAddress(
                        address = it,
                        crimeScene = crimeScene,
                        investigation = investigation,
                        userId = userId
                    )
                }
            }
        }
    }

    override fun save() {
        entity.value?.let { crimeScene ->
            saveEntity(crimeScene)
            saveAddress(crimeScene)
            postSaving(crimeScene)
        }
    }

    override fun updateUiStates(entity: CrimeScene) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _docNumber.value = entity.docNumber
        _locationType.value = entity.locationType
        _shortDescription.value = entity.shortDescription
        _timeOfArrival.value = entity.timeOfArrival
    }

    private fun updateAddressUiStates(entity: Address) {
        _thumbnailId.value = entity.thumbnailId
        _street.value = entity.postalAddress?.street
        _houseNumber.value = entity.postalAddress?.houseNumber
        _district.value = entity.postalAddress?.district
        _streetCode.value = entity.postalAddress?.streetCode
        _alternativeAddress.value = entity.postalAddress?.alternativeAddress
        _city.value = entity.postalAddress?.city
        _postalCode.value = entity.postalAddress?.postalCode
        _country.value = entity.postalAddress?.country
        _municipalityCode.value = entity.administrativeEncoding?.municipalityCode
        _county.value = entity.administrativeEncoding?.county
        _regionCode.value = entity.administrativeEncoding?.regionCode
        _federalState.value = entity.administrativeEncoding?.federalState
        _comment.value = entity.comment
        _geolocation.value = entity.geolocation
        _region.value = entity.region
    }

    override fun updateEntityFromUiStates() {
        address.value?.let {
            it.thumbnailId = thumbnailId.value
            it.postalAddress = PostalAddress(
                street = _street.value,
                houseNumber = _houseNumber.value,
                district = _district.value,
                streetCode = _streetCode.value,
                alternativeAddress = _alternativeAddress.value,
                city = _city.value,
                postalCode = _postalCode.value,
                country = _country.value
            )
            it.administrativeEncoding = AdministrativeEncoding(
                municipalityCode = _municipalityCode.value,
                county = _county.value,
                district = _district.value,
                regionCode = _regionCode.value,
                federalState = _federalState.value,
            )
            it.comment = _comment.value
            it.geolocation = _geolocation.value
            it.region = _region.value
            setAddress(it)
        }
        entity.value?.also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = _docNumber.value
            it.locationType = _locationType.value
            it.shortDescription = _shortDescription.value
            it.timeOfArrival = _timeOfArrival.value
            if (it.designation.isNullOrEmpty() && it.locationType != null) {
                it.designation = it.locationType.toString()
            } else if (it.designation.isNullOrEmpty() && !address.value?.postalAddress?.toString().isNullOrEmpty()) {
                it.designation = address.value?.postalAddress?.toString()
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): CrimeScene {
        return CrimeScene().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.locationType = locationType.value
            it.shortDescription = shortDescription.value
            it.timeOfArrival = timeOfArrival.value
        }
    }

    private fun getEditedAddressState(): Address {
        return Address().also {
            it.thumbnailId = thumbnailId.value
            it.postalAddress = PostalAddress(
                street = street.value,
                houseNumber = houseNumber.value,
                district = district.value,
                streetCode = streetCode.value,
                alternativeAddress = alternativeAddress.value,
                city = city.value,
                postalCode = postalCode.value,
                country = country.value
            )
            it.administrativeEncoding = AdministrativeEncoding(
                municipalityCode = municipalityCode.value,
                county = county.value,
                district = district.value,
                regionCode = regionCode.value,
                federalState = federalState.value,
            )
            it.comment = comment.value
            it.geolocation = geolocation.value
            it.region = region.value
        }
    }

    override fun checkForPendingChanges(ignoreAttributes: List<String>): Boolean {
        val crimeSceneChanges = super.checkForPendingChanges(
            listOf(
                "id",
                "deleted"
            )
        )
        var addressChanges = false
        if (uiStateHandler.editMode.value && !uiStateHandler.newEntity.value) {
            getEditedAddressState().let { currentAddressState ->
                val currentAttributeMap = toMap(currentAddressState as BaseEntity)
                val mapDifference = mapDifference(
                    oldMap = initialAddressAttributeMap,
                    newMap = currentAttributeMap,
                    ignoreKeys = listOf(
                        "id",
                        "deleted",
                        "designation"
                    )
                )
                addressChanges = !mapDifference.entriesDiffering.isNullOrEmpty() ||
                        !mapDifference.entriesAdded.isNullOrEmpty() ||
                        !mapDifference.entriesRemoved.isNullOrEmpty()
            }
        }
        val pendingChanges = crimeSceneChanges || addressChanges
        uiStateHandler.setPendingChanges(pendingChanges)
        return pendingChanges
    }
}