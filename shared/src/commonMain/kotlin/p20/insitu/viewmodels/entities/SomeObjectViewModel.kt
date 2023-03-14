package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataApi
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.components.*
import p20.insitu.model.components.Material
import p20.insitu.model.entities.Investigation
import p20.insitu.model.entities.SomeObject
import p20.insitu.model.util.CatalogInfo
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.resources.FileHandler
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.getCurrentZonedDateTime

class SomeObjectViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EvidenceDataViewModel<SomeObject>(
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

    // Type of object
    private val _typeOfObject =
        MutableStateFlow<CatalogCodeNotComplete<KatalogCode119_NichtAbgeschlossen>?>(null)
    val typeOfObject: StateFlow<CatalogCodeNotComplete<KatalogCode119_NichtAbgeschlossen>?> =
        _typeOfObject

    fun setTypeOfObject(typeOfObject: CatalogCodeNotComplete<KatalogCode119_NichtAbgeschlossen>?) {
        _typeOfObject.value = typeOfObject
        checkForPendingChanges()
    }

    // Number of pieces
    private val _numberOfPieces = MutableStateFlow<Int?>(null)
    val numberOfPieces: StateFlow<Int?> = _numberOfPieces
    fun setNumberOfPieces(numberOfPieces: Int?) {
        _numberOfPieces.value = numberOfPieces
        checkForPendingChanges()
    }

    // Special features
    private val _specialFeatures = MutableStateFlow<String?>(null)
    val specialFeatures: StateFlow<String?> = _specialFeatures
    fun setSpecialFeatures(specialFeatures: String?) {
        _specialFeatures.value = specialFeatures
        checkForPendingChanges()
    }

    // Comment
    private val _comment = MutableStateFlow<String?>(null)
    val comment: StateFlow<String?> = _comment
    fun setComment(comment: String?) {
        _comment.value = comment
        checkForPendingChanges()
    }

    // Colors
    private val _colors = MutableStateFlow<List<ColorDescription>>(listOf())
    val colors: StateFlow<List<ColorDescription>> = _colors
    fun setColors(colors: List<ColorDescription>) {
        _colors.value = colors
        checkForPendingChanges()
    }

    // Materials
    private val _materials = MutableStateFlow<List<Material>>(listOf())
    val materials: StateFlow<List<Material>> = _materials
    fun setMaterials(materials: List<Material>) {
        _materials.value = materials
        checkForPendingChanges()
    }

    // Weight
    private val _weight = MutableStateFlow<Weight?>(null)
    val weight: StateFlow<Weight?> = _weight
    fun setWeight(weight: Weight?) {
        _weight.value = weight
        checkForPendingChanges()
    }

    // Volume
    private val _volume = MutableStateFlow<Volume?>(null)
    val volume: StateFlow<Volume?> = _volume
    fun setVolume(volume: Volume?) {
        _volume.value = volume
        checkForPendingChanges()
    }

    // Length
    private val _length = MutableStateFlow<Size?>(null)
    val length: StateFlow<Size?> = _length
    fun setLength(length: Size?) {
        _length.value = length
        checkForPendingChanges()
    }

    // Width
    private val _width = MutableStateFlow<Size?>(null)
    val width: StateFlow<Size?> = _width
    fun setWidth(width: Size?) {
        _width.value = width
        checkForPendingChanges()
    }

    // Height
    private val _height = MutableStateFlow<Size?>(null)
    val height: StateFlow<Size?> = _height
    fun setHeight(height: Size?) {
        _height.value = height
        checkForPendingChanges()
    }

    override fun createNewEntity(): SomeObject {
        return ObjectFactory.createSomeObject()
    }

    override fun updateUiStates(entity: SomeObject) {
        super.updateUiStates(entity)
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _docNumber.value = entity.docNumber
        _typeOfObject.value = entity.typeOfObject
        _numberOfPieces.value = entity.numberOfPieces
        _specialFeatures.value = entity.specialFeatures
        _comment.value = entity.comment
        _colors.value = entity.color ?: listOf()
        _materials.value = entity.material ?: listOf()
        _weight.value = entity.weight
        _volume.value = entity.volume
        _length.value = entity.length
        _width.value = entity.width
        _height.value = entity.height
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.evidenceData = getEvidenceDataFromCurrentState()
            it.typeOfObject = typeOfObject.value
            it.numberOfPieces = numberOfPieces.value
            it.specialFeatures = specialFeatures.value
            it.comment = comment.value
            it.color = colors.value
            it.material = materials.value
            it.weight = weight.value
            it.volume = volume.value
            it.length = length.value
            it.width = width.value
            it.height = height.value
            if (it.designation.isNullOrEmpty()) {
                it.designation =
                    it.typeOfObject?.toString()
                        ?: EntityTypeStrings.someObject(uiStateHandler.language.value)
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): SomeObject {
        return SomeObject().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.evidenceData = getEvidenceDataFromCurrentState()
            it.typeOfObject = typeOfObject.value
            it.specialFeatures = specialFeatures.value
            it.numberOfPieces = numberOfPieces.value
            it.comment = comment.value
            it.color = colors.value
            it.material = materials.value
            it.weight = weight.value
            it.volume = volume.value
            it.length = length.value
            it.width = width.value
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