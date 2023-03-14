package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KfzKennzeichenschild
import p20.insitu.model.components.Authority
import p20.insitu.model.components.ColorDescription
import p20.insitu.model.components.LicensePlateData
import p20.insitu.model.components.Size

interface XpLicensePlate : XpCommonBaseClass {

    var specialFeatures: String?
    var comment: String?
    var frameColor: ColorDescription?
    var backgroundColor: ColorDescription?
    var fontColor: ColorDescription?
    var licensePlateData: LicensePlateData?
    var width: Size?
    var length: Size?
    var issuedBy: Authority?
    var numberOfPieces: Int?

    fun getKfzKennzeichenschild(): KfzKennzeichenschild

}