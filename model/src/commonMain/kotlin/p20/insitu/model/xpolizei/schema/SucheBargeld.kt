package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheBargeld() : SucheGeld() {
  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var besondereMerkmale: CIMPSucheString? = null

  public var bezeichnung: CIMPSucheString? = null

  public var sachgebundenerHinweis: List<CIMPSucheKatalogWert>? = null

  public var ausgabestaat: CIMPSucheKatalogWert? = null

  public var emittent: CIMPSucheKatalogWert? = null

  public constructor(
      stueckzahl: CIMPSucheIntegerWert?,
      besondereMerkmale: CIMPSucheString?,
      bezeichnung: CIMPSucheString?,
      sachgebundenerHinweis: List<CIMPSucheKatalogWert>?,
      ausgabestaat: CIMPSucheKatalogWert?,
      emittent: CIMPSucheKatalogWert?
  ) : this() {
    this.stueckzahl = stueckzahl
    this.besondereMerkmale = besondereMerkmale
    this.bezeichnung = bezeichnung
    this.sachgebundenerHinweis = sachgebundenerHinweis
    this.ausgabestaat = ausgabestaat
    this.emittent = emittent
  }
}
