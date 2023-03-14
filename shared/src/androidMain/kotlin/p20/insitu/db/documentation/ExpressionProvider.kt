package p20.insitu.db.documentation

import com.couchbase.lite.Expression
import p20.insitu.model.entities.enums.EntityGroup
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.entities.enums.EntityTypeIdentifier

fun propertyMatches(propertyName: String, value: String): Expression {
    return Expression.property(propertyName).equalTo(Expression.string(value))
}

fun propertyMatches(propertyName: String, value: Boolean): Expression {
    return Expression.property(propertyName).equalTo(Expression.booleanValue(value))
}

fun propertyMatches(propertyName: String, value: Int): Expression {
    return Expression.property(propertyName).equalTo(Expression.intValue(value))
}

fun propertyMatches(propertyName: String, value: Float): Expression {
    return Expression.property(propertyName).equalTo(Expression.floatValue(value))
}

fun propertyMatches(propertyName: String, value: Double): Expression {
    return Expression.property(propertyName).equalTo(Expression.doubleValue(value))
}

fun propertyMatchesAny(propertyName: String, values: List<String>): Expression {
    return Expression.property(propertyName)
        .`in`(*values.map { Expression.string(it) }.toTypedArray())
}

fun propertyMatches(propertyName: String, entityType: EntityTypeIdentifier): Expression {
    return when(entityType){
        is EntityType -> propertyMatches(propertyName, entityType.toString())
        else -> propertyMatchesAny(propertyName, (entityType as EntityGroup).types.map { it.toString() }) // EntityGroup!
    }
}

fun propertyMatchesNot(propertyName: String, value: String): Expression {
    return Expression.property(propertyName).notEqualTo(Expression.string(value))
}
