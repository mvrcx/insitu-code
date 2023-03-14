package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheAltersangabe() {
  public var exakt: CIMPSucheAlterPerson? = null

  public var alterVonBis: SucheAlterVonBis? = null

  public constructor(exakt: CIMPSucheAlterPerson?, alterVonBis: SucheAlterVonBis?) : this() {
    this.exakt = exakt
    this.alterVonBis = alterVonBis
  }
}
