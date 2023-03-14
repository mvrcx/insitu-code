package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode322_NichtAbgeschlossen() {
  public var katalog: KatalogCode322? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode322?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
