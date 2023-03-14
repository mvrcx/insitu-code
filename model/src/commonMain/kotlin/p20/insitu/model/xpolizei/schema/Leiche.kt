package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Eine Leiche ist der morphologisch im wesentlichen intakte Körper (größerer Teil des Rumpfes mit
 * einem weiteren Körperteil) eines Menschen, bei dem sichere Todeszeichen bestehen.
 */
@Serializable
public open class Leiche() : Leiche_Leer() {
  /**
   * Eine Leiche ist vollständig, wenn sämtliche Körperteile vorhanden sind.
   */
  public var vollstaendigkeit: KatalogCode217? = null

  /**
   * Nennung eines fehlenden Körperteiles: Unter diesem versteht man ein morphologisch als
   * funktionelle Einheit erkennbares Segment des Körpers.
   *
   * Beispiele: Bein, Arm
   */
  public var fehlendesKoerperteil: List<Koerperteilangabe>? = null

  /**
   * Wird als Nummer abgebildet, welche im Zusammenhang der BAO SGS bei der Leichenbergung
   * Verwendung findet.
   */
  public var bergungsnummer: String? = null

  /**
   * Diese Nummer wird im Rahmen der Identifizierung von der IDKO vergeben.
   */
  public var identifizierungsnummer: String? = null

  /**
   * Angabe, ob es sich um ein Kind (Person, die das 14. Lebensjahr noch nicht vollendet hat)
   * handelt.
   */
  public var kind: KatalogCode217? = null

  /**
   * Dieses Feld enthält eine freitextliche Bemerkung zur Leiche.
   */
  public var bemerkung: String? = null

  public var asservat: Asservat? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  public constructor(
      vollstaendigkeit: KatalogCode217?,
      fehlendesKoerperteil: List<Koerperteilangabe>?,
      bergungsnummer: String?,
      identifizierungsnummer: String?,
      kind: KatalogCode217?,
      bemerkung: String?,
      asservat: Asservat?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?
  ) : this() {
    this.vollstaendigkeit = vollstaendigkeit
    this.fehlendesKoerperteil = fehlendesKoerperteil
    this.bergungsnummer = bergungsnummer
    this.identifizierungsnummer = identifizierungsnummer
    this.kind = kind
    this.bemerkung = bemerkung
    this.asservat = asservat
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
  }
}
