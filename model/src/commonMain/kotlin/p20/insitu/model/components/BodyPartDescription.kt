package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpBodyPartDescription
import p20.insitu.model.xpolizei.schema.KatalogCode244_MitZusatz
import p20.insitu.model.xpolizei.schema.KatalogCode376
import p20.insitu.model.xpolizei.schema.Koerperteilangabe

@Serializable
data class BodyPartDescription(
    override var bodyPart: CatalogCodeWithAddition<KatalogCode244_MitZusatz>?,
    override var location: List<CatalogCodeFixed<KatalogCode376>>?
) : Component(), XpBodyPartDescription {

    override fun getKoerperteilangabe(): Koerperteilangabe {
        return Koerperteilangabe(
            koerperteil = bodyPart?.getKatalogCodeMitZusatz(),
            lagespezifikation = location?.map { it.getKatalogCode() }?.filterNotNull()
        )
    }
}
