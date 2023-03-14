package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Unter dem Vorgang der Georeferenzierung, Geokodierung oder Verortung versteht man die Zuweisung
 * raumbezogener Referenzinformationen, der Georeferenz, zu einem Datensatz.
 *
 * Beispiel Dresden:
 * 51.048611 13.741389
 */
@Serializable
public open class Geometrie() {
  /**
   * Angabe des Referenzsystems (WGS84 oder ETRS89).
   */
  public var referenzsystem: KatalogCode231? = null

  /**
   * Angabe zu Geodaten.
   */
  public var geoDaten: GeoDaten? = null

  public constructor(referenzsystem: KatalogCode231?, geoDaten: GeoDaten?) : this() {
    this.referenzsystem = referenzsystem
    this.geoDaten = geoDaten
  }
}
