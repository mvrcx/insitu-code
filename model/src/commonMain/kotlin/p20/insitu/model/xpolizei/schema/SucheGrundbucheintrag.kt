package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGrundbucheintrag() {
  public var grundbuchnummer: CIMPSucheString? = null

  public var grundbuchamt: SucheBeteiligteStelle? = null

  public constructor(grundbuchnummer: CIMPSucheString?, grundbuchamt: SucheBeteiligteStelle?) :
      this() {
    this.grundbuchnummer = grundbuchnummer
    this.grundbuchamt = grundbuchamt
  }
}
