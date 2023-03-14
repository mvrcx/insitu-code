package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Dauerhaft spurgebundene Landfahrzeuge (Schienenfahrzeuge, Magnetschwebebahnen).
 */
@Serializable
public open class Schienenfahrzeug() : Fahrzeug() {
  /**
   * Teilkatalog der Sachenart mit dauerhaft spurgebundenen Landfahrzeugen:
   *  
   * Beispiele: Straßenbahn, Triebfahrzeug, Schwebebahn, Waggon
   */
  public var art: KatalogCode118? = null

  public constructor(art: KatalogCode118?) : this() {
    this.art = art
  }
}
