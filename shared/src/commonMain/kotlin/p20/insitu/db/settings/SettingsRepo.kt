package p20.insitu.db.settings

import co.touchlab.kermit.Logger
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent

class SettingsRepo(
    private val log: Logger,
    private val coroutineScope: CoroutineScope
) : KoinComponent {

    private val config = RealmConfiguration.Builder(
        setOf(
            RStringSetting::class,
            RBooleanSetting::class,
            RIntSetSetting::class,
            RIntSetSetting::class,
            RFloatSetting::class
        )
    ).build()//.encryptionKey(getNewRealmKey()).build()

    private val settingRealm = Realm.open(config)

    suspend fun putString(key: String, value: String?) {
        RStringSetting().let {
            it.key = key
            it.value = value
            putRStringSetting(it)
        }
    }

    private suspend fun putRStringSetting(stringSetting: RStringSetting) {
        stringSetting.key.let { key ->
            coroutineScope.launch {
                settingRealm.write {
                    getRStringSetting(key)?.let {
                        findLatest(it)?.value = stringSetting.value
                    } ?: run {
                        copyToRealm(stringSetting)
                    }
                }
            }
        }
    }

    fun getString(key: String, defaultValue: String?): String? =
        getRStringSetting(key)?.value ?: defaultValue

    private fun getRStringSetting(key: String): RStringSetting? {
            return settingRealm.query<RStringSetting>(
                query = "key == $0",
                args = arrayOf(key)
            ).find().firstOrNull()
        }

    suspend fun putBoolean(key: String, value: Boolean) {
        RBooleanSetting().let {
            it.key = key
            it.value = value
            putRBooleanSetting(it)
        }
    }

    private suspend fun putRBooleanSetting(booleanSetting: RBooleanSetting) {
        booleanSetting.key.let { key ->
            coroutineScope.launch {
            settingRealm.write {
                    getRBooleanSetting(key)?.let {
                        findLatest(it)?.value = booleanSetting.value
                    } ?: run {
                        copyToRealm(booleanSetting)
                    }
                }
            }
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        getRBooleanSetting(key)?.value ?: defaultValue

    private fun getRBooleanSetting(key: String): RBooleanSetting? {
        return settingRealm.query<RBooleanSetting>(
            query = "key == $0",
            key
        ).find().firstOrNull()
    }

    suspend fun putFloat(key: String, value: Float) {
        RFloatSetting().let {
            it.key = key
            it.value = value
            putRFloatSetting(it)
        }
    }

    private suspend fun putRFloatSetting(floatSetting: RFloatSetting) {
        floatSetting.key.let { key ->
            coroutineScope.launch {
                settingRealm.write {
                    getRFloatSetting(key)?.let {
                        findLatest(it)?.value = floatSetting.value
                    } ?: run {
                        copyToRealm(floatSetting)
                    }
                }
            }
        }
    }

    fun getFloat(key: String, defaultValue: Float): Float =
        getRFloatSetting(key)?.value ?: defaultValue

    private fun getRFloatSetting(key: String): RFloatSetting? {
        return settingRealm.query<RFloatSetting>(
            query = "key == $0",
            key
        ).find().firstOrNull()
    }

    suspend fun putInt(key: String, value: Int) {
        RIntSetting().let {
            it.key = key
            it.value = value
            putRIntSetting(it)
        }
    }

    private suspend fun putRIntSetting(intSetting: RIntSetting) {
        intSetting.key.let { key ->
            coroutineScope.launch {
                settingRealm.write {
                    getRIntSetting(key)?.let {
                        findLatest(it)?.value = intSetting.value
                    } ?: run {
                        copyToRealm(intSetting)
                    }
                }
            }
        }
    }

    fun getInt(key: String, defaultValue: Int): Int =
        getRIntSetting(key)?.value ?: defaultValue

    private fun getRIntSetting(key: String): RIntSetting? {
        return settingRealm.query<RIntSetting>(
            query = "key == $0",
            key
        ).find().firstOrNull()
    }

    suspend fun putIntSet(key: String, value: Set<Int>) {
        RIntSetSetting().let {
            it.key = key
            it.value = value.toRealmList()
            putRIntSetSetting(it)
        }
    }

    private suspend fun putRIntSetSetting(intSetSetting: RIntSetSetting) {
        intSetSetting.key.let { key ->
            coroutineScope.launch {
                settingRealm.write {
                    getRIntSetSetting(key)?.let {
                        findLatest(it)?.value = intSetSetting.value
                    } ?: run {
                        copyToRealm(intSetSetting)
                    }
                }
            }
        }
    }

    fun getIntSet(key: String, defaultValue: Set<Int>): Set<Int> =
        getRIntSetSetting(key)?.value?.toSet() ?: defaultValue

    private fun getRIntSetSetting(key: String): RIntSetSetting? {
        return settingRealm.query<RIntSetSetting>(
            query = "key == $0",
            key
        ).find().firstOrNull()
    }
}