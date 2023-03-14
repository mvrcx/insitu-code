package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataApi
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.DocNumber
import p20.insitu.model.entities.Investigation
import p20.insitu.model.entities.Room
import p20.insitu.model.entities.enums.RoomType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.resources.FileHandler
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

class RoomViewModel(
    log: Logger,
    fileHandler: FileHandler,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Room>(
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

    // Type of location (fixed)
    private val _locationType =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>?>(null)
    val locationType: StateFlow<CatalogCodeNotComplete<KatalogCode115_NichtAbgeschlossen>?> =
        _locationType

    // Short description
    private val _shortDescription = MutableStateFlow<String?>(null)
    val shortDescription: StateFlow<String?> = _shortDescription
    fun setShortDescription(shortDescription: String?) {
        _shortDescription.value = shortDescription
        checkForPendingChanges()
    }

    // Room type
    private val _roomType = MutableStateFlow<RoomType?>(null)
    val roomType: StateFlow<RoomType?> = _roomType
    fun setRoomType(roomType: RoomType?) {
        _roomType.value = roomType
        checkForPendingChanges()
    }

    // Width
    private val _width = MutableStateFlow<Float?>(null)
    val width: StateFlow<Float?> = _width
    fun setWidth(width: Float?) {
        _width.value = width
        checkForPendingChanges()
    }

    // Length
    private val _length = MutableStateFlow<Float?>(null)
    val length: StateFlow<Float?> = _length
    fun setLength(length: Float?) {
        _length.value = length
        checkForPendingChanges()
    }

    // Height
    private val _height = MutableStateFlow<Float?>(null)
    val height: StateFlow<Float?> = _height
    fun setHeight(height: Float?) {
        _height.value = height
        checkForPendingChanges()
    }

    override fun createNewEntity(): Room {
        return ObjectFactory.createRoom()
    }

    override fun updateUiStates(entity: Room) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _docNumber.value = entity.docNumber
        _locationType.value = entity.locationType
        _roomType.value = entity.roomType
        _width.value = entity.width
        _length.value = entity.length
        _height.value = entity.height
        _shortDescription.value = entity.shortDescription
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { it ->
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.locationType = locationType.value
            it.roomType = roomType.value
            it.width = width.value
            it.length = length.value
            it.height = height.value
            it.shortDescription = _shortDescription.value
            if (it.designation.isNullOrEmpty() && it.roomType != null) {
                it.designation = it.roomType!!.designation
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): Room {
        return Room().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.locationType = locationType.value
            it.roomType = roomType.value
            it.width = width.value
            it.length = length.value
            it.height = height.value
            it.shortDescription = shortDescription.value
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