package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeoPointWithIndex() : SucheGeoPoint() {
  public var index: Int? = 0

  public constructor(index: Int?) : this() {
    this.index = index
  }
}
