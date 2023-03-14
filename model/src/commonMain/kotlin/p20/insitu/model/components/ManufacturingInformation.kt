package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpManufacturingInformation
import p20.insitu.model.xpolizei.schema.Herstellungsinformation
import p20.insitu.model.xpolizei.schema.KatalogCode285_NichtAbgeschlossen

@Serializable
data class ManufacturingInformation(
    override var manufacturer: String?,
    override var country: CatalogCodeNotComplete<KatalogCode285_NichtAbgeschlossen>?,
    override var manufacuringDate: String?
) : Component(), XpManufacturingInformation{

    override fun getHerstellungsinformation(): Herstellungsinformation {
        return Herstellungsinformation(
            herstellerbezeichnung = manufacturer,
            herstellungsstaat = country?.getKatalogCodeNichtAbgeschlossen(),
            herstellungsdatum = manufacuringDate
        )
    }
}
