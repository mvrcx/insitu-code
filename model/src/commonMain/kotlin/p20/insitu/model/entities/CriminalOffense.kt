package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.components.*
import p20.insitu.model.components.ModusOperandi
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class CriminalOffense(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var typeOfCrime: CatalogCodeFixed<KatalogCode121>? = null,
    override var attempt: CatalogCodeFixed<KatalogCode217>? = null,
    override var europeanCrimeCategory: List<CatalogCodeNotComplete<KatalogCode272_NichtAbgeschlossen>>? = null,
    override var shortDescription: String? = null,
    override var characteristics: List<CatalogCodeNotComplete<KatalogCode304_NichtAbgeschlossen>>? = null,
    override var start: ZonedDateTime? = null,
    override var end: ZonedDateTime? = null,
    override var timeOfReporting: ZonedDateTime? = null,
    override var modusOperandi: List<ModusOperandi>? = null,
    override var victimType: List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>? = null,
    override var offenderType: List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>? = null,
    override var legalAsset: List<CatalogCodeFixed<KatalogCode370>>? = null
) : BaseEntity(), DocumentationObject, XpCriminalOffense {

    override val entityType: String = EntityType.CRIMINAL_OFFENSE.toString()

    override fun getStraftat(): Straftat {
        return Straftat().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.delikt = typeOfCrime?.getKatalogCode()
            it.bezeichnung = designation
            it.versuch = attempt?.getKatalogCode()
            it.europaeischeStraftatenkategorie =
                europeanCrimeCategory?.map { it.getKatalogCodeNichtAbgeschlossen() }
                    ?.filterNotNull()
            it.kurzdarstellung = shortDescription
            it.tatbestandsmerkmal =
                characteristics?.map { it.getKatalogCodeNichtAbgeschlossen() }?.filterNotNull()
            it.beginn = start?.getDatumZeit()
            it.ende = end?.getDatumZeit()
            it.feststellungszeit = timeOfReporting?.getDatumZeit()
            it.modusOperandi = modusOperandi?.map { it.getModusOperandi() }
            it.opfertypus =
                victimType?.map { it.getKatalogCodeMitZusatz() }?.filterNotNull()
            it.taetertypus =
                offenderType?.map { it.getKatalogCodeMitZusatz() }?.filterNotNull()
            it.rechtsgut = legalAsset?.map { it.getKatalogCode() }?.filterNotNull()
        }
    }
}