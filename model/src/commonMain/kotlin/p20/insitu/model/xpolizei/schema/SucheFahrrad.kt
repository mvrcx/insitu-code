package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheFahrrad() : SucheFahrzeug() {
  public var rahmennummer: CIMPSucheString? = null

  public var codenummer: CIMPSucheString? = null

  public var radgroesseInZoll: CIMPSucheNumerischerWert? = null

  public var modell: CIMPSucheString? = null

  public var art: CIMPSucheKatalogWert? = null

  public var pedelec: CIMPSucheKatalogWert? = null

  public constructor(
      rahmennummer: CIMPSucheString?,
      codenummer: CIMPSucheString?,
      radgroesseInZoll: CIMPSucheNumerischerWert?,
      modell: CIMPSucheString?,
      art: CIMPSucheKatalogWert?,
      pedelec: CIMPSucheKatalogWert?
  ) : this() {
    this.rahmennummer = rahmennummer
    this.codenummer = codenummer
    this.radgroesseInZoll = radgroesseInZoll
    this.modell = modell
    this.art = art
    this.pedelec = pedelec
  }
}
