package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheFahrzeugfarbe() {
  public var farbangabe: List<SucheFarbangabe>? = null

  public var bis: CIMPSucheDatum? = null

  public var von: CIMPSucheDatum? = null

  public constructor(
      farbangabe: List<SucheFarbangabe>?,
      bis: CIMPSucheDatum?,
      von: CIMPSucheDatum?
  ) : this() {
    this.farbangabe = farbangabe
    this.bis = bis
    this.von = von
  }
}
