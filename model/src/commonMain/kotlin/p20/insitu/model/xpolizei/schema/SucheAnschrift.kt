package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheAnschrift() {
  public var strasse: CIMPSucheStrasse? = null

  public var hausnummer: CIMPSucheHausnummer? = null

  public var ortsteil: CIMPSucheString? = null

  public var strassenschluessel: CIMPSucheString? = null

  public var alternativeAdressangabe: CIMPSucheString? = null

  public var pLZOrt: SuchePLZOrt? = null

  public constructor(
      strasse: CIMPSucheStrasse?,
      hausnummer: CIMPSucheHausnummer?,
      ortsteil: CIMPSucheString?,
      strassenschluessel: CIMPSucheString?,
      alternativeAdressangabe: CIMPSucheString?,
      pLZOrt: SuchePLZOrt?
  ) : this() {
    this.strasse = strasse
    this.hausnummer = hausnummer
    this.ortsteil = ortsteil
    this.strassenschluessel = strassenschluessel
    this.alternativeAdressangabe = alternativeAdressangabe
    this.pLZOrt = pLZOrt
  }
}
