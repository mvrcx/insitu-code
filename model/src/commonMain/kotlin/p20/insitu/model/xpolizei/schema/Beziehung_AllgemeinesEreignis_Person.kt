package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen allgemeinen Ereignissen und Personen.
 */
@Serializable
public open class Beziehung_AllgemeinesEreignis_Person() : Beziehung() {
  /**
   * Dieses Feld enthält Angaben über das Alter der Person (in ganzen Jahren) zur Ereigniszeit.
   * Zulässig sind die Werte von 0 bis 150.
   */
  public var alterZurEreigniszeit: Int? = null

  public constructor(alterZurEreigniszeit: Int?) : this() {
    this.alterZurEreigniszeit = alterZurEreigniszeit
  }
}
