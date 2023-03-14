package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheWirkstoff() {
  public var bezeichnung: CIMPSucheString? = null

  public var gewicht: SucheGewicht? = null

  public constructor(bezeichnung: CIMPSucheString?, gewicht: SucheGewicht?) : this() {
    this.bezeichnung = bezeichnung
    this.gewicht = gewicht
  }
}
