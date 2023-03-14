package p20.insitu.db.settings

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberPersistentFloatSettingState(
    key: String,
    defaultValue: Float,
    settingsRepo: SettingsRepo,
    coroutineScope: CoroutineScope
): PersistentFloatSettingValueState {
    return remember {
        PersistentFloatSettingValueState(
            key = key,
            defaultValue = defaultValue,
            settingsRepo = settingsRepo,
            coroutineScope = coroutineScope
        )
    }
}

class PersistentFloatSettingValueState(
    val key: String,
    val defaultValue: Float,
    private val settingsRepo: SettingsRepo,
    val coroutineScope: CoroutineScope
) : SettingValueState<Float> {
    private var _value: Float by mutableStateOf(settingsRepo.getFloat(key, defaultValue))

    override var value: Float
        set(value) {
            _value = value
            coroutineScope.launch {
                settingsRepo.putFloat(key, value)
            }
        }
        get() = _value

    override fun reset() {
        value = defaultValue
    }
}
