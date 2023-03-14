package p20.insitu.model.entities.enums

import kotlinx.serialization.Serializable

@Serializable
enum class AuditType {
    CREATE,
    EDIT,
    DELETE
}