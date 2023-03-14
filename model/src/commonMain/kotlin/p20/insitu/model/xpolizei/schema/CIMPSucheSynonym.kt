package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheSynonym() {
  public var text: CIMPNormierterSuchString? = null

  public var thesaurus: String? = null

  public constructor(text: CIMPNormierterSuchString?, thesaurus: String?) : this() {
    this.text = text
    this.thesaurus = thesaurus
  }
}
