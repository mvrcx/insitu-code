package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Geometrie Daten
 */
@Serializable
public open class GeoPointWithIndex() : GeoPoint() {
  /**
   * Index von GeoPointWithIndex.
   */
  public var index: Int? = 0

  public constructor(index: Int?) : this() {
    this.index = index
  }
}
