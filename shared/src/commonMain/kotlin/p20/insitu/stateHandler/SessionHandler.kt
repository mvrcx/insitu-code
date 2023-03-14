package p20.insitu.stateHandler

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import p20.insitu.com.authApi.AuthService
import p20.insitu.com.authApi.TokenInfo
import p20.insitu.com.authApi.UserInfo
import p20.insitu.db.app.AppDataRepo
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.model.util.randomUUID

@OptIn(ExperimentalSerializationApi::class)
class SessionHandler(
    private val log: Logger,
    private val coroutineScope: CoroutineScope,
    private val authService: AuthService,
    private val appDataRepo: AppDataRepo,
    val docuHandler: DocuHandler
) : KoinComponent {

    private val _userInfo = MutableStateFlow<UserInfo?>(null)
    val userInfo: StateFlow<UserInfo?> = _userInfo

    private val _latestToken = MutableStateFlow<TokenInfo?>(null)
    val latestToken: StateFlow<TokenInfo?> = _latestToken

    /** AUTHENTICATION & TOKENS **/

    // ---------------------------------------------------------------------------------------------
    // DEV USER LOGIN
    // ---------------------------------------------------------------------------------------------
    fun devMaxHeadroomLogin(username: String, password: String): Boolean {
        if (username == "headroom" && password == "insitu") {
            _userInfo.value = UserInfo(
                id = "283cde9a-464c-11ed-b878-0242ac120002",
                username = username,
                firstName = "Max",
                lastName = "Headroom"
            )
            return true
        }
        return false
    }

    fun randomDevUserLogin(username: String, password: String): Boolean {
        if (username.isNotBlank() && password == "insitu") {
            _userInfo.value = UserInfo(
                id = randomUUID(),
                username = username,
                firstName = username,
                lastName = "Dev-User"
            )
            return true
        }
        return false
    }
    // ---------------------------------------------------------------------------------------------

    // do not use appCoroutineScope here, authentication should be bound to user action
    // --> should be canceled if user closes app while logging in
    suspend fun authenticate(username: String, password: String): Boolean {
        val tokenInfo = authService.authenticate(username, password)
        return if (tokenInfo?.accessToken != null) {
            log.d("authentication successful")
            addToken(tokenInfo)
            true
        } else {
            log.d("authentication unsuccessful")
            false
        }
    }

    suspend fun verifyToken(accessToken: String): UserInfo? {
        val result = authService.verifyToken(accessToken)
        log.d("Verify token result: $result")
        return result
    }

    suspend fun refreshToken(refreshToken: String): Boolean {
        val tokenInfo = authService.refreshToken(refreshToken)
        return if (tokenInfo?.accessToken != null) {
            log.d("token refresh successful")
            addToken(tokenInfo)
            true
        } else {
            log.d("token refresh unsuccessful")
            false
        }
    }

    private suspend fun addToken(tokenInfo: TokenInfo) {
        _latestToken.value = tokenInfo
        loadUserInfo(tokenInfo.accessToken)
        appDataRepo.addToken(tokenInfo)
        autoRefreshTokenTimer(tokenInfo.expiresIn)
    }

    private suspend fun loadUserInfo(accessToken: String) {
        authService.verifyToken(accessToken)?.let {
            _userInfo.value = it
            appDataRepo.addUser(it)
        }
    }

    suspend fun getLatestToken(): TokenInfo? {
        return latestToken.value ?: appDataRepo.getLatestToken()
    }

    suspend fun getLatestAccessToken(): String? {
        return getLatestToken()?.accessToken ?: appDataRepo.getLatestToken()?.accessToken
    }

    suspend fun getLatestRefreshToken(): String? {
        return getLatestToken()?.refreshToken ?: appDataRepo.getLatestToken()?.refreshToken
    }

    private fun autoRefreshTokenTimer(timeToRefresh: Long) {
        val offset = 90L
        coroutineScope.launch {
            val timer: Long = when {
                timeToRefresh - offset < 0 -> timeToRefresh
                else -> timeToRefresh - offset
            }
            log.d("Started auto refresh token timer (Seconds to next refresh attempt: $timer)")
            delay(timer * 1000L)
            log.d("Start refreshing token")
            getLatestRefreshToken()?.let {
                refreshToken(it)
            } ?: run {
                log.e("Auto refresh token not possible -> No refresh token found!")
            }
        }
    }
}