package p20.insitu.viewmodels.entities

import android.net.Uri
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Audio
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.resources.FileHandler
import p20.insitu.resources.FileType
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

@OptIn(ExperimentalCoroutinesApi::class)
class AudioViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Audio>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {

    val uri: StateFlow<Uri?> = _entity.flatMapLatest { entity->
        flow {
            entity?.filename?.let {
                fileHandler.getAudioFile(it)?.let { file ->
                    emit(Uri.fromFile(file))
                }
            }?: emit(null)
        }
    }.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Eagerly,
        initialValue = null
    )

    private val _transcription = MutableStateFlow<String?>(null)
    val transcription: StateFlow<String?> = _transcription
    fun setTranscription(transcription: String?) {
        _transcription.value = transcription
        checkForPendingChanges()
    }

    override fun createNewEntity(): Audio {
        return ObjectFactory.createAudioAnnotation(FileType.AUDIO.extension)
    }

    override fun updateUiStates(entity: Audio) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _transcription.value = entity.transcription
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { it ->
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.transcription = transcription.value
            if (it.designation.isNullOrEmpty()) {
                it.designation =
                    EntityTypeStrings.typeString(EntityType.AUDIO, uiStateHandler.language.value)
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): Audio {
        return Audio().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.transcription = transcription.value
        }
    }

    override fun checkForPendingChanges(ignoreAttributes: List<String>): Boolean {
        return super.checkForPendingChanges(
            listOf(
                "id",
                "deleted",
                "filename",
                "deviceId",
                "annotationType",
                "keywords",
                "language",
                "creationDate",
                "recordingLength",
                "transcription"
            )
        )
    }
}