package p20.insitu.viewmodels.documode

import co.touchlab.kermit.Logger
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.*
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

@OptIn(ExperimentalCoroutinesApi::class)
class DocuListViewModel(
    private val log: Logger,
    private val sessionHandler: SessionHandler,
    private val uiStateHandler: UiStateHandler,
    private val docuDataRepo: DocuDataRepo,
    private val coroutineScope: CoroutineScope
) : KoinComponent {

    /**
     * StateFlow that provides the most recent data for the crime scenes associated with the
     * current investigation.
     */
    val crimeScenes: StateFlow<List<CrimeScene>> =
        sessionHandler.docuHandler.investigation.flatMapLatest { inv ->
            inv?.id?.let { invId ->
                docuDataRepo.observeRelatedCrimeScenes(invId)
            } ?: flow { emit(listOf()) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    /**
     * StateFlow that provides the most recent data for the addresses related to the crime scenes
     * associated with the current investigation.
     */
    val crimeSceneAddresses: StateFlow<Map<String, Address?>> =
        crimeScenes.flatMapLatest { crimeScenes ->
            flow {
                emit(crimeScenes.associate { it.id to docuDataRepo.getRelatedAddress(it.id) })
            }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = mapOf()
        )

    /**
     * Temporary list of child objects of the current documentation object (see [DocuHandler])
     * provided as a MutableStateFlow.
     * The users are allowed to manually change the order of the child objects retrieved from the
     * repository (see [docItems]). Changes are applied to the temporary list until they are saved.
     */
    private val _editDocItems = MutableStateFlow<List<DocNumberObject>?>(null)

    /**
     * The child objects of the current documentation object (see [DocuHandler]) provided as a
     * StateFlow.
     * The list of child objects is observed by the repository. The value of the StateFlow changes
     * either when the documentation object changes, when a child object is added or removed, or
     * when the child objects themselves change.
     * The child objects are ordered by their [DocNumber].
     * The users are allowed to manually change the order of the child objects.
     * Changes are performed on a temporary list (see [_editDocItems]).
     * As long as the temporary list is not null, the StateFlow will return the temporary list
     * instead of the list retrieved from the repository.
     */
    val docItems: StateFlow<List<DocNumberObject>> =
        sessionHandler.docuHandler.selectedListObject.flatMapLatest { docuObject ->
            docuObject?.id?.let { docuObjectId ->
                docuDataRepo.observeDocNumberChildren(docuObjectId)
            } ?: flow { emit(listOf()) }
        }.combine(_editDocItems) { dbList, editList ->
            (editList ?: dbList).sortedBy { docNumberItem ->
                docNumberItem.docNumber?.docNumberString?.filter { docNbrStr ->
                    docNbrStr.isDigit()
                }?.toInt()
            }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

    private val editedItemIds: MutableSet<String> = mutableSetOf()

    /**
     * Start editing the list of child objects. Initializes the value of the [_editDocItems] list
     * with the current [docItems] list.
     */
    fun startEditing() {
        _editDocItems.value = docItems.value
    }

    /**
     * Stop editing list of child objects. Sets the value of the [_editDocItems] list to null.
     */
    @OptIn(ExperimentalSerializationApi::class)
    fun stopEditing() {
        editedItemIds.forEach { itemId ->
            sessionHandler.userInfo.value?.id?.let { userId ->
                docuDataRepo.update(
                    docItems.value.first { it.id == itemId } as BaseEntity,
                    userId,
                    true
                )
            }
        }
        coroutineScope.launch {
            delay(1000L) // Give updates some time, to avoid weird UI updates
            _editDocItems.value = null
            editedItemIds.clear()
        }
    }

    /**
     * Swaps two items of the [_editDocItems] list and re-assigns their [DocNumber]s.
     *
     * @param from Current list index of the item being swapped.
     * @param to The new list index of the item being swapped.
     */
    fun swapDocItems(from: Int, to: Int) {
        _editDocItems.value?.let { editList ->
            val fromItem = editList[from]
            val fromDocNumber = editList[from].docNumber
            val toItem = editList[to]
            val toDocNumber = editList[to].docNumber
            val newList = editList.toMutableList()
            newList[from] = toItem
            newList[from].docNumber = fromDocNumber
            newList[to] = fromItem
            newList[to].docNumber = toDocNumber
            editedItemIds.add(fromItem.id)
            editedItemIds.add(toItem.id)
            _editDocItems.value = newList
        }
    }

}