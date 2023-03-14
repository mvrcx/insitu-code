package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SuchePackstation() {
  public var nummerDesEmpfaengers: CIMPSucheString? = null

  public var nummerDerPackstation: CIMPSucheString? = null

  public var pLZOrt: SuchePLZOrt? = null

  public constructor(
      nummerDesEmpfaengers: CIMPSucheString?,
      nummerDerPackstation: CIMPSucheString?,
      pLZOrt: SuchePLZOrt?
  ) : this() {
    this.nummerDesEmpfaengers = nummerDesEmpfaengers
    this.nummerDerPackstation = nummerDerPackstation
    this.pLZOrt = pLZOrt
  }
}
