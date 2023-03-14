package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Personen oder Organisationen zu Organisationen oder
 * Örtlichkeiten (Immobilien).
 */
@Serializable
public open class Beziehung_PersonalieOrganisation_OrganisationOertlichkeit() : Beziehung() {
  /**
   * Hier wird der Wert einer Beteiligung in Prozent an einer Organisation (Firma) oder Örtlichkeit
   * (Immobilie) als Anteil vom Gesamtwert abgebildet, z. B. 30.
   */
  public var anteilInProzent: Double? = 0.0

  /**
   * Höhe des Anteilswertes.
   */
  public var anteilswert: Geldbetrag? = null

  public constructor(anteilInProzent: Double?, anteilswert: Geldbetrag?) : this() {
    this.anteilInProzent = anteilInProzent
    this.anteilswert = anteilswert
  }
}
