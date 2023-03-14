package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerbundanker() {
  public var fZID: CIMPSucheString? = null

  public var aZID: List<CIMPSucheString>? = null

  public var fMZID: List<CIMPSucheString>? = null

  public var aMZID: List<CIMPSucheString>? = null

  public var fNZID: List<CIMPSucheString>? = null

  public constructor(
      fZID: CIMPSucheString?,
      aZID: List<CIMPSucheString>?,
      fMZID: List<CIMPSucheString>?,
      aMZID: List<CIMPSucheString>?,
      fNZID: List<CIMPSucheString>?
  ) : this() {
    this.fZID = fZID
    this.aZID = aZID
    this.fMZID = fMZID
    this.aMZID = aMZID
    this.fNZID = fNZID
  }
}
