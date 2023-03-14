package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Träger von Binärdaten.
 *
 * Beispiele: *.jpg, *.doc, *.mp3, *.wav
 */
@Serializable
public open class DigitaleDaten() {
  /**
   * Der Type der zu übertragenden digitalen Daten.
   */
  public var mimeType: String? = null

  /**
   * Eindeutige ID, die der Absender zur Referenzierung der zu übertragenden digitalen Daten
   * vergibt.
   */
  public var dateiID: String? = null

  /**
   * Eindeutige ID des (ggf. ursprünglichen) Absenders, welche in Kombination mit der DateiID eine
   * systemübergreifend eindeutige ID der digitalen Daten bildet.
   */
  public var absenderID: String? = null

  /**
   * Angaben zur Prüfsumme der Datei.
   *
   * (Das Verfahren zur Generierung der Prüfsumme ist in der Schnittstellenvereinbarung
   * projektspezifisch festzulegen.)
   */
  public var pruefsumme: String? = null

  public var datei: Datei? = null

  public constructor(
    mimeType: String?,
    dateiID: String?,
    absenderID: String?,
    pruefsumme: String?,
    datei: Datei?
  ) : this() {
    this.mimeType = mimeType
    this.dateiID = dateiID
    this.absenderID = absenderID
    this.pruefsumme = pruefsumme
    this.datei = datei
  }
}
