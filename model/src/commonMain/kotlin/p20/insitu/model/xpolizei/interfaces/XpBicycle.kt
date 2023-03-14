package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Fahrrad
import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.xpolizei.schema.KatalogCode328_NichtAbgeschlossen
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpBicycle : XpVehicle {

    var frameNumber: String?
    var codeNumber: String?
    var wheelDiameterInch: Double?
    var model: String?
    var type: CatalogCodeNotComplete<KatalogCode328_NichtAbgeschlossen>?
    var pedelec: CatalogCodeFixed<KatalogCode217>?

    fun getFahrrad(): Fahrrad

}