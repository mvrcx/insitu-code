package p20.insitu.db.app

import io.realm.kotlin.types.RealmObject
import kotlinx.serialization.ExperimentalSerializationApi
import p20.insitu.com.authApi.UserInfo

class RUserInfo : RealmObject {
    var id: String = ""
    var username: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""
    var agency: String = ""

    @OptIn(ExperimentalSerializationApi::class)
    fun getUserInfo(): UserInfo {
        return UserInfo(
            id,
            username,
            firstName,
            lastName,
            email,
            agency
        )
    }
}
