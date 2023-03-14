package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Spreng- und / oder Brandvorrichtungen sind gewerbliche, militärische oder selbst hergestellte
 * Vorrichtungen, die eine Explosion und / oder einen Brand herbeiführen können.
 *  
 * Flugkörperbaugruppen wie das Triebwerk etc. sind in der Anlage § 1 Abs.1 zum KrWaffKontrG
 * enthalten und damit ebenfalls Bestandteil dieses Fachobjekts.
 */
@Serializable
public open class Sprengvorrichtung_Brandvorrichtung() : Waffe() {
  /**
   * Kategorisierung der Spreng- / Brandvorrichtung in die Bereiche:
   * - Brandvorrichtung
   * - Sprengvorrichtung
   * - Spreng- und Brandvorrichtung
   * - Pyrotechnischer Gegenstand
   */
  public var kategorie: KatalogCode302? = null

  /**
   * Angabe über die Art der Spreng- / Brandvorrichtung.
   */
  public var art: KatalogCode300? = null

  /**
   * Angabe, ob es sich um eine Attrappe handelt.
   */
  public var attrappe: KatalogCode217? = null

  /**
   * Angabe über die Art der Laborierung.
   */
  public var laborierung: KatalogCode301? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob die jeweilige Waffe einer Erlaubnispflicht zum Besitz
   * unterliegt oder nicht.
   */
  public var erlaubnispflicht: KatalogCode214? = null

  public constructor(
      kategorie: KatalogCode302?,
      art: KatalogCode300?,
      attrappe: KatalogCode217?,
      laborierung: KatalogCode301?,
      herstellungsinformation: Herstellungsinformation?,
      erlaubnispflicht: KatalogCode214?
  ) : this() {
    this.kategorie = kategorie
    this.art = art
    this.attrappe = attrappe
    this.laborierung = laborierung
    this.herstellungsinformation = herstellungsinformation
    this.erlaubnispflicht = erlaubnispflicht
  }
}
