package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpDentures
import p20.insitu.model.xpolizei.schema.Gebiss
import p20.insitu.model.xpolizei.schema.KatalogCode374

@Serializable
data class Dentures(
    override var specialFeatures: List<CatalogCodeFixed<KatalogCode374>>?,
    override var teeth: List<Tooth>?
) : Component(), XpDentures{

    override fun getGebiss(): Gebiss {
        return Gebiss(
            auffaelligkeit = specialFeatures?.map { it.getKatalogCode() }?.filterNotNull(),
            zahn = teeth?.map { it.getZahn() }
        )
    }
}
