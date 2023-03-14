package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class Entity() {
  public var id: String? = null

  public var name: String? = null

  public var result: Boolean? = true

  public constructor(
    id: String?,
    name: String?,
    result: Boolean?
  ) : this() {
    this.id = id
    this.name = name
    this.result = result
  }
}
