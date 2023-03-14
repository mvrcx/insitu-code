package p20.insitu.model.xpolizei.schema

import kotlin.Float
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class CIMPTreffergueteBewertung() {
  public var minimaleGuete: Float? = 0.0f

  public var maximaleGuete: Float? = 0.0f

  public var algorithmus: String? = null

  public constructor(
    minimaleGuete: Float?,
    maximaleGuete: Float?,
    algorithmus: String?
  ) : this() {
    this.minimaleGuete = minimaleGuete
    this.maximaleGuete = maximaleGuete
    this.algorithmus = algorithmus
  }
}
