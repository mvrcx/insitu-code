package p20.insitu.model.xpolizei.schema

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBeziehung() : SucheAllgemeineBasisklasse() {
  public var rolle: CIMPSucheKatalogWert? = null

  public var bezeichnung: CIMPSucheString? = null

  public var quellreferenz: List<CIMPSucheString>? = null

  public var richtungsrelevant: CIMPSucheKatalogWert? = null

  public var eISRelevanz: CIMPSucheKatalogWert? = null

  public var bemerkung: CIMPSucheString? = null

  public var anacapabewertung: SucheAnacapabewertung? = null

  public var beginndatum: SucheDatumZeit? = null

  public var enddatum: SucheDatumZeit? = null

  public var ermittlungsrelevanz: CIMPSucheKatalogWert? = null

  public var id1_quellID: String? = null

  public var id1_xmlID: String? = null

  public var id1_zielID: String? = null

  public var id2_quellID: String? = null

  public var id2_xmlID: String? = null

  public var id2_zielID: String? = null

  public constructor(
      rolle: CIMPSucheKatalogWert?,
      bezeichnung: CIMPSucheString?,
      quellreferenz: List<CIMPSucheString>?,
      richtungsrelevant: CIMPSucheKatalogWert?,
      eISRelevanz: CIMPSucheKatalogWert?,
      bemerkung: CIMPSucheString?,
      anacapabewertung: SucheAnacapabewertung?,
      beginndatum: SucheDatumZeit?,
      enddatum: SucheDatumZeit?,
      ermittlungsrelevanz: CIMPSucheKatalogWert?,
      id1_quellID: String?,
      id1_xmlID: String?,
      id1_zielID: String?,
      id2_quellID: String?,
      id2_xmlID: String?,
      id2_zielID: String?
  ) : this() {
    this.rolle = rolle
    this.bezeichnung = bezeichnung
    this.quellreferenz = quellreferenz
    this.richtungsrelevant = richtungsrelevant
    this.eISRelevanz = eISRelevanz
    this.bemerkung = bemerkung
    this.anacapabewertung = anacapabewertung
    this.beginndatum = beginndatum
    this.enddatum = enddatum
    this.ermittlungsrelevanz = ermittlungsrelevanz
    this.id1_quellID = id1_quellID
    this.id1_xmlID = id1_xmlID
    this.id1_zielID = id1_zielID
    this.id2_quellID = id2_quellID
    this.id2_xmlID = id2_xmlID
    this.id2_zielID = id2_zielID
  }
}
