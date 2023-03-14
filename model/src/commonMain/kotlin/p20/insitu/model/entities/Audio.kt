package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.CatalogCodeNotComplete
import p20.insitu.model.components.ZonedDateTime

/**
 * This class describes an audio [Annotation], i.e. the audio file and associated meta data.
 *
 * ## XPolizei
 * [Audio] is an [Annotation] and therefore implements the [XpRecording] interface which exposes a
 * [Aufzeichnung] object.
 *
 * @property deleted Indicates if the object should be regarded as deleted. Default: `false`
 * @property designation The name or short description of the audio annotation.
 * @property thumbnailId Reference to an [Image] object that represents the thumbnail / icon of the
 * audio annotation.
 * @property filename The name of the media file.
 * @property deviceId Reference to the [Device] with which the annotation was created, e.g., a smartphone.
 * @property annotationType The type of recording. Maps to [Aufzeichnung.art].
 * @property keywords Keywords describing to the content / topic of the recording. Maps to
 * [Aufzeichnung.schlagworte].
 * @property language The language of the recording. Maps to [Aufzeichnung.sprache].
 * @property creationDate The creation date of the recording. Maps to [Aufzeichnung.erstellungsDatum].
 * @property recordingLength The duration of the audio recording in seconds.
 * @property transcription The transcription of the audio recording.
 * @constructor Create a new Audio object.
 */
@Serializable
data class Audio(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var filename: String? = null,
    override var deviceId: String? = null,
    override var annotationType: CatalogCodeFixed<KatalogCode102>? = null,
    override var keywords: List<String>? = null,
    override var language: List<CatalogCodeNotComplete<KatalogCode203_NichtAbgeschlossen>>? = null,
    override var creationDate: ZonedDateTime? = null,
    var recordingLength: Int? = null,
    var transcription: String? = null
) : BaseEntity(), Annotation {

    /**
     * The unique type descriptor for this entity class.
     *
     * @see p20.insitu.model.entities.enums.EntityType
     */
    override val entityType: String = EntityType.AUDIO.toString()

}
