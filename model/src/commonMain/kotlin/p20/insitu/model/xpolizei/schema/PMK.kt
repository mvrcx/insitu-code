package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Abbildung besonderer Eigenheiten der Politisch Motivierten Kriminalität in strukturierter Form.
 */
@Serializable
public open class PMK() {
  /**
   * Entspricht dem Gliederungspunkt 'Deliktsqualität' in der kriminaltaktischen Anfrage (KTA).
   */
  public var deliktsqualitaet: KatalogCode266? = null

  /**
   * Der Phänomenbereich (z. B. Rechts- oder Linksextremismus), dem die Straftat zuzuordnen ist.
   */
  public var phaenomenbereich: KatalogCode267? = null

  /**
   * In der Kriminaltaktischen Anfrage zur politisch motivierten Kriminalität (KTA-PMK) ist eine
   * ja/nein-Angabe dazu vorgesehen, ob es sich bei dem fraglichen Ereignis um einen Fall von
   * Extremismus handelt.
   */
  public var extremismus: KatalogCode214? = null

  /**
   * Abbildung des Themenfeldes gem. Themenfeldkatalog der Kriminaltaktischen Anfrage zur politisch
   * motivierten Kriminalität (KTA-PMK).
   *  
   * Dieser wird fortlaufend durch die Bund-Länder Arbeitsgruppe 'AG Qualitätskontrolle'
   * aktualisiert / abgestimmt und durch die K-ST beschlossen.
   */
  public var thema: List<KatalogCode268>? = null

  /**
   * Hier werden bestimmte Jahrestage abgebildet, wie Todestag Rudolf Hess, Geburtstag Adolf Hitler,
   * NEWROZ.
   */
  public var politischerKalender: KatalogCode265? = null

  /**
   * Schlagworte zu Angriffszielen und Tatmitteln im Kontext politisch motivierter Kriminalität.
   *
   * Angriffsziel einer politisch motivierten Straftat ist das Objekt (Ort, Institution oder
   * Person), welches aufgrund einer festgestellten oder sich aus dem Phänomenbereich und ggf.
   * Themenfeld ergebenden Motivation heraus gezielt angegriffen wird.
   * Das Angriffsziel einer Straftat (z. B. christenfeindliche Schmiererei an einer Kirche ->
   * Angriffsziel "Kirche") ist vom reinen Geschehensort (Tatörtlichkeit / angegriffenes Objekt) einer
   * Straftat (z. B. christenfeindliche Schmiererei an einer Autobahnbrücke -> kein Angriffsziel)
   * abzugrenzen.
   *
   * Tatmittel sind die Gegenstände / Mittel, die unmittelbar zur Begehung oder Vorbereitung einer
   * Straftat verwendet wurden oder dazu bestimmt waren. Darüber hinaus sind als Tatmittel die
   * Gegenstände zu verstehen, deren Mitführen gem. Versammlungsrecht / WaffG mit Strafe bedroht ist.
   * Detaillierte Angaben zum Tatmittel wie Art, Bezeichnung, Eigenname, Herkunft, Typ, Modell,
   * Funktionsfähigkeit des Tatmittels (z. B. Faustfeuerwaffe, Pistole, Walther PPK, Schreckschuss,
   * scharfgemacht, funktionstüchtig), Titel der inkriminierten Schrift, Bezeichnung des Mediums (z. B.
   * Tonträger, Internet, Buch) werden im jeweiligen Fachobjekt abgebildet. Im Bereich von Straftaten
   * mittels Internet sind hier, soweit bekannt, Angaben über Internetadressen (vollständige URL)
   * und/oder benutzte Server (Standort im In- und Ausland) zu machen.
   */
  public var schlagwort: List<KatalogCode368>? = null

  /**
   * Unmittelbarer zeitlicher / örtlicher Zusammenhang mit Demonstrationen, Veranstaltungen,
   * Aufzügen, Kundgebungen etc.
   * (Quelle: Ausfüllanleitung zur KTA-PMK)
   *
   * Beispiel: Täter lösen sich kurzzeitig aus Demonstrationszug und setzen Mülleimer am Straßenrand
   * in Brand.
   */
  public var zusammenhangMitDemonstrativemEreignis: KatalogCode217? = null

  /**
   * Resonanzstraftaten auf Ereignisse im Ausland.
   * (Quelle: Ausfüllanleitung zur KTA-PMK)
   *
   * Beispiel: Nach Ankündigung der Verlegung der US-amerikanischen Botschaft nach Jerusalem
   * schmieren Unbekannte u. a. volksverhetzende Parolen mit Bezug auf die vorgenannte Ankündigung an
   * die Mauer eines jüdischen Friedhofs.
   */
  public var zusammenhangMitAuslandsereignis: KatalogCode217? = null

  /**
   * Darunter sind z. B. zu verstehen:
   *
   * - Tatort im Ausland
   * - Steuerung der Tat aus dem Ausland
   * - Täterverbindungen ins Ausland
   * - Teile der Tathandlung grenzüberschreitend
   * - Tatmittel im Ausland beschafft
   * - Einfuhr / Anreise aus dem Ausland
   * - Kontakte ins / aus dem Ausland
   * (Quelle: Ausfüllanleitung zur KTA-PMK)
   *
   * Beispiel: Täter reisen zur Begehung von PMK-Straftaten im Rahmen einer Kundgebung in Köln / NW
   * aus Frankreich an.
   */
  public var internationaleBezuege: KatalogCode217? = null

  public constructor(
      deliktsqualitaet: KatalogCode266?,
      phaenomenbereich: KatalogCode267?,
      extremismus: KatalogCode214?,
      thema: List<KatalogCode268>?,
      politischerKalender: KatalogCode265?,
      schlagwort: List<KatalogCode368>?,
      zusammenhangMitDemonstrativemEreignis: KatalogCode217?,
      zusammenhangMitAuslandsereignis: KatalogCode217?,
      internationaleBezuege: KatalogCode217?
  ) : this() {
    this.deliktsqualitaet = deliktsqualitaet
    this.phaenomenbereich = phaenomenbereich
    this.extremismus = extremismus
    this.thema = thema
    this.politischerKalender = politischerKalender
    this.schlagwort = schlagwort
    this.zusammenhangMitDemonstrativemEreignis = zusammenhangMitDemonstrativemEreignis
    this.zusammenhangMitAuslandsereignis = zusammenhangMitAuslandsereignis
    this.internationaleBezuege = internationaleBezuege
  }
}
