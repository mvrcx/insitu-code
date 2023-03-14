package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode279_NichtAbgeschlossen() {
  public var katalog: KatalogCode279? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode279?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
