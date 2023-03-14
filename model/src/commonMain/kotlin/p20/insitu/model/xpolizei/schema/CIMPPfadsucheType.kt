package p20.insitu.model.xpolizei.schema

import kotlin.Int
import kotlinx.serialization.Serializable

/**
 * Container für die Pfadsuche
 */
@Serializable
public open class CIMPPfadsucheType() {
  /**
   * Standard Nachrichtenkopf
   */
  public var nachrichtenkopf: CIMPNachrichtenKopf? = null

  /**
   * Die Art des Ergebnisses
   */
  public var artErgebnis: CIMPErgebnisArt? = null

  /**
   * Länge des gesuchten Pfades
   */
  public var maxTiefe: Int? = 0

  /**
   * Die Suchobjekte, zwischen denen ein Pfad gesucht wird.
   */
  public var suchObjekt: CIMPSuchObjektType? = null

  /**
   * Objekte, die bei der Ermittlung des Pfades nicht berücksichtigt werden sollen
   */
  public var ausgeschlosseneObjekte: CIMPSuchObjekteType? = null

  /**
   * Beziehungen, die bei der Ermittlung des Pfades nicht berücksichtigt werden sollen
   */
  public var ausgeschlosseneBeziehungen: CIMPSuchBeziehungenType? = null

  public constructor(
      nachrichtenkopf: CIMPNachrichtenKopf?,
      artErgebnis: CIMPErgebnisArt?,
      maxTiefe: Int?,
      suchObjekt: CIMPSuchObjektType?,
      ausgeschlosseneObjekte: CIMPSuchObjekteType?,
      ausgeschlosseneBeziehungen: CIMPSuchBeziehungenType?
  ) : this() {
    this.nachrichtenkopf = nachrichtenkopf
    this.artErgebnis = artErgebnis
    this.maxTiefe = maxTiefe
    this.suchObjekt = suchObjekt
    this.ausgeschlosseneObjekte = ausgeschlosseneObjekte
    this.ausgeschlosseneBeziehungen = ausgeschlosseneBeziehungen
  }
}
