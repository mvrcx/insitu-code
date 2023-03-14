package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Verkehrsunfällen und Organisationen.
 */
@Serializable
public open class Beziehung_Verkehrsunfall_Organisation() : Beziehung() {
  /**
   * Den Beteiligten an einem Verkehrsunfall wird eine Ordnungsnummer zugeordnet.
   * Die Ordnungsnummer 01 erhält der Beteiligte, dem die wesentliche Ursache zum Unfall zuzuordnen
   * ist. Die Schwere der Tat ist hier nicht ausschlaggebend. Für jedes Fahrzeug erhalten Führer und
   * Insassen (Mitfahrer) die gleiche Ordnungsnummer. Sie ist in der gesamten Unfallanzeige
   * beizubehalten. Andere Geschädigte erhalten eine eigene Ordnungsnummer.Unbeteiligte Zeugen erhalten
   * keine Ordnungsnummer. Beispiele: 01 Die Darstellung und Eingabe erfolgt mit führender Null (falls
   * notwendig).
   */
  public var ordnungsnummer: String? = null

  /**
   * Angabe des Sachsachadens.
   */
  public var schaden: Geldbetrag? = null

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

  public constructor(
      ordnungsnummer: String?,
      schaden: Geldbetrag?,
      verkehrsbeteiligungFahrzeugbezogen: KatalogCode348?,
      gefahrgutangabe: Gefahrgut?
  ) : this() {
    this.ordnungsnummer = ordnungsnummer
    this.schaden = schaden
    this.verkehrsbeteiligungFahrzeugbezogen = verkehrsbeteiligungFahrzeugbezogen
    this.gefahrgutangabe = gefahrgutangabe
  }
}
