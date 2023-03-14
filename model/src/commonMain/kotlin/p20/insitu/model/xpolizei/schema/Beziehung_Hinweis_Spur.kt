package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Abbildung von Zusammenhängen zwischen einem Hinweis und den Personen, Organisationen,
 * Örtlichkeiten, Sachen und Ereignissen, die Gegenstand eines Hinweises sein können (Spur).
 */
@Serializable
public open class Beziehung_Hinweis_Spur() : Beziehung() {
  /**
   * Die Spurennummer ist bis zum Schrägstrich siebenstellig numerisch.
   * Die ersten beiden Stellen der insgesamt siebenstelligen Spurnummer werden für den numerischen
   * Länderschlüssel benutzt (Quelle SPUDOK Handbuch).
   *  
   * Beispiele:
   * SPU:2100123/-- (Länderschlüssel 21 BKA Meckenheim)
   * SPU:0200456/-- (Länderschlüssel 02 LKA Hamburg)
   * SPU:9900789/-- (Sonderkommission bzw. Einsatzort)
   *  
   * Hinter dem Schrägstrich werden die zum Spurengrunddatensatz dazu gehörenden Folgedatensätze
   * laufend nummeriert, z. B. 2100123/01.
   *  
   * VERZEICHNIS DER NUMERISCHEN LÄNDERSCHLÜSSEL GEM. INPOL: 
   * 01 = Schleswig-Holstein
   * 02 = Hamburg
   * 03 = Niedersachsen
   * 04 = Bremen
   * 05 = Nordrhein-Westfalen
   * 06 = Hessen
   * 07 = Rheinland-Pfalz
   * 08 = Baden-Württemberg
   * 09 = Bayern
   * 10 = Saarland
   * 11 = Berlin
   * 12 = Brandenburg
   * 13 = Mecklenburg-Vorpommern
   * 14 = Sachsen
   * 15 = Sachsen-Anhalt
   * 16 = Thüringen
   * 20 =
   * 21 = BKA Abteilung ST
   * 23 = BKA Berlin SG
   * 25 =
   * 27 =
   * 30 = Bundespolizei
   * 31 = ZF – Zollkriminalamt
   * 99 = SOKO – Sonderkommission
   */
  public var spurennummer: String? = null

  public constructor(spurennummer: String?) : this() {
    this.spurennummer = spurennummer
  }
}
