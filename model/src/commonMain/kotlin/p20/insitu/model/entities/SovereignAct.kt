package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.AuthorityInvolvement
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.LegalBasis
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.XpSovereignAct
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class SovereignAct(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var type: CatalogCodeFixed<KatalogCode108>?,
    override var category: CatalogCodeFixed<KatalogCode404>?,
    override var specification: String?,
    override var comment: String?,
    override var start: ZonedDateTime?,
    override var end: ZonedDateTime?,
    override var involvedAgencies: List<AuthorityInvolvement>?,
    override var priority: CatalogCodeFixed<KatalogCode235>?,
    override var objection: CatalogCodeFixed<KatalogCode217>?,
    override var legalBasis: LegalBasis?
) : BaseEntity(), DocumentationObject, XpSovereignAct {

    override val entityType: String = EntityType.SOVEREIGN_ACT.toString()

    override fun getHoheitlicheMassnahme(): HoheitlicheMassnahme {
        return HoheitlicheMassnahme().also {
            it.art = type?.getKatalogCode()
            it.bezeichnung = designation
            it.spezifikationKatalogisiert = category?.getKatalogCode()
            it.bemerkung = comment
            it.spezifikation = specification
            it.beginn = start?.getDatumZeit()
            it.ende = end?.getDatumZeit()
            it.beteiligung = involvedAgencies?.map { it.getBeteiligteStelleBeteiligungsart() }
            it.prioritaet = priority?.getKatalogCode()
            it.widerspruch = objection?.getKatalogCode()
            it.rechtsgrundlage = legalBasis?.getRechtsgrundlage()
        }
    }

}
