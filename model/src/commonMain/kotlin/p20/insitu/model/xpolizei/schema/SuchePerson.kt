package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SuchePerson() : SucheAllgemeineBasisklasse() {
  public var redundanzinformation: SucheRedundanzinformation? = null

  public constructor(redundanzinformation: SucheRedundanzinformation?) : this() {
    this.redundanzinformation = redundanzinformation
  }
}
