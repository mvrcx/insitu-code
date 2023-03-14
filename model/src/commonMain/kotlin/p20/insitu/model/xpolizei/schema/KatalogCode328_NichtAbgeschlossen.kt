package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode328_NichtAbgeschlossen() {
  public var katalog: KatalogCode328? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode328?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
