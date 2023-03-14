package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class ConditionGroup() {
  public var condition: Condition? = null

  public var and: And_Condition? = null

  public var or: Or_Condition? = null

  public var not: Not_Condition? = null

  public constructor(
      condition: Condition?,
      and: And_Condition?,
      or: Or_Condition?,
      not: Not_Condition?
  ) : this() {
    this.condition = condition
    this.and = and
    this.or = or
    this.not = not
  }
}
