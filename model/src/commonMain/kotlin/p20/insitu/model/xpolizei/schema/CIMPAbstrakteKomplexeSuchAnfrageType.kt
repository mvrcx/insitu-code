package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Container für AbstrakteKomplexeSuchAnfrage
 */
@Serializable
public open class CIMPAbstrakteKomplexeSuchAnfrageType() {
  /**
   * Standard Nachrichtenkopf
   */
  public var nachrichtenkopf: CIMPNachrichtenKopf? = null

  /**
   * Die Art des Ergebnisses
   */
  public var artErgebnis: CIMPErgebnisArt? = null

  /**
   * Maximale Anzahl
   */
  public var maxAnzahl: Int? = 0

  /**
   * Maximale Anzahl pro Seite
   */
  public var maxAnzahlSeite: Int? = 0

  /**
   * Auswahlliste mit den Werten:
   * • statuslosesPaging
   * • statusbehaftetesPaging
   * Wird das Element Paging nicht übertragen bedeutet dies, dass kein Paging erwünscht ist
   */
  public var paging: CIMPPagingType? = null

  public var treffergueteBewertung: CIMPTreffergueteBewertung? = null

  public constructor(
      nachrichtenkopf: CIMPNachrichtenKopf?,
      artErgebnis: CIMPErgebnisArt?,
      maxAnzahl: Int?,
      maxAnzahlSeite: Int?,
      paging: CIMPPagingType?,
      treffergueteBewertung: CIMPTreffergueteBewertung?
  ) : this() {
    this.nachrichtenkopf = nachrichtenkopf
    this.artErgebnis = artErgebnis
    this.maxAnzahl = maxAnzahl
    this.maxAnzahlSeite = maxAnzahlSeite
    this.paging = paging
    this.treffergueteBewertung = treffergueteBewertung
  }
}
