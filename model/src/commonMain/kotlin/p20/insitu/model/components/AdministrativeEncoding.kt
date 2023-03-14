package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpAdministrativeEncoding
import p20.insitu.model.xpolizei.schema.KatalogCode321
import p20.insitu.model.xpolizei.schema.KatalogCode371
import p20.insitu.model.xpolizei.schema.VerwaltungspolitischeKodierung

@Serializable
data class AdministrativeEncoding(
    override var municipalityCode: CatalogCodeFixed<KatalogCode371>?,
    override var county: String?,
    override var district: String?,
    override var regionCode: String?,
    override var federalState: CatalogCodeFixed<KatalogCode321>?
) : Component(), XpAdministrativeEncoding{

    override fun getVerwaltungspolitischeKodierung(): VerwaltungspolitischeKodierung {
        return VerwaltungspolitischeKodierung(
            gemeindeschluessel = municipalityCode?.getKatalogCode(),
            kreis = county,
            bezirk = district,
            regionalschluessel = regionCode,
            bundesland = federalState?.getKatalogCode()
        )
    }
}
