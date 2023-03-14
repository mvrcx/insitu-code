package p20.insitu.model.entities

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import p20.insitu.model.components.ValueDifference
import p20.insitu.model.components.ZonedDateTime
import p20.insitu.model.entities.enums.AuditType
import p20.insitu.model.entities.enums.EntityType

@Serializable
data class AuditEntry(
    override var deleted: Boolean = false,
    val timestamp: ZonedDateTime,
    val auditType: AuditType,
    val auditEntityId: String,
    val auditEntityType: String,
    val userId: String,
    val entriesAdded: Map<String, @Contextual Any?>? = null,
    val entriesInCommon: Map<String, @Contextual Any?>? = null,
    val entriesRemoved: Map<String, @Contextual Any?>? = null,
    val entriesDiffering: Map<String, ValueDifference>? = null
) : BaseEntity(){

    /**
     * The unique type descriptor for this entity class.
     *
     * @see p20.insitu.model.entities.enums.EntityType
     */
    override val entityType: String = EntityType.AUDIT_ENTRY.toString()

}
