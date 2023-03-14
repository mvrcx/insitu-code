package p20.insitu.model.components

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpDateTime

@Serializable
data class ZonedDateTime(
    override var dateTime: LocalDateTime,
    override var zone: TimeZone
) : Component(), XpDateTime {

    enum class DateTimeFormat {
        DDMMYYYY_HHMM,
        DDMMYY_HHMM,
        MMDDYYYY_HHMM,
        MMDDYY_HHMM,
        YYYYMMDD_HHMM
    }

    enum class DateFormat {
        DDMMYYYY,
        DDMMYY,
        MMDDYYYY,
        MMDDYY,
        YYYYMMDD
    }

    enum class TimeFormat{
        HHMM,
        HHMMSS,
        HHMMSSNN
    }

    fun getFormattedTimeString(pattern: TimeFormat = TimeFormat.HHMM): String {
        val hh: String =
            if (dateTime.hour < 10) "0" + dateTime.hour else dateTime.hour.toString()
        val mm: String =
            if (dateTime.minute < 10) "0" + dateTime.minute else dateTime.minute.toString()
        val ss: String =
            if (dateTime.second < 10) "0" + dateTime.second else dateTime.second.toString()
        val nn: String =
            if (dateTime.nanosecond < 10) "0" + dateTime.nanosecond else dateTime.nanosecond.toString()
        return when(pattern){
            TimeFormat.HHMM -> "$hh:$mm"
            TimeFormat.HHMMSS -> "$hh:$mm:$ss"
            TimeFormat.HHMMSSNN -> "$hh:$mm:$ss:$nn"
        }
    }

    fun getFormattedDateString(pattern: DateFormat = DateFormat.DDMMYYYY): String {
        val dd: String =
            if (dateTime.dayOfMonth < 10) "0" + dateTime.dayOfMonth else dateTime.dayOfMonth.toString()
        val mm: String =
            if (dateTime.monthNumber < 10) "0" + dateTime.monthNumber else dateTime.monthNumber.toString()
        val yyyy: String = dateTime.year.toString()
        val yy: String = dateTime.year.toString().removeRange(0, 1)
       return when (pattern) {
            DateFormat.DDMMYYYY -> "$dd.$mm.$yyyy"
            DateFormat.DDMMYY -> "$dd.$mm.$yy"
            DateFormat.MMDDYYYY -> "$mm/$dd/$yyyy"
            DateFormat.MMDDYY -> "$mm/$dd/$yy"
            DateFormat.YYYYMMDD -> "$yyyy-$mm-$dd"
        }
    }

    fun getFormattedDateTimeString(pattern: DateTimeFormat = DateTimeFormat.DDMMYYYY_HHMM): String {
        val dd: String =
            if (dateTime.dayOfMonth < 10) "0" + dateTime.dayOfMonth else dateTime.dayOfMonth.toString()
        val mm: String =
            if (dateTime.monthNumber < 10) "0" + dateTime.monthNumber else dateTime.monthNumber.toString()
        val yyyy: String = dateTime.year.toString()
        val yy: String = dateTime.year.toString().removeRange(0, 1)
        val hhmm = getFormattedTimeString()
        return when (pattern) {
            DateTimeFormat.DDMMYYYY_HHMM -> "$dd.$mm.$yyyy $hhmm"
            DateTimeFormat.DDMMYY_HHMM -> "$dd.$mm.$yy $hhmm"
            DateTimeFormat.MMDDYYYY_HHMM -> "$mm/$dd/$yyyy $hhmm"
            DateTimeFormat.MMDDYY_HHMM -> "$mm/$dd/$yy $hhmm"
            DateTimeFormat.YYYYMMDD_HHMM -> "$yyyy-$mm-$dd $hhmm"
        }
    }

    override fun toString(): String {
        return dateTime.toString().replace("T", " ")
    }
}
