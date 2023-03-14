package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDate
import p20.insitu.model.xpolizei.schema.KatalogCode214
import p20.insitu.model.xpolizei.schema.ZulassungsinformationKfz
import p20.insitu.model.components.Authority
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.LicensePlateData

interface XpMotorVehicleRegistrationData {

    var rental: CatalogCodeFixed<KatalogCode214>?
    var validFrom: LocalDate?
    var validUntil: LocalDate?
    var registrationOffice: Authority?
    var licensePlateData: LicensePlateData?

    fun getZulassungsinformationKfz(): ZulassungsinformationKfz

}