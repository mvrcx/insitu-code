package p20.insitu.util

import kotlinx.datetime.*
import p20.insitu.model.components.ZonedDateTime

fun getCurrentDate(): LocalDate {
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
}

fun getCurrentDateTime(): LocalDateTime {
    return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
}

fun getCurrentZonedDateTime(): ZonedDateTime {
    return getCurrentDateTime().toZonedDateTime()
}

fun LocalDateTime.toZonedDateTime(): ZonedDateTime {
    return ZonedDateTime(this, TimeZone.currentSystemDefault())
}

fun LocalDate.toZonedDateTime(): ZonedDateTime {
    return ZonedDateTime(
        LocalDateTime(this.year, this.month, this.dayOfMonth, 0, 0, 0, 0),
        TimeZone.currentSystemDefault()
    )
}