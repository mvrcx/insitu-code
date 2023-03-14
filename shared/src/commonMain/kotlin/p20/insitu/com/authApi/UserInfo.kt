package p20.insitu.com.authApi

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import p20.insitu.db.app.RUserInfo

@ExperimentalSerializationApi
@Serializable
data class UserInfo(
    @JsonNames("sub") val id: String,
    @JsonNames("preferred_username") val username: String,
    @JsonNames("given_name") val firstName: String,
    @JsonNames("family_name") val lastName: String,
    @SerialName("email") val email: String = "",
    @SerialName("agency") val agency: String = ""
){
    fun getRealmObject(): RUserInfo {
        return RUserInfo().also {
            it.id = id
            it.username = username
            it.firstName = firstName
            it.lastName = lastName
            it.email = email
            it.agency = agency
        }
    }
}
