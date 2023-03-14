package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

/**
 * Container der Quittung
 */
@Serializable
public open class CIMPQuittungType() {
  /**
   * Nachrichten bezogene Quittung
   */
  public var nachrichtenBezogeneQuittung: CIMPQuittungBasisType? = null

  /**
   * Das Ziel-System liefert in den datenbezogenen Quittungen jedoch die Abbildung der Objekt-IDs
   * (und der Quell-ID) aus den Daten der Einfügeoperation auf die Ziel-IDs an das Quell-System zurück
   */
  public var datenBezogeneQuittung: List<CIMPDatenQuittungType>? = null

  public constructor(nachrichtenBezogeneQuittung: CIMPQuittungBasisType?,
                     datenBezogeneQuittung: List<CIMPDatenQuittungType>?) : this() {
    this.nachrichtenBezogeneQuittung = nachrichtenBezogeneQuittung
    this.datenBezogeneQuittung = datenBezogeneQuittung
  }
}
