package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode214
import p20.insitu.model.xpolizei.schema.KatalogCode294
import p20.insitu.model.xpolizei.schema.Waffenzubehoer_Waffenteil
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ManufacturingInformation

interface XpWeaponPart : XpWeapon {

    var type: CatalogCodeFixed<KatalogCode294>?
    var manufacturingInformation: ManufacturingInformation?
    var permitRequired: CatalogCodeFixed<KatalogCode214>?

    fun getWaffenzubehoerWaffenteil(): Waffenzubehoer_Waffenteil

}