package p20.insitu.stateHandler

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.*

@OptIn(ExperimentalCoroutinesApi::class)
class DocuHandler(
    private val log: Logger,
    private val docuDataRepo: DocuDataRepo,
    private val coroutineScope: CoroutineScope
) : KoinComponent {

    private val _investigation = MutableStateFlow<Investigation?>(null)
    val investigation: StateFlow<Investigation?> =
        _investigation.flatMapLatest { investigation ->
            investigation?.id?.let { investigationId ->
                docuDataRepo.observeEntity<Investigation>(investigationId)
                    .onStart { emit(investigation) }
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    private val _crimeScene = MutableStateFlow<CrimeScene?>(null)
    val crimeScene: StateFlow<CrimeScene?> =
        _crimeScene.flatMapLatest { crimeScene ->
            crimeScene?.id?.let { crimeSceneId ->
                docuDataRepo.observeEntity<CrimeScene>(crimeSceneId).onStart { emit(crimeScene) }
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    val crimeSceneAddress: StateFlow<Address?> =
        _crimeScene.flatMapLatest { crimeScene ->
            crimeScene?.id?.let { crimeSceneId ->
                docuDataRepo.observeRelatedAddress(crimeSceneId)
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    private val _docuObject = MutableStateFlow<DocumentationObject?>(null)
    val docuObject: StateFlow<DocumentationObject?> =
        _docuObject.flatMapLatest { docuObject ->
            docuObject?.id?.let { docuObjectId ->
                docuDataRepo.observeEntity<DocumentationObject>(docuObjectId)
                    .onStart { emit(docuObject) }
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    private val _docNumberParent = MutableStateFlow<DocNumberObject?>(null)
    val docNumberParent: StateFlow<DocNumberObject?> =
        _docuObject.flatMapLatest { obj ->
            obj?.id?.let { objId ->
                docuDataRepo.observeDocNumberParent(objId)
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    /**
     * StateFlow that provides the most recent data for the currently focused object of the
     * documentation list.
     */
    private val _selectedListObject = MutableStateFlow<DocNumberObject?>(null)
    val selectedListObject: StateFlow<DocNumberObject?> =
        _selectedListObject.flatMapLatest { selectedListObject ->
            selectedListObject?.id?.let { selectedListObjectId ->
                docuDataRepo.observeEntity<DocNumberObject>(selectedListObjectId)
                    .onStart { emit(selectedListObject) }
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    @OptIn(ExperimentalSerializationApi::class)
    fun setSelectedListObject(
        selectedListObject: DocNumberObject?,
        userId: String?
    ) {
        setDocuHandler(
            docuObject = selectedListObject ?: investigation.value,
            crimeScene = if(selectedListObject is CrimeScene) selectedListObject else crimeScene.value,
            investigation = investigation.value,
            selectedDetailsObject = selectedListObject,
            selectedListObject = selectedListObject,
            userId = userId
        )
    }

    /**
     * StateFlow that provides the most recent data for the currently focused object of the
     * documentation details screen.
     */
    private val _selectedDetailsObject = MutableStateFlow<DocumentationObject?>(null)
    val selectedDetailsObject: StateFlow<DocumentationObject?> =
        _selectedDetailsObject.flatMapLatest { selectedDetailsObject ->
            selectedDetailsObject?.id?.let { selectedDetailsObjectId ->
                docuDataRepo.observeEntity<DocumentationObject>(selectedDetailsObjectId)
                    .onStart { emit(selectedDetailsObject) }
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    @OptIn(ExperimentalSerializationApi::class)
    fun setSelectedDetailsObject(
        selectedDetailsObject: DocumentationObject?,
        userId: String?
    ) {
        setDocuHandler(
            docuObject = selectedDetailsObject,
            crimeScene = crimeScene.value,
            investigation = investigation.value,
            selectedDetailsObject = selectedDetailsObject,
            selectedListObject = selectedListObject.value,
            userId = userId
        )
    }

    //region Handling the documentation objects
    fun setDocuHandler(
        docuObject: DocumentationObject?,
        crimeScene: CrimeScene?,
        investigation: Investigation?,
        selectedDetailsObject: DocumentationObject?,
        selectedListObject: DocNumberObject?,
        userId: String?
    ) {
        _investigation.value = investigation
        _crimeScene.value = crimeScene
        _docuObject.value = docuObject
        _selectedDetailsObject.value = selectedDetailsObject
        _selectedListObject.value = selectedListObject
        userId?.let {
            docuDataRepo.saveUserSettings(
                it,
                _investigation.value?.id,
                _crimeScene.value?.id,
                _docuObject.value?.id
            )
        }
        log.d(
            "setDocuHandler -> Investigation: ${this.investigation.value?.id} " +
                    "| CrimeScene: ${this.crimeScene.value?.id} " +
                    "| DocuObject: ${this.docuObject.value?.id}" +
                    "| SelectedDetailsObject: ${this.selectedDetailsObject.value?.id}" +
                    "| SelectedListObject: ${this.selectedListObject.value?.id}"
        )
    }

    fun setDocuObject(
        docuObject: DocumentationObject?,
        userId: String?
    ) {
        setDocuHandler(
            docuObject = docuObject,
            crimeScene = if(docuObject is CrimeScene) docuObject else crimeScene.value,
            investigation = if(docuObject is Investigation) docuObject else investigation.value,
            selectedDetailsObject = selectedDetailsObject.value,
            selectedListObject = selectedListObject.value,
            userId = userId
        )
    }

    fun setInvestigation(
        investigation: Investigation,
        userId: String?
    ) {
        setDocuHandler(
            docuObject = investigation,
            crimeScene = null,
            investigation = investigation,
            selectedDetailsObject = null,
            selectedListObject = null,
            userId = userId
        )
    }

    fun clear() {
        _investigation.value = null
        _crimeScene.value = null
        _docuObject.value = null
        _docNumberParent.value = null
        _selectedListObject.value = null
        _selectedDetailsObject.value = null
    }
    //endregion

}