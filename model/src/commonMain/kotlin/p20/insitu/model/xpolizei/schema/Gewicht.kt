package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Klasse zur Abbildung von Gewichten, z. B. einer Person oder Sache.
 *  
 * Wenn mehrere Sachen über die BK Stückzahl abgebildet werden, kann man aus Stückzahl x Wert des
 * Gewichtes das Gesamtgewicht errechnen.
 *  
 * Hinweis: In der Regel wird nicht das Gewicht, sondern die Masse angegeben.
 */
@Serializable
public open class Gewicht() {
  /**
   * Maßeinheit, in der das Gewicht angegeben ist.
   *
   * Beispiele: Kilogramm, Tonne
   */
  public var masseinheit: KatalogCode232? = null

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
      masseinheit: KatalogCode232?,
      wertangabe: Wertangabe?,
      feststellungsart: KatalogCode206?
  ) : this() {
    this.masseinheit = masseinheit
    this.wertangabe = wertangabe
    this.feststellungsart = feststellungsart
  }
}
