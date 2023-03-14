package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Tragbarer Gegenstand:
 *  
 * Tragbarer Gegenstand nach § 1 Absatz 2 Nr. 2 (siehe Anlage 1, Abschnitt 1, UA 2 'Tragbare
 * Gegenstände' zum WaffG):
 *  
 * Gegenstände, die ihrem Wesen nach dazu bestimmt sind, die Angriffs- oder Abwehrfähigkeit von
 * Menschen zu beseitigen oder herabzusetzen, insbesondere Hieb- und Stoßwaffen.
 *  
 * Gegenstände, die – ohne dazu bestimmt zu sein - insbesondere wegen ihrer Beschaffenheit,
 * Handhabung oder Wirkweise geeignet sind, Abwehrfähigkeit von Menschen zu beseitigen oder
 * herabzusetzen und im WaffG benannt sind.
 *  
 * Schusswaffe gleichstehender tragbarer Gegenstand:
 *  
 * Gegenstände die zum Abschießen von Munition zum Zwecke des Angriffs oder der Verteidigung,
 * Signalgebung, Jagd, Distanzinjektion, Markierung, des Sports oder Spiels bestimmt sind.
 *  
 * Den Schusswaffen gleichstehende tragbare Gegenstände, die zum Abschießen von Munition bestimmt
 * sind, bei denen bestimmungsgemäß feste Körper gezielt verschossen werden, deren Antriebsenergie
 * durch Muskelkraft eingebracht und durch eine Sperrvorrichtung gespeichert werden kann (z. B.
 * Armbrust), siehe Anlage 1 zum WaffG (zu § 1 Abs.4 Nr. 1.2-1.6).
 */
@Serializable
public open class TragbarerGegenstand() : Waffe() {
  /**
   * Angaben zur Art des tragbaren Gegenstandes.
   *  
   * Beispiele: Hieb- / Stichwaffe, Bogenwaffe, Dolch, Armbrust, etc.
   */
  public var art: KatalogCode293? = null

  public var herstellungsinformation: Herstellungsinformation? = null

  /**
   * Dieses Feld enthält Angaben darüber, ob die jeweilige Waffe einer Erlaubnispflicht zum Besitz
   * unterliegt oder nicht.
   */
  public var erlaubnispflicht: KatalogCode214? = null

  public constructor(
      art: KatalogCode293?,
      herstellungsinformation: Herstellungsinformation?,
      erlaubnispflicht: KatalogCode214?
  ) : this() {
    this.art = art
    this.herstellungsinformation = herstellungsinformation
    this.erlaubnispflicht = erlaubnispflicht
  }
}
