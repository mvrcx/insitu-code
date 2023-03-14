package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Verkehrsunfällen und Örtlichkeiten.
 */
@Serializable
public open class Beziehung_Verkehrsunfall_Oertlichkeit() : Beziehung() {
  /**
   * Angabe der Charakeristik der Unfallstelle.
   */
  public var charakteristik: List<KatalogCode342>? = null

  /**
   * Angabe der Besonderheit der Unfallstelle.
   */
  public var besonderheit: List<KatalogCode343>? = null

  public constructor(charakteristik: List<KatalogCode342>?, besonderheit: List<KatalogCode343>?) :
      this() {
    this.charakteristik = charakteristik
    this.besonderheit = besonderheit
  }
}
