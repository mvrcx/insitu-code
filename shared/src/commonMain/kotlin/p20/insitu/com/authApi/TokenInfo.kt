package p20.insitu.com.authApi

import kotlinx.serialization.*
import p20.insitu.db.app.RTokenInfo

@Serializable
data class TokenInfo(
    @SerialName("access_token") val accessToken: String,
    @SerialName("expires_in") val expiresIn: Long,
    @SerialName("refresh_token") val refreshToken: String?,
    @SerialName("refresh_expires_in") val refreshExpiresIn: Long?,
    @SerialName("scope") val scope: String,
    @SerialName("token_type") val tokenType: String
){
    fun getRealmObject(): RTokenInfo {
        return RTokenInfo().also {
            it.accessToken = accessToken
            it.expiresIn = expiresIn
            it.refreshToken = refreshToken
            it.refreshExpiresIn = refreshExpiresIn
            it.scope = scope
            it.tokenType = tokenType
        }
    }
}