package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode321
import p20.insitu.model.xpolizei.schema.KatalogCode371
import p20.insitu.model.xpolizei.schema.VerwaltungspolitischeKodierung
import p20.insitu.model.components.CatalogCodeFixed

interface XpAdministrativeEncoding {

    var municipalityCode: CatalogCodeFixed<KatalogCode371>?
    var county: String?
    var district: String?
    var regionCode: String?
    var federalState: CatalogCodeFixed<KatalogCode321>?

    fun getVerwaltungspolitischeKodierung(): VerwaltungspolitischeKodierung
}