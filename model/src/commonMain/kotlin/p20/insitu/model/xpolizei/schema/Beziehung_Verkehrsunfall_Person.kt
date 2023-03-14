package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Verkehrsunfällen und Personen.
 */
@Serializable
public open class Beziehung_Verkehrsunfall_Person() : Beziehung() {
  /**
   * Hier wird das Aussonderungsprüfdatum gemäß Datenschutzregelung des jeweiligen Gesetzes
   * abgebildet. Dieses kann verändert werden, aufgrund Verlängerung oder Verkürzung der Frist und wird
   * dann überschrieben.
   */
  public var aussonderungspruefdatum: LocalDate? = null

  /**
   * Den Beteiligten an einem Verkehrsunfall wird eine Ordnungsnummer zugeordnet.
   *
   * Die Ordnungsnummer 01 erhält der Beteiligte, dem die wesentliche Ursache zum Unfall zuzuordnen
   * ist. Die Schwere der Tat ist hier nicht ausschlaggebend.
   * Für jedes Fahrzeug erhalten Führer und Insassen (Mitfahrer) die gleiche Ordnungsnummer. Sie ist
   * in der gesamten Unfallanzeige beizubehalten.
   * Andere Geschädigte erhalten eine eigene Ordnungsnummer.
   *
   * Unbeteiligte Zeugen erhalten keine Ordnungsnummer.
   *
   * Beispiele: 01 Die Darstellung und Eingabe erfolgt mit führender Null (falls notwendig)
   */
  public var ordnungsnummer: String? = null

  /**
   * Angabe, ob die erforderliche Fahrerlaubnis vorhanden war.
   */
  public var fahrerlaubnisVorhanden: KatalogCode217? = null

  /**
   * Dieses Feld enthält Angaben zum Grad der Verletzungen.
   *
   * Beispiele: leicht verletzt, schwer verletzt
   */
  public var verletzungsgrad: KatalogCode277? = null

  /**
   * Angabe des Sachsachadens.
   */
  public var schaden: Geldbetrag? = null

  /**
   * Angabe, ob eine Unfallflucht vorgelegen hat.
   */
  public var unfallflucht: KatalogCode217? = null

  /**
   * Die Unfallursachen werden nach dem seit 1975 geltenden Ursachenverzeichnis von den aufnehmenden
   * Polizeibeamten entsprechend ihrer Einschätzung in das Erhebungspapier eingetragen.
   * Es wird unterschieden nach allgemeinen Ursachen (u. a. Straßenverhältnisse,
   * Witterungseinflüsse, Hindernisse), die dem Unfall und nicht einzelnen Beteiligten zugeordnet
   * werden, sowie personenbezogenem Fehlverhalten (wie Vorfahrtsmissachtung, zu schnelles Fahren
   * usw.), das bestimmten Fahrzeugführern oder Fußgängern - d. h. den Beteiligten - zugeschrieben
   * wird.
   */
  public var unfallursache: List<KatalogCode344>? = null

  /**
   * Art der Verkehrsbeteiligung bei einem Verkehrsunfall, katalogisiert.
   */
  public var verkehrsbeteiligungPersonenbezogen: KatalogCode347? = null

  /**
   * Art der Verkehrsbeteiligung (fahrzeugbezogen).
   */
  public var verkehrsbeteiligungFahrzeugbezogen: KatalogCode348? = null

  /**
   * War an dem Unfall ein Fahrzeug beteiligt, das zum Unfallzeitpunkt kennzeichnungspflichtige
   * gefährliche Güter i. S. der GGVSEB beförderte, so liegt ein Gefahrgutunfall vor.
   * Es ist die vierstellige UN-Nummer aus den Begleitpapieren einzutragen. Im Tank- und
   * Schüttgutverkehr kann diese Nummer auch an der orangefarbenen Warntafel am Fahrzeug abgelesen
   * werden.
   * Beim Transport von Gefahrgütern unterschiedlicher UN-Nummern ist nach Einschätzung die
   * UN-Nummer des Stoffes anzugeben, der mengenmäßig am bedeutendsten ist (z. B. Transport
   * verschiedener Kraftstoffe). Bei sonstigem Gefahrgut ist 9999 einzugeben.
   *
   * Beispiele: Diesel UN-Nummer 1202, Benzin UN-Nummer 1203
   */
  public var gefahrgutangabe: Gefahrgut? = null

  public var alkoholeinfluss: Alkoholeinfluss? = null

  public constructor(
      aussonderungspruefdatum: LocalDate?,
      ordnungsnummer: String?,
      fahrerlaubnisVorhanden: KatalogCode217?,
      verletzungsgrad: KatalogCode277?,
      schaden: Geldbetrag?,
      unfallflucht: KatalogCode217?,
      unfallursache: List<KatalogCode344>?,
      verkehrsbeteiligungPersonenbezogen: KatalogCode347?,
      verkehrsbeteiligungFahrzeugbezogen: KatalogCode348?,
      gefahrgutangabe: Gefahrgut?,
      alkoholeinfluss: Alkoholeinfluss?
  ) : this() {
    this.aussonderungspruefdatum = aussonderungspruefdatum
    this.ordnungsnummer = ordnungsnummer
    this.fahrerlaubnisVorhanden = fahrerlaubnisVorhanden
    this.verletzungsgrad = verletzungsgrad
    this.schaden = schaden
    this.unfallflucht = unfallflucht
    this.unfallursache = unfallursache
    this.verkehrsbeteiligungPersonenbezogen = verkehrsbeteiligungPersonenbezogen
    this.verkehrsbeteiligungFahrzeugbezogen = verkehrsbeteiligungFahrzeugbezogen
    this.gefahrgutangabe = gefahrgutangabe
    this.alkoholeinfluss = alkoholeinfluss
  }
}
