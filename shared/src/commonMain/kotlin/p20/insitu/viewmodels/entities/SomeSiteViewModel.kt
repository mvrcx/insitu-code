package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.DocNumber
import p20.insitu.model.entities.Investigation
import p20.insitu.model.entities.SomeSite
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.xpolizei.schema.KatalogCode115_NichtAbgeschlossen
import p20.insitu.resources.FileHandler
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

class SomeSiteViewModel(
    log: Logger,
    fileHandler: FileHandler,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<SomeSite>(
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

    override fun createNewEntity(): SomeSite {
        return ObjectFactory.createSomeSite()
    }

    override fun updateUiStates(entity: SomeSite) {
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
            it.shortDescription = _shortDescription.value
            if (it.designation.isNullOrEmpty() && it.locationType != null) {
                it.designation = it.locationType!!.toString()
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): SomeSite {
        return SomeSite().also {
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