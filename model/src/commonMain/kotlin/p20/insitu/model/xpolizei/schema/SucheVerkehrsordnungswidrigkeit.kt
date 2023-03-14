package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerkehrsordnungswidrigkeit() {
  public var tatbestandsnummer: CIMPSucheKatalogWert? = null

  public var tatbestandsnummerKonkretisierung: CIMPSucheString? = null

  public constructor(tatbestandsnummer: CIMPSucheKatalogWert?,
                     tatbestandsnummerKonkretisierung: CIMPSucheString?) : this() {
    this.tatbestandsnummer = tatbestandsnummer
    this.tatbestandsnummerKonkretisierung = tatbestandsnummerKonkretisierung
  }
}
