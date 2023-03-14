package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Das Kataster bzw. Liegenschaftskataster ist die flächendeckende Beschreibung sämtlicher
 * Flurstücke (Parzellen) eines Landes. In einem beschreibenden Teil und in Karten werden die
 * geometrische Lage, die baulichen Anlagen / Liegenschaften, die Art der Nutzung und Größe
 * beschrieben.
 */
@Serializable
public open class Katastereintrag() {
  /**
   * Das Element Gemarkung bezeichnet eine Fläche. Eine Gemarkung ist eine zusammenhängende, aus
   * mehreren Fluren bestehende Fläche des Liegenschaftskatasters. Sie wird nach ihrer Lage benannt, z.
   * B. Wiesbaden, Forstmühler Forst.
   */
  public var gemarkung: String? = null

  /**
   * Ein Flurstück ist die kleinste Buchungseinheit des Liegenschaftskatasters und stellt einen
   * geometrisch eindeutigen Teil der Erdoberfläche dar. Das Flurstück wird mit einer Flurstücksnummer,
   * die aus einer Zahl, einer Kombination von Zahl und Buchstabe oder einer Kombination von Zähler und
   * Nenner besteht, bezeichnet, z. B. 234/34.
   */
  public var flurstueck: String? = null

  /**
   * Eine Flurnummer ist ein Schlüssel zur Identifikation einer Flur. Die Flur ist eine
   * zusammenhängende, aus mehreren Flurstücken bestehende Fläche des Liegenschaftskatasters, z. B.
   * 234.
   */
  public var flurnummer: String? = null

  /**
   * Die Gewanne ist ein Teil einer Flur. Typisch für die Gewanne ist, dass ihre Länge mindestens
   * das Zehnfache der Breite beträgt.
   *
   * Beispiel: Der Plan des Frankfurter Hauptfriedhofs in Gewanne geteilt, z. B. 7.
   */
  public var gewanne: String? = null

  /**
   * Angabe des Katasteramts.
   */
  public var katasteramt: BeteiligteStelle? = null

  public constructor(
    gemarkung: String?,
    flurstueck: String?,
    flurnummer: String?,
    gewanne: String?,
    katasteramt: BeteiligteStelle?
  ) : this() {
    this.gemarkung = gemarkung
    this.flurstueck = flurstueck
    this.flurnummer = flurnummer
    this.gewanne = gewanne
    this.katasteramt = katasteramt
  }
}
