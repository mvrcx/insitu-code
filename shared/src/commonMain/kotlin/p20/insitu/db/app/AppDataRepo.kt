package p20.insitu.db.app

import co.touchlab.kermit.Logger
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.core.component.KoinComponent
import p20.insitu.com.authApi.TokenInfo
import p20.insitu.com.authApi.UserInfo

class AppDataRepo(
    private val log: Logger,
    private val coroutineScope: CoroutineScope
) : KoinComponent {

    private val config = RealmConfiguration.Builder(schema =
        setOf(
            RTokenInfo::class,
            RUserInfo::class
        )
    ).build()//.encryptionKey(getNewRealmKey()).build()

    private val appDataRealm = Realm.open(config)

    suspend fun deleteAppData() {
        val tokens: RealmResults<RTokenInfo> = appDataRealm.query(RTokenInfo::class).find()
        val users: RealmResults<RUserInfo> = appDataRealm.query(RUserInfo::class).find()
        appDataRealm.write {
            tokens.forEach { tokenInfo ->
                findLatest(tokenInfo)?.also { delete(it) }
            }
            users.forEach { userInfo ->
                findLatest(userInfo)?.also { delete(it) }
            }
        }
    }

    suspend fun addToken(token: TokenInfo) {
        appDataRealm.write {
            token.getRealmObject().also {
                copyToRealm(it)
                log.d("added token to DB (token timestamp: ${it.timestamp})")
                coroutineScope.launch {
                    removeOlderTokens(it.timestamp)
                }
            }
        }
    }

    private suspend fun removeOlderTokens(refTimestamp: Long){
        appDataRealm.write {
            val oldTokens: RealmResults<RTokenInfo> =
                appDataRealm.query<RTokenInfo>("timestamp < $0", refTimestamp).find()
            oldTokens.forEach { oldToken ->
                findLatest(oldToken)?.also { delete(it) }
                log.d("removed token from DB (token timestamp: ${oldToken.timestamp})")
            }
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun addUser(user: UserInfo) {
        appDataRealm.write {
            //coroutineScope.launch {
                val existingUser: RUserInfo? =
                    appDataRealm.query<RUserInfo>("id == $0", user.id).find().firstOrNull()
                if (existingUser != null) {
                    findLatest(existingUser)?.let {
                        it.username = user.username
                        it.firstName = user.firstName
                        it.lastName = user.lastName
                        it.email = user.email
                        it.agency = user.agency
                    }
                } else {
                    copyToRealm(user.getRealmObject())
                }
            //}
        }
    }

    suspend fun getLatestToken(): TokenInfo? =
        withContext(coroutineScope.coroutineContext) {
            return@withContext appDataRealm.query<RTokenInfo>().find().maxByOrNull { it.timestamp }
                ?.getTokenInfo()
        }

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getUserInfo(userId: String): UserInfo? =
        withContext(coroutineScope.coroutineContext) {
            return@withContext appDataRealm.query<RUserInfo>("id == $0", userId).find()
                .firstOrNull()?.getUserInfo()
        }


}