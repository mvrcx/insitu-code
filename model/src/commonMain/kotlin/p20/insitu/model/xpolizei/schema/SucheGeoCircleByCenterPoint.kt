package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

@Serializable
public open class SucheGeoCircleByCenterPoint() {
  public var mittelpunkt: SucheGeoPoint? = null

  public var radius: SucheGeoRadius? = null

  public constructor(mittelpunkt: SucheGeoPoint?, radius: SucheGeoRadius?) : this() {
    this.mittelpunkt = mittelpunkt
    this.radius = radius
  }
}
