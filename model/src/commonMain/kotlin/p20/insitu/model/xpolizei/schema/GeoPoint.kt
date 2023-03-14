package p20.insitu.model.xpolizei.schema

import kotlin.Double
import kotlinx.serialization.Serializable

/**
 * Angabe zu Geometriedaten.
 */
@Serializable
public open class GeoPoint() {
  /**
   * Angabe der geografischen Länge gem. WGS84 (EPS-Code 4326) bzw. des 'East'-Wertes gem. ETRS89
   * (EPS-Code 25832) in Dezimalschreibweise.
   *
   * Beispiele: 49.37154 bzw. 5547991.52356376
   */
  public var geografischeLaenge: Double? = 0.0

  /**
   * Angabe der geografischen Breite gem. WGS84 (EPS-Code 4326) bzw. des 'North'-Wertes gem. ETRS89
   * (EPS-Code 25832) in Dezimalschreibweise.
   *
   * Beispiele: 8.54321 bzw. 445563.9843170741
   */
  public var geografischeBreite: Double? = 0.0

  public constructor(geografischeLaenge: Double?, geografischeBreite: Double?) : this() {
    this.geografischeLaenge = geografischeLaenge
    this.geografischeBreite = geografischeBreite
  }
}
