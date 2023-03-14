package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Maximale Anzahl an Objekten, die das Ergebnis beinhalten darf
 */
@Serializable
public open class CIMPLesenAnfrageType() {
  public var nachrichtenkopf: CIMPNachrichtenKopf? = null

  public var artErgebnis: CIMPErgebnisArt? = null

  /**
   * Maximale Anzahl an Objekten, die das Ergebnis beinhalten darf
   */
  public var maxAnzahl: Int? = 0

  /**
   * Maximale Anzahl an Objekten, die auf einer Seite dargestellt werden dürfen.
   */
  public var maxAnzahlSeite: Int? = 0

  /**
   * Auswahlliste mit den Werten:
   * - statuslosesPaging
   * - statusbehaftetesPaging
   *
   * Wird as Element Paging nicht übertragen bedeutet dies, dass kein Paging erwünscht ist.
   */
  public var paging: CIMPPagingType? = null

  public constructor(
      nachrichtenkopf: CIMPNachrichtenKopf?,
      artErgebnis: CIMPErgebnisArt?,
      maxAnzahl: Int?,
      maxAnzahlSeite: Int?,
      paging: CIMPPagingType?
  ) : this() {
    this.nachrichtenkopf = nachrichtenkopf
    this.artErgebnis = artErgebnis
    this.maxAnzahl = maxAnzahl
    this.maxAnzahlSeite = maxAnzahlSeite
    this.paging = paging
  }
}
