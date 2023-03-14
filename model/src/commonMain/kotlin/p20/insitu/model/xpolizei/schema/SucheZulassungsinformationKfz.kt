package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheZulassungsinformationKfz() {
  public var mietfahrzeug: CIMPSucheKatalogWert? = null

  public var gueltigBis: CIMPSucheDatum? = null

  public var gueltigVon: CIMPSucheDatum? = null

  public var zulassungsstelle: SucheBeteiligteStelle? = null

  public var kfzKennzeicheninformation: SucheKfzKennzeicheninformation? = null

  public constructor(
      mietfahrzeug: CIMPSucheKatalogWert?,
      gueltigBis: CIMPSucheDatum?,
      gueltigVon: CIMPSucheDatum?,
      zulassungsstelle: SucheBeteiligteStelle?,
      kfzKennzeicheninformation: SucheKfzKennzeicheninformation?
  ) : this() {
    this.mietfahrzeug = mietfahrzeug
    this.gueltigBis = gueltigBis
    this.gueltigVon = gueltigVon
    this.zulassungsstelle = zulassungsstelle
    this.kfzKennzeicheninformation = kfzKennzeicheninformation
  }
}
