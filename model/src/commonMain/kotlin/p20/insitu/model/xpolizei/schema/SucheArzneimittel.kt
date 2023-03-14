package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheArzneimittel() : SucheArznei_Betaeubungsmittel_Grundstoff() {
  public var art: CIMPSucheKatalogWert? = null

  public var stueckzahl: CIMPSucheIntegerWert? = null

  public var darreichungsform: CIMPSucheKatalogWert? = null

  public var pZN: CIMPSucheString? = null

  public var verwendungszweck: CIMPSucheKatalogWert? = null

  public var dopingmittel: CIMPSucheKatalogWert? = null

  public var chargennummer: CIMPSucheString? = null

  public var verfallsdatum: CIMPSucheDatum? = null

  public var ausweichmittelBtM: CIMPSucheKatalogWert? = null

  public var verpackung: SucheVerpackung? = null

  public var verboteneSubstanz: List<SucheVerboteneSubstanz>? = null

  public var faelschung: SucheFaelschung? = null

  public var wirkstoff: List<SucheWirkstoff>? = null

  public constructor(
      art: CIMPSucheKatalogWert?,
      stueckzahl: CIMPSucheIntegerWert?,
      darreichungsform: CIMPSucheKatalogWert?,
      pZN: CIMPSucheString?,
      verwendungszweck: CIMPSucheKatalogWert?,
      dopingmittel: CIMPSucheKatalogWert?,
      chargennummer: CIMPSucheString?,
      verfallsdatum: CIMPSucheDatum?,
      ausweichmittelBtM: CIMPSucheKatalogWert?,
      verpackung: SucheVerpackung?,
      verboteneSubstanz: List<SucheVerboteneSubstanz>?,
      faelschung: SucheFaelschung?,
      wirkstoff: List<SucheWirkstoff>?
  ) : this() {
    this.art = art
    this.stueckzahl = stueckzahl
    this.darreichungsform = darreichungsform
    this.pZN = pZN
    this.verwendungszweck = verwendungszweck
    this.dopingmittel = dopingmittel
    this.chargennummer = chargennummer
    this.verfallsdatum = verfallsdatum
    this.ausweichmittelBtM = ausweichmittelBtM
    this.verpackung = verpackung
    this.verboteneSubstanz = verboteneSubstanz
    this.faelschung = faelschung
    this.wirkstoff = wirkstoff
  }
}
