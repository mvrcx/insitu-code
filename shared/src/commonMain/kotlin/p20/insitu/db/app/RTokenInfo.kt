package p20.insitu.db.app

import io.realm.kotlin.types.RealmObject
import kotlinx.datetime.Clock
import p20.insitu.com.authApi.TokenInfo

class RTokenInfo : RealmObject {

    //private val clock: Clock by inject()

    var timestamp: Long = Clock.System.now().epochSeconds
    var accessToken: String = ""
    var expiresIn: Long = 0
    var refreshToken: String? = null
    var refreshExpiresIn: Long? = null
    var scope: String = ""
    var tokenType: String = ""

    fun getTokenInfo(): TokenInfo {
        return TokenInfo(
            accessToken,
            expiresIn,
            refreshToken,
            refreshExpiresIn,
            scope,
            tokenType
        )
    }
}