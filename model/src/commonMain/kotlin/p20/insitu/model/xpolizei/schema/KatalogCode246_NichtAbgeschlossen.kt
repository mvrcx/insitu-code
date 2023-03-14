package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode246_NichtAbgeschlossen() {
  public var katalog: KatalogCode246? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode246?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
