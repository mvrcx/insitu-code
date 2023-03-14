package p20.insitu.model.entities

import kotlinx.serialization.Serializable
import p20.insitu.model.entities.enums.EntityType
import p20.insitu.model.xpolizei.interfaces.XpProcess
import p20.insitu.model.xpolizei.schema.*
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.components.ZonedDateTime

@Serializable
data class Investigation(
    override var deleted: Boolean = false,
    override var designation: String? = null,
    override var thumbnailId: String? = null,
    override var typeOfProcess: CatalogCodeFixed<KatalogCode123>? = null,
    override var number: String? = null,
    override var keywords: List<String>? = null,
    override var priority: CatalogCodeFixed<KatalogCode235>? = null,
    override var category: CatalogCodeFixed<KatalogCode330>? = null,
    override var processingStatus: CatalogCodeFixed<KatalogCode221>? = null,
    override var comment: String? = null,
    override var startDate: ZonedDateTime? = null,
    override var endDate: ZonedDateTime? = null
) : BaseEntity(), HierarchicalObject, XpProcess {

    override val entityType: String = EntityType.INVESTIGATION.toString()

}

