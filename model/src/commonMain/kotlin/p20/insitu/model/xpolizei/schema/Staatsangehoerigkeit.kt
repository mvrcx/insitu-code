package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zur Staatsangehörigkeit einer Person.
 *
 * Zusätzlich besteht die Möglichkeit, anzugeben, ab bzw. bis wann oder in welchem Zeitraum eine
 * bestimmte Staatsangehörigkeit bestanden hat.
 *
 * Beispiele: Deutschland, Türkei
 */
@Serializable
public open class Staatsangehoerigkeit() {
  /**
   * Angaben zu Staatsangehörigkeiten der Person.
   *
   * Beispiele: Deutschland, Türkei
   */
  public var staat: KatalogCode208_NichtAbgeschlossen? = null

  /**
   * Angaben des Datums des Endes der Staatsangehörigkeit.
   */
  public var bis: String? = null

  /**
   * Angaben des Datums des Beginns der Staatsangehörigkeit.
   */
  public var von: String? = null

  public constructor(
      staat: KatalogCode208_NichtAbgeschlossen?,
      bis: String?,
      von: String?
  ) : this() {
    this.staat = staat
    this.bis = bis
    this.von = von
  }
}
