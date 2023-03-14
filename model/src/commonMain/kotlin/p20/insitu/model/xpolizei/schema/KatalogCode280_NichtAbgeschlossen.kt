package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode280_NichtAbgeschlossen() {
  public var katalog: KatalogCode280? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode280?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
