package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angabe der Lage_Postanschrift Informationen.
 */
@Serializable
public open class Lage_Postanschrift() {
  /**
   * Zur Abbildung von Kreuzungsbereichen ist es erforderlich, zwei Adressen mit jeweils einer
   * Anschrift mit dem Fachobjekt Oertlichkeit zu verknüpfen.
   */
  public var anschrift: Anschrift? = null

  public var verkehrsweg: Verkehrsweg? = null

  public var katastereintrag: List<Katastereintrag>? = null

  public constructor(
      anschrift: Anschrift?,
      verkehrsweg: Verkehrsweg?,
      katastereintrag: List<Katastereintrag>?
  ) : this() {
    this.anschrift = anschrift
    this.verkehrsweg = verkehrsweg
    this.katastereintrag = katastereintrag
  }
}
