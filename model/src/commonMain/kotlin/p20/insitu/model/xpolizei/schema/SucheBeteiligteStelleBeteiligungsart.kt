package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeteiligteStelleBeteiligungsart() : SucheBeteiligteStelle() {
  public var artDerBeteiligung: CIMPSucheKatalogWert? = null

  public var von: SucheDatumZeit? = null

  public var bis: SucheDatumZeit? = null

  public constructor(
      artDerBeteiligung: CIMPSucheKatalogWert?,
      von: SucheDatumZeit?,
      bis: SucheDatumZeit?
  ) : this() {
    this.artDerBeteiligung = artDerBeteiligung
    this.von = von
    this.bis = bis
  }
}
