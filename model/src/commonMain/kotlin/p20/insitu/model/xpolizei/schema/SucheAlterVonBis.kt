package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheAlterVonBis() {
  public var alterVon: CIMPSucheAlterPerson? = null

  public var alterBis: CIMPSucheAlterPerson? = null

  public constructor(alterVon: CIMPSucheAlterPerson?, alterBis: CIMPSucheAlterPerson?) : this() {
    this.alterVon = alterVon
    this.alterBis = alterBis
  }
}
