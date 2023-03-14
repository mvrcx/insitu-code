package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpModusOperandi
import p20.insitu.model.xpolizei.schema.KatalogCode245
import p20.insitu.model.xpolizei.schema.KatalogCode316
import p20.insitu.model.xpolizei.schema.ModusOperandi

@Serializable
data class ModusOperandi(
    override var type: CatalogCodeFixed<KatalogCode245>?,
    override var designation: String?,
    override var crimePhase: CatalogCodeFixed<KatalogCode316>?
) :Component(),  XpModusOperandi {

    override fun getModusOperandi(): ModusOperandi {
        return ModusOperandi(
            art = type?.getKatalogCode(),
            bezeichnung = designation,
            tatphase = crimePhase?.getKatalogCode()
        )
    }
}