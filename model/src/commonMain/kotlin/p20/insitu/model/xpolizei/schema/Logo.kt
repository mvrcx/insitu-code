package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Grafik oder grafisch gestaltetes Wortzeichen auf einem Betäubungsmittel.
 */
@Serializable
public open class Logo() {
  /**
   * Art der Aufbringung des Logos.
   *
   * Beispiel: aufgedruckt, von Hand
   */
  public var aufbringungsart: KatalogCode241_NichtAbgeschlossen? = null

  /**
   * Bezeichnung des Logos.
   *
   * Beispiele: Herz, Stern, Drache, Buchstabe, Audi-TT -05 / 360-05 (XTC),
   * Armani logo -06 / 373-06 (Kokain)
   */
  public var bezeichnung: String? = null

  public constructor(aufbringungsart: KatalogCode241_NichtAbgeschlossen?, bezeichnung: String?) :
      this() {
    this.aufbringungsart = aufbringungsart
    this.bezeichnung = bezeichnung
  }
}
