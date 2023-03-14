package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public enum class CIMPFehlerKategorie(
  private val type: String
) {
  BACKEND("Backend"),
  BERECHTIGUNG("Berechtigung"),
  DATEN("Daten"),
  FACHLICH("Fachlich"),
  UEBERTRAGUNG("Uebertragung"),
  ;

  public override fun toString(): String = type
}
