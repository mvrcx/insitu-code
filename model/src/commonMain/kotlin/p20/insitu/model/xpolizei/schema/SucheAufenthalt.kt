package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAufenthalt() {
  public var aufenthaltsstatus: List<SucheAufenthaltsstatus>? = null

  public var artDesAufenthaltsendes: CIMPSucheKatalogWert? = null

  public var beginn: CIMPSucheDatum? = null

  public var ende: CIMPSucheDatum? = null

  public var ersteinreise: CIMPSucheDatum? = null

  public constructor(
      aufenthaltsstatus: List<SucheAufenthaltsstatus>?,
      artDesAufenthaltsendes: CIMPSucheKatalogWert?,
      beginn: CIMPSucheDatum?,
      ende: CIMPSucheDatum?,
      ersteinreise: CIMPSucheDatum?
  ) : this() {
    this.aufenthaltsstatus = aufenthaltsstatus
    this.artDesAufenthaltsendes = artDesAufenthaltsendes
    this.beginn = beginn
    this.ende = ende
    this.ersteinreise = ersteinreise
  }
}
