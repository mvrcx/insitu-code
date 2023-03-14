package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDate
import p20.insitu.model.xpolizei.schema.KatalogCode284_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode402
import p20.insitu.model.xpolizei.schema.ZulassungsinformationWasserfahrzeug
import p20.insitu.model.components.Authority
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpWatercraftRegistrationData {

    var identificationMark: String?
    var identificationType: CatalogCodeNotComplete<KatalogCode284_NichtAbgeschlossen>?
    var validFrom: LocalDate?
    var validUntil: LocalDate?
    var registrationOffice: Authority?
    var type: CatalogCodeFixed<KatalogCode402>?

    fun getZulassungsinformationWasserfahrzeug(): ZulassungsinformationWasserfahrzeug {
        return ZulassungsinformationWasserfahrzeug(
            kennzeichen = identificationMark,
            kennzeichenArt = identificationType?.getKatalogCodeNichtAbgeschlossen(),
            unterscheidungssignal = null,
            gueltigVon = validFrom?.toString(),
            gueltigBis = validUntil?.toString(),
            zulassungsstelle = registrationOffice?.getBeteiligteStelle(),
            art = type?.getKatalogCode()
        )
    }
}