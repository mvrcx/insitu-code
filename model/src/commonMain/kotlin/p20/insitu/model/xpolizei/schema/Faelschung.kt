package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Fälschungseigenschaften, z. B. für das Fachobjekt KfzKennzeichenschild, Fahrzeug, SonstigeSache
 * und Waffe.
 */
@Serializable
public open class Faelschung() {
  /**
   * Angabe zur Fälschungsart z. B. einer Sonstigen Sache oder eines Kfz-Kennzeichenschildes.
   *
   * Anmerkung: Fälschungsart 'unbekannt' wird verwendet, wenn eine Fälschung vermutet wird, aber
   * nicht bekannt ist, welche Fälschungsart vorliegt.
   */
  public var art: KatalogCode222? = null

  /**
   * Freitextliche Beschreibung von Fälschungsmerkmalen.
   * Alle Merkmale in einem Eintrag.
   * Beispiel (SonstigeSache): 'Herstellerlogo verwischt/unscharf', 'Andidas' statt 'Adidas' als
   * Beschriftung.
   * Beispiel (KfzKennzeichenschild): 'abweichendes Material', 'abweichender Schrifttyp',
   * 'Farbabweichung'.
   */
  public var merkmale: String? = null

  public constructor(art: KatalogCode222?, merkmale: String?) : this() {
    this.art = art
    this.merkmale = merkmale
  }
}
