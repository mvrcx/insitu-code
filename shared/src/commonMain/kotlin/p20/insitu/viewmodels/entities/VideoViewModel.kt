package p20.insitu.viewmodels.entities

import android.net.Uri
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Video
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.resources.FileHandler
import p20.insitu.resources.FileType
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

@OptIn(ExperimentalCoroutinesApi::class)
class VideoViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Video>(
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
                fileHandler.getVideoFile(it)?.let { file ->
                    emit(Uri.fromFile(file))
                }
            }?: emit(null)
        }
    }.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Eagerly,
        initialValue = null
    )

    override fun createNewEntity(): Video {
        return ObjectFactory.createVideoAnnotation(FileType.VIDEO.extension)
    }

    override fun updateUiStates(entity: Video) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { it ->
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            if (it.designation.isNullOrEmpty()) {
                it.designation =
                    EntityTypeStrings.typeString(EntityType.VIDEO, uiStateHandler.language.value)
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): Video {
        return Video().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
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
                "poses"
            )
        )
    }

}