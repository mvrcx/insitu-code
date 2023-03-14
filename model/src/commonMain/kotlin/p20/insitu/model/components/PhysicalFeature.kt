package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpPhysicalFeature
import p20.insitu.model.xpolizei.schema.KatalogCode243_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Merkmal

@Serializable
data class PhysicalFeature(
    override var designation: CatalogCodeNotComplete<KatalogCode243_NichtAbgeschlossen>?,
    override var location: BodyPartDescription?,
    override var comment: String?
) : Component(), XpPhysicalFeature{

    override fun getMerkmal(): Merkmal {
        return Merkmal(
            bezeichnung = designation?.getKatalogCodeNichtAbgeschlossen(),
            lage = location?.getKoerperteilangabe(),
            bemerkung = comment
        )
    }
}
