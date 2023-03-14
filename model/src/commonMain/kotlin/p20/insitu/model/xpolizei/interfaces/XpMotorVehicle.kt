package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDate
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.MotorVehicleRegistrationData
import p20.insitu.model.components.Weight

interface XpMotorVehicle : XpVehicle {

    var type: CatalogCodeFixed<KatalogCode113>?
    var brand: CatalogCodeNotComplete<KatalogCode240_NichtAbgeschlossen>?
    var vehicleIdentificationNumber: String?
    var bodyType: CatalogCodeNotComplete<KatalogCode239_NichtAbgeschlossen>?
    var typeCode: String?
    var manufacturerCode: String?
    var decommissioning: LocalDate?
    var firstRegistration: LocalDate?
    var registrationData: List<MotorVehicleRegistrationData>?
    var loadCapacity: Weight?

    fun getKraftfahrzeug(): Kraftfahrzeug

}