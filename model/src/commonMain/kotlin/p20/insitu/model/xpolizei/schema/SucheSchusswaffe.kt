package p20.insitu.model.xpolizei.schema

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public open class SucheSchusswaffe() : SucheWaffe() {
  public var kategorie: CIMPSucheKatalogWert? = null

  public var art: CIMPSucheKatalogWert? = null

  public var ungesetzlicheBearbeitung_Herstellung: List<CIMPSucheKatalogWert>? = null

  public var angabenZuPruefzeichen: CIMPSucheString? = null

  public var anzahlZuegeFelder: CIMPSucheIntegerWert? = null

  public var kaliberXWaffe: List<CIMPSucheKatalogWert>? = null

  public var kaliberXWaffeGeaendert: List<CIMPSucheKatalogWert>? = null

  public var nWRIDWaffe: CIMPSucheString? = null

  public var eUKategorie: CIMPSucheKatalogWert? = null

  public var beschussamt: List<SucheBeteiligteStelle>? = null

  public var lauflaenge: SucheAusmass? = null

  public var schusswaffenherstellungsinformation: SucheSchusswaffenherstellungsinformation? = null

  public var haendlerzeichen: CIMPSucheString? = null

  public var kaliber: List<CIMPSucheKatalogWert>? = null

  public var schusswaffenzustandsinformation: SucheSchusswaffenzustandsinformation? = null

  public var amtlichRegistriert: CIMPSucheKatalogWert? = null

  public var erlaubnispflicht: CIMPSucheKatalogWert? = null

  public var mitPruef_Beschuss_Zulassungszeichen: CIMPSucheKatalogWert? = null

  public var vollautomat: CIMPSucheKatalogWert? = null

  public var umgangsverbot: CIMPSucheKatalogWert? = null

  public var besondererTyp: CIMPSucheKatalogWert? = null

  public constructor(
      kategorie: CIMPSucheKatalogWert?,
      art: CIMPSucheKatalogWert?,
      ungesetzlicheBearbeitung_Herstellung: List<CIMPSucheKatalogWert>?,
      angabenZuPruefzeichen: CIMPSucheString?,
      anzahlZuegeFelder: CIMPSucheIntegerWert?,
      kaliberXWaffe: List<CIMPSucheKatalogWert>?,
      kaliberXWaffeGeaendert: List<CIMPSucheKatalogWert>?,
      nWRIDWaffe: CIMPSucheString?,
      eUKategorie: CIMPSucheKatalogWert?,
      beschussamt: List<SucheBeteiligteStelle>?,
      lauflaenge: SucheAusmass?,
      schusswaffenherstellungsinformation: SucheSchusswaffenherstellungsinformation?,
      haendlerzeichen: CIMPSucheString?,
      kaliber: List<CIMPSucheKatalogWert>?,
      schusswaffenzustandsinformation: SucheSchusswaffenzustandsinformation?,
      amtlichRegistriert: CIMPSucheKatalogWert?,
      erlaubnispflicht: CIMPSucheKatalogWert?,
      mitPruef_Beschuss_Zulassungszeichen: CIMPSucheKatalogWert?,
      vollautomat: CIMPSucheKatalogWert?,
      umgangsverbot: CIMPSucheKatalogWert?,
      besondererTyp: CIMPSucheKatalogWert?
  ) : this() {
    this.kategorie = kategorie
    this.art = art
    this.ungesetzlicheBearbeitung_Herstellung = ungesetzlicheBearbeitung_Herstellung
    this.angabenZuPruefzeichen = angabenZuPruefzeichen
    this.anzahlZuegeFelder = anzahlZuegeFelder
    this.kaliberXWaffe = kaliberXWaffe
    this.kaliberXWaffeGeaendert = kaliberXWaffeGeaendert
    this.nWRIDWaffe = nWRIDWaffe
    this.eUKategorie = eUKategorie
    this.beschussamt = beschussamt
    this.lauflaenge = lauflaenge
    this.schusswaffenherstellungsinformation = schusswaffenherstellungsinformation
    this.haendlerzeichen = haendlerzeichen
    this.kaliber = kaliber
    this.schusswaffenzustandsinformation = schusswaffenzustandsinformation
    this.amtlichRegistriert = amtlichRegistriert
    this.erlaubnispflicht = erlaubnispflicht
    this.mitPruef_Beschuss_Zulassungszeichen = mitPruef_Beschuss_Zulassungszeichen
    this.vollautomat = vollautomat
    this.umgangsverbot = umgangsverbot
    this.besondererTyp = besondererTyp
  }
}
