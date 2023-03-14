package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.util.randomUUID
import p20.insitu.model.xpolizei.interfaces.*
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class PersonalDetails(
    override val id: String = randomUUID(),
    override var type: CatalogCodeFixed<KatalogCode117>? = null,
    override var leadership: CatalogCodeFixed<KatalogCode217>? = null,
    override var sex: CatalogCodeFixed<KatalogCode255>? = null,
    override var birthplace: String? = null,
    override var birthCounty: String? = null,
    override var birthRegion: String? = null,
    override var birthCountry: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>? = null,
    override var nationality: List<Nationality>? = null,
    override var maritalStatus: CatalogCodeFixed<KatalogCode254>? = null,
    override var ethnicity: CatalogCodeNotComplete<KatalogCode251_NichtAbgeschlossen>? = null,
    override var title: List<CatalogCodeNotComplete<KatalogCode252_MitZusatz_NichtAbgeschlossen>>? = null,
    override var comment: String? = null,
    override var birthday: ZonedDateTime? = null,
    override var timeOfDeath: ZonedDateTime? = null,
    override var religiousAffiliation: List<ReligiousAffiliation>? = null,
    override var firstName: NameData? = null,
    override var lastName: NameData? = null,
    override var birthName: NameData? = null,
    override var alias: List<NameData>? = null,
    override var personalID: List<PersonalID>? = null
): Component(), XpPersonalDetails{

    override fun getPersonalie(): Personalie {
        return Personalie().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = type?.getKatalogCode()
            it.fuehrungspersonalie = leadership?.getKatalogCode()
            it.geschlecht = sex?.getKatalogCode()
            it.geburtsort = birthplace
            it.geburtskreis = birthCounty
            it.geburtsregion = birthRegion
            it.geburtsstaat = birthCountry?.getKatalogCodeNichtAbgeschlossen()
            it.staatsangehoerigkeit = nationality?.map { it.getStaatsangehoerigkeit() }
            it.familienstand = maritalStatus?.getKatalogCode()
            it.volkszugehoerigkeit = ethnicity?.getKatalogCodeNichtAbgeschlossen()
            it.bemerkung = comment
            it.geburtsdatum = birthday?.dateTime?.date.toString()
            it.sterbedatum = timeOfDeath?.getDatumZeit()
            it.religionszugehoerigkeit =
                religiousAffiliation?.map { it.getReligionszugehoerigkeit() }
            it.vorname = firstName?.getNamensangabe()
            it.familienname = lastName?.getNamensangabe()
            it.geburtsname = birthName?.getNamensangabe()
            it.deckname = alias?.map { it.getNamensangabe() }
            it.personenidentifikationsnummer =
                personalID?.map { it.getPersonenidentifikationsnummer() }
        }
    }
}
