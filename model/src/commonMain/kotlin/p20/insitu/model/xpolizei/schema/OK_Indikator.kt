package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Es werden die OK-Indikatoren gemäß OK-Raster (Punkt 3.6) abgebildet.
 */
@Serializable
public open class OK_Indikator() {
  /**
   * Katalogisierte Abbildung der OK-Indikatoren gemäß OK-Raster (Punkt 3.6).
   */
  public var art: KatalogCode298? = null

  /**
   * Katalogisierte Abbildung, ob der OK-Indikator 'zutrifft', 'nicht zutrifft' oder keine Aussage
   * ('nicht bekannt') dazu getroffen werden kann. Hierbei entspricht die katalogisierte Abbildung den
   * folgenden Codelisten-Einträgen von 'Code214' (ja/nein/unbekannt):
   *
   * ja = trifft zu
   * nein = trifft nicht zu
   * unbekannt = nicht bekannt
   */
  public var bewertung: KatalogCode214? = null

  public constructor(art: KatalogCode298?, bewertung: KatalogCode214?) : this() {
    this.art = art
    this.bewertung = bewertung
  }
}
