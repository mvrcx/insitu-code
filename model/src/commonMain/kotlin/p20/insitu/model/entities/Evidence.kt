package p20.insitu.model.entities

import p20.insitu.model.components.EvidenceData
import p20.insitu.model.xpolizei.schema.Asservat

/**
 * Interface for objects that can hold evidence data. An evidence object is a
 * [SpatialSemanticObject] and a [DocNumberObject].
 * The interface provides a Getter function that exposes an [Asservat] object.
 */
interface Evidence : SpatialSemanticObject  {

    /**
     * Set of evidence related information.
     */
    var evidenceData: EvidenceData?

    /**
     * Gets an instance of [Asservat] based on the [EvidenceData] stored in [evidenceData].
     * Calls [EvidenceData.getAsservat] and passes the inherited [IBaseEntity.id].
     *
     * @return An instance of [Asservat].
     */
    fun getAsservat(): Asservat? {
        return evidenceData?.getAsservat(id, docNumber)
    }
}