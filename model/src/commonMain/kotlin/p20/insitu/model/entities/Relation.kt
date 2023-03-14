package p20.insitu.model.entities

import p20.insitu.model.entities.enums.EntityType

/**
 * Base interface for all relation objects of the INSITU data model. Declares the base attributes
 * that every relation entity has. A relation connects a source object to a target object.
 *
 * @property sourceId The ID of the source object of the relation.
 * @property sourceType The type of the source object. See [EntityType].
 * @property targetId The ID of the target object of the relation.
 * @property targetType The type of the target object. See [EntityType].
 */
interface Relation : IBaseEntity {
    var sourceId: String
    var sourceType: String
    var targetId: String
    var targetType: String

    /**
     * Sets the source object of the relation by setting [sourceId] and [sourceType].
     *
     * @param source The source object of the relation.
     */
    fun setSource(source: BaseEntity) {
        sourceId = source.id
        sourceType = source.entityType
    }

    /**
     * Sets the target object of the relation by setting [targetId] and [targetType].
     *
     * @param target The target object of the relation.
     */
    fun setTarget(target: BaseEntity) {
        targetId = target.id
        targetType = target.entityType
    }
}