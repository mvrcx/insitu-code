package p20.insitu.model.components

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpVehicleColor
import p20.insitu.model.xpolizei.schema.Fahrzeugfarbe

@Serializable
data class VehicleColor(
    override var colors: List<ColorDescription>?,
    override var from: LocalDate?,
    override var until: LocalDate?
) : Component(), XpVehicleColor {

    override fun getFahrzeugfarbe(): Fahrzeugfarbe {
        return Fahrzeugfarbe(
            farbangabe = colors?.map { it.getFarbangabe() },
            von = from.toString(),
            bis = until.toString()
        )
    }
}
