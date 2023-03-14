package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ColorDescription
import p20.insitu.model.components.Ingredient
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.Logo

interface XpDrug : XpMedicineDrugRawMaterial {

    var type: CatalogCodeFixed<KatalogCode105>?
    var form: CatalogCodeFixed<KatalogCode211>?
    var packaging: String?
    var numberOfPieces: Int?
    var color: List<ColorDescription>?
    var composition: List<Ingredient>?
    var logo: Logo?

    fun getBetaeubungsmittel(): Betaeubungsmittel
}