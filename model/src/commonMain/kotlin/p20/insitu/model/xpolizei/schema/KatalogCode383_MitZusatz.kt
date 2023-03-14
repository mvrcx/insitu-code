package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode383_MitZusatz() {
  public var katalog: KatalogCode383? = null

  public var zusatz: String? = null

  public constructor(katalog: KatalogCode383?, zusatz: String?) : this() {
    this.katalog = katalog
    this.zusatz = zusatz
  }
}
