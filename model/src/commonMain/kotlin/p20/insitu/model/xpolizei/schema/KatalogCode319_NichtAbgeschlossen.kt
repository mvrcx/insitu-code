package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode319_NichtAbgeschlossen() {
  public var katalog: KatalogCode319? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode319?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
