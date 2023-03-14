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
import p20.insitu.model.entities.CriminalOffense
import p20.insitu.model.entities.Floor
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.resources.FileHandler
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

class FloorViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Floor>(
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

    // Height
    private val _height = MutableStateFlow<Float?>(null)
    val height: StateFlow<Float?> = _height
    fun setHeight(height: Float?) {
        _height.value = height
        checkForPendingChanges()
    }

    override fun createNewEntity(): Floor {
        return ObjectFactory.createFloor()
    }

    override fun updateUiStates(entity: Floor) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _docNumber.value = entity.docNumber
        _locationType.value = entity.locationType
        _shortDescription.value = entity.shortDescription
        _height.value = entity.height
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { it ->
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.locationType = locationType.value
            it.shortDescription = shortDescription.value
            it.height = height.value
            if (it.designation.isNullOrEmpty()) {
                it.designation =
                    EntityTypeStrings.typeString(EntityType.FLOOR, uiStateHandler.language.value)
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): Floor {
        return Floor().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.locationType = locationType.value
            it.shortDescription = shortDescription.value
            it.height = height.value
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