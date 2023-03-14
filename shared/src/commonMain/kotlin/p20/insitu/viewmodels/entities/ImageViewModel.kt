package p20.insitu.viewmodels.entities

import androidx.compose.ui.graphics.ImageBitmap
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Image
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.resources.FileHandler
import p20.insitu.resources.FileType
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

@OptIn(ExperimentalCoroutinesApi::class)
class ImageViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Image>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {

    val imageBitmap: StateFlow<ImageBitmap?> = _entity.flatMapLatest { entity ->
        flow {
            entity?.let {
                emit(fileHandler.getImageBitmap(it))
            } ?: emit(null)
        }
    }.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Eagerly,
        initialValue = null
    )

    override fun createNewEntity(): Image {
        return ObjectFactory.createImageAnnotation(FileType.PHOTO.extension)
    }

    override fun updateUiStates(entity: Image) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { it ->
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            if (it.designation.isNullOrEmpty()) {
                it.designation =
                    EntityTypeStrings.typeString(EntityType.IMAGE, uiStateHandler.language.value)
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): Image {
        return Image().also {
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
                "planPose",
                "geoPose",
                "exifData",
                "sketch"
            )
        )
    }

}