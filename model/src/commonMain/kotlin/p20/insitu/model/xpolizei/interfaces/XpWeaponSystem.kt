package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode214
import p20.insitu.model.xpolizei.schema.KatalogCode297
import p20.insitu.model.xpolizei.schema.Waffensystem
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ManufacturingInformation

interface XpWeaponSystem : XpWeapon {

    var type: CatalogCodeFixed<KatalogCode297>?
    var manufacturingInformation: ManufacturingInformation?
    var permitRequired: CatalogCodeFixed<KatalogCode214>?

    fun getWaffensystem(): Waffensystem

}