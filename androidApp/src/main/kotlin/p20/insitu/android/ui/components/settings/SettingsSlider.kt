package p20.insitu.android.ui.components.settings

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.SliderColors
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import p20.insitu.db.settings.*
import p20.insitu.android.ui.components.settings.internal.SettingsTileIcon
import p20.insitu.android.ui.components.settings.internal.SettingsTileSlider

@Composable
fun SettingsSlider(
  modifier: Modifier = Modifier,
  storage: SettingValueState<Float>,
  icon: @Composable (() -> Unit)? = null,
  title: @Composable () -> Unit,
  onValueChange: (Float) -> Unit = {},
  sliderModifier: Modifier = Modifier,
  enabled: Boolean = true,
  valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
  steps: Int = 0,
  onValueChangeFinished: (() -> Unit)? = null,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  colors: SliderColors = SliderDefaults.colors()
) {
  var settingValue = storage.value
  Surface {
    Row(
      modifier = modifier
        .height(72.dp)
        .fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      SettingsTileIcon(icon = icon)
      SettingsTileSlider(
        title,
        settingValue,
        { value ->
          settingValue = value
          onValueChange(settingValue)
        },
        sliderModifier,
        enabled,
        valueRange,
        steps,
        onValueChangeFinished,
        interactionSource,
        colors
      )
    }
  }
}
