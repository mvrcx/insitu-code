package p20.insitu.model.xpolizei.schema

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Ordnungswidrigkeiten und Personen.
 */
@Serializable
public open class Beziehung_Ordnungswidrigkeit_Person() : Beziehung() {
  /**
   * Hier wird das Aussonderungsprüfdatum gemäß Datenschutzregelung des jeweiligen Gesetzes
   * abgebildet. Dieses kann verändert werden, aufgrund Verlängerung oder Verkürzung der Frist und wird
   * dann überschrieben.
   */
  public var aussonderungspruefdatum: LocalDate? = null

  public var alkoholeinfluss: Alkoholeinfluss? = null

  public var btMeinfluss: BtMeinfluss? = null

  public constructor(
      aussonderungspruefdatum: LocalDate?,
      alkoholeinfluss: Alkoholeinfluss?,
      btMeinfluss: BtMeinfluss?
  ) : this() {
    this.aussonderungspruefdatum = aussonderungspruefdatum
    this.alkoholeinfluss = alkoholeinfluss
    this.btMeinfluss = btMeinfluss
  }
}
