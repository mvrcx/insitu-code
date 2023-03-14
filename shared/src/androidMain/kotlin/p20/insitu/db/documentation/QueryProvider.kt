package p20.insitu.db.documentation

import com.couchbase.lite.*
import p20.insitu.model.entities.IBaseEntity
import p20.insitu.model.entities.enums.EntityGroup
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.entities.enums.EntityTypeIdentifier

fun getRelatedAddressId(
    database: Database,
    crimeSceneId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityType.ADDRESS_RELATION)
        .and(propertyMatches(sourceId, crimeSceneId))
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(targetId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getAnnotationIds(
    database: Database,
    entityId: String,
    annotationType: EntityType? = null
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    var expression = propertyMatches(entityType, EntityType.ANNOTATION_RELATION)
        .and(propertyMatches(sourceId, entityId))
        .and(propertyMatches(deleted, false))
    annotationType?.let {
        if (EntityGroup.ANNOTATIONS.types.contains(it)) {
            expression = expression.and(propertyMatches(targetType, it))
        }
    }
    // Define select results
    val selectResults = SelectResult.property(targetId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getAnnotationIdsNotRelatedToEntity(
    database: Database,
    entityId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityType.ANNOTATION_RELATION)
        .and(propertyMatchesNot(sourceId, entityId)) // Not equal to entity ID
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(targetId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getCriminalOffenseIds(
    database: Database,
    entityId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityType.CRIMINAL_OFFENSE_RELATION)
        .and(propertyMatches(sourceId, entityId))
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(targetId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getEntityIds(
    database: Database,
    types: EntityTypeIdentifier
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, types)
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getAllEntityIds(
    database: Database
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityGroup.ALL)
    // Define select results
    val selectResults = SelectResult.property(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getHierarchicalParentId(
    database: Database,
    childId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityGroup.HIERARCHICAL_RELATIONS)
        .and(propertyMatches(targetId, childId))
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(sourceId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

/**
 * Returns a [Query] that fetches the IDs of all child entities, with respect to the given parent
 * entity ID. Child entities are all entities that are related to the parent entity via a
 * hierarchical, i.e. directed, relation, where the parent is the "source" and the child is the
 * "target" of the relation. [EntityGroup.HIERARCHICAL_RELATIONS] defines the types of hierarchical
 * relations in the INSITU data model.
 *
 * @param database The database object.
 * @param parentId The ID of the parent entity.
 * @param childType Optional parameter for the entity type of the children. If null, any child type
 * is allowed.
 */
fun getHierarchicalChildIds(
    database: Database,
    parentId: String,
    childType: EntityTypeIdentifier? = null
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    var expression =
        propertyMatches(p20.insitu.db.documentation.entityType, EntityGroup.HIERARCHICAL_RELATIONS)
            .and(propertyMatches(sourceId, parentId))
            .and(propertyMatches(deleted, false))
    childType?.let {
        expression = expression.and(propertyMatches(targetType, it))
    }
    // Define select results
    val selectResults = SelectResult.property(targetId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getImageTagIds(
    database: Database,
    imageId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityType.IMAGE_TAG)
        .and(propertyMatches(p20.insitu.db.documentation.imageId, imageId))
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getLastActiveCrimeSceneId(
    database: Database,
    userId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityType.USER_SETTINGS)
        .and(propertyMatches(p20.insitu.db.documentation.userId, userId))
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(lastActiveCrimeSceneId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getLastActiveDocuObjectId(
    database: Database,
    userId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityType.USER_SETTINGS)
        .and(propertyMatches(p20.insitu.db.documentation.userId, userId))
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(lastActiveDocuObjectId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getLastActiveInvestigationId(
    database: Database,
    userId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityType.USER_SETTINGS)
        .and(propertyMatches(p20.insitu.db.documentation.userId, userId))
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(lastActiveInvestigationId).`as`(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getPersonIds(
    database: Database,
    entityId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityGroup.ASSOCIATIVE_RELATIONS)
        .and(propertyMatches(sourceId, entityId).or(propertyMatches(targetId, entityId)))
        .and(
            propertyMatches(sourceType, EntityType.PERSON).or(
                propertyMatches(
                    targetType,
                    EntityType.PERSON
                )
            )
        )
        .and(propertyMatches(deleted, false))
    // Define select results
    val targetId = SelectResult.property(targetId).`as`(targetId)
    val sourceId = SelectResult.property(sourceId).`as`(sourceId)
    // Build query
    return QueryBuilder.selectDistinct(targetId, sourceId).from(dataSource).where(expression)
}

fun getRelationIdsBySourceOrTarget(
    database: Database,
    sourceOrTargetId: String,
    relationType: EntityType?
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    var expression = propertyMatches(deleted, false)
        .and(
            propertyMatches(sourceId, sourceOrTargetId)
                .or(propertyMatches(targetId, sourceOrTargetId))
        )
    relationType?.let {
        expression = expression.and(propertyMatches(entityType, it))
    }
    // Define select results
    val selectResults = SelectResult.property(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

fun getUserSettingsId(
    database: Database,
    userId: String
): Query {
    // Set datasource
    val dataSource = DataSource.database(database)
    // Build query expression
    val expression = propertyMatches(entityType, EntityType.USER_SETTINGS)
        .and(propertyMatches(p20.insitu.db.documentation.userId, userId))
        .and(propertyMatches(deleted, false))
    // Define select results
    val selectResults = SelectResult.property(id)
    // Build query
    return QueryBuilder.selectDistinct(selectResults).from(dataSource).where(expression)
}

