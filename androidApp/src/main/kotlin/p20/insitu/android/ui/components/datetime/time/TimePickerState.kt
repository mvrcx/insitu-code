package p20.insitu.android.ui.components.datetime.time

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import p20.insitu.android.ui.components.datetime.util.isAM
import java.time.LocalTime

/**
 * Copyright 2020 Pranav Maganti

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

internal enum class ClockScreen {
    Hour,
    Minute;

    fun isHour() = this == Hour
    fun isMinute() = this == Minute
}

internal class TimePickerState(
    val colors: TimePickerColors,
    selectedTime: LocalTime,
    currentScreen: ClockScreen = ClockScreen.Hour,
    clockInput: Boolean = true,
    timeRange: ClosedRange<LocalTime>,
    is24Hour: Boolean,
) {
    var selectedTime by mutableStateOf(selectedTime)
    var timeRange by mutableStateOf(timeRange)
    var is24Hour by mutableStateOf(is24Hour)
    var currentScreen by mutableStateOf(currentScreen)
    var clockInput by mutableStateOf(clockInput)

    private fun minimumMinute(isAM: Boolean, hour: Int): Int {
        return when {
            isAM == timeRange.start.isAM ->
                if (timeRange.start.hour == hour) {
                    timeRange.start.minute
                } else {
                    0
                }
            isAM -> 61
            else -> 0
        }
    }

    private fun maximumMinute(isAM: Boolean, hour: Int): Int {
        return when {
            isAM == timeRange.endInclusive.isAM ->
                if (timeRange.endInclusive.hour == hour) {
                    timeRange.endInclusive.minute
                } else {
                    60
                }
            isAM -> 60
            else -> 0
        }
    }

    fun hourRange() = timeRange.start.hour..timeRange.endInclusive.hour

    fun minuteRange(isAM: Boolean, hour: Int) = minimumMinute(isAM, hour)..maximumMinute(isAM, hour)
}
