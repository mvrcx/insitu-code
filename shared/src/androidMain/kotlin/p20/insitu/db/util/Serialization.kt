package p20.insitu.db.util

import p20.insitu.db.documentation.Serializer
import p20.insitu.model.entities.BaseEntity

actual fun toMap(entity: BaseEntity):Map<String, Any?>{
    return Serializer.toMap(entity)
}