package p20.insitu.model.xpolizei.schema

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * AKK zur Abbildung von Redundanzinformationen.
 */
@Serializable
public open class Redundanzinformation() {
  public var teilnehmeranker: Teilnehmeranker? = null

  public var verbundanker: Verbundanker? = null

  /**
   * In diesem Feld erfolgt die Kenntlichmachung eines zusätzlichen Informationsbedarfs am
   * redundanten Fachobjekt.
   *
   * Es ist das Datum anzugeben, ab dem das Fachobjekt zum 'Objekt besonderen Interesses' (ObI)
   * wird.
   */
  public var obIGueltigAb: LocalDate? = null

  public constructor(
      teilnehmeranker: Teilnehmeranker?,
      verbundanker: Verbundanker?,
      obIGueltigAb: LocalDate?
  ) : this() {
    this.teilnehmeranker = teilnehmeranker
    this.verbundanker = verbundanker
    this.obIGueltigAb = obIGueltigAb
  }
}
