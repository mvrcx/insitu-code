package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpLogo
import p20.insitu.model.xpolizei.schema.KatalogCode241_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Logo

@Serializable
data class Logo(
    override var methodOfApplicaion: CatalogCodeNotComplete<KatalogCode241_NichtAbgeschlossen>?,
    override var designation: String?
) :Component(),  XpLogo {

    override fun getLogo(): Logo {
        return Logo(
            aufbringungsart = methodOfApplicaion?.getKatalogCodeNichtAbgeschlossen(),
            bezeichnung = designation
        )
    }
}
