package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSuchePhonetisch() {
  public var text: CIMPNormierterSuchString? = null

  public var phonetik: String? = null

  public constructor(text: CIMPNormierterSuchString?, phonetik: String?) : this() {
    this.text = text
    this.phonetik = phonetik
  }
}
