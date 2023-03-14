package p20.insitu.model.components

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpMotorVehicleRegistrationData
import p20.insitu.model.xpolizei.schema.KatalogCode214
import p20.insitu.model.xpolizei.schema.ZulassungsinformationKfz

@Serializable
data class MotorVehicleRegistrationData(
    override var rental: CatalogCodeFixed<KatalogCode214>?,
    override var validFrom: LocalDate?,
    override var validUntil: LocalDate?,
    override var registrationOffice: Authority?,
    override var licensePlateData: LicensePlateData?
) : Component(), XpMotorVehicleRegistrationData{

    override fun getZulassungsinformationKfz(): ZulassungsinformationKfz {
        return ZulassungsinformationKfz(
            mietfahrzeug = rental?.getKatalogCode(),
            gueltigVon = validFrom?.toString(),
            gueltigBis = validUntil?.toString(),
            zulassungsstelle = registrationOffice?.getBeteiligteStelle(),
            kfzKennzeicheninformation = licensePlateData?.getKfzKennzeicheninformation()
        )
    }
}
