package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class Relations() {
  public var relation: List<Relation>? = null

  public constructor(relation: List<Relation>?) : this() {
    this.relation = relation
  }
}
