package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Unter einem explosionsgefährlichen Stoff versteht man einen chemischen Stoff oder eine Mischung
 * chemischer Stoffe, die unter Einwirkung bestimmter äußerer Einflüsse zu einer chemischen Reaktion
 * gelangen, bei der eine große Energiemenge in Form einer Druckwelle und / oder Hitze freigesetzt
 * wird.
 */
@Serializable
public open class ExplosionsgefaehrlicherStoff() : Waffe() {
  /**
   * Angabe der Art des explosionsgefährlichen Stoffes.
   */
  public var art: KatalogCode307? = null

  /**
   * Pyrotechnische Gegenstände der Klassen I, II, III, T1 und T2 unterliegen der Zulassungspflicht
   * durch die Bundesanstalt für Materialforschung und -prüfung (BAM). Nach erfolgreichem Abschluss des
   * Zulassungsverfahrens erteilt die BAM ein Zulassungszeichen, mit dem der pyrotechnische Gegenstand
   * eindeutig identifiziert werden kann. Das Zulassungszeichen muss auf jedem zugelassenen
   * pyrotechnischen Gegenstand aufgedruckt sein.
   *  
   * Das Zulassungszeichen besteht aus der Kurzbezeichnung der Bundesanstalt für Materialforschung
   * und -prüfung 'BAM' gefolgt von einem Bindestrich, gefolgt von dem für die jeweilige Klasse
   * vorgesehenen Zeichen, gefolgt von einem Bindestrich, gefolgt von einer fortlaufenden Kennnummer.
   *  
   * Beispiele für Zulassungszeichen:
   *  
   * Klasse I: BAM - PI - 0470
   * Klasse II: BAM - PII - 0225
   * Klasse III: BAM - PIII - 0211
   * Klasse T1: BAM - PT1 - 0931
   * Klasse T2: BAM - PT2 - 0440
   *  
   * Die BAM gibt regelmäßig aktualisierte Listen heraus, auf denen die zugelassenen pyrotechnischen
   * Gegenstände nach Zulassungszeichen (bzw. fortlaufender Nummer im Zulassungszeichen) aufgeführt
   * sind und aus denen ersichtlich ist, ob die Zulassung noch gültig oder bereits erloschen ist.
   */
  public var bAMZulassungszeichen: String? = null

  /**
   * Angabe über die Art der Laborierung.
   */
  public var laborierung: KatalogCode301? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Angabe zum Volumen des explosionsgefährlichen Stoffes.
   */
  public var volumen: Volumen? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob die jeweilige Waffe einer Erlaubnispflicht zum Besitz
   * unterliegt oder nicht.
   */
  public var erlaubnispflicht: KatalogCode214? = null

  public constructor(
      art: KatalogCode307?,
      bAMZulassungszeichen: String?,
      laborierung: KatalogCode301?,
      herstellungsinformation: Herstellungsinformation?,
      volumen: Volumen?,
      erlaubnispflicht: KatalogCode214?
  ) : this() {
    this.art = art
    this.bAMZulassungszeichen = bAMZulassungszeichen
    this.laborierung = laborierung
    this.herstellungsinformation = herstellungsinformation
    this.volumen = volumen
    this.erlaubnispflicht = erlaubnispflicht
  }
}
