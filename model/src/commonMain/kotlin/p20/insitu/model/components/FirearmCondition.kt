package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpFirearmCondition
import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.xpolizei.schema.KatalogCode367
import p20.insitu.model.xpolizei.schema.Schusswaffenzustandsinformation

@Serializable
data class FirearmCondition(
    override var safetyOn: CatalogCodeFixed<KatalogCode217>?,
    override var safetyExisting: CatalogCodeFixed<KatalogCode217>?,
    override var fireMode: CatalogCodeFixed<KatalogCode367>?,
    override var loaded: CatalogCodeFixed<KatalogCode217>?,
    override var cocked: CatalogCodeFixed<KatalogCode217>?,
    override var barrelCondition: String?,
    override var breechCondition: String?
) : Component(), XpFirearmCondition{

    override fun getSchusswaffenzustandsinformation(): Schusswaffenzustandsinformation {
        return Schusswaffenzustandsinformation(
            gesichert = safetyOn?.getKatalogCode(),
            sicherungVorhanden = safetyExisting?.getKatalogCode(),
            artDesFeuermodus = fireMode?.getKatalogCode(),
            durchgeladen = loaded?.getKatalogCode(),
            hahnGespannt = cocked?.getKatalogCode(),
            zustandLauf = barrelCondition,
            zustandVerschluss = breechCondition
        )
    }
}
