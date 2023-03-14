package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.Grundstoff
import p20.insitu.model.xpolizei.schema.KatalogCode313
import p20.insitu.model.components.CatalogCodeFixed

interface XpDrugRawMaterial : XpMedicineDrugRawMaterial {

    var type: CatalogCodeFixed<KatalogCode313>?

    fun getGrundstoff(): Grundstoff
}