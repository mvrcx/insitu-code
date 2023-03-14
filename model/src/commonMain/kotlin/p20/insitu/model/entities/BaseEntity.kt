package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.util.randomUUID

/**
 * This is the abstract base class for all objects (entities) that compose the INSITU data model.
 *
 * ## Notes
 * Every time an entity is saved in the database (insert / update), an [AuditEntry] is created to
 * reflect the changes made to the object.
 *
 * @property id The ID of the entity. Will be generated on object initialization by [randomUUID]
 * function.
 * @constructor Create a new BaseEntity object. Invoked by subclasses.
 */
@Serializable
sealed class BaseEntity(
    override val id: String = randomUUID()
) : IBaseEntity

