package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ManufacturingInformation
import p20.insitu.model.components.Volume

interface XpExplosiveSubstance : XpWeapon {

    var type: CatalogCodeFixed<KatalogCode307>?
    var approvalMarkBAM: String?
    var assembly: CatalogCodeFixed<KatalogCode301>?
    var manufacturingInformation: ManufacturingInformation?
    var volume: Volume?
    var permitRequired: CatalogCodeFixed<KatalogCode214>?

    fun getExplosionsgefaehrlicherStoff(): ExplosionsgefaehrlicherStoff

}