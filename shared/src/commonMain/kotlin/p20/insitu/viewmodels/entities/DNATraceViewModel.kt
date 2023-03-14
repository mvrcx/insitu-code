package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.components.*
import p20.insitu.model.entities.DNATrace
import p20.insitu.model.entities.Investigation
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.CatalogInfo
import p20.insitu.model.util.ObjectFactory
import p20.insitu.model.xpolizei.schema.KatalogCode120
import p20.insitu.model.xpolizei.schema.KatalogCode327
import p20.insitu.resources.FileHandler
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.util.getCurrentZonedDateTime

class DNATraceViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EvidenceDataViewModel<DNATrace>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {

    override fun createNewEntity(): DNATrace {
        return ObjectFactory.createDNATrace(securingTimestamp = getCurrentZonedDateTime())
    }

    override fun updateUiStates(entity: DNATrace) {
        super.updateUiStates(entity)
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _docNumber.value = entity.docNumber
        _numberOfPieces.value = entity.numberOfPieces
        _position.value = entity.position
        _comment.value = entity.comment
        _colors.value = entity.color ?: listOf()
        _materials.value = entity.material ?: listOf()
        _weight.value = entity.weight
        _volume.value = entity.volume
        _length.value = entity.length
        _width.value = entity.width
        _height.value = entity.height
        _diameter.value = entity.diameter
        _quality.value = entity.quality
    }

    override fun updateEntityFromUiStates() {
        entity.value?.also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.evidenceData = getEvidenceDataFromCurrentState()
            it.typeOfPhysicalTrace = null
            it.numberOfPieces = numberOfPieces.value
            it.position = position.value
            it.comment = comment.value
            it.color = colors.value
            it.material = materials.value
            it.weight = weight.value
            it.volume = volume.value
            it.length = length.value
            it.width = width.value
            it.height = height.value
            it.diameter = diameter.value
            it.quality = quality.value
            if (it.designation.isNullOrEmpty()) {
                it.designation = EntityTypeStrings.typeString(
                    EntityType.DNA_TRACE,
                    uiStateHandler.language.value
                )
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): DNATrace {
        return DNATrace().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.docNumber = docNumber.value
            it.evidenceData = getEvidenceDataFromCurrentState()
            it.typeOfPhysicalTrace = null
            it.numberOfPieces = numberOfPieces.value
            it.position = position.value
            it.comment = comment.value
            it.color = colors.value
            it.material = materials.value
            it.weight = weight.value
            it.volume = volume.value
            it.length = length.value
            it.width = width.value
            it.height = height.value
            it.diameter = diameter.value
            it.quality = quality.value
        }
    }

    // Documentation number
    private val _docNumber = MutableStateFlow<DocNumber?>(null)
    val docNumber: StateFlow<DocNumber?> = _docNumber
    fun setDocNumber(docNumber: DocNumber?) {
        _docNumber.value = docNumber
        checkForPendingChanges()
    }

    // Number of pieces
    private val _numberOfPieces = MutableStateFlow<Int?>(null)
    val numberOfPieces: StateFlow<Int?> = _numberOfPieces
    fun setNumberOfPieces(numberOfPieces: Int?) {
        _numberOfPieces.value = numberOfPieces
        checkForPendingChanges()
    }

    // Position description
    private val _position = MutableStateFlow<String?>(null)
    val position: StateFlow<String?> = _position
    fun setPosition(position: String?) {
        _position.value = position
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

    // Diameter
    private val _diameter = MutableStateFlow<Size?>(null)
    val diameter: StateFlow<Size?> = _diameter
    fun setDiameter(diameter: Size?) {
        _diameter.value = diameter
        checkForPendingChanges()
    }

    // Quality
    private val _quality = MutableStateFlow<CatalogCodeFixed<KatalogCode327>?>(null)
    val quality: StateFlow<CatalogCodeFixed<KatalogCode327>?> = _quality
    fun setQuality(quality: CatalogCodeFixed<KatalogCode327>?) {
        _quality.value = quality
        checkForPendingChanges()
    }

    override fun checkForPendingChanges(ignoreAttributes: List<String>): Boolean {
        return super.checkForPendingChanges(
            listOf(
                "id",
                "deleted",
                "spatialRepresentation",
                "classification"
            )
        )
    }
}