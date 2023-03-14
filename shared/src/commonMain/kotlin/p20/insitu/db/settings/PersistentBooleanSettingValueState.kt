package p20.insitu.db.settings

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberPersistentBooleanSettingState(
    key: String,
    defaultValue: Boolean,
    settingsRepo: SettingsRepo,
    coroutineScope: CoroutineScope
): PersistentBooleanSettingValueState {
    return remember {
        PersistentBooleanSettingValueState(
            key = key,
            defaultValue = defaultValue,
            settingsRepo = settingsRepo,
            coroutineScope = coroutineScope
        )
    }
}

class PersistentBooleanSettingValueState(
    val key: String,
    val defaultValue: Boolean,
    private val settingsRepo: SettingsRepo,
    val coroutineScope: CoroutineScope
) : SettingValueState<Boolean> {
    private var _value: Boolean by mutableStateOf(settingsRepo.getBoolean(key, defaultValue))

    override var value: Boolean
        set(value) {
            _value = value
            coroutineScope.launch {
                settingsRepo.putBoolean(key, value)
            }
        }
        get() = _value

    override fun reset() {
        value = defaultValue
    }
}
