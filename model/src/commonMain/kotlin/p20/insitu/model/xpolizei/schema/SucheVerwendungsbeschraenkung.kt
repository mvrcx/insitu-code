package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheVerwendungsbeschraenkung() {
  public var datenschutzklausel: List<CIMPSucheKatalogWert>? = null

  public var europolHandlingcode: List<CIMPSucheKatalogWert>? = null

  public constructor(datenschutzklausel: List<CIMPSucheKatalogWert>?,
                     europolHandlingcode: List<CIMPSucheKatalogWert>?) : this() {
    this.datenschutzklausel = datenschutzklausel
    this.europolHandlingcode = europolHandlingcode
  }
}
