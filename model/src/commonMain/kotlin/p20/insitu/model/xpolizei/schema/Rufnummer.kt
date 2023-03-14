package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Zusätzliche strukturierte Angaben zur Rufnummer.
 * Die Angabe einer strukturierten Rufnummer ohne Kennung ist fachlich nicht zulässig. Die erfassten
 * Daten in beiden Bereichen dürfen nicht voneinander abweichen.
 */
@Serializable
public open class Rufnummer() {
  /**
   * Angabe der internationalen Telefonvorwahl.
   *
   * Beispiel: für Gespräche nach Deutschland sind u. a. folgende Angaben möglich:
   * '+49', '00 49', '011 49' (von Australien aus), etc.
   */
  public var laenderkennzahl: String? = null

  /**
   * Angabe der Vorwahl.
   *
   * Beispiel: Ortsnetzkennzahl, Mobilfunkvorwahl, Servicevorwahl, etc.
   */
  public var vorwahl: String? = null

  /**
   * Angabe der Teilnehmerrufnummer, Durchwahlrufnummer (Basisnummer und Nebenstellennummer), etc.
   */
  public var nummer: String? = null

  public constructor(
    laenderkennzahl: String?,
    vorwahl: String?,
    nummer: String?
  ) : this() {
    this.laenderkennzahl = laenderkennzahl
    this.vorwahl = vorwahl
    this.nummer = nummer
  }
}
