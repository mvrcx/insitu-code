package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Abbildung des Stationierungssystems für Straßen.
 */
@Serializable
public open class Stationierungssystem() {
  /**
   * Angabe des Abschnitts.
   * Straßen werden in Abschnitte unterteilt. Diese sind durch Netzknoten (NK) an Kreuzungen und
   * Einmündungen von überörtlichen Straßen begrenzt. Die Abschnitte werden mit Nummern bezeichnet, die
   * in der Regel in 20er-Schritten aufsteigen.
   */
  public var abschnitt: Int? = 0

  /**
   * Angabe der Station.
   * Die Station gibt an, wie weit ein Punkt vom Beginn des Abschnittes entfernt ist. Sie beginnt in
   * jedem Abschnitt bei '0' und wird in der Maßeinheit Kilometer angegeben.
   */
  public var station: Double? = 0.0

  /**
   * Angabe der Nummer der Anschlussstelle oder die Bezeichnung des Netzknotens.
   * Bei unbekannten Werten zur Anschlussstelle sind als Anschlussstellennummern '999' einzutragen.
   */
  public var anschlussstelle: String? = null

  /**
   * Bei der Astbezeichnung einer (BAB-)Anschlussstelle handelt es sich um eine Kombination aus
   * Anfangs- und Endpunkt. Diese werden mit Buchstaben bezeichnet (z. B. A-F). Die Astbezeichnung ist
   * einer Netzknotenskizze oder den vor Ort aufgestellten Schildern zu entnehmen.
   * Bei unbekannten Werten ist als Astbezeichnung '9-9' einzutragen.
   */
  public var astbezeichnung: String? = null

  /**
   * Hier ist die Position innerhalb des jeweiligen Astes anzugeben. Die Angabe erfolgt in
   * Kilometern vom Astbeginn aus beginnend mit 0,000 km.
   * Negative Kilometerangaben sind nicht zulässig.
   * Bei unbekannten Werten ist als Astkilometer '99,999' einzutragen.
   */
  public var astkilometer: Double? = 0.0

  public constructor(
    abschnitt: Int?,
    station: Double?,
    anschlussstelle: String?,
    astbezeichnung: String?,
    astkilometer: Double?
  ) : this() {
    this.abschnitt = abschnitt
    this.station = station
    this.anschlussstelle = anschlussstelle
    this.astbezeichnung = astbezeichnung
    this.astkilometer = astkilometer
  }
}
