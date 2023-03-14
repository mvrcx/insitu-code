package p20.insitu.model.components

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpWatercraftRegistrationData
import p20.insitu.model.xpolizei.schema.KatalogCode284_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode402
import p20.insitu.model.xpolizei.schema.ZulassungsinformationWasserfahrzeug

@Serializable
data class WatercraftRegistrationData(
    override var identificationMark: String?,
    override var identificationType: CatalogCodeNotComplete<KatalogCode284_NichtAbgeschlossen>?,
    override var validFrom: LocalDate?,
    override var validUntil: LocalDate?,
    override var registrationOffice: Authority?,
    override var type: CatalogCodeFixed<KatalogCode402>?
) : Component(), XpWatercraftRegistrationData {

    override fun getZulassungsinformationWasserfahrzeug(): ZulassungsinformationWasserfahrzeug {
        return super.getZulassungsinformationWasserfahrzeug()
    }
}
