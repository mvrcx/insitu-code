package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode214
import p20.insitu.model.xpolizei.schema.KatalogCode293
import p20.insitu.model.xpolizei.schema.TragbarerGegenstand
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ManufacturingInformation

interface XpPortableObject : XpWeapon {

    var type: CatalogCodeFixed<KatalogCode293>?
    var manufacturingInformation: ManufacturingInformation?
    var permitRequired: CatalogCodeFixed<KatalogCode214>?

    fun getTragbarerGegenstand(): TragbarerGegenstand

}