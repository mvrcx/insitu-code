package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Abbildung von Nummern, welche sich z. B. auf Bauteilen / Baugruppen, Anbauteilen oder
 * Zubehörteilen befinden und zur Identifikation des Fahrzeuges herangezogen werden können.
 */
@Serializable
public open class NummernangabeBeiFahrzeugen() {
  /**
   * Art der Nummer, die zur Identifikation eines Fahrzeuges herangezogen werden kann.
   */
  public var art: KatalogCode225_MitZusatz_NichtAbgeschlossen? = null

  /**
   * Alphanumerische Darstellung der Nummer.
   */
  public var nummer: String? = null

  public constructor(art: KatalogCode225_MitZusatz_NichtAbgeschlossen?, nummer: String?) : this() {
    this.art = art
    this.nummer = nummer
  }
}
