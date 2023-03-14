package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpLicensePlateData {

    var type: CatalogCodeNotComplete<KatalogCode109_NichtAbgeschlossen>?
    var licensePlateNumber: String?
    var countryCode: CatalogCodeNotComplete<KatalogCode372_NichtAbgeschlossen>?
    var seasonalLicenseStartMonth: String?
    var seasonalLicenseEndMonth: String?

    fun getKfzKennzeicheninformation(): KfzKennzeicheninformation

}