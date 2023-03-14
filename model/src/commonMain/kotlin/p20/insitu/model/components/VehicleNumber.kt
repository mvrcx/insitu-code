package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpVehicleNumber
import p20.insitu.model.xpolizei.schema.KatalogCode225_MitZusatz_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.NummernangabeBeiFahrzeugen

@Serializable
data class VehicleNumber(
    override var type: CatalogCodeNotComplete<KatalogCode225_MitZusatz_NichtAbgeschlossen>?,
    override var number: String?
) : Component(), XpVehicleNumber {

    override fun getNummernangabeBeiFahrzeugen(): NummernangabeBeiFahrzeugen {
        return NummernangabeBeiFahrzeugen(
            art = type?.getKatalogCodeNichtAbgeschlossen(),
            nummer = number
        )
    }
}
