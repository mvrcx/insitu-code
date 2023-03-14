package p20.insitu.android.ui.components.datetime.date

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
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
 * Object to hold default values used by [datepicker]
 */
object DatePickerDefaults {
    /**
     * Initialises a [DatePickerColors] object which represents the different colors used by
     * the [datepicker] composable
     * @param headerBackgroundColor background color of header
     * @param headerTextColor color of text on the header
     * @param calendarHeaderTextColor color of text on the calendar header (year selector
     * and days of week)
     * @param dateActiveBackgroundColor background color of date when selected
     * @param dateActiveTextColor color of date text when selected
     * @param dateInactiveBackgroundColor background color of date when not selected
     * @param dateInactiveTextColor color of date text when not selected
     */
    @Composable
    fun colors(
        headerBackgroundColor: Color = MaterialTheme.colors.primary,
        headerTextColor: Color = MaterialTheme.colors.onPrimary,
        calendarHeaderTextColor: Color = MaterialTheme.colors.onBackground,
        dateActiveBackgroundColor: Color = MaterialTheme.colors.primary,
        dateInactiveBackgroundColor: Color = Color.Transparent,
        dateActiveTextColor: Color = MaterialTheme.colors.onPrimary,
        dateInactiveTextColor: Color = MaterialTheme.colors.onBackground
    ): DatePickerColors {
        return DefaultDatePickerColors(
            headerBackgroundColor = headerBackgroundColor,
            headerTextColor = headerTextColor,
            calendarHeaderTextColor = calendarHeaderTextColor,
            dateActiveBackgroundColor = dateActiveBackgroundColor,
            dateInactiveBackgroundColor = dateInactiveBackgroundColor,
            dateActiveTextColor = dateActiveTextColor,
            dateInactiveTextColor = dateInactiveTextColor,
        )
    }
}
