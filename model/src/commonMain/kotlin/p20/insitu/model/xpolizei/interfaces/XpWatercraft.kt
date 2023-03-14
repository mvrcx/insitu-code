package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*
import p20.insitu.model.xpolizei.schema.*

interface XpWatercraft : XpVehicle {

    var type: CatalogCodeFixed<KatalogCode124>?
    var model: String?
    var name: String?
    var homePort: String?
    var flagcountry: CatalogCodeNotComplete<KatalogCode286_NichtAbgeschlossen>?
    var grossRoomNumber: Double?
    var netRoomNumber: Double?
    var draft: Size?
    var registrationData: List<WatercraftRegistrationData>?
    var loadCapacity: Weight?

    fun getWasserfahrzeug(): Wasserfahrzeug

}