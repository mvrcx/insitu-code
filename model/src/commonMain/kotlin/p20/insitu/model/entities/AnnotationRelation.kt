package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.XpGeneralRelation
import p20.insitu.model.xpolizei.schema.Beziehung_allgemein
import p20.insitu.model.xpolizei.schema.KatalogCode001
import p20.insitu.model.components.CatalogCodeFixed

@Serializable
data class AnnotationRelation(
    override var deleted: Boolean = false,
    override var sourceId: String,
    override var sourceType: String,
    override var targetId: String,
    override var targetType: String,
    override var role: CatalogCodeFixed<KatalogCode001>? = null,
    override var designation: String? = null,
    override var comment: String? = null
) : BaseEntity(), Relation, XpGeneralRelation {

    override val entityType: String = EntityType.ANNOTATION_RELATION.toString()

    override fun getBeziehungAllgemein(): Beziehung_allgemein {
        return Beziehung_allgemein().also {
            it.rolle = role?.getKatalogCode()
            it.bezeichnung = designation
            it.bemerkung = comment
            it.id1_quellID = sourceId
            it.id2_zielID = targetId
        }
    }

}