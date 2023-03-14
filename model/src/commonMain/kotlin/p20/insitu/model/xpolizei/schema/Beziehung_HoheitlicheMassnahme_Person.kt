package p20.insitu.model.xpolizei.schema

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * Abbildung von Beziehungen zwischen Maßnahmen und Personen.
 */
@Serializable
public open class Beziehung_HoheitlicheMassnahme_Person() : Beziehung() {
  /**
   * Hier wird das Aussonderungsprüfdatum gemäß Datenschutzregelung des jeweiligen Gesetzes
   * abgebildet. Dieses kann verändert werden, aufgrund Verlängerung oder Verkürzung der Frist, und
   * wird dann überschrieben.
   */
  public var aussonderungspruefdatum: LocalDate? = null

  /**
   * KK zur Abbildung von datenschutzrechtlichen Status einer Person.
   */
  public var dSStatus: DatenschutzrechtlicherStatus? = null

  /**
   * Dieses Feld enthält Angaben über die Gefährdungsstufe einer Person.
   */
  public var gefaehrdungsstufe: KatalogCode403? = null

  public constructor(
      aussonderungspruefdatum: LocalDate?,
      dSStatus: DatenschutzrechtlicherStatus?,
      gefaehrdungsstufe: KatalogCode403?
  ) : this() {
    this.aussonderungspruefdatum = aussonderungspruefdatum
    this.dSStatus = dSStatus
    this.gefaehrdungsstufe = gefaehrdungsstufe
  }
}
