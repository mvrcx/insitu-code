package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen hoheitlichen Maßnahmen und Örtlichkeiten.
 */
@Serializable
public open class Beziehung_HoheitlicheMassnahme_Oertlichkeit() : Beziehung() {
  /**
   * Dieses Feld enthält Angaben über die Gefährdungsstufe einer Örtlichkeit.
   */
  public var gefaehrdungsstufe: KatalogCode403? = null

  public constructor(gefaehrdungsstufe: KatalogCode403?) : this() {
    this.gefaehrdungsstufe = gefaehrdungsstufe
  }
}
