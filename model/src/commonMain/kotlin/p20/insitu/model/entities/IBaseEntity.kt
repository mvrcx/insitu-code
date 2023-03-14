package p20.insitu.model.entities

/**
 * Base interface for all entities of the INSITU data model. Declares the base attributes that
 * every entity has.
 *
 * @see BaseEntity
 */
sealed interface IBaseEntity {

    /**
     * The ID of the entity.
     */
    val id: String

    /**
     * A unique type descriptor for the entity class. Used, e.g., to distinguish objects in the database
     * by their type.
     *
     * @see p20.insitu.model.entities.ObjectType
     */
    val entityType: String

    /**
     * Indicates if the object should be regarded as deleted. Default: `false`
     */
    var deleted: Boolean

}