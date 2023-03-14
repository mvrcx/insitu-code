package p20.insitu.model.components

import kotlinx.serialization.Serializable
import p20.insitu.model.xpolizei.interfaces.XpVolume
import p20.insitu.model.xpolizei.schema.KatalogCode206
import p20.insitu.model.xpolizei.schema.KatalogCode278
import p20.insitu.model.xpolizei.schema.Volumen
import p20.insitu.model.xpolizei.schema.Wertangabe

@Serializable
data class Volume(
    override var value: Float,
    override var unit: CatalogCodeFixed<KatalogCode278>?,
    override var typeOfDetermination: CatalogCodeFixed<KatalogCode206>?
) : Component(), XpVolume {

    override fun getVolumen(): Volumen {
        return Volumen(
            masseinheit = unit?.getKatalogCode(),
            wertangabe = Wertangabe(wert = value.toDouble(), wertVonBis = null),
            feststellungsart = typeOfDetermination?.getKatalogCode()
        )
    }

    override fun toString(): String {
        return "$value ${unit?.toString() ?: ""} (${typeOfDetermination?.toString() ?: "-"})"
    }
}
