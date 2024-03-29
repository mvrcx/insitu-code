package p20.insitu.android.ui.components.datetime.date

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import java.time.LocalDate

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

internal class DatePickerState(
    initialDate: LocalDate,
    val colors: DatePickerColors,
    val yearRange: IntRange,
    val dialogBackground: Color
) {
    var selected by mutableStateOf(initialDate)
    var yearPickerShowing by mutableStateOf(false)
}
