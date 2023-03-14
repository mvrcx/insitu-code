package p20.insitu.db.settings

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberPersistentIntSetSettingState(
    key: String,
    defaultValue: Set<Int>,
    settingsRepo: SettingsRepo,
    coroutineScope: CoroutineScope
): PersistentIntSetSettingValueState {
    return remember {
        PersistentIntSetSettingValueState(
            key = key,
            defaultValue = defaultValue,
            settingsRepo = settingsRepo,
            coroutineScope = coroutineScope
        )
    }
}

class PersistentIntSetSettingValueState(
    val key: String,
    val defaultValue: Set<Int>,
    private val settingsRepo: SettingsRepo,
    val coroutineScope: CoroutineScope
) : SettingValueState<Set<Int>> {
    private var _value: Set<Int> by mutableStateOf(settingsRepo.getIntSet(key, defaultValue))

    override var value: Set<Int>
        set(value) {
            _value = value
            coroutineScope.launch {
                settingsRepo.putIntSet(key, value)
            }
        }
        get() = _value

    override fun reset() {
        value = defaultValue
    }
}
