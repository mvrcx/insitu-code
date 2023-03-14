package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class Entities() {
  public var entity: List<Entity>? = null

  public constructor(entity: List<Entity>?) : this() {
    this.entity = entity
  }
}
