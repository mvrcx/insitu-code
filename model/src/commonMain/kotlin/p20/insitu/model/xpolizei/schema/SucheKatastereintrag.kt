package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheKatastereintrag() {
  public var gemarkung: CIMPSucheString? = null

  public var flurstueck: CIMPSucheString? = null

  public var flurnummer: CIMPSucheString? = null

  public var gewanne: CIMPSucheString? = null

  public var katasteramt: SucheBeteiligteStelle? = null

  public constructor(
      gemarkung: CIMPSucheString?,
      flurstueck: CIMPSucheString?,
      flurnummer: CIMPSucheString?,
      gewanne: CIMPSucheString?,
      katasteramt: SucheBeteiligteStelle?
  ) : this() {
    this.gemarkung = gemarkung
    this.flurstueck = flurstueck
    this.flurnummer = flurnummer
    this.gewanne = gewanne
    this.katasteramt = katasteramt
  }
}
