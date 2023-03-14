package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode251_NichtAbgeschlossen() {
  public var katalog: KatalogCode251? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode251?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
