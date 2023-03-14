package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode387_NichtAbgeschlossen() {
  public var katalog: KatalogCode387? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode387?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
