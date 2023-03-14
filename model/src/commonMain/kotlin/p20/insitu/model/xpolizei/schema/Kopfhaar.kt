package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angaben zur Beschreibung von Kopfhaaren.
 */
@Serializable
public open class Kopfhaar() {
  /**
   * Angaben über die Art und Weise, wie Haare getragen werden.
   *
   * Beispiele: Rasta, zurückgekämmt, Mittelscheitel
   */
  public var frisur: List<KatalogCode377>? = null

  /**
   * Angaben zur Haarfarbe.
   *  
   * Beispiele: blond, schwarz, rot, braun
   */
  public var farbe: List<KatalogCode378>? = null

  /**
   * Angaben zur Haarlänge.
   *  
   * Beispiele: schulterlang, kurz / rasiert
   */
  public var laenge: KatalogCode379? = null

  /**
   * Dieses Feld enthält Angaben über den Haarwuchs einer Person.
   */
  public var haarwuchs: List<KatalogCode380>? = null

  /**
   * Dieses Feld enthält Angaben über die Haarform einer Person.
   */
  public var form: KatalogCode381? = null

  public constructor(
      frisur: List<KatalogCode377>?,
      farbe: List<KatalogCode378>?,
      laenge: KatalogCode379?,
      haarwuchs: List<KatalogCode380>?,
      form: KatalogCode381?
  ) : this() {
    this.frisur = frisur
    this.farbe = farbe
    this.laenge = laenge
    this.haarwuchs = haarwuchs
    this.form = form
  }
}
