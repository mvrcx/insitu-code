package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public enum class CIMPHierarchischeSuche(
  private val type: String
) {
  EXAKT("exakt"),
  MITNACHFOLGERN("mitNachfolgern"),
  MITVORGAENGERN("mitVorgaengern"),
  ;

  public override fun toString(): String = type
}
