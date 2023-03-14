package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public enum class CIMPFehlerKlasse(
  private val type: String
) {
  FATAL("Fatal"),
  FEHLER("Fehler"),
  INFO("Info"),
  KRITISCH("Kritisch"),
  OK("OK"),
  WARNUNG("Warnung"),
  ;

  public override fun toString(): String = type
}
