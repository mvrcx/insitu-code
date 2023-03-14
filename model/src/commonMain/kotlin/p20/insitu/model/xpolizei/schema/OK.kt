package p20.insitu.model.xpolizei.schema

import kotlinx.serialization.Serializable

/**
 * Organisierte Kriminalität ist die von Gewinn- oder Machtstreben bestimmte planmäßige Begehung von
 * Straftaten, die einzeln oder in ihrer Gesamtheit von erheblicher Bedeutung sind, wenn mehr als zwei
 * Beteiligte auf längere oder unbestimmte Dauer arbeitsteilig
 * a) unter Verwendung gewerblicher oder geschäftsähnlicher Strukturen,
 * b) unter Anwendung von Gewalt oder anderer zur Einschüchterung geeigneter Mittel
 * oder
 * c) unter Einflussnahme auf Politik, Medien, öffentliche Verwaltung, Justiz oder Wirtschaft
 * zusammenwirken.
 */
@Serializable
public open class OK() {
  public var oKIndikator: OK_Indikator? = null

  public var oKMerkmal: OK_Merkmal? = null

  public constructor(oKIndikator: OK_Indikator?, oKMerkmal: OK_Merkmal?) : this() {
    this.oKIndikator = oKIndikator
    this.oKMerkmal = oKMerkmal
  }
}
