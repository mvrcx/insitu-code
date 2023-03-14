package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Beschreibungen zu einzelnen Abschnitten (Kapitel eines Buches, Artikel in einer Zeitschrift,
 * Tracks auf einer Compact Disc, Kapitel einer DVD) einer Aufzeichnung.
 */
@Serializable
public open class EinzeltitelKapitelBeschreibung() {
  /**
   * Bezeichnung oder Überschrift des betrachteten Kapitels oder Teiles der Aufzeichnung (bei
   * Compact Discs beispielsweise die Tracknummer, welche die inkriminierte Aufzeichnung enthält).
   *  
   * Beispiele:
   * - Track 4
   * - Kapitel 3
   * - Abschnitt 3.2.1
   * - Artikel xxx, S. 87
   */
  public var einzeltitelKapitel: String? = null

  /**
   * Beschreibung der Inhalte eines Kapitels, Tracks (bei Compact Disc) oder Abschnitts der
   * Aufzeichnung.
   *  
   * Beispiele:
   * - Kennzeichen verfassungswidriger Organisationen
   * - Inhalte, die unter § 130 StGB fallen
   * - junges Mädchen im Schlafzimmer
   */
  public var textauswertung: String? = null

  public constructor(einzeltitelKapitel: String?, textauswertung: String?) : this() {
    this.einzeltitelKapitel = einzeltitelKapitel
    this.textauswertung = textauswertung
  }
}
