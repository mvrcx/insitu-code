package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import p20.insitu.model.xpolizei.schema.DatumZeit

interface XpDateTime {

    var dateTime: LocalDateTime
    var zone: TimeZone

    fun getDatumZeit(): DatumZeit{
        return DatumZeit().also {
            it.datum = this.toString().split("T")[0].split(" ")[0]
            it.zeit = this.toString().split(" ")[1]
            it.zeitzone = zone.toString()
        }
    }
}