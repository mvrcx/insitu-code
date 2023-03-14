package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SuchePKS() {
  public var straftatenschluessel: CIMPSucheString? = null

  public var wirkdatum: CIMPSucheDatum? = null

  public constructor(straftatenschluessel: CIMPSucheString?, wirkdatum: CIMPSucheDatum?) : this() {
    this.straftatenschluessel = straftatenschluessel
    this.wirkdatum = wirkdatum
  }
}
