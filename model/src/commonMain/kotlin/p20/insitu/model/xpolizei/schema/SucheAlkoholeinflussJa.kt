package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAlkoholeinflussJa() {
  public var ja: Boolean? = true

  public var atemAlkoholwert: CIMPSucheNumerischerWert? = null

  public var blutAlkoholwert: CIMPSucheNumerischerWert? = null

  public constructor(
      ja: Boolean?,
      atemAlkoholwert: CIMPSucheNumerischerWert?,
      blutAlkoholwert: CIMPSucheNumerischerWert?
  ) : this() {
    this.ja = ja
    this.atemAlkoholwert = atemAlkoholwert
    this.blutAlkoholwert = blutAlkoholwert
  }
}
