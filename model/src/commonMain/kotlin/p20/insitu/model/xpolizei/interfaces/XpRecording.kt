package p20.insitu.model.xpolizei.interfaces

import kotlinx.datetime.LocalDateTime
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime

/**
 * Interface for the XPolizei object [Aufzeichnung].
 * Declares a (sub-)set of relevant properties and maps them to its XPolizei counterparts.
 * Provides a Getter function to create an instance of [Aufzeichnung].
 */
interface XpRecording : XpCommonBaseClass {

    /**
     * The name or short description of the recording. Maps to [Aufzeichnung.bezeichnung].
     */
    var designation: String?

    /**
     * The type of recording. Maps to [Aufzeichnung.art].
     */
    var annotationType: CatalogCodeFixed<KatalogCode102>?

    /**
     * Keywords describing to the content / topic of the recording. Maps to [Aufzeichnung.schlagworte].
     */
    var keywords: List<String>?

    /**
     * The language of the recording. Maps to [Aufzeichnung.sprache].
     */
    var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>?

    /**
     * The creation date of the recording. Maps to [Aufzeichnung.erstellungsDatum].
     */
    var creationDate: ZonedDateTime?

    /**
     * Get an instance of [Aufzeichnung] by mapping the interface properties.
     *
     * @return An instance of [Aufzeichnung].
     */
    fun getAufzeichnung(): Aufzeichnung

}