package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode115_NichtAbgeschlossen() {
  public var katalog: KatalogCode115? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode115?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
