package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Eine Organisation ist eine Vereinigung mehrerer natürlicher oder juristischer Personen bzw. eine
 * rechtsfähige Personengesellschaft zu einem gemeinsamen Zweck, z. B. im wirtschaftlichen,
 * gemeinnützigen, religiösen, öffentlichen oder politischen Bereich (Quelle: XÖV), z. B. Firmen,
 * Vereine aber auch extremistische oder terroristische Vereinigungen.
 *  
 * Hinweis: Eine Behörde wird im IMP unter 'beteiligte Stelle' geführt, wenn sie nicht im
 * polizeilichen Interesse steht, z. B. bei internen Ermittlungen.
 */
@Serializable
public open class Organisation() : Organisation_Leer() {
  /**
   * Angabe über die Art der Organisation.
   *
   * Beispiele: Behörde, extremistische Vereinigung, öffentliche Einrichtung oder Unternehmen,
   * Vereinigung
   *  
   */
  public var art: KatalogCode116? = null

  /**
   * Die Angabe des Zwecks der Organisation.
   *
   * Beispiele: Wohltätigkeitsverein, Völkerverständigung, Bildung eines Gottesstaates, Abschaffung
   * der Türkei, Abschaffung FDGO)
   */
  public var zweck: String? = null

  /**
   * Einer Organisation werden im allgemeinkriminellen, extremistischen oder terroristischen Bereich
   * ein oder mehrere Betätigungsfelder zugeordnet, d. h. ein Gebiet oder Bereich, auf / in dem sich
   * die Organisation betätigt.
   *  
   * Bespiele: Anschlagsplanung, Terrorakte, Finanzierung, logistische Unterstützung, Propaganda,
   * Missionierung, Rekrutierung, Kaderbildung, Schleusungen, Menschenhandel, Geldwäsche,
   * Produktpiraterie
   *  
   * Hinweis: legale Betätigungsfelder (insbes. von Firmen) werden im Attribut Branche abgebildet.
   */
  public var betaetigungsfeld: List<KatalogCode247_NichtAbgeschlossen>? = null

  /**
   * Bezeichnung der Volkszugehörigkeit der Organisation.
   *
   * Beispiele: Kurde, Serbe
   */
  public var volkszugehoerigkeit: KatalogCode251_NichtAbgeschlossen? = null

  /**
   * Eine Bezeichnung des Staates zu dem eine Organisation zugehörig ist.
   *
   * Beispiele: Serbien, Kroatien
   */
  public var nationaleZugehoerigkeit: KatalogCode208_NichtAbgeschlossen? = null

  /**
   * Der Name des Landes / Gebiets, in dem die Organisation gegründet wurde.
   *
   * Beispiele: Deutschland, Italien
   */
  public var gruendungsstaat: KatalogCode285_NichtAbgeschlossen? = null

  /**
   * Angaben zur deutschen Rechtsform einer Organisation.
   *
   * Die Rechtsform definiert die gesetzlichen Rahmenbedingungen der Organisation.
   *
   * Beispiele: gemeinnützige Gesellschaft mit beschränkter Haftung, Aktiengesellschaft, Offene
   * Handelsgesellschaft, eingetragener Verein
   */
  public var nationaleRechtsform: KatalogCode250_NichtAbgeschlossen? = null

  /**
   * Angaben zu einer internationalen Rechtsform einer Organisation.
   *
   * Die Rechtsform definiert die gesetzlichen Rahmenbedingungen der Organisation.
   *
   * Beispiele: Ltd., S.A., S.A.R.L.
   */
  public var internationaleRechtsform: String? = null

  /**
   * Die Branche gibt Auskunft über den Wirtschaftszweig, in dem eine Organisation tätig ist.
   *
   * Beispiele: Baugewerbe / Bau, Energieversorgung, Information und Kommunikation
   * (Quelle: XÖV)
   *  
   * Hinweis: Hier werden legale Betätigungsfelder abgebildet.
   */
  public var branche: List<KatalogCode204>? = null

  /**
   * Angabe des Auflösungsgrundes der Organisation.
   *  
   * Beispiele: Verbotsbeschluss, Insolvenz
   */
  public var aufloesungsgrund: KatalogCode246_NichtAbgeschlossen? = null

  /**
   * Im politischen Sinne dienen Ideologien zur Begründung und Rechtfertigung politischen Handelns.
   * Ideologien sind daher immer eine Kombination von
   *  
   * - bestimmten Weltanschauungen (Kommunismus, Konservatismus, Liberalismus, Sozialismus), die
   * eine spezifische Art des Denkens und des Wertsetzens bedingen.
   * - bestimmten Interessen und Absichten, die i. d. R eigenen Zielen dienen, d. h. neben der Idee
   * und Weltanschauung auch den Wunsch zur konkreten politischen und sozialen Umsetzung ausdrücken.
   *  
   * Ideologien sind wesentlicher Teil politischer Orientierung.
   *  
   * (Quelle: Bundeszentrale für politische Bildung)
   */
  public var ideologie: KatalogCode249_NichtAbgeschlossen? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob das Fachobjekt personenbezogene Daten enthält, die aus
   * einer verdeckten Maßnahme stammen.
   * Personenbezogene Daten sind alle Daten, welche eine Person direkt oder indirekt bestimmbar
   * machen (vgl. § 46 Nr. 1 BDSG).
   */
  public var erkenntnisseAusVerdeckterMassnahme: KatalogCode217? = null

  /**
   * Freitextliche Ergänzungen zur Organisation.
   *
   * Beispiele: Bemerkungen, besondere Hinweise, Ergänzungen, Vermerke
   */
  public var bemerkung: String? = null

  /**
   * Angabe des Datums der Gründung der Organisation.
   */
  public var gruendungsdatum: String? = null

  /**
   * Angabe des Datums der Auflösung der Organisation.
   */
  public var aufloesungsdatum: String? = null

  /**
   * Wert des Gesamtvermögens der Organisation.
   */
  public var vermoegen: Geldbetrag? = null

  public var registereintrag: List<Registereintrag>? = null

  public var dokument: List<Dokument>? = null

  /**
   * Der Name der Organisation fasst Angaben zum Namen einer Organisation zusammen.
   *
   * Beispiele: Technisches Hilfswerk, Scientology Church, Al Qaeda
   *
   * Bei Firmen ist die Rechtsform kein Namensbestandteil. Der Name lautet 'Gesellschaft für
   * elektronische  Informationsverarbeitung' und nicht 'Gesellschaft für elektronische 
   * Informationsverarbeitung mbH'.
   */
  public var name: List<Namensangabe>? = null

  /**
   * Die Abkürzung des Namens der Organisation.
   *
   * Beispiele:
   * - Langbezeichnung = Maschienenfabrik Augsburg Nürnberg; Kurzbezeichnung = MAN
   * - Liberation Tigers of Tamil Eelam= LTTE
   * - Arbeiterpartei Kurdistans= PKK)
   */
  public var abkuerzungName: List<Namensangabe>? = null

  /**
   * Der Name, den eine Organisation früher geführt hat. 
   */
  public var fruehererName: List<Namensangabe>? = null

  public var redundanzinformation: Redundanzinformation? = null

  /**
   * Angabe zu Nummern einer Organisation.
   */
  public var nummerDerOrganisation: List<NummerDerOrganisation>? = null

  /**
   * Angabe einer Konkretisierung zur Art der Organisation. Hierüber wird nicht der Name einer
   * Organisation abgebildet.
   * Beispiel: 'Reisebüro' bei Art der Organisation 'Unternehmen'.
   */
  public var bezeichnung: String? = null

  public constructor(
      art: KatalogCode116?,
      zweck: String?,
      betaetigungsfeld: List<KatalogCode247_NichtAbgeschlossen>?,
      volkszugehoerigkeit: KatalogCode251_NichtAbgeschlossen?,
      nationaleZugehoerigkeit: KatalogCode208_NichtAbgeschlossen?,
      gruendungsstaat: KatalogCode285_NichtAbgeschlossen?,
      nationaleRechtsform: KatalogCode250_NichtAbgeschlossen?,
      internationaleRechtsform: String?,
      branche: List<KatalogCode204>?,
      aufloesungsgrund: KatalogCode246_NichtAbgeschlossen?,
      ideologie: KatalogCode249_NichtAbgeschlossen?,
      erkenntnisseAusVerdeckterMassnahme: KatalogCode217?,
      bemerkung: String?,
      gruendungsdatum: String?,
      aufloesungsdatum: String?,
      vermoegen: Geldbetrag?,
      registereintrag: List<Registereintrag>?,
      dokument: List<Dokument>?,
      name: List<Namensangabe>?,
      abkuerzungName: List<Namensangabe>?,
      fruehererName: List<Namensangabe>?,
      redundanzinformation: Redundanzinformation?,
      nummerDerOrganisation: List<NummerDerOrganisation>?,
      bezeichnung: String?
  ) : this() {
    this.art = art
    this.zweck = zweck
    this.betaetigungsfeld = betaetigungsfeld
    this.volkszugehoerigkeit = volkszugehoerigkeit
    this.nationaleZugehoerigkeit = nationaleZugehoerigkeit
    this.gruendungsstaat = gruendungsstaat
    this.nationaleRechtsform = nationaleRechtsform
    this.internationaleRechtsform = internationaleRechtsform
    this.branche = branche
    this.aufloesungsgrund = aufloesungsgrund
    this.ideologie = ideologie
    this.erkenntnisseAusVerdeckterMassnahme = erkenntnisseAusVerdeckterMassnahme
    this.bemerkung = bemerkung
    this.gruendungsdatum = gruendungsdatum
    this.aufloesungsdatum = aufloesungsdatum
    this.vermoegen = vermoegen
    this.registereintrag = registereintrag
    this.dokument = dokument
    this.name = name
    this.abkuerzungName = abkuerzungName
    this.fruehererName = fruehererName
    this.redundanzinformation = redundanzinformation
    this.nummerDerOrganisation = nummerDerOrganisation
    this.bezeichnung = bezeichnung
  }
}
