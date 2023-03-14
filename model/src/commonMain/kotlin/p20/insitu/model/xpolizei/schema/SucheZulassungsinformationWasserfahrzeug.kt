package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheZulassungsinformationWasserfahrzeug() {
  public var kennzeichen: CIMPSucheString? = null

  public var kennzeichenArt: CIMPSucheKatalogWert? = null

  public var unterscheidungssignal: CIMPSucheString? = null

  public var gueltigVon: CIMPSucheDatum? = null

  public var gueltigBis: CIMPSucheDatum? = null

  public var zulassungsstelle: SucheBeteiligteStelle? = null

  public var art: CIMPSucheKatalogWert? = null

  public constructor(
      kennzeichen: CIMPSucheString?,
      kennzeichenArt: CIMPSucheKatalogWert?,
      unterscheidungssignal: CIMPSucheString?,
      gueltigVon: CIMPSucheDatum?,
      gueltigBis: CIMPSucheDatum?,
      zulassungsstelle: SucheBeteiligteStelle?,
      art: CIMPSucheKatalogWert?
  ) : this() {
    this.kennzeichen = kennzeichen
    this.kennzeichenArt = kennzeichenArt
    this.unterscheidungssignal = unterscheidungssignal
    this.gueltigVon = gueltigVon
    this.gueltigBis = gueltigBis
    this.zulassungsstelle = zulassungsstelle
    this.art = art
  }
}
