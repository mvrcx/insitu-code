package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode223_NichtAbgeschlossen() {
  public var katalog: KatalogCode223? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode223?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
