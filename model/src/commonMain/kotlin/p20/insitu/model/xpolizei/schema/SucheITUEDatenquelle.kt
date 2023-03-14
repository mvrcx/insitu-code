package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheITUEDatenquelle() {
  public var quellsystem: CIMPSucheString? = null

  public var systemID: CIMPSucheString? = null

  public var nutzdatenquelle: CIMPSucheString? = null

  public var verbindungsdatenquelle: CIMPSucheString? = null

  public var iRIID: List<CIMPSucheString>? = null

  public constructor(
      quellsystem: CIMPSucheString?,
      systemID: CIMPSucheString?,
      nutzdatenquelle: CIMPSucheString?,
      verbindungsdatenquelle: CIMPSucheString?,
      iRIID: List<CIMPSucheString>?
  ) : this() {
    this.quellsystem = quellsystem
    this.systemID = systemID
    this.nutzdatenquelle = nutzdatenquelle
    this.verbindungsdatenquelle = verbindungsdatenquelle
    this.iRIID = iRIID
  }
}
