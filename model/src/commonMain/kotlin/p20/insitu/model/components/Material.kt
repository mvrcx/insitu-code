package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpMaterial
import p20.insitu.model.xpolizei.schema.KatalogCode242_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Material

@Serializable
data class Material(
    override var type: CatalogCodeNotComplete<KatalogCode242_NichtAbgeschlossen>?,
    override var designation: String?,
    override var percentage: Double?,
    override var comment: String?
) :Component(),  XpMaterial{

    override fun getMaterial(): Material {
        return Material(
            art = type?.getKatalogCodeNichtAbgeschlossen(),
            bezeichnung = designation,
            anteilInProzent = percentage,
            bemerkung = comment
        )
    }
}
