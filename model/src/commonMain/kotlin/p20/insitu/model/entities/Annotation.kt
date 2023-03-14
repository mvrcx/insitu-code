package p20.insitu.model.entities

import p20.insitu.model.xpolizei.interfaces.XpRecording
import p20.insitu.model.xpolizei.schema.Aufzeichnung

/**
 * Interface for objects that represent media annotations. Annotations are [DocumentationObject]s.
 * Extends the XPolizei interface [XpRecording] and implements the Getter function to export an
 * instance of [Aufzeichnung].
 */
interface Annotation : DocumentationObject, XpRecording {

    /**
     * The name of the media file.
     */
    var filename: String?

    /**
     * Reference to the [Device] with which the annotation was created, e.g., a smartphone.
     */
    var deviceId: String?

    override fun getAufzeichnung(): Aufzeichnung {
        return Aufzeichnung().also {
            // Base class attributes
            it.id = id
            // Class attributes
            it.art = annotationType?.getKatalogCode()
            it.bezeichnung = designation
            it.schlagworte = keywords?.joinToString(";")
            it.sprache =
                language?.map { it.getKatalogCodeNichtAbgeschlossen() }?.filterNotNull()
            it.erstellungsDatum = creationDate?.dateTime
        }
    }
}