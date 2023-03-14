package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheKfzKennzeicheninformation() {
  public var kennzeichenArt: CIMPSucheKatalogWert? = null

  public var kennzeichen: CIMPSucheString? = null

  public var nationalitaet: CIMPSucheKatalogWert? = null

  public var beginnMonatSaisonkennzeichen: CIMPSucheMonat? = null

  public var endeMonatSaisonkennzeichen: CIMPSucheMonat? = null

  public constructor(
      kennzeichenArt: CIMPSucheKatalogWert?,
      kennzeichen: CIMPSucheString?,
      nationalitaet: CIMPSucheKatalogWert?,
      beginnMonatSaisonkennzeichen: CIMPSucheMonat?,
      endeMonatSaisonkennzeichen: CIMPSucheMonat?
  ) : this() {
    this.kennzeichenArt = kennzeichenArt
    this.kennzeichen = kennzeichen
    this.nationalitaet = nationalitaet
    this.beginnMonatSaisonkennzeichen = beginnMonatSaisonkennzeichen
    this.endeMonatSaisonkennzeichen = endeMonatSaisonkennzeichen
  }
}
