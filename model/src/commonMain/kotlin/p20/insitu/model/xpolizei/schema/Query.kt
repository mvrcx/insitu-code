package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class Query() {
  public var entities: Entities? = null

  public var relations: Relations? = null

  public constructor(entities: Entities?, relations: Relations?) : this() {
    this.entities = entities
    this.relations = relations
  }
}
