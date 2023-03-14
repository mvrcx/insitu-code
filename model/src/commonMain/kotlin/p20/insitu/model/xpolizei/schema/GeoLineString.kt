package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Angabe zu Geometrie-Daten.
 */
@Serializable
public open class GeoLineString() {
  /**
   * Angabe des Streckenpunktes.
   */
  public var streckenpunkt: List<GeoPointWithIndex>? = null

  public constructor(streckenpunkt: List<GeoPointWithIndex>?) : this() {
    this.streckenpunkt = streckenpunkt
  }
}
