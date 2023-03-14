package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode118
import p20.insitu.model.xpolizei.schema.Schienenfahrzeug
import p20.insitu.model.components.CatalogCodeFixed

interface XpRailVehicle : XpVehicle {

    var type: CatalogCodeFixed<KatalogCode118>?

    fun getSchienenfahrzeug(): Schienenfahrzeug

}