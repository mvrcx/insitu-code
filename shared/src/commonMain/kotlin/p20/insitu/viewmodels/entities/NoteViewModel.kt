package p20.insitu.viewmodels.entities

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import p20.insitu.db.catalogs.CatalogRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Note
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.util.ObjectFactory
import p20.insitu.resources.FileHandler
import p20.insitu.resources.strings.EntityTypeStrings
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

class NoteViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    uiStateHandler: UiStateHandler,
    fileHandler: FileHandler,
    docuDataRepo: DocuDataRepo,
    catalogRepo: CatalogRepo,
    coroutineScope: CoroutineScope
) : EntityViewModel<Note>(
    log = log,
    sessionHandler = sessionHandler,
    uiStateHandler = uiStateHandler,
    fileHandler = fileHandler,
    docuDataRepo = docuDataRepo,
    catalogRepo = catalogRepo,
    coroutineScope = coroutineScope
) {
    // Keywords
    private val _keywords = MutableStateFlow<List<String>>(listOf())
    val keywords: StateFlow<List<String>> = _keywords
    fun setKeywords(keywords: List<String>) {
        _keywords.value = keywords
        checkForPendingChanges()
    }

    // The note text
    private val _text = MutableStateFlow<String?>(null)
    val text: StateFlow<String?> = _text
    fun setText(text: String?) {
        _text.value = text
        checkForPendingChanges()
    }

    override fun createNewEntity(): Note {
        return ObjectFactory.createNoteAnnotation()
    }

    override fun updateUiStates(entity: Note) {
        _designation.value = entity.designation
        _thumbnailId.value = entity.thumbnailId
        _text.value = entity.text
        _keywords.value = entity.keywords ?: listOf()
    }

    override fun updateEntityFromUiStates() {
        entity.value?.let { it ->
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.text = text.value
            it.keywords = keywords.value
            if (it.designation.isNullOrEmpty()) {
                it.designation =
                    EntityTypeStrings.typeString(EntityType.NOTE, uiStateHandler.language.value)
            }
            setEntity(it)
        }
    }

    override fun getEditedEntityState(): Note {
        return Note().also {
            it.designation = designation.value
            it.thumbnailId = thumbnailId.value
            it.text = text.value
            it.keywords = keywords.value
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
                "creationDate"
            )
        )
    }

}