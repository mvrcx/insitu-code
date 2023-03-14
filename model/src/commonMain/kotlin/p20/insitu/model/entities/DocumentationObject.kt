package p20.insitu.model.entities

/**
 * Interface for objects (entities) that can be subject of a crime scene documentation.
 */
interface DocumentationObject : IBaseEntity {

    /**
     * The name or short description of the object.
     */
    var designation: String?

    /**
     * Reference to an [Image] object that represents the thumbnail / icon of the
     * object.
     */
    var thumbnailId: String?

}