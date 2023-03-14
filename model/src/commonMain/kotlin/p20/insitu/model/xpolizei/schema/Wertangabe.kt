package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlinx.serialization.Serializable

/**
 * Auswahl von Wert oder WertVonBis.
 */
@Serializable
public open class Wertangabe() {
  /**
   * Exakte Angabe eines Wertes.
   *
   * Kann nur ohne Attribut WertVon und Attribut WertBis verwendet werden. Sinnvoll für
   * Feststellungsarten 'gemessen', 'Übernahme aus Sekundärquelle' oder 'Übernahme von Originalobjekt
   * / -sache'.
   */
  public var wert: Double? = 0.0

  public var wertVonBis: WertVonBis? = null

  public constructor(wert: Double?, wertVonBis: WertVonBis?) : this() {
    this.wert = wert
    this.wertVonBis = wertVonBis
  }
}
