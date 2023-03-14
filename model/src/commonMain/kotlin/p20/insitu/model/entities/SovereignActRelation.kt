package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.XpGeneralRelation
import p20.insitu.model.xpolizei.schema.Beziehung_allgemein
import p20.insitu.model.xpolizei.schema.KatalogCode001
import p20.insitu.model.components.CatalogCodeFixed

@Serializable
data class SovereignActRelation(
    override var deleted: Boolean = false,
    override var sourceId: String,
    override var sourceType: String,
    override var targetId: String,
    override var role: CatalogCodeFixed<KatalogCode001>?,
    override var designation: String? = null,
    override var comment: String? = null
): BaseEntity(), Relation, XpGeneralRelation {

    override val entityType: String = EntityType.SOVEREIGN_ACT_RELATION.toString()
    override var targetType: String  = EntityType.SOVEREIGN_ACT.toString()

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