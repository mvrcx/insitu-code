package p20.insitu.db.documentation

import com.couchbase.lite.Document
import com.couchbase.lite.MutableDocument
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import p20.insitu.model.entities.BaseEntity
import p20.insitu.model.entities.IBaseEntity

object Serializer {

    @OptIn(ExperimentalSerializationApi::class)
    val module = SerializersModule {
        contextual(Any::class, AnySerializer)
    }

    val json = Json {
        encodeDefaults = true
        serializersModule = module
    }

    fun toMutableDocument(entity: BaseEntity): MutableDocument {
       return MutableDocument(
           entity.id,
           json.encodeToString(entity)
       )
    }

    fun toMap(entity: BaseEntity): Map<String, Any?> {
        return MutableDocument(
            entity.id,
            json.encodeToString(entity)
        ).toMap()
    }

    fun toJsonString(entity: BaseEntity): String {
        return json.encodeToString(entity)
    }

    fun toBaseEntity(mDoc: MutableDocument): BaseEntity {
        return json.decodeFromString(mDoc.toJSON())
    }

    fun toBaseEntity(doc: Document): BaseEntity? {
        val docAsJson = doc.toJSON() ?: return null
        return json.decodeFromString(docAsJson)
    }

}