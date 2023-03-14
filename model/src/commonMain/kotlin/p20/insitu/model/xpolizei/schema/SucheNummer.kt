package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheNummer() {
  public var bezeichnung: CIMPSucheString? = null

  public var nummernwert: CIMPSucheString? = null

  public var behoerde: SucheBeteiligteStelle? = null

  public constructor(
      bezeichnung: CIMPSucheString?,
      nummernwert: CIMPSucheString?,
      behoerde: SucheBeteiligteStelle?
  ) : this() {
    this.bezeichnung = bezeichnung
    this.nummernwert = nummernwert
    this.behoerde = behoerde
  }
}
