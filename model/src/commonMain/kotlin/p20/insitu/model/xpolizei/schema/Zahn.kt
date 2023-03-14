package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Hartgebilde in der Mundhöhle einer Person, die als modifizierte Teile des Hautskeletts in ihrer
 * Gesamtheit das Gebiss bilden.
 */
@Serializable
public open class Zahn() {
  /**
   * Angabe der Zahnnummer nach dem FDI-Zahnschema. Das FDI-Zahnschema ist nach der Fédération
   * Dentaire Internationale (FDI), dem Zahnärzteweltverband bezeichnet, welcher dieses Zahnschema als
   * international gültiges Zahnschema verabschiedet hat.
   *  
   * Bei diesem genormten System wird jeder Zahn durch die Kombination von zwei Ziffern bestimmt.
   * Die erste Ziffer kennzeichnet den Kieferquadranten, die zweite Ziffer verweist auf einen einzelnen
   * Zahn im jeweiligen Quadranten. Die Quadranten-Ziffern werden der Kennziffer des Zahnes
   * vorangestellt. Dabei werden die Quadranten aus Sicht des Patienten gegen den Uhrzeigersinn
   * durchnummeriert. Die Zähne wiederum werden jeweils von der Mitte aus nach hinten durchnummeriert.
   * So wird z. B. der obere rechte Eckzahn mit den Kennziffern '13' bezeichnet.
   *  
   * Da es sich um eine zweiziffrige Kennung und nicht um eine zweistellige Zahl handelt, werden die
   * Ziffern nacheinander genannt und daraus keine Zahl gebildet; es heißt demzufolge 'eins-drei' und
   * nicht 'dreizehn'.
   *  
   * Die Milchzahnquadranten werden entsprechend von 5 bis 8 durchnummeriert, so dass der obere
   * linke seitliche Schneidezahn die Kennziffern '62' (sechs-zwei) erhält.
   *  
   * Analog dem AM-Formular der IDKO werden die Kennziffern des Milchgebisses mit den Kennziffern
   * des Erwachsenengebisses zusammengefasst.
   */
  public var zahnnummer: KatalogCode311? = null

  /**
   * Die Angabe der Abbildung der konkreten Farbe oder Färbung eines einzelnen Zahnes.
   *  
   * Beispiele: schneeweiß, schwarz
   */
  public var zahnfarbe: String? = null

  /**
   * Die Angabe der Bezeichnung des jeweiligen Status eines Zahnes.
   *
   * Beispiele: vorhanden, fehlt
   */
  public var zahnstatus: String? = null

  /**
   * Die Angabe der Beschreibung eines individuellen Zustandes eines Zahnes. Zu einem Zahn können
   * mehrere Zustände beschrieben werden.
   *  
   * Beispiele: Füllung, Inlay
   */
  public var zahnzustand: String? = null

  /**
   * Die Angabe der Beschreibung des bei der Behandlung eines Zahnes verwendeten Materials.
   *
   * Beispiele: Keramik, Amalgam
   */
  public var zahnmaterial: String? = null

  /**
   * Dieses Feld enthält freitextliche Angaben zum Zahn.
   *
   * Beispiele: angebrochen, wurzelbehandelt
   */
  public var zahnBemerkung: String? = null

  /**
   * Dieses Feld enthält Angaben zu Besonderheiten des Zahns.
   *  
   * Beispiele: Zahn-Tattoo, Grillz Zahncaps, Zahn-Schmuck
   */
  public var zahnBesonderheiten: String? = null

  public constructor(
      zahnnummer: KatalogCode311?,
      zahnfarbe: String?,
      zahnstatus: String?,
      zahnzustand: String?,
      zahnmaterial: String?,
      zahnBemerkung: String?,
      zahnBesonderheiten: String?
  ) : this() {
    this.zahnnummer = zahnnummer
    this.zahnfarbe = zahnfarbe
    this.zahnstatus = zahnstatus
    this.zahnzustand = zahnzustand
    this.zahnmaterial = zahnmaterial
    this.zahnBemerkung = zahnBemerkung
    this.zahnBesonderheiten = zahnBesonderheiten
  }
}
