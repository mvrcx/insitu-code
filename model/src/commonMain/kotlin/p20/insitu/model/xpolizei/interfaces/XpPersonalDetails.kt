package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*
import p20.insitu.model.xpolizei.schema.*

interface XpPersonalDetails : XpCommonBaseClass {

    var type: CatalogCodeFixed<KatalogCode117>?
    var leadership: CatalogCodeFixed<KatalogCode217>?
    var sex: CatalogCodeFixed<KatalogCode255>?
    var birthplace: String?
    var birthCounty: String?
    var birthRegion: String?
    var birthCountry: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?
    var nationality: List<Nationality>?
    var maritalStatus: CatalogCodeFixed<KatalogCode254>?
    var ethnicity: CatalogCodeNotComplete<KatalogCode251_NichtAbgeschlossen>?
    var title: List<CatalogCodeNotComplete<KatalogCode252_MitZusatz_NichtAbgeschlossen>>?
    var comment: String?
    var birthday: ZonedDateTime?
    var timeOfDeath: ZonedDateTime?
    var religiousAffiliation: List<ReligiousAffiliation>?
    var firstName: NameData?
    var lastName: NameData?
    var birthName: NameData?
    var alias: List<NameData>?
    var personalID: List<PersonalID>?

    fun getPersonalie(): Personalie

}