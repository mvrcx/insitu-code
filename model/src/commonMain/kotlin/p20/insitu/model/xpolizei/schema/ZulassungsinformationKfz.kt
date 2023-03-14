package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlinx.serialization.Serializable

/**
 * Information zu einer Zulassung eines individuellen Fahrzeugs.
 *
 * Ein Fahrzeug kann im Laufe seiner Existenz in verschiedenen Zulassungsbezirken Deutschlands oder
 * sogar im Ausland zugelassen sein und erhält dabei unter Umständen verschiedene Kfz-Kennzeichen
 * (innerhalb Deutschlands, wenn Zulassung in einem anderen Zulassungsbezirk erfolgt).
 */
@Serializable
public open class ZulassungsinformationKfz() {
  /**
   * Gibt an, ob das Kraftfahrzeug als 'Mietfahrzeug für Selbstfahrer' zugelassen ist.
   *
   * Bemerkung: Verwendungsart 'Mietfahrzeug' ist unabhängig von der Zulassung und kann auch auf
   * Fahrzeuge angewandt werden, die nicht explizit als Mietfahrzeug zugelassen werden müssen.
   *
   * Beispiel: Fahrradverleih, Tretbootverleih, Luftsportgeräteverleih
   *
   * Die Vermietung an sich (inkl. der handelnden Personen) wird als Allgemeines Ereignis
   * abgebildet.
   */
  public var mietfahrzeug: KatalogCode214? = null

  /**
   * Ende der Gültigkeit einer Kraftfahrzeugzulassung - auch bei Tageskennzeichen. Das Attribut ist
   * optional, da man vom KBA zu einem Kraftfahrzeug auch eine sogenannte 'Nullauskunft' bekommen
   * kann. 
   */
  public var gueltigBis: String? = null

  /**
   * Beginn der Gültigkeit einer Kraftfahrzeugzulassung - auch bei Tageskennzeichen. Das Attribut
   * ist optional, da man vom KBA zu einem Kraftfahrzeug auch eine sogenannte 'Nullauskunft' bekommen
   * kann. 
   */
  public var gueltigVon: String? = null

  /**
   * Angabe der Zulassungsstelle des Kraftfahrzeugs.
   */
  public var zulassungsstelle: BeteiligteStelle? = null

  public var kfzKennzeicheninformation: KfzKennzeicheninformation? = null

  public constructor(
      mietfahrzeug: KatalogCode214?,
      gueltigBis: String?,
      gueltigVon: String?,
      zulassungsstelle: BeteiligteStelle?,
      kfzKennzeicheninformation: KfzKennzeicheninformation?
  ) : this() {
    this.mietfahrzeug = mietfahrzeug
    this.gueltigBis = gueltigBis
    this.gueltigVon = gueltigVon
    this.zulassungsstelle = zulassungsstelle
    this.kfzKennzeicheninformation = kfzKennzeicheninformation
  }
}
