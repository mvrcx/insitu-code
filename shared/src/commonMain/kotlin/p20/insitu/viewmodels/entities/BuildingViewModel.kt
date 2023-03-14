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
import p20.insitu.model.entities.Apartment
import p20.insitu.model.entities.Building
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.resources.FileHandler
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

class BuildingViewModel(
    log: Logger,
    fileHandler: FileHandler,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Building>(
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

    override fun createNewEntity(): Building {
        return ObjectFactory.createBuilding()
    }

    override fun updateUiStates(entity: Building) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _docNumber.value = entity.docNumber
        _locationType.value = entity.locationType
        _shortDescription.value = entity.shortDescription
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { it ->
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.locationType = locationType.value
            it.shortDescription = shortDescription.value
            if (it.designation.isNullOrEmpty()) {
                it.designation =
                    EntityTypeStrings.typeString(EntityType.BUILDING, uiStateHandler.language.value)
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): Building {
        return Building().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.locationType = locationType.value
            it.docNumber = docNumber.value
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