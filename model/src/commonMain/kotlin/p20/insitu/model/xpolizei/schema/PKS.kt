package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * Die PKS-relevanten Informationen zu einer Straftat (PKS = Polizeiliche Kriminalstatistik).
 */
@Serializable
public open class PKS() {
  /**
   * Im Attribut StraftatenschluesselPKS wird der Straftatenschlüssel der polizeilichen
   * Kriminalstatistik (PKS) übermittelt.
   */
  public var straftatenschluessel: String? = null

  /**
   * Das Wirkdatum gibt an, in welchem Berichtsmonat der Zugang, die Veränderung oder die Löschung
   * eines Einzeldatensatzes beim Sender, dem Land, und damit auch synchron beim EDS-Empfänger, dem
   * BKA, gezählt wird bzw. ihre Wirkung zeigt. Bei der Monatsabschlussmeldung definiert die Angabe den
   * zu schließenden Berichtsmonat. Zu prüfen: Wirkdatum in Nachricht oder als fachliche Information.
   */
  public var wirkdatum: LocalDate? = null

  public constructor(straftatenschluessel: String?, wirkdatum: LocalDate?) : this() {
    this.straftatenschluessel = straftatenschluessel
    this.wirkdatum = wirkdatum
  }
}
