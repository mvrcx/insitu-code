package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpSize
import p20.insitu.model.xpolizei.schema.Ausmass
import p20.insitu.model.xpolizei.schema.KatalogCode206
import p20.insitu.model.xpolizei.schema.KatalogCode207
import p20.insitu.model.xpolizei.schema.Wertangabe

@Serializable
data class Size(
    override var value: Float,
    override var unit: CatalogCodeFixed<KatalogCode207>?,
    override var typeOfDetermination: CatalogCodeFixed<KatalogCode206>?
) : Component(), XpSize {

    override fun getAusmass(): Ausmass {
        return Ausmass(
            masseinheit = unit?.getKatalogCode(),
            wertangabe = Wertangabe(wert = value.toDouble(), wertVonBis = null),
            feststellungsart = typeOfDetermination?.getKatalogCode()
        )
    }

    override fun toString(): String {
        return "$value ${unit?.toString() ?: ""} (${typeOfDetermination?.toString() ?: "-"})"
    }
}
