package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung_Ordnungswidrigkeit_Person() : SucheBeziehung() {
  public var aussonderungspruefdatum: CIMPSucheDatum? = null

  public var alkoholeinfluss: SucheAlkoholeinfluss? = null

  public var btMeinfluss: SucheBtMeinfluss? = null

  public constructor(
      aussonderungspruefdatum: CIMPSucheDatum?,
      alkoholeinfluss: SucheAlkoholeinfluss?,
      btMeinfluss: SucheBtMeinfluss?
  ) : this() {
    this.aussonderungspruefdatum = aussonderungspruefdatum
    this.alkoholeinfluss = alkoholeinfluss
    this.btMeinfluss = btMeinfluss
  }
}
