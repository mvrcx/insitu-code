package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheDatenschutzrechtlicherStatus() {
  public var bKAG: CIMPSucheKatalogWert? = null

  public var landespolizeigesetz: CIMPSucheKatalogWert? = null

  public constructor(bKAG: CIMPSucheKatalogWert?, landespolizeigesetz: CIMPSucheKatalogWert?) :
      this() {
    this.bKAG = bKAG
    this.landespolizeigesetz = landespolizeigesetz
  }
}
