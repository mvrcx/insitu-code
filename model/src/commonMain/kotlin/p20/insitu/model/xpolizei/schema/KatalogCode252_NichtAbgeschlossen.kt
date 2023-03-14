package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode252_NichtAbgeschlossen() {
  public var katalog: KatalogCode252? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode252?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
