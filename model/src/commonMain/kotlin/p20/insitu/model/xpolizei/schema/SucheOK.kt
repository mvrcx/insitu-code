package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheOK() {
  public var oKIndikator: SucheOK_Indikator? = null

  public var oKMerkmal: SucheOK_Merkmal? = null

  public constructor(oKIndikator: SucheOK_Indikator?, oKMerkmal: SucheOK_Merkmal?) : this() {
    this.oKIndikator = oKIndikator
    this.oKMerkmal = oKMerkmal
  }
}
