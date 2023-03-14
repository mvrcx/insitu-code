package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public enum class CIMPPagingType(
  private val type: String
) {
  STATUSBEHAFTETESPAGING("statusbehaftetesPaging"),
  STATUSLOSESPAGING("statuslosesPaging"),
  ;

  public override fun toString(): String = type
}
