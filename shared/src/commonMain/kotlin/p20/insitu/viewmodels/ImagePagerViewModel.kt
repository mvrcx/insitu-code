package p20.insitu.viewmodels

import androidx.compose.ui.graphics.ImageBitmap
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import org.koin.core.component.KoinComponent
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.DocumentationObject
import p20.insitu.model.entities.Image
import p20.insitu.resources.FileHandler
import p20.insitu.stateHandler.UiStateHandler

@Suppress("UNCHECKED_CAST")
class ImagePagerViewModel(
    private val log: Logger,
    private val uiStateHandler: UiStateHandler,
    private val fileHandler: FileHandler,
    private val docuDataRepo: DocuDataRepo,
    private val coroutineScope: CoroutineScope
) : KoinComponent {

    private val _entity: MutableStateFlow<DocumentationObject?> = MutableStateFlow(null)

    suspend fun init(entityId: String?) {
        entityId?.let { id ->
            docuDataRepo.getEntityById<DocumentationObject>(id)?.let {
                _entity.value = it
            }
        }
    }

    // Image annotations
    @OptIn(ExperimentalCoroutinesApi::class)
    val images: StateFlow<List<Image>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryImageAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    @OptIn(ExperimentalCoroutinesApi::class)
    val imageBitmaps: StateFlow<Map<String, ImageBitmap>> =
        images.mapLatest { list ->
            list.associate { img -> img.id to fileHandler.getImageBitmap(img) }
                .filterValues { it != null } as Map<String, ImageBitmap>
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = mapOf()
        )

    // Image annotations of hierarchical children
    @OptIn(ExperimentalCoroutinesApi::class)
    val imagesNested: StateFlow<List<Image>> =
        _entity.flatMapLatest { entity ->
            entity?.let { docuDataRepo.liveQueryNestedImageAnnotations(it.id) } ?: emptyFlow()
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    @OptIn(ExperimentalCoroutinesApi::class)
    val imageBitmapsNested: StateFlow<Map<String, ImageBitmap>> =
        imagesNested.mapLatest { list ->
            list.associate { img -> img.id to fileHandler.getImageBitmap(img) }
                .filterValues { it != null } as Map<String, ImageBitmap>
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = mapOf()
        )

}