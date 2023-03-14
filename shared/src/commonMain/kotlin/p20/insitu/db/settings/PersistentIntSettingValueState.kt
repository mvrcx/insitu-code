package p20.insitu.db.settings

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberPersistentIntSettingState(
    key: String,
    defaultValue: Int,
    settingsRepo: SettingsRepo,
    coroutineScope: CoroutineScope
): PersistentIntSettingValueState {
    return remember {
        PersistentIntSettingValueState(
            key = key,
            defaultValue = defaultValue,
            settingsRepo = settingsRepo,
            coroutineScope = coroutineScope
        )
    }
}

class PersistentIntSettingValueState(
    val key: String,
    val defaultValue: Int,
    private val settingsRepo: SettingsRepo,
    val coroutineScope: CoroutineScope
) : SettingValueState<Int> {
    private var _value: Int by mutableStateOf(settingsRepo.getInt(key, defaultValue))

    override var value: Int
        set(value) {
            _value = value
            coroutineScope.launch {
                settingsRepo.putInt(key, value)
            }
        }
        get() = _value

    override fun reset() {
        value = defaultValue
    }
}
