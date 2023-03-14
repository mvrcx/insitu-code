package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpWeight
import p20.insitu.model.xpolizei.schema.Gewicht
import p20.insitu.model.xpolizei.schema.KatalogCode206
import p20.insitu.model.xpolizei.schema.KatalogCode232
import p20.insitu.model.xpolizei.schema.Wertangabe

@Serializable
data class Weight(
    override var value: Float,
    override var unit: CatalogCodeFixed<KatalogCode232>?,
    override var typeOfDetermination: CatalogCodeFixed<KatalogCode206>?
) : Component(), XpWeight {

    override fun getGewicht(): Gewicht {
        return Gewicht(
            masseinheit = unit?.getKatalogCode(),
            wertangabe = Wertangabe(wert = value.toDouble(), wertVonBis = null),
            feststellungsart = typeOfDetermination?.getKatalogCode()
        )
    }

    override fun toString(): String {
        return "$value ${unit?.toString() ?: ""} (${typeOfDetermination?.toString() ?: "-"})"
    }
}
