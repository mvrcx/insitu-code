package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.AllgemeinesEreignis
import p20.insitu.model.xpolizei.schema.KatalogCode101_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime

interface XpGeneralEvent: XpCommonBaseClass {

    var type: CatalogCodeNotComplete<KatalogCode101_NichtAbgeschlossen>?
    var designation: String?
    var shortDescription: String?
    var start: ZonedDateTime?
    var end: ZonedDateTime?
    var timeOfDetermination : ZonedDateTime?
    var attempt: CatalogCodeFixed<KatalogCode217>?

    fun getAllgemeinesEreignis(): AllgemeinesEreignis
}