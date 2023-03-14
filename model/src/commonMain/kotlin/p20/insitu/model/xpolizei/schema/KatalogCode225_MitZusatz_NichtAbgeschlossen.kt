package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode225_MitZusatz_NichtAbgeschlossen() {
  public var katalog: KatalogCode225_MitZusatz? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode225_MitZusatz?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
