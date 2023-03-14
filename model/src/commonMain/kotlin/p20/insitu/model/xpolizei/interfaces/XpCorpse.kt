package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.KatalogCode217
import p20.insitu.model.xpolizei.schema.Leiche
import p20.insitu.model.components.BodyPartDescription
import p20.insitu.model.components.CatalogCodeFixed

interface XpCorpse: XpCommonBaseClass {

    var completeness: CatalogCodeFixed<KatalogCode217>?
    var missingBodyParts: List<BodyPartDescription>?
    var recoveryNumber: String?
    var identificationNumber: String?
    var child: CatalogCodeFixed<KatalogCode217>?
    var comment: String?

    fun getLeiche(): Leiche

}