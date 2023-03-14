package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheAsservat() {
  public var fachlicheAsservatennummer: CIMPSucheString? = null

  public var asservatenID: CIMPSucheString? = null

  public var gefahrenhinweis: CIMPSucheString? = null

  public var transportUndLagerhinweis: CIMPSucheString? = null

  public var beschaedigungserlaubnis: CIMPSucheKatalogWert? = null

  public var kTUntersuchung: CIMPSucheKatalogWert? = null

  public var lagerstatus: CIMPSucheKatalogWert? = null

  public var zweckDerAsservierung: List<CIMPSucheKatalogWert>? = null

  public var uNNummer: CIMPSucheKatalogWert? = null

  public var gefahrgutnummer: CIMPSucheKatalogWert? = null

  public var dateigroesse: SucheSpeichergroesse? = null

  public var sicherungsart: CIMPSucheKatalogWert? = null

  public constructor(
      fachlicheAsservatennummer: CIMPSucheString?,
      asservatenID: CIMPSucheString?,
      gefahrenhinweis: CIMPSucheString?,
      transportUndLagerhinweis: CIMPSucheString?,
      beschaedigungserlaubnis: CIMPSucheKatalogWert?,
      kTUntersuchung: CIMPSucheKatalogWert?,
      lagerstatus: CIMPSucheKatalogWert?,
      zweckDerAsservierung: List<CIMPSucheKatalogWert>?,
      uNNummer: CIMPSucheKatalogWert?,
      gefahrgutnummer: CIMPSucheKatalogWert?,
      dateigroesse: SucheSpeichergroesse?,
      sicherungsart: CIMPSucheKatalogWert?
  ) : this() {
    this.fachlicheAsservatennummer = fachlicheAsservatennummer
    this.asservatenID = asservatenID
    this.gefahrenhinweis = gefahrenhinweis
    this.transportUndLagerhinweis = transportUndLagerhinweis
    this.beschaedigungserlaubnis = beschaedigungserlaubnis
    this.kTUntersuchung = kTUntersuchung
    this.lagerstatus = lagerstatus
    this.zweckDerAsservierung = zweckDerAsservierung
    this.uNNummer = uNNummer
    this.gefahrgutnummer = gefahrgutnummer
    this.dateigroesse = dateigroesse
    this.sicherungsart = sicherungsart
  }
}
