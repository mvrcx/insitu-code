package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Schusswaffen sind Gegenstände, die zum Angriff oder zur Verteidigung, zur Signalgebung, zur Jagd,
 * zur Distanzinjektion, zur Markierung, zum Sport oder zum Spiel bestimmt sind und bei denen Geschosse
 * oder heiße Gase durch einen Lauf getrieben werden.
 *  
 * In dem Fachobjekt werden weiterhin Schalldämpfer sowie wesentliche Teile von Schusswaffen, selbst
 * wenn diese mit anderen Gegenständen verbunden sind und sofern die Gebrauchsfähigkeit als Waffenteil
 * unbeeinträchtigt ist oder mit allgemein gebräuchlichen Werkzeugen wiederhergestellt werden kann
 * (bspw. Läufe, Verschlüsse), abgebildet.
 *  
 * Beispiele:
 * Büchsen, Flinten, einschließlich Flobertwaffen, Pistolen und Revolver zum Verschießen von
 * Patronenmunition, Schalldämpfer, Schreckschuss-, Reizstoff- und Signalwaffen gem. Anlage 1 Abschnitt
 * 1 UA 1 Nr. 2.6 bis 2.8 WaffG, Druckluft-, Federdruck- und Druckgaswaffen
 */
@Serializable
public open class Schusswaffe() : Waffe() {
  /**
   * Kategorisierung, ob es sich um eine komplette Schusswaffe oder einzelne wesentliche Teile /
   * Baugruppen einer Schusswaffe handelt, ohne die die Schusswaffe als nicht schussfähig anzusehen
   * sind (z. B. Rohr, Schlitten, Griffstück). Der rechtlich gleichgestellte Gegenstand Schalldämpfer
   * ist ebenfalls mit inbegriffen (siehe XWaffe-Katalog Waffe / Waffenteil).
   */
  public var kategorie: KatalogCode305? = null

  /**
   * Angaben zur Art der Schusswaffe.
   *  
   * Beispiele: Pistole, Gewehr, etc.
   */
  public var art: KatalogCode291? = null

  /**
   * Angaben zur ungesetzlichen Bearbeitung oder Herstellung einer Schusswaffe:
   *
   * Beispiele:
   * - Bearbeitung (allgemein)
   * - Bearbeitung aus SRS-Waffe
   * - Herstellung / Eigenbau
   */
  public var ungesetzlicheBearbeitung_Herstellung: List<KatalogCode296>? = null

  /**
   * Ergänzende Angaben zu Beschuss- / Prüf- und Zulassungszeichen.
   *
   * Sind diese vorhanden, können sie hier eingetragen werden. Fehlen diese Zeichen, kann hier die
   * Angabe erfolgen, welche Zeichen nicht vorhanden sind.
   */
  public var angabenZuPruefzeichen: String? = null

  /**
   * Die Angabe des numerischen Wertes, der die Anzahl der vorhandenen Züge (= Anzahl der Felder)
   * bei Schusswaffen mit gezogenen Läufen angibt.
   *  
   * Gezogener Lauf: mit spiralförmig angebrachten Zügen und Feldern ausgestatteter Lauf, in die das
   * Projektil hineingepresst wird, wodurch dieses in Rotation versetzt wird, was der Stabilisierung
   * der Flugbahn dient.
   *  
   * Felder: Erhöhungen in gezogenen Läufen. Zusammen mit den Zügen setzen sie ein abgefeuertes
   * Geschoss in eine Rotationsbewegung, was der Stabilisierung des Flugverhaltens dient.
   *  
   * Züge: Vertiefungen in gezogenen Läufen. Zusammen mit den Feldern setzen sie ein abgefeuertes
   * Geschoss in eine Rotationsbewegung, was der Stabilisierung des Flugverhaltens dient.
   */
  public var anzahlZuegeFelder: Int? = 0

  /**
   * Exakte Angabe zum Kaliber gem. XWaffe.
   */
  public var kaliberXWaffe: List<KatalogCode295_NichtAbgeschlossen>? = null

  /**
   * Exakte Angabe zum geänderten Kaliber gem. XWaffe.
   */
  public var kaliberXWaffeGeaendert: List<KatalogCode295_NichtAbgeschlossen>? = null

  /**
   * Jedes waffenrechtliche Objekt erhält eine eindeutige Identifikation (ID). Die Identifikation
   * wird durch die Zentrale Komponente des Nationalen Waffenregisters vergeben (NWR-ID).
   *  
   * Hier wird die ID für das waffenrechtliche Objekt Schusswaffe abgebildet.
   *  
   * Der Aufbau der NWR-ID für Schusswaffen kann dem Standard XWaffe entnommen werden.
   */
  public var nWRIDWaffe: String? = null

  /**
   * Festlegung der Waffenkategorie gemäß EU-Waffenrichtlinie (Kat. A - D).
   */
  public var eUKategorie: KatalogCode306? = null

  /**
   * Angabe des Beschussamtes.
   */
  public var beschussamt: List<BeteiligteStelle>? = null

  /**
   * Angabe der Lauflänge der Schusswaffe.
   */
  public var lauflaenge: Ausmass? = null

  public var schusswaffenherstellungsinformation: Schusswaffenherstellungsinformation? = null

  /**
   * Name, Firma oder eine eingetragene Marke eines Waffenimporteurs oder -händlers, der im
   * Geltungsbereich des deutschen Waffengesetzes eine gewerbliche Niederlassung hat. Dieses
   * Kennzeichen ist auf wenigstens einem wesentlichen Waffenteil anzubringen.
   */
  public var haendlerzeichen: String? = null

  /**
   * 'Grobe' Angabe zum Kaliber.
   */
  public var kaliber: List<KatalogCode329>? = null

  /**
   * Angaben zum Schusswaffenzustand zum Zeitpunkt der Sicherstellung.
   */
  public var schusswaffenzustandsinformation: Schusswaffenzustandsinformation? = null

  /**
   * Angabe, ob die Schusswaffe in Deutschland amtlich registriert ist (z. B. im NWR).
   */
  public var amtlichRegistriert: KatalogCode214? = null

  /**
   * Angabe, ob in Deutschland für den Erwerb und Besitz der Schusswaffe eine Erlaubnispflicht
   * besteht.
   *
   * Ja: Es besteht eine Erlaubnispflicht für den Erwerb und Besitz der Schusswaffe.
   *
   * Nein: Es besteht keine Erlaubnispflicht für den Erwerb und Besitz der Schusswaffe.
   *
   * Ist dieses Attribut nicht gefüllt wird keine Aussage getroffen.
   */
  public var erlaubnispflicht: KatalogCode217? = null

  /**
   * Angabe, ob die Schlusswaffe die in Deutschland notwendigen amtlichen Prüf- / Beschuss- /
   * Zulassungszeichen trägt.
   *
   * Ja: Die Schusswaffe trägt die in Deutschland notwendigen amtlichen Prüf- / Beschuss- /
   * Zulassungszeichen.
   *
   * Nein: Die Schusswaffe trägt nicht die in Deutschland notwendigen amtlichen Prüf- / Beschuss- /
   * Zulassungszeichen.
   *
   * Ist dieses Attribut nicht gefüllt wird keine Aussage getroffen.
   */
  public var mitPruef_Beschuss_Zulassungszeichen: KatalogCode217? = null

  /**
   * Angabe, ob es sich bei der Schusswaffe um einen Vollautomaten handelt.
   *
   * Ja: Bei der Schusswaffe handelt es sich um einen Vollautomaten.
   *
   * Ist dieses Attribut nicht gefüllt wird keine Aussage getroffen.
   */
  public var vollautomat: KatalogCode406? = null

  /**
   * Angabe, ob es sich um eine Schusswaffe handelt, die laut Gesetz in Deutschland mit einem
   * Umgangsverbot belegt ist.
   *
   * Ja: Die Schusswaffe ist mit einem Umgangsverbot belegt.
   *
   * Ist dieses Attribut nicht gefüllt wird keine Aussage getroffen.
   */
  public var umgangsverbot: KatalogCode406? = null

  /**
   * Angabe, ob es sich bei der Schusswaffe um einen besonderen Schusswaffentyp handelt.
   */
  public var besondererTyp: KatalogCode407? = null

  public constructor(
      kategorie: KatalogCode305?,
      art: KatalogCode291?,
      ungesetzlicheBearbeitung_Herstellung: List<KatalogCode296>?,
      angabenZuPruefzeichen: String?,
      anzahlZuegeFelder: Int?,
      kaliberXWaffe: List<KatalogCode295_NichtAbgeschlossen>?,
      kaliberXWaffeGeaendert: List<KatalogCode295_NichtAbgeschlossen>?,
      nWRIDWaffe: String?,
      eUKategorie: KatalogCode306?,
      beschussamt: List<BeteiligteStelle>?,
      lauflaenge: Ausmass?,
      schusswaffenherstellungsinformation: Schusswaffenherstellungsinformation?,
      haendlerzeichen: String?,
      kaliber: List<KatalogCode329>?,
      schusswaffenzustandsinformation: Schusswaffenzustandsinformation?,
      amtlichRegistriert: KatalogCode214?,
      erlaubnispflicht: KatalogCode217?,
      mitPruef_Beschuss_Zulassungszeichen: KatalogCode217?,
      vollautomat: KatalogCode406?,
      umgangsverbot: KatalogCode406?,
      besondererTyp: KatalogCode407?
  ) : this() {
    this.kategorie = kategorie
    this.art = art
    this.ungesetzlicheBearbeitung_Herstellung = ungesetzlicheBearbeitung_Herstellung
    this.angabenZuPruefzeichen = angabenZuPruefzeichen
    this.anzahlZuegeFelder = anzahlZuegeFelder
    this.kaliberXWaffe = kaliberXWaffe
    this.kaliberXWaffeGeaendert = kaliberXWaffeGeaendert
    this.nWRIDWaffe = nWRIDWaffe
    this.eUKategorie = eUKategorie
    this.beschussamt = beschussamt
    this.lauflaenge = lauflaenge
    this.schusswaffenherstellungsinformation = schusswaffenherstellungsinformation
    this.haendlerzeichen = haendlerzeichen
    this.kaliber = kaliber
    this.schusswaffenzustandsinformation = schusswaffenzustandsinformation
    this.amtlichRegistriert = amtlichRegistriert
    this.erlaubnispflicht = erlaubnispflicht
    this.mitPruef_Beschuss_Zulassungszeichen = mitPruef_Beschuss_Zulassungszeichen
    this.vollautomat = vollautomat
    this.umgangsverbot = umgangsverbot
    this.besondererTyp = besondererTyp
  }
}
