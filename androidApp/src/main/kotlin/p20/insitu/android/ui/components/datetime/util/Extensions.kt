package p20.insitu.android.ui.components.datetime.util

import androidx.compose.ui.geometry.Offset
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month
import java.time.YearMonth
import java.util.Locale
import kotlin.math.cos
import kotlin.math.sin

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

internal fun Float.getOffset(angle: Double): Offset =
    Offset((this * cos(angle)).toFloat(), (this * sin(angle)).toFloat())

internal val LocalDate.yearMonth: YearMonth
    get() = YearMonth.of(this.year, this.month)

internal val LocalTime.isAM: Boolean
    get() = this.hour in 0..11

internal val LocalTime.simpleHour: Int
    get() {
        val tempHour = this.hour % 12
        return if (tempHour == 0) 12 else tempHour
    }

internal fun Month.getShortLocalName(locale: Locale): String =
    this.getDisplayName(java.time.format.TextStyle.SHORT, locale)

internal fun Month.getFullLocalName(locale: Locale) =
    this.getDisplayName(java.time.format.TextStyle.FULL, locale)

internal fun DayOfWeek.getShortLocalName(locale: Locale) =
    this.getDisplayName(java.time.format.TextStyle.SHORT, locale)

internal fun LocalTime.toAM(): LocalTime = if (this.isAM) this else this.minusHours(12)
internal fun LocalTime.toPM(): LocalTime = if (!this.isAM) this else this.plusHours(12)

internal fun LocalTime.noSeconds(): LocalTime = LocalTime.of(this.hour, this.minute)
