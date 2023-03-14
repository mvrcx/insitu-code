package p20.insitu.db.settings

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberPersistentStringSettingState(
    key: String,
    defaultValue: String? = null,
    settingsRepo: SettingsRepo,
    coroutineScope: CoroutineScope
): PersistentStringSettingValueState {
    return remember {
        PersistentStringSettingValueState(
            key = key,
            defaultValue = defaultValue,
            settingsRepo = settingsRepo,
            coroutineScope = coroutineScope
        )
    }
}

class PersistentStringSettingValueState(
    val key: String,
    val defaultValue: String? = null,
    private val settingsRepo: SettingsRepo,
    val coroutineScope: CoroutineScope
) : SettingValueState<String?> {
    private var _value: String? by mutableStateOf(settingsRepo.getString(key, defaultValue))

    override var value: String?
        set(value) {
            _value = value
            coroutineScope.launch {
                settingsRepo.putString(key, value)
            }
        }
        get() = _value

    override fun reset() {
        value = defaultValue
    }
}
