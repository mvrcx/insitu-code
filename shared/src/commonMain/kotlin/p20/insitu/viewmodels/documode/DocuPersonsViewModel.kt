package p20.insitu.viewmodels.documode

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import org.koin.core.component.KoinComponent
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Person
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler

class DocuPersonsViewModel(
    private val log: Logger,
    private val uiStateHandler: UiStateHandler,
    private val sessionHandler: SessionHandler,
    private val docuDataRepo: DocuDataRepo,
    private val coroutineScope: CoroutineScope
) : KoinComponent {

    /**
     * StateFlow that provides the most recent data for the persons associated with the
     * current investigation.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    val persons: StateFlow<List<Person>> =
        sessionHandler.docuHandler.investigation.flatMapLatest { inv ->
            inv?.id?.let { invId ->
                docuDataRepo.observeRelatedPersons(invId)
            } ?: flow { emit(listOf()) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

}