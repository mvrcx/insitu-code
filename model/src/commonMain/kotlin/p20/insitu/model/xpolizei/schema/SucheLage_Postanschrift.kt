package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheLage_Postanschrift() {
  public var anschrift: SucheAnschrift? = null

  public var verkehrsweg: SucheVerkehrsweg? = null

  public var katastereintrag: List<SucheKatastereintrag>? = null

  public constructor(
      anschrift: SucheAnschrift?,
      verkehrsweg: SucheVerkehrsweg?,
      katastereintrag: List<SucheKatastereintrag>?
  ) : this() {
    this.anschrift = anschrift
    this.verkehrsweg = verkehrsweg
    this.katastereintrag = katastereintrag
  }
}
