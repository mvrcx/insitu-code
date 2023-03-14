package p20.insitu.model.components

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpReligiousAffiliation
import p20.insitu.model.xpolizei.schema.KatalogCode214
import p20.insitu.model.xpolizei.schema.KatalogCode257_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Religionszugehoerigkeit

@Serializable
data class ReligiousAffiliation(
    override var religion: CatalogCodeNotComplete<KatalogCode257_NichtAbgeschlossen>? = null,
    override var converted: CatalogCodeFixed<KatalogCode214>? = null,
    override var from: LocalDate? = null,
    override var until: LocalDate? = null
) : Component(), XpReligiousAffiliation {

    override fun getReligionszugehoerigkeit(): Religionszugehoerigkeit {
        return Religionszugehoerigkeit(
            religion = religion?.getKatalogCodeNichtAbgeschlossen(),
            konvertiert = converted?.getKatalogCode(),
            von = from?.toString(),
            bis = until?.toString()
        )
    }
}
