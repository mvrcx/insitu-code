package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.FirearmCondition
import p20.insitu.model.components.FirearmManufacturingInformation
import p20.insitu.model.components.Size

interface XpFirearm : XpWeapon {

    var category: CatalogCodeFixed<KatalogCode305>?
    var type: CatalogCodeFixed<KatalogCode291>?
    var illegalModificationOrManufacturing: List<CatalogCodeFixed<KatalogCode296>>?
    var barrelLength: Size?
    var manufacturingInformation: FirearmManufacturingInformation?
    var dealerIdentification: String?
    var caliber: List<CatalogCodeFixed<KatalogCode329>>?
    var condition: FirearmCondition?
    var registered: CatalogCodeFixed<KatalogCode214>?
    var permitRequired: CatalogCodeFixed<KatalogCode217>?

    fun getSchusswaffe(): Schusswaffe

}