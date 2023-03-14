package p20.insitu.viewmodels.entities

import androidx.compose.ui.graphics.ImageBitmap
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.*
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.resources.FileHandler
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.MediaViewModel

@OptIn(ExperimentalCoroutinesApi::class)
@Suppress("UNCHECKED_CAST")
abstract class EntityMediaViewModel<T : DocumentationObject>(
    protected val log: Logger,
    protected val sessionHandler: SessionHandler,
    protected val uiStateHandler: UiStateHandler,
    protected val fileHandler: FileHandler,
    protected val docuDataRepo: DocuDataRepo,
    protected val coroutineScope: CoroutineScope
) : KoinComponent, MediaViewModel {

    protected val _entity: MutableStateFlow<T?> = MutableStateFlow(null)

    // Note annotations
    @OptIn(ExperimentalSerializationApi::class, ExperimentalCoroutinesApi::class)
    private val userNoteIds: StateFlow<List<String>> =
        sessionHandler.docuHandler.investigation.flatMapLatest { investigation ->
            sessionHandler.userInfo.flatMapLatest { userInfo ->
                investigation?.id?.let { investigationId ->
                    userInfo?.id?.let { userId ->
                        docuDataRepo.liveQueryUserAnnotationIds(
                            investigationId,
                            userId,
                            type = EntityType.NOTE
                        )
                    }
                } ?: emptyFlow()
            }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    override val notes: StateFlow<List<Note>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryNoteAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    // Note annotations of hierarchical children
    override val notesNested: StateFlow<List<Note>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryNestedNoteAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    override val notesFiltered: StateFlow<List<Note>> = combine(
        listOf(
            uiStateHandler.showNestedAnnotations,
            uiStateHandler.showUserAnnotationsOnly
        )
    ) {
        var filteredNotes = notes.value.toMutableList()
        when {
            uiStateHandler.showNestedAnnotations.value -> filteredNotes += notesNested.value
            uiStateHandler.showUserAnnotationsOnly.value -> filteredNotes =
                filteredNotes.filter { userNoteIds.value.contains(it.id) }.toMutableList()
            else -> {}
        }
        filteredNotes
    }.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Eagerly,
        initialValue = listOf()
    )

    // Image annotations
    final override val images: StateFlow<List<Image>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryImageAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    override val imageBitmaps: StateFlow<Map<String, ImageBitmap>> =
        images.mapLatest { list ->
            list.associate { img -> img.id to fileHandler.getImageBitmap(img) }
                .filterValues { it != null } as Map<String, ImageBitmap>
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = mapOf()
        )

    // Image annotations of hierarchical children
    final override val imagesNested: StateFlow<List<Image>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryNestedImageAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    override val imageBitmapsNested: StateFlow<Map<String, ImageBitmap>> =
        imagesNested.mapLatest { list ->
            list.associate { img -> img.id to fileHandler.getImageBitmap(img) }
                .filterValues { it != null } as Map<String, ImageBitmap>
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = mapOf()
        )

    // Audio annotations
    override val audioRecordings: StateFlow<List<Audio>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryAudioAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    // Audio annotations of hierarchical children
    override val audioRecordingsNested: StateFlow<List<Audio>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryNestedAudioAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    // Video annotations
    override  val videos: StateFlow<List<Video>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryVideoAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    // Video annotations of hierarchical children
    override val videosNested: StateFlow<List<Video>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryNestedVideoAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

}