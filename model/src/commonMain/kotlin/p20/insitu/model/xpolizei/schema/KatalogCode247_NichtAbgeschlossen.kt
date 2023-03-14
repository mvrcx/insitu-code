package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode247_NichtAbgeschlossen() {
  public var katalog: KatalogCode247? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode247?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
