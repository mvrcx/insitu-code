package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheOK_Merkmal() {
  public var a1: CIMPSucheString? = null

  public var a2: CIMPSucheString? = null

  public var b1: CIMPSucheString? = null

  public var b2: CIMPSucheString? = null

  public var c: CIMPSucheString? = null

  public constructor(
      a1: CIMPSucheString?,
      a2: CIMPSucheString?,
      b1: CIMPSucheString?,
      b2: CIMPSucheString?,
      c: CIMPSucheString?
  ) : this() {
    this.a1 = a1
    this.a2 = a2
    this.b1 = b1
    this.b2 = b2
    this.c = c
  }
}
