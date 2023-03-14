package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheAufenthaltsstatus() {
  public var art: CIMPSucheKatalogWert? = null

  public var beginn: CIMPSucheDatum? = null

  public var ende: CIMPSucheDatum? = null

  public var aufenthaltszweck: CIMPSucheString? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      beginn: CIMPSucheDatum?,
      ende: CIMPSucheDatum?,
      aufenthaltszweck: CIMPSucheString?
  ) : this() {
    this.art = art
    this.beginn = beginn
    this.ende = ende
    this.aufenthaltszweck = aufenthaltszweck
  }
}
