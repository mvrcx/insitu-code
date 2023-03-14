package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SuchePostfach() {
  public var nummer: CIMPSucheString? = null

  public var pLZOrt: SuchePLZOrt? = null

  public constructor(nummer: CIMPSucheString?, pLZOrt: SuchePLZOrt?) : this() {
    this.nummer = nummer
    this.pLZOrt = pLZOrt
  }
}
