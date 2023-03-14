package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Dieses Fachobjekt enthält Angaben über Datum und Uhrzeit.
 *  
 * Beispiele:
 * - Datum:19850901
 * - Zeit:124500
 */
@Serializable
public open class DatumZeit() {
  /**
   * Dieses Feld enthält Angaben zum Datum. Die Datumsangabe erfolgt gemäß ISO 8601 ausschließlich
   * achtstellig mit der Schreibweise JJJJMMTT.
   * Die Angabe eines unvollständigen Datums ist in allen drei Datumselementen (JJJJ, MM und TT)
   * zulässig. Als Platzhalter wird \? verwendet.
   *  
   * Beispiele:
   * - 03. März mit unbekanntem Jahr: \?\?\?\?0303
   * - März des Jahres 2009, ohne Tagesangabe: 200903\?\?
   * - 3. Tag eines Monats des Jahres 2008 ohne Monatsangabe: 2008\?\?03
   * - 30. oder 31.März des Jahres 2012: 2012033\?
   */
  public var datum: String? = null

  /**
   * Dieses Feld enthält Angaben zur Uhrzeit im Uhrzeitformat hhmmss. Die Angabe von unscharfen
   * Uhrzeiten ist zulässig und wird durch Platzhalter \? abgebildet.
   *  
   * Beispiele: 124259 (für 12:42:59); 12\?259 (für 12:?2:59)
   *  
   */
  public var zeit: String? = null

  /**
   * Angabe der Zeitzone als Differenz zur UTC (Weltzeit). Sofern keine Zeitzone angegeben ist, so
   * ist die Zeitzone bzw. das Offset gemäß den Vorgaben des ISO-Standards bzw. des W3C unbestimmt.
   */
  public var zeitzone: String? = null

  public constructor(
    datum: String?,
    zeit: String?,
    zeitzone: String?
  ) : this() {
    this.datum = datum
    this.zeit = zeit
    this.zeitzone = zeitzone
  }
}
