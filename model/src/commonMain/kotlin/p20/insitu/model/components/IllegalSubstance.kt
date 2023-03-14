package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpIllegalSubstance
import p20.insitu.model.xpolizei.schema.KatalogCode326
import p20.insitu.model.xpolizei.schema.VerboteneSubstanz

@Serializable
data class IllegalSubstance(
    override var type: CatalogCodeFixed<KatalogCode326>?,
    override var designation: String?
) : Component(), XpIllegalSubstance{

    override fun getVerboteneSubstanz(): VerboteneSubstanz {
        return VerboteneSubstanz(
            art = type?.getKatalogCode(),
            bezeichnung = designation
        )
    }
}
