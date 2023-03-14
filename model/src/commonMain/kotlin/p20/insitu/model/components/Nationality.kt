package p20.insitu.model.components

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpNationality
import p20.insitu.model.xpolizei.schema.KatalogCode208_NichtAbgeschlossen
import p20.insitu.model.xpolizei.schema.Staatsangehoerigkeit

@Serializable
data class Nationality(
    override var country: CatalogCodeNotComplete<KatalogCode208_NichtAbgeschlossen>? = null,
    override var from: LocalDate? = null,
    override var until: LocalDate? = null
) : Component(), XpNationality{

    override fun getStaatsangehoerigkeit(): Staatsangehoerigkeit {
        return Staatsangehoerigkeit(
            staat = country?.getKatalogCodeNichtAbgeschlossen(),
            von = from?.toString(),
            bis = until?.toString()
        )
    }
}