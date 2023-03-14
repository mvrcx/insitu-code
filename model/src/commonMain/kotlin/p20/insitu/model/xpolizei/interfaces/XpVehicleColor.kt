package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDate
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.ColorDescription

interface XpVehicleColor {

    var colors: List<ColorDescription>?
    var from: LocalDate?
    var until: LocalDate?

    fun getFahrzeugfarbe(): Fahrzeugfarbe
}