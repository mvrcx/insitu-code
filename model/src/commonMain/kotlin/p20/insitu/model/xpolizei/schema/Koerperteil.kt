package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Beschreibung eines Körperteiles: Unter diesem versteht man ein morphologisch als funktionelle
 * Einheit erkennbares Segment des Körpers.
 *
 * Beispiele: Bein, Arm, Hand
 */
@Serializable
public open class Koerperteil() : Koerperteil_Leer() {
  /**
   * Angabe der Art des Körperteils.
   */
  public var art: Koerperteilangabe? = null

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
   * Freitextliche Bemerkungen zum Körperteil, die sich nicht strukturiert beschreiben lassen.
   */
  public var bemerkung: String? = null

  public var verletzung: List<Verletzung>? = null

  public var merkmal: List<Merkmal>? = null

  public var taetowierung: List<Taetowierung>? = null

  public var gebiss: Gebiss? = null

  public var asservat: Asservat? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  public constructor(
      art: Koerperteilangabe?,
      bergungsnummer: String?,
      identifizierungsnummer: String?,
      kind: KatalogCode217?,
      bemerkung: String?,
      verletzung: List<Verletzung>?,
      merkmal: List<Merkmal>?,
      taetowierung: List<Taetowierung>?,
      gebiss: Gebiss?,
      asservat: Asservat?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?
  ) : this() {
    this.art = art
    this.bergungsnummer = bergungsnummer
    this.identifizierungsnummer = identifizierungsnummer
    this.kind = kind
    this.bemerkung = bemerkung
    this.verletzung = verletzung
    this.merkmal = merkmal
    this.taetowierung = taetowierung
    this.gebiss = gebiss
    this.asservat = asservat
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
  }
}
