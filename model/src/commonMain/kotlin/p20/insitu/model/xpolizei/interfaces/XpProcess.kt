package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ZonedDateTime

interface XpProcess: XpCommonBaseClass {

    var designation:String?
    var typeOfProcess: CatalogCodeFixed<KatalogCode123>?
    var number: String?
    var keywords: List<String>?
    var priority: CatalogCodeFixed<KatalogCode235>?
    var category: CatalogCodeFixed<KatalogCode330>?
    var processingStatus: CatalogCodeFixed<KatalogCode221>?
    var comment: String?
    var startDate: ZonedDateTime?
    var endDate: ZonedDateTime?

   fun getVorgang(): Vorgang {
        return Vorgang().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = typeOfProcess?.getKatalogCode()
            it.bezeichnung = designation
            it.nummer = number
            it.schlagworte = keywords?.joinToString(";")
            it.prioritaet = priority?.getKatalogCode()
            it.bearbeitungsstand = processingStatus?.getKatalogCode()
            it.bemerkung = comment
            it.beginnzeitpunkt = startDate?.getDatumZeit()
            it.endzeitpunkt = endDate?.getDatumZeit()
            it.kategorie = category?.getKatalogCode()
        }
    }
}

