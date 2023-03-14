package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode203_NichtAbgeschlossen() {
  public var katalog: KatalogCode203? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode203?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
