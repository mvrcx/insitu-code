package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Container für QuittungBasis
 */
@Serializable
public open class CIMPQuittungBasisType() {
  public var klasse: CIMPFehlerKlasse? = null

  public var kategorie: CIMPFehlerKategorie? = null

  public var code: String? = null

  /**
   * Freitext
   */
  public var freiText: String? = null

  public constructor(
      klasse: CIMPFehlerKlasse?,
      kategorie: CIMPFehlerKategorie?,
      code: String?,
      freiText: String?
  ) : this() {
    this.klasse = klasse
    this.kategorie = kategorie
    this.code = code
    this.freiText = freiText
  }
}
