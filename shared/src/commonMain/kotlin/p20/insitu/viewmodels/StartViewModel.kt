package p20.insitu.viewmodels

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.entities.CrimeScene
import p20.insitu.model.entities.DocumentationObject
import p20.insitu.model.entities.Investigation
import p20.insitu.stateHandler.SessionHandler

@OptIn(ExperimentalCoroutinesApi::class)
class StartViewModel(
    private val log: Logger,
    private val sessionHandler: SessionHandler,
    private val docuDataRepo: DocuDataRepo,
    private val coroutineScope: CoroutineScope
) : KoinComponent {

    @OptIn(ExperimentalSerializationApi::class)
    val lastActiveInvestigation: StateFlow<Investigation?> =
        sessionHandler.userInfo.flatMapLatest { userInfo ->
            userInfo?.id?.let { userId ->
                docuDataRepo.observeLastActiveInvestigation(userId)
            } ?: flow { emit(null) }
        }.stateIn(
        scope = coroutineScope,
        started = SharingStarted.Eagerly,
        initialValue = null
    )

    @OptIn(ExperimentalSerializationApi::class)
    val lastActiveCrimeScene: StateFlow<CrimeScene?> =
        sessionHandler.userInfo.flatMapLatest { userInfo ->
            userInfo?.id?.let { userId ->
                docuDataRepo.observeLastActiveCrimeScene(userId)
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    @OptIn(ExperimentalSerializationApi::class)
    val lastActiveDocuObject: StateFlow<DocumentationObject?> =
        sessionHandler.userInfo.flatMapLatest { userInfo ->
            userInfo?.id?.let { userId ->
                docuDataRepo.observeLastActiveDocuObject(userId)
            } ?: flow { emit(null) }
        }.stateIn(
            scope = coroutineScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )


}