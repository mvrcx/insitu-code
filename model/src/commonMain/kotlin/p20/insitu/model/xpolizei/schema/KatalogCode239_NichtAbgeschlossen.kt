package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode239_NichtAbgeschlossen() {
  public var katalog: KatalogCode239? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode239?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
