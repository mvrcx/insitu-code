package p20.insitu.android.ui.components.datetime.date

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

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

/**
 * Represents the colors used by a [timepicker] and its parts in different states
 *
 * See [DatePickerDefaults.colors] for the default implementation
 */
interface DatePickerColors {
    val headerBackgroundColor: Color
    val headerTextColor: Color
    val calendarHeaderTextColor: Color

    /**
     * Gets the background color dependant on if the item is active or not
     *
     * @param active true if the component/item is selected and false otherwise
     * @return background color as a State
     */
    @Composable
    fun dateBackgroundColor(active: Boolean): State<Color>

    /**
     * Gets the text color dependant on if the item is active or not
     *
     * @param active true if the component/item is selected and false otherwise
     * @return text color as a State
     */
    @Composable
    fun dateTextColor(active: Boolean): State<Color>
}

internal class DefaultDatePickerColors(
    override val headerBackgroundColor: Color,
    override val headerTextColor: Color,
    override val calendarHeaderTextColor: Color,
    private val dateActiveBackgroundColor: Color,
    private val dateInactiveBackgroundColor: Color,
    private val dateActiveTextColor: Color,
    private val dateInactiveTextColor: Color
) : DatePickerColors {
    @Composable
    override fun dateBackgroundColor(active: Boolean): State<Color> {
        return rememberUpdatedState(if (active) dateActiveBackgroundColor else dateInactiveBackgroundColor)
    }

    @Composable
    override fun dateTextColor(active: Boolean): State<Color> {
        return rememberUpdatedState(if (active) dateActiveTextColor else dateInactiveTextColor)
    }
}
