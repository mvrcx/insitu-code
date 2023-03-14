package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_PersonalieOrganisation_OrganisationOertlichkeit() :
    SucheBeziehung() {
  public var anteilInProzent: CIMPSucheNumerischerWert? = null

  public var anteilswert: SucheGeldbetrag? = null

  public constructor(anteilInProzent: CIMPSucheNumerischerWert?, anteilswert: SucheGeldbetrag?) :
      this() {
    this.anteilInProzent = anteilInProzent
    this.anteilswert = anteilswert
  }
}
