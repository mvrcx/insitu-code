package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Angabe der hyDaNe-Kategorie sowie ggf. einer Begründung der Abweichung von den Vorgaben.
 */
@Serializable
public open class HyDaNeKennzeichnung() {
  /**
   * Angabe der hyDaNe-Kategorie mit dem Ziel der späteren Vergleichbarkeit.
   */
  public var hyDaNeKategorie: KatalogCode408? = null

  /**
   * Abbildung der freitextlichen Begründung, wenn die vorgeschlagene hyDaNe-Kategorie manuell
   * geändert wurde.
   */
  public var begruendungBeiAbweichung: String? = null

  public constructor(hyDaNeKategorie: KatalogCode408?, begruendungBeiAbweichung: String?) : this() {
    this.hyDaNeKategorie = hyDaNeKategorie
    this.begruendungBeiAbweichung = begruendungBeiAbweichung
  }
}
