package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Maßangaben für Längen.
 *  
 * Es lassen sich beispielsweise folgende Sachverhalte ausdrücken:
 * - geschätzte Länge zwischen 1,5 und 1,75 m
 * - gemessene Länge 3,87 m
 */
@Serializable
public open class Ausmass() {
  /**
   * Maßeinheit, in der die Größe angegeben ist.
   *
   * Beispiele: Kilometer, Meter, Zentimeter, Millimeter
   */
  public var masseinheit: KatalogCode207? = null

  /**
   * Angabe eines Wertes oder Wertebereichs als Dezimalzahl, in der durch das Attribut Masseinheit
   * bestimmten Einheit.
   *
   * Beispiele:
   * - 12,3 (m)
   * - 2 (cm)
   * - 21,23 (km)
   */
  public var wertangabe: Wertangabe? = null

  /**
   * Angabe, ob der Wert gemessen oder geschätzt oder auf andere Weise (z. B. Übernahme aus
   * Sekundärquelle [Aufzeichnung, etc.] oder Übernahme von Originalobjekt / -sache) ermittelt wurde.
   *  
   * Beispiele: gemessen, geschätzt
   */
  public var feststellungsart: KatalogCode206? = null

  public constructor(
      masseinheit: KatalogCode207?,
      wertangabe: Wertangabe?,
      feststellungsart: KatalogCode206?
  ) : this() {
    this.masseinheit = masseinheit
    this.wertangabe = wertangabe
    this.feststellungsart = feststellungsart
  }
}
