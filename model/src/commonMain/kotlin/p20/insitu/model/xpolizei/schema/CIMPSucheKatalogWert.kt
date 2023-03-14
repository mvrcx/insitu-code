package p20.insitu.model.xpolizei.schema

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPSucheKatalogWert() {
  public var name: String? = null

  public var nichtGelisteterWert: String? = null

  public var code: String? = null

  public var hierarchischeSuche: CIMPHierarchischeSuche? = null

  public var istLeer: Boolean? = true

  public constructor(
      name: String?,
      nichtGelisteterWert: String?,
      code: String?,
      hierarchischeSuche: CIMPHierarchischeSuche?,
      istLeer: Boolean?
  ) : this() {
    this.name = name
    this.nichtGelisteterWert = nichtGelisteterWert
    this.code = code
    this.hierarchischeSuche = hierarchischeSuche
    this.istLeer = istLeer
  }
}
