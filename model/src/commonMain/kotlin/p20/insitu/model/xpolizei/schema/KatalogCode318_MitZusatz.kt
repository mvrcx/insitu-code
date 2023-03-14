package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode318_MitZusatz() {
  public var katalog: KatalogCode318? = null

  public var zusatz: String? = null

  public constructor(katalog: KatalogCode318?, zusatz: String?) : this() {
    this.katalog = katalog
    this.zusatz = zusatz
  }
}
