package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheFalschgeld() : SucheGeld() {
  public var faelschungsart: List<CIMPSucheKatalogWert>? = null

  public var nationaleSeite: CIMPSucheString? = null

  public var besondereMerkmale: CIMPSucheString? = null

  public var plattennummer: CIMPSucheString? = null

  public var muenzzeichen: CIMPSucheString? = null

  public var festgestelltBei: CIMPSucheKatalogWert? = null

  public var anzahlMitGleichenHerstellungsmerkmalen: CIMPSucheIntegerWert? = null

  public var serienbezeichnung: CIMPSucheString? = null

  public var indikativEZB: CIMPSucheString? = null

  public constructor(
      faelschungsart: List<CIMPSucheKatalogWert>?,
      nationaleSeite: CIMPSucheString?,
      besondereMerkmale: CIMPSucheString?,
      plattennummer: CIMPSucheString?,
      muenzzeichen: CIMPSucheString?,
      festgestelltBei: CIMPSucheKatalogWert?,
      anzahlMitGleichenHerstellungsmerkmalen: CIMPSucheIntegerWert?,
      serienbezeichnung: CIMPSucheString?,
      indikativEZB: CIMPSucheString?
  ) : this() {
    this.faelschungsart = faelschungsart
    this.nationaleSeite = nationaleSeite
    this.besondereMerkmale = besondereMerkmale
    this.plattennummer = plattennummer
    this.muenzzeichen = muenzzeichen
    this.festgestelltBei = festgestelltBei
    this.anzahlMitGleichenHerstellungsmerkmalen = anzahlMitGleichenHerstellungsmerkmalen
    this.serienbezeichnung = serienbezeichnung
    this.indikativEZB = indikativEZB
  }
}
