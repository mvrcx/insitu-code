package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheRegistereintrag() {
  public var nummer: CIMPSucheString? = null

  public var eintragsdatum: CIMPSucheDatum? = null

  public var austragsdatum: CIMPSucheDatum? = null

  public var stammkapital_Grundkapital: SucheGeldbetrag? = null

  public var behoerde: SucheBeteiligteStelle? = null

  public constructor(
      nummer: CIMPSucheString?,
      eintragsdatum: CIMPSucheDatum?,
      austragsdatum: CIMPSucheDatum?,
      stammkapital_Grundkapital: SucheGeldbetrag?,
      behoerde: SucheBeteiligteStelle?
  ) : this() {
    this.nummer = nummer
    this.eintragsdatum = eintragsdatum
    this.austragsdatum = austragsdatum
    this.stammkapital_Grundkapital = stammkapital_Grundkapital
    this.behoerde = behoerde
  }
}
