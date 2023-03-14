package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class Relation() : Entity() {
  public var rel_equals: Int? = 0 // Attribute name is actually just 'equals' but that clashes with the generated javascript sources

  public var id1: String? = null

  public var id2: String? = null

  public var max: Int? = 0

  public var min: Int? = 0

  public var unequals: Int? = 0

  public constructor(
    equals: Int?,
    id1: String?,
    id2: String?,
    max: Int?,
    min: Int?,
    unequals: Int?
  ) : this() {
    this.rel_equals = equals
    this.id1 = id1
    this.id2 = id2
    this.max = max
    this.min = min
    this.unequals = unequals
  }
}
