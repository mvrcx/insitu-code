package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpColorDescription
import p20.insitu.model.xpolizei.schema.Farbangabe
import p20.insitu.model.xpolizei.schema.KatalogCode228_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.KatalogCode229

@Serializable
data class ColorDescription(
    override var color: CatalogCodeNotComplete<KatalogCode228_NichtAbgeschlossen>?,
    override var colorEffect: CatalogCodeFixed<KatalogCode229>?,
    override var designation: String?,
    override var comment: String?
) : Component(), XpColorDescription{

    override fun getFarbangabe(): Farbangabe {
        return Farbangabe(
            farbe = color?.getKatalogCodeNichtAbgeschlossen(),
            farbeffekt = colorEffect?.getKatalogCode(),
            bezeichnung = designation,
            bemerkung = comment
        )
    }
}
