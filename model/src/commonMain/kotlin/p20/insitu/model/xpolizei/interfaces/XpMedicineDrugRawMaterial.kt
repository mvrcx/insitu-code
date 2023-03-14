package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*

interface XpMedicineDrugRawMaterial : XpCommonBaseClass {

    var designation: String?
    var comment: String?
    var manufacturingInformation: ManufacturingInformation?
    var volume: Volume?
    var width: Size?
    var height: Size?
    var length: Size?
    var weight: Weight?
    var streetValue: MoneyAmount?
    var diameter: Size?
    var pertinentNote: List<String>?

}