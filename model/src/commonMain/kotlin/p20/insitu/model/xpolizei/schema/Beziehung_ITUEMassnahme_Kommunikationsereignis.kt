package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Abbildung von Zusammenhängen zwischen einer ITÜ-Maßnahme und Kommunikationsereignissen.
 */
@Serializable
public open class Beziehung_ITUEMassnahme_Kommunikationsereignis() : Beziehung() {
  /**
   * Angabe der Gesprächsklassifizierung gem. 'Gemeinsame Leitlinie der Generalstaatsanwälte zur
   * Bestimmung kernbereichsrelevanter Telekommunikation und zur Benachrichtigung von
   * Telekommunikationsüberwachungsmaßnahmen Betroffener'.
   */
  public var gespraechsklassifizierung: KatalogCode358? = null

  public constructor(gespraechsklassifizierung: KatalogCode358?) : this() {
    this.gespraechsklassifizierung = gespraechsklassifizierung
  }
}
