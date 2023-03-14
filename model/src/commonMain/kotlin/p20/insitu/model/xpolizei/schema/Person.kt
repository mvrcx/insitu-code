package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Das Fachobjekt wird verwendet, um verschiedene Personalien, Personenbeschreibungen und
 * DNA_Blut-Merkmale einer Person abbilden zu können.
 */
@Serializable
public open class Person() : Person_Leer() {
  public var redundanzinformation: Redundanzinformation? = null

  public constructor(redundanzinformation: Redundanzinformation?) : this() {
    this.redundanzinformation = redundanzinformation
  }
}
