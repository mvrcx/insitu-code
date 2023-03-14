package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Beschreibt die Vorgehensmerkmale des Täters vor, bei und nach der Tat.
 *
 * - Arbeitsweise, auch bei Tatvorbereitung und -ausführung
 * - Absicherung der Tat
 * - Art und Weise der Erzielung von Vermögensvorteilen aus der Tat
 * - Fahrt von der Wohnung direkt zum Tatort
 */
@Serializable
public open class ModusOperandi() {
  /**
   * Angabe über die Art des Modus Operandi.
   */
  public var art: KatalogCode245? = null

  /**
   * Freitextliche Angabe / Erläuterung zum Modus Operandi.
   */
  public var bezeichnung: String? = null

  /**
   * Angabe der Tatphase (Vortat / Tatvorbereitung, Tatdurchführung und Nachtat (-verhalten)), in
   * der eine tatrelevante Handlung stattgefunden hat.
   */
  public var tatphase: KatalogCode316? = null

  public constructor(
      art: KatalogCode245?,
      bezeichnung: String?,
      tatphase: KatalogCode316?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.tatphase = tatphase
  }
}
