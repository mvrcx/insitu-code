package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Rauminhalt einer Sache.
 */
@Serializable
public open class Volumen() {
  /**
   * Maßeinheit, in der das Volumen angegeben ist.
   *
   * Beispiele: Liter, Kubikzentimeter
   */
  public var masseinheit: KatalogCode278? = null

  /**
   * Angabe eines Wertes oder Wertebereichs in der durch das Attribut Masseinheit bestimmten
   * Einheit.
   *
   * Beispiele: 12 (m), 2 (cm)
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
      masseinheit: KatalogCode278?,
      wertangabe: Wertangabe?,
      feststellungsart: KatalogCode206?
  ) : this() {
    this.masseinheit = masseinheit
    this.wertangabe = wertangabe
    this.feststellungsart = feststellungsart
  }
}
