package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public enum class CIMPErgebnisArt(
  private val type: String
) {
  ANZAHL("Anzahl"),
  REDUZIERT("Reduziert"),
  VOLLSTAENDIG("Vollstaendig"),
  ;

  public override fun toString(): String = type
}
