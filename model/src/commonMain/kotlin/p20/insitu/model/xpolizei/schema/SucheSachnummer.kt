package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheSachnummer() {
  public var sachnummer: CIMPSucheAlphanumerischerWert? = null

  public constructor(sachnummer: CIMPSucheAlphanumerischerWert?) : this() {
    this.sachnummer = sachnummer
  }
}
