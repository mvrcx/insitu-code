package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Farbangaben zu Sachen.
 *  
 * Bei mehrfarbigen Sachen können mehrere Instanzen der Kernkomponente verwendet werden.
 */
@Serializable
public open class Farbangabe() {
  /**
   * Angabe zur Farbe.
   *
   * Beispiele: anthrazit, beige, braun, grau, grün, rosa, silber
   */
  public var farbe: KatalogCode228_NichtAbgeschlossen? = null

  /**
   * Angabe von Farbeffekten.
   *
   * Beispiele: metallic, matt, glänzend
   */
  public var farbeffekt: KatalogCode229? = null

  /**
   * Genaue Bezeichnung der Farbe, z. B. hellrot. Bei Kraftfahrzeugen kann hier auch eine
   * Herstellerbezeichnung (z. B. 'tornadorot') stehen.
   *  
   * Auch denkbar: Angaben nach einem Farbsystem z. B. RAL-Code (z. B. Signalgelb = RAL 1003,
   * Verkehrsorange = RAL 2009), Pantone-Code, CMYK oder RGB.
   */
  public var bezeichnung: String? = null

  /**
   * In diesem Feld werden freitextliche Informationen zur Farbe abgebildet, wie Erläuterungen zum
   * Farbauftrag oder Zustand der Farbe.
   *  
   * Beispiele: ausgeblichen, unregelmäßiger Auftrag, abgeblättert, Anstrich, Lackierung
   *  
   * Nicht in diesem Attribut erfasst werden genaue Farbbezeichnungen (hierzu dient das Attribut
   * Bezeichnung) und Effekte (hierzu dient das Attribut Farbeffekt).
   */
  public var bemerkung: String? = null

  public constructor(
      farbe: KatalogCode228_NichtAbgeschlossen?,
      farbeffekt: KatalogCode229?,
      bezeichnung: String?,
      bemerkung: String?
  ) : this() {
    this.farbe = farbe
    this.farbeffekt = farbeffekt
    this.bezeichnung = bezeichnung
    this.bemerkung = bemerkung
  }
}
