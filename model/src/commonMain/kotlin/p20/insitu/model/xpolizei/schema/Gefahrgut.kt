package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Abbildung von Informationen zum Gefahrgut im Zusammenhang mit dem Transport im öffentlichen Raum.
 */
@Serializable
public open class Gefahrgut() {
  /**
   * Angabe der Gefahrgut UN-Nummer.
   *
   * Beispiele:
   * Diesel UN-Nummer 1202, Benzin UN-Nummer 1203
   */
  public var uNNummer: KatalogCode349? = null

  /**
   * Angabe der Nummer der Ausnahmeverordnung.
   *
   * Diese Nummer kann aus der Anlage der GGAV (Gefahrgutausnahmeverordnung), die grundsätzlich bei
   * innerstaatlichen Beförderungen gilt, oder den Multilateralen Vereinbarungen zur ADR entnommen
   * werden.
   *
   * Hinweis: Die Gültigkeit dieser Ausnahmen ist begrenzt und die Begrenzung folgt keinem
   * erkennbaren Muster.
   */
  public var gefahrgutAusnahmeverordnung: KatalogCode350? = null

  /**
   * Angabe, ob Gefahrgut freigesetzt wurde.
   */
  public var gefahrgutfreisetzung: KatalogCode217? = null

  public constructor(
      uNNummer: KatalogCode349?,
      gefahrgutAusnahmeverordnung: KatalogCode350?,
      gefahrgutfreisetzung: KatalogCode217?
  ) : this() {
    this.uNNummer = uNNummer
    this.gefahrgutAusnahmeverordnung = gefahrgutAusnahmeverordnung
    this.gefahrgutfreisetzung = gefahrgutfreisetzung
  }
}
