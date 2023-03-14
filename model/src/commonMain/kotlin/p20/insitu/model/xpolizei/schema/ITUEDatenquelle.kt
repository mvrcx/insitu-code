package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Informationen zu den Datenquellen, die bei einer ITÜ-Maßnahme genutzt wurden.
 * Die Informationen werden zur Dokumentation von ITÜ-Maßnahmen benötigt.
 *  
 * Es handelt sich also um einen Verweis auf das Primärsystem der ITÜ, wo sich die Originaldaten
 * befinden (Gerichtsverwertbarkeit).
 */
@Serializable
public open class ITUEDatenquelle() {
  /**
   * Bezeichnung des Quelldatensystems.
   */
  public var quellsystem: String? = null

  /**
   * Eindeutige Kennzeichnung der Datenquelle.
   */
  public var systemID: String? = null

  /**
   * Quelle der Nutzdaten.
   *
   * Beispiele:
   * - Bei Gesprächen: Tonaufzeichnungen
   * - Bei FAX: übermittelte Bilddaten
   * - Bei E-Mail: Textkörper ('body') und Anhänge ('attachments')
   * - Bei Instant-Messaging: Textkörper ('body') und Anhänge ('attachments')
   * - Bei Chat: Textkörper ('body') und verlinkte Dateien
   */
  public var nutzdatenquelle: String? = null

  /**
   * Technische ID der aufzeichnenden Anlage, die eine eindeutige Zuordnung des
   * Kommunikationsereignisses (z. B. Gespräch, Nachricht) ermöglicht.
   */
  public var verbindungsdatenquelle: String? = null

  /**
   * Die IRI-ID ist die eindeutige Kennung eines IRI-Datensatzes.
   */
  public var iRIID: List<String>? = null

  public constructor(
    quellsystem: String?,
    systemID: String?,
    nutzdatenquelle: String?,
    verbindungsdatenquelle: String?,
    iRIID: List<String>?
  ) : this() {
    this.quellsystem = quellsystem
    this.systemID = systemID
    this.nutzdatenquelle = nutzdatenquelle
    this.verbindungsdatenquelle = verbindungsdatenquelle
    this.iRIID = iRIID
  }
}
