package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode225_MitZusatz() {
  public var katalog: KatalogCode225? = null

  public var zusatz: String? = null

  public constructor(katalog: KatalogCode225?, zusatz: String?) : this() {
    this.katalog = katalog
    this.zusatz = zusatz
  }
}
