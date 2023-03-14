package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angaben zum Verkehrsweg.
 */
@Serializable
public open class Verkehrsweg() {
  /**
   * Genaue Bezeichnung der Verkehrswege wie 'A5', 'Bahnstrecke zwischen München Hbf und Nürnberg
   * Hbf', 'Rhein zwischen Bingen und Koblenz'.
   */
  public var bezeichnung: String? = null

  /**
   * Der 'NetzknotenVon' gibt den Anfang einer Strecke an.
   */
  public var netzknotenVon: String? = null

  /**
   * Der 'NetzknotenBis' gibt das Ende einer Strecke an.
   */
  public var netzknotenBis: String? = null

  /**
   * Abbildung der genauen Kilometerangabe z. B. '5'.
   *  
   * Die 'kmAngabe' bezieht sich auf die Entfernung vom 'NetzknotenVon' in Kilometern.
   */
  public var kmAngabe: Double? = 0.0

  public var stationierungssystem: Stationierungssystem? = null

  public constructor(
    bezeichnung: String?,
    netzknotenVon: String?,
    netzknotenBis: String?,
    kmAngabe: Double?,
    stationierungssystem: Stationierungssystem?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.netzknotenVon = netzknotenVon
    this.netzknotenBis = netzknotenBis
    this.kmAngabe = kmAngabe
    this.stationierungssystem = stationierungssystem
  }
}
