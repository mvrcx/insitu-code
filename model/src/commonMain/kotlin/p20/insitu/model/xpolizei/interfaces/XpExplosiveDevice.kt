package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ManufacturingInformation

interface XpExplosiveDevice: XpWeapon {

    var category: CatalogCodeFixed<KatalogCode302>?
    var type: CatalogCodeFixed<KatalogCode300>?
    var dummy: CatalogCodeFixed<KatalogCode217>?
    var assembly: CatalogCodeFixed<KatalogCode301>?
    var manufacturingInformation: ManufacturingInformation?
    var permitRequired: CatalogCodeFixed<KatalogCode214>?

    fun getSprengvorrichtungBrandvorrichtung(): Sprengvorrichtung_Brandvorrichtung

}