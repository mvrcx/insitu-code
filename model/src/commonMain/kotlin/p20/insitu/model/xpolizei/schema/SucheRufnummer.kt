package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheRufnummer() {
  public var laenderkennzahl: CIMPSucheString? = null

  public var vorwahl: CIMPSucheString? = null

  public var nummer: CIMPSucheString? = null

  public constructor(
      laenderkennzahl: CIMPSucheString?,
      vorwahl: CIMPSucheString?,
      nummer: CIMPSucheString?
  ) : this() {
    this.laenderkennzahl = laenderkennzahl
    this.vorwahl = vorwahl
    this.nummer = nummer
  }
}
