package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode269_NichtAbgeschlossen() {
  public var katalog: KatalogCode269? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode269?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
