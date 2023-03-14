package p20.insitu.model.entities.enums

enum class EvidenceType {
    /**
     * An area that will be searched for / might contain evidence. Such an area may be a user defined
     * space at a crime scene or a physical object.
     */
    AREA,

    /**
     * A physical object that has been secured as evidence.
     */
    OBJECT,

    /**
     * A physical trace that has been secured as evidence.
     */
    TRACE
}