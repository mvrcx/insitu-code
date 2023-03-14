package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpLicensePlateData
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class LicensePlateData(
    override var type: CatalogCodeNotComplete<KatalogCode109_NichtAbgeschlossen>?,
    override var licensePlateNumber: String?,
    override var countryCode: CatalogCodeNotComplete<KatalogCode372_NichtAbgeschlossen>?,
    override var seasonalLicenseStartMonth: String?,
    override var seasonalLicenseEndMonth: String?
) : Component(), XpLicensePlateData{

    override fun getKfzKennzeicheninformation(): KfzKennzeicheninformation {
        return KfzKennzeicheninformation(
            kennzeichenArt = type?.getKatalogCodeNichtAbgeschlossen(),
            kennzeichen = licensePlateNumber,
            nationalitaet = countryCode?.getKatalogCodeNichtAbgeschlossen(),
            beginnMonatSaisonkennzeichen = seasonalLicenseStartMonth,
            endeMonatSaisonkennzeichen = seasonalLicenseEndMonth
        )
    }

}