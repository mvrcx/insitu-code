package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class KatalogCode383_MitZusatz_NichtAbgeschlossen() {
  public var katalog: KatalogCode383_MitZusatz? = null

  public var nichtGelisteterWert: String? = null

  public constructor(katalog: KatalogCode383_MitZusatz?, nichtGelisteterWert: String?) : this() {
    this.katalog = katalog
    this.nichtGelisteterWert = nichtGelisteterWert
  }
}
