package p20.insitu.model.xpolizei.schema

import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

/**
 * Container des Standard Nachrichtenkopfes
 */
@Serializable
public open class CIMPNachrichtenKopf() {
  /**
   * Absender der Nachricht
   */
  public var absender: String? = null

  /**
   * Empfänger der Nachricht
   */
  public var empfaenger: String? = null

  /**
   * Die AnfrageID dient dazu, einen Bezug zwischen Anfrage und Antwort herzustellen (insbesondere
   * bei asynchroner Kommunikation)
   */
  public var anfrageID: String? = null

  /**
   * Optionale Sequenznummer, um einevollständige und duplikatfreie Übertragung und Verarbeitung in
   * der Reihenfolge der Auslösung der Anfragenachrichten realisieren und sicherstellen zu können.
   */
  public var anfrageSequenznummer: Long? = 0

  /**
   * Zeitpunkt der Erstellung der Nachricht durch das sendende System.
   *
   * Der Datentyp dateTime stellt einen spezifischen Zeitpunkt dar. Der Wertebereich von dateTime
   * entspricht dem Raum von möglichen Kombinationen aus Datum und Tageszeit wie in §5.4 von [ISO 8601]
   * definiert.
   *
   * Die Angabe der Zeitzone ist in XPolizei Pflicht!
   *
   * Beispiele:
   * Um auszudrücken, dass es sich um die Coordinated Universal Time (UTC) handelt, wird der
   * Darstellung direkt ein 'Z' oder ein '+00:00' nachgestellt.
   * Der 01. März 1999 um 11:00 Uhr in London ist folgendermaßen anzugeben:
   * 1999-03-01T11:00:00Z oder 1999-03-01T11:00:00+00:00
   *
   * Eine Lokalzeit in einer von UTC abweichenden Zeitzone, z. B. der 31. Mai 1999 um 13:20 Uhr in
   * Berlin zur Sommerzeit, ist folgendermaßen anzugeben:
   * 1999-05-31T13:20:00+02:00
   *
   * Der 02. Dezember 1999 um 14:45 Uhr in Berlin, also zur Winterzeit, ist folgendermaßen
   * anzugeben:
   * 1999-12-02T14:45:00+01:00
   */
  public var zeitstempel: LocalDateTime? = null

  /**
   * Im XPolizei-Projekt zu vereinbaren, falls Angabe erforderlich.
   */
  public var datenbereich: List<String>? = null

  /**
   * Im XPolizei-Projekt zu vereinbaren, falls Angabe erforderlich
   */
  public var ansprechpartner: Kontakt? = null

  /**
   * Angabe von Informationen zum hyDaNe-Ticket bzw. über das Vorliegen einer Ausnahme von der
   * hyDaNe-Prüfung.
   */
  public var hyDaNeTicket: HyDaNeTicket? = null

  public constructor(
    absender: String?,
    empfaenger: String?,
    anfrageID: String?,
    anfrageSequenznummer: Long?,
    zeitstempel: LocalDateTime?,
    datenbereich: List<String>?,
    ansprechpartner: Kontakt?,
    hyDaNeTicket: HyDaNeTicket?
  ) : this() {
    this.absender = absender
    this.empfaenger = empfaenger
    this.anfrageID = anfrageID
    this.anfrageSequenznummer = anfrageSequenznummer
    this.zeitstempel = zeitstempel
    this.datenbereich = datenbereich
    this.ansprechpartner = ansprechpartner
    this.hyDaNeTicket = hyDaNeTicket
  }

  /**
   * Angabe der Ausnahme, die zu einer Beendigung der hyDaNe-Prüfung führt
   */
  @Serializable
  public class HyDaNeTicket() {
    /**
     * Angabe der Ausnahme, die zu einer Beendigung der hyDaNe-Prüfung führt
     */
    public var ausnahme: List<KatalogCode409>? = null

    /**
     * Angabe von Informationen zum Inhalt des hyDaNe-Tickets.
     */
    public var inhalt: Inhalt? = null

    public constructor(ausnahme: List<KatalogCode409>?,
                       inhalt: Inhalt?) : this() {
      this.ausnahme = ausnahme
      this.inhalt = inhalt
    }

    /**
     * Angabe der abfragenden Behörde, um einen Abgleich durchführen zu können, ob die abfragende
     * Behörde mit der datenerhebenden Behörde identisch ist.
     */
    @Serializable
    public class Inhalt() {
      /**
       * Angabe der abfragenden Behörde, um einen Abgleich durchführen zu können, ob die abfragende
       * Behörde mit der datenerhebenden Behörde identisch ist.
       */
      public var behoerde: String? = null

      /**
       * Angabe, zur Erfüllung welcher Aufgabe die Abfrage dient.
       */
      public var aufgabe: KatalogCode123? = null

      /**
       * Angabe, ob eine Gefahr vorliegt, die die Weiterverarbeitung von Daten aus der
       * Online-Durchsuchung und der Wohnraumüberwachung im Rahmen der Gefahrenabwehr rechtfertigen.
       */
      public var vorliegendeGefahr: KatalogCode410? = null

      /**
       * Angabe des Abfragegrunds.
       */
      public var abfragegrund: List<KatalogCode411>? = null

      /**
       * Angabe des Rechtsguts oder der Straftat, welche(s) der Datenverarbeitung zugrunde liegt.
       */
      public var rechtsgutStraftat: RechtsgutStraftat? = null

      /**
       * Angabe der hyDaNe-Kategorie sowie ggf. einer Begründung der Abweichung von den Vorgaben.
       */
      public var hyDaNeKennzeichnung: HyDaNeKennzeichnung? = null

      public constructor(
        behoerde: String?,
        aufgabe: KatalogCode123?,
        vorliegendeGefahr: KatalogCode410?,
        abfragegrund: List<KatalogCode411>?,
        rechtsgutStraftat: RechtsgutStraftat?,
        hyDaNeKennzeichnung: HyDaNeKennzeichnung?
      ) : this() {
        this.behoerde = behoerde
        this.aufgabe = aufgabe
        this.vorliegendeGefahr = vorliegendeGefahr
        this.abfragegrund = abfragegrund
        this.rechtsgutStraftat = rechtsgutStraftat
        this.hyDaNeKennzeichnung = hyDaNeKennzeichnung
      }

      /**
       * Angabe der Straftat.
       */
      @Serializable
      public class RechtsgutStraftat() {
        /**
         * Angabe der Straftat.
         */
        public var straftat: KatalogCode121? = null

        /**
         * Angabe des Rechtsguts.
         */
        public var rechtsgut: KatalogCode370? = null

        public constructor(straftat: KatalogCode121?, rechtsgut: KatalogCode370?) : this() {
          this.straftat = straftat
          this.rechtsgut = rechtsgut
        }
      }
    }

    /**
     * Angabe der Straftat.
     */
    @Serializable
    public class RechtsgutStraftat() {
      /**
       * Angabe der Straftat.
       */
      public var straftat: KatalogCode121? = null

      /**
       * Angabe des Rechtsguts.
       */
      public var rechtsgut: KatalogCode370? = null

      public constructor(straftat: KatalogCode121?, rechtsgut: KatalogCode370?) : this() {
        this.straftat = straftat
        this.rechtsgut = rechtsgut
      }
    }
  }

  /**
   * Angabe der abfragenden Behörde, um einen Abgleich durchführen zu können, ob die abfragende
   * Behörde mit der datenerhebenden Behörde identisch ist.
   */
  @Serializable
  public class Inhalt() {
    /**
     * Angabe der abfragenden Behörde, um einen Abgleich durchführen zu können, ob die abfragende
     * Behörde mit der datenerhebenden Behörde identisch ist.
     */
    public var behoerde: String? = null

    /**
     * Angabe, zur Erfüllung welcher Aufgabe die Abfrage dient.
     */
    public var aufgabe: KatalogCode123? = null

    /**
     * Angabe, ob eine Gefahr vorliegt, die die Weiterverarbeitung von Daten aus der
     * Online-Durchsuchung und der Wohnraumüberwachung im Rahmen der Gefahrenabwehr rechtfertigen.
     */
    public var vorliegendeGefahr: KatalogCode410? = null

    /**
     * Angabe des Abfragegrunds.
     */
    public var abfragegrund: List<KatalogCode411>? = null

    /**
     * Angabe des Rechtsguts oder der Straftat, welche(s) der Datenverarbeitung zugrunde liegt.
     */
    public var rechtsgutStraftat: RechtsgutStraftat? = null

    /**
     * Angabe der hyDaNe-Kategorie sowie ggf. einer Begründung der Abweichung von den Vorgaben.
     */
    public var hyDaNeKennzeichnung: HyDaNeKennzeichnung? = null

    public constructor(
      behoerde: String?,
      aufgabe: KatalogCode123?,
      vorliegendeGefahr: KatalogCode410?,
      abfragegrund: List<KatalogCode411>?,
      rechtsgutStraftat: RechtsgutStraftat?,
      hyDaNeKennzeichnung: HyDaNeKennzeichnung?
    ) : this() {
      this.behoerde = behoerde
      this.aufgabe = aufgabe
      this.vorliegendeGefahr = vorliegendeGefahr
      this.abfragegrund = abfragegrund
      this.rechtsgutStraftat = rechtsgutStraftat
      this.hyDaNeKennzeichnung = hyDaNeKennzeichnung
    }

    /**
     * Angabe der Straftat.
     */
    @Serializable
    public class RechtsgutStraftat() {
      /**
       * Angabe der Straftat.
       */
      public var straftat: KatalogCode121? = null

      /**
       * Angabe des Rechtsguts.
       */
      public var rechtsgut: KatalogCode370? = null

      public constructor(straftat: KatalogCode121?, rechtsgut: KatalogCode370?) : this() {
        this.straftat = straftat
        this.rechtsgut = rechtsgut
      }
    }
  }

  /**
   * Angabe der Straftat.
   */
  @Serializable
  public class RechtsgutStraftat() {
    /**
     * Angabe der Straftat.
     */
    public var straftat: KatalogCode121? = null

    /**
     * Angabe des Rechtsguts.
     */
    public var rechtsgut: KatalogCode370? = null

    public constructor(straftat: KatalogCode121?, rechtsgut: KatalogCode370?) : this() {
      this.straftat = straftat
      this.rechtsgut = rechtsgut
    }
  }
}
