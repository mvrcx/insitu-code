package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Repräsentiert die Verbindung eines Fachobjekts zu einem Teilnehmeranker. Jedes Fachobjekt kann
 * nur genau einen Teilnehmeranker referenzieren.
 */
@Serializable
public open class Teilnehmeranker() {
  /**
   * Katalogisierte Abbildung der Art des Teilnehmerankers.
   */
  public var art: KatalogCode308? = null

  /**
   * ID des Teilnehmerankers, den das Fachobjekt referenziert.
   */
  public var iD: String? = null

  public constructor(art: KatalogCode308?, iD: String?) : this() {
    this.art = art
    this.iD = iD
  }
}
