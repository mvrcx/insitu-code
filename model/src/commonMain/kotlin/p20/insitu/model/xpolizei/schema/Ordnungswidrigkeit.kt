package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Ordnungswidrigkeiten sind gesetzliche Verstöße, die ausschließlich mit Bußgeld geahndet werden.
 * Neben den allgemeinen bundesweit gültigen Ordnungswidrigkeiten werden auch die
 * Verkehrsordnungswidrigkeiten abgebildet.
 */
@Serializable
public open class Ordnungswidrigkeit() : Ordnungswidrigkeit_Leer() {
  /**
   * Angabe der gesetzlichen Vorschrift (Ordnugswidrigkeit), gegen die verstoßen wurde.
   *
   * Beispiel: AufenthaltsG
   */
  public var art: KatalogCode351? = null

  /**
   * Freitextliche Beschreibung, nähere Erläuterung für globale Ordnungswidrigkeiten.
   *
   * Beispiel: Nennung von konkreten Paragrafen vor allem in Bereichen, bei denen als Delikt nur das
   * Gesetz genannt ist.
   */
  public var bezeichnung: String? = null

  /**
   * Angabe, ob ein versuchter Gesetzesverstoß vorliegt.
   */
  public var versuch: KatalogCode217? = null

  /**
   * Freitextliche Kurzdarstellung der Ordnungswidrigkeit.
   */
  public var kurzdarstellung: String? = null

  /**
   * Freitextliche Beschreibung des Beweismittels.
   *
   * Beispiele: Zeuge, Foto, Radarmessung
   */
  public var beweismittel: List<String>? = null

  /**
   * Angabe, ob die Ordnungswidrigkeit lagerelevant ist.
   */
  public var lagerelevanz: KatalogCode217? = null

  public var verkehrsordnungswidrigkeit: List<Verkehrsordnungswidrigkeit>? = null

  public var dokument: List<Dokument>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Zeitpunkt, an dem die Ordnungswidrigkeit begonnen hat.
   */
  public var beginn: DatumZeit? = null

  /**
   * Zeitpunkt, an dem die Ordnungswidrigkeit geendet hat.
   */
  public var ende: DatumZeit? = null

  /**
   * Zeitpunkt, an dem die Ordnungswidrigkeit durch eine Amtsperson oder einen Zeugen festgestellt
   * wurde.
   */
  public var feststellungszeit: DatumZeit? = null

  /**
   * Kategorisierung von Ordnungswidrigkeiten mit dem Ziel der späteren Vergleichbarkeit im Rahmen
   * der hyDaNe.
   */
  public var hyDaNeKategorie: KatalogCode408? = null

  /**
   * Angabe der Rechtsgüter, deren Schutz die Erhebung dient.
   */
  public var rechtsgut: List<KatalogCode370>? = null

  public constructor(
      art: KatalogCode351?,
      bezeichnung: String?,
      versuch: KatalogCode217?,
      kurzdarstellung: String?,
      beweismittel: List<String>?,
      lagerelevanz: KatalogCode217?,
      verkehrsordnungswidrigkeit: List<Verkehrsordnungswidrigkeit>?,
      dokument: List<Dokument>?,
      redundanzinformation: Redundanzinformation?,
      beginn: DatumZeit?,
      ende: DatumZeit?,
      feststellungszeit: DatumZeit?,
      hyDaNeKategorie: KatalogCode408?,
      rechtsgut: List<KatalogCode370>?
  ) : this() {
    this.art = art
    this.bezeichnung = bezeichnung
    this.versuch = versuch
    this.kurzdarstellung = kurzdarstellung
    this.beweismittel = beweismittel
    this.lagerelevanz = lagerelevanz
    this.verkehrsordnungswidrigkeit = verkehrsordnungswidrigkeit
    this.dokument = dokument
    this.redundanzinformation = redundanzinformation
    this.beginn = beginn
    this.ende = ende
    this.feststellungszeit = feststellungszeit
    this.hyDaNeKategorie = hyDaNeKategorie
    this.rechtsgut = rechtsgut
  }
}
