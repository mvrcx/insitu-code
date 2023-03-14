package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.components.*
import p20.insitu.model.components.ModusOperandi
import p20.insitu.model.xpolizei.schema.*

interface XpCriminalOffense : XpCommonBaseClass {

    var typeOfCrime: CatalogCodeFixed<KatalogCode121>?
    var designation:String?
    var attempt: CatalogCodeFixed<KatalogCode217>?
    var europeanCrimeCategory: List<CatalogCodeNotComplete<KatalogCode272_NichtAbgeschlossen>>?
    var shortDescription : String?
    var characteristics: List<CatalogCodeNotComplete<KatalogCode304_NichtAbgeschlossen>>?
    var start: ZonedDateTime?
    var end: ZonedDateTime?
    var timeOfReporting: ZonedDateTime?
    var modusOperandi: List<ModusOperandi>?
    var victimType: List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>?
    var offenderType: List<CatalogCodeWithAddition<KatalogCode318_MitZusatz>>?
    var legalAsset: List<CatalogCodeFixed<KatalogCode370>>?

    fun getStraftat(): Straftat


}