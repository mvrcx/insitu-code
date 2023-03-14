package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpFirearmManufacturingInformation
import p20.insitu.model.xpolizei.schema.*

@Serializable
data class FirearmManufacturingInformation(
    override var manufacturer: CatalogCodeNotComplete<KatalogCode290_NichtAbgeschlossen>?,
    override var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?,
    override var manufacturingDate: String?
) : Component(), XpFirearmManufacturingInformation{

    override fun getSchusswaffenherstellungsinformation(): Schusswaffenherstellungsinformation {
        return Schusswaffenherstellungsinformation(
            hersteller = manufacturer?.getKatalogCodeNichtAbgeschlossen(),
            herstellungsstaat = country?.getKatalogCodeNichtAbgeschlossen(),
            herstellungsdatum = manufacturingDate
        )
    }
}
