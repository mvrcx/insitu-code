package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode225_MitZusatz_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.NummernangabeBeiFahrzeugen
import p20.insitu.model.components.CatalogCodeNotComplete

interface XpVehicleNumber {

    var type: CatalogCodeNotComplete<KatalogCode225_MitZusatz_NichtAbgeschlossen>?
    var number: String?

    fun getNummernangabeBeiFahrzeugen(): NummernangabeBeiFahrzeugen
}