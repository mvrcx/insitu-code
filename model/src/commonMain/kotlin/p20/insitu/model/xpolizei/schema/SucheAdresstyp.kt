package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheAdresstyp() {
  public var postfach: SuchePostfach? = null

  public var packstation: SuchePackstation? = null

  public var lage_Postanschrift: SucheLage_Postanschrift? = null

  public constructor(
      postfach: SuchePostfach?,
      packstation: SuchePackstation?,
      lage_Postanschrift: SucheLage_Postanschrift?
  ) : this() {
    this.postfach = postfach
    this.packstation = packstation
    this.lage_Postanschrift = lage_Postanschrift
  }
}
