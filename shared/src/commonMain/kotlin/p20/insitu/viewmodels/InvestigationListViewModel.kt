package p20.insitu.viewmodels

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.Investigation
import p20.insitu.stateHandler.SessionHandler

class InvestigationListViewModel(
    log: Logger,
    sessionHandler: SessionHandler,
    docuDataRepo: DocuDataRepo,
    coroutineScope: CoroutineScope
) : KoinComponent {

    @OptIn(ExperimentalCoroutinesApi::class, ExperimentalSerializationApi::class)
    val investigations: StateFlow<List<Investigation>> =
        sessionHandler.userInfo.flatMapLatest { userInfo ->
            userInfo?.id?.let { userId ->
                docuDataRepo.observeInvestigations(userId)
            } ?: flow { emit(listOf()) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf()
        )

}