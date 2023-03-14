package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Hier werden Sprachkenntnisse in Bezug auf Sprache, Sprachfärbung und Sprachbeherrschung einer
 * Person abgebildet.
 */
@Serializable
public open class Sprachangabe() {
  /**
   * Angaben zu Sprachkenntnissen.
   */
  public var sprache: KatalogCode203_NichtAbgeschlossen? = null

  /**
   * Angabe, ob es sich um die Muttersprache der Person handelt.
   */
  public var muttersprache: KatalogCode217? = null

  /**
   * Angaben zum Sprachniveau der Person.
   *  
   * Beispiele: fließend, gebrochen
   */
  public var sprachniveau: KatalogCode271? = null

  /**
   * Angabe, ob die Sprache mit Akzent gesprochen wird.
   *  
   * Der jeweilige Akzent wäre dann im Bemerkungsfeld einzutragen.
   */
  public var akzent: KatalogCode217? = null

  /**
   * Die Dialekte bzw. Mundarten gehören zu den nicht standardisierten Sprachvarietäten, wie z. B.
   * Umgangssprachen und die Regionalsprachen. Dieses Feld enthält lediglich Angaben zu den
   * verschiedenen Mundarten.
   *
   * Beispiele: Hessisch, Berlinerisch
   */
  public var mundart: KatalogCode383_MitZusatz_NichtAbgeschlossen? = null

  /**
   * Dieses Feld enthält freitextliche Angaben zu Sprachkenntnis.
   *  
   * Beispiele: gebrochenes Deutsch mit russischem Akzent
   */
  public var bemerkung: String? = null

  /**
   * Art, wie die Sprachangabe festgestellt wurde.
   */
  public var feststellungsart: KatalogCode363? = null

  /**
   * Angabe der Erkennungsrate in Prozent bei der technischen Erkennung einer Sprache.
   */
  public var erkennungsrate: Double? = 0.0

  public constructor(
      sprache: KatalogCode203_NichtAbgeschlossen?,
      muttersprache: KatalogCode217?,
      sprachniveau: KatalogCode271?,
      akzent: KatalogCode217?,
      mundart: KatalogCode383_MitZusatz_NichtAbgeschlossen?,
      bemerkung: String?,
      feststellungsart: KatalogCode363?,
      erkennungsrate: Double?
  ) : this() {
    this.sprache = sprache
    this.muttersprache = muttersprache
    this.sprachniveau = sprachniveau
    this.akzent = akzent
    this.mundart = mundart
    this.bemerkung = bemerkung
    this.feststellungsart = feststellungsart
    this.erkennungsrate = erkennungsrate
  }
}
