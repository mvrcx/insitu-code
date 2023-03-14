package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode214
import p20.insitu.model.xpolizei.schema.KatalogCode299
import p20.insitu.model.xpolizei.schema.Massenvernichtungswaffe
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ManufacturingInformation

interface XpWeaponOfMassDestruction : XpWeapon {

    var type: CatalogCodeFixed<KatalogCode299>?
    var manufacturingInformation: ManufacturingInformation?
    var permitRequired: CatalogCodeFixed<KatalogCode214>?

    fun getMassenvernichtungswaffe(): Massenvernichtungswaffe

}